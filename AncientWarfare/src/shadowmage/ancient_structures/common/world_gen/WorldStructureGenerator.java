/**
   Copyright 2012-2013 John Cummens (aka Shadowmage, Shadowmage4513)
   This software is distributed under the terms of the GNU General Public License.
   Please see COPYING for precise license information.

   This file is part of Ancient Warfare.

   Ancient Warfare is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   Ancient Warfare is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with Ancient Warfare.  If not, see <http://www.gnu.org/licenses/>.
 */
package shadowmage.ancient_structures.common.world_gen;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import shadowmage.ancient_framework.common.config.AWLog;
import shadowmage.ancient_framework.common.config.Statics;
import shadowmage.ancient_framework.common.gamedata.AWGameData;
import shadowmage.ancient_structures.common.config.AWStructureStatics;
import shadowmage.ancient_structures.common.manager.WorldGenStructureManager;
import shadowmage.ancient_structures.common.template.StructureTemplate;
import shadowmage.ancient_structures.common.template.build.StructureBuilder;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldStructureGenerator implements IWorldGenerator
{

private static WorldStructureGenerator instance = new WorldStructureGenerator();
private WorldStructureGenerator(){}
public static WorldStructureGenerator instance(){return instance;}
public static HashSet<String> skippableWorldGenBlocks = new HashSet<String>();

static
{
skippableWorldGenBlocks.add(Block.cactus.getUnlocalizedName());
skippableWorldGenBlocks.add(Block.vine.getUnlocalizedName());
skippableWorldGenBlocks.add(Block.tallGrass.getUnlocalizedName());
skippableWorldGenBlocks.add(Block.wood.getUnlocalizedName());
skippableWorldGenBlocks.add(Block.plantRed.getUnlocalizedName());
skippableWorldGenBlocks.add(Block.plantYellow.getUnlocalizedName());
skippableWorldGenBlocks.add(Block.deadBush.getUnlocalizedName());
skippableWorldGenBlocks.add(Block.leaves.getUnlocalizedName());
skippableWorldGenBlocks.add(Block.snow.getUnlocalizedName());
}

private boolean isGenerating = false;
private LinkedList<DelayedGenerationEntry> delayedChunks = new LinkedList<DelayedGenerationEntry>();
private Random rng = new Random();

@Override
public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
  {
  if(!AWStructureStatics.enableStructureGeneration){return;}
//  if(rng.nextInt(10)>0){return;}
  if(isGenerating)
    {
    delayedChunks.add(new DelayedGenerationEntry(chunkX, chunkZ, world, chunkGenerator, chunkProvider));
    return;
    }
  else
    {
    isGenerating = true;
    generateAt(chunkX, chunkZ, world, chunkGenerator, chunkProvider);
    }
  while(!delayedChunks.isEmpty())
    {    
    DelayedGenerationEntry entry = delayedChunks.poll();
    generateAt(entry.chunkX, entry.chunkZ, entry.world, entry.generator, entry.provider);
    }
  isGenerating = false;
  }

private void generateAt(int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
  {
  long t1 = System.currentTimeMillis();
  long seed = (((long)chunkX)<< 32) | (((long)chunkZ) & 0xffffffffl);
  rng.setSeed(seed);
  int x = chunkX*16 + rng.nextInt(16);  
  int z = chunkZ*16 + rng.nextInt(16); 
  int y = getTargetY(world, x, z)+1;  
  if(y<=0){return;}
  int face = rng.nextInt(4);
  StructureTemplate template = WorldGenStructureManager.instance().selectTemplateForGeneration(world, rng, x, y, z, face, AWStructureStatics.chunkSearchRadius);
  int remainingClusterValue = WorldGenStructureManager.instance().getRemainingValue();//TODO use this to alter the random chance/range values to favor generating in clusters  
  if(Statics.DEBUG)
    {
    AWLog.logDebug("Template selection took: "+(System.currentTimeMillis()-t1)+" ms.");
    }
  if(template==null){return;} 
  StructureMap map = AWGameData.get(world, "AWStructureMap", StructureMap.class);
  if(attemptStructureGenerationAt(world, x, y, z, face, template, map))
    {
    AWLog.log(String.format("Generated structure: %s at %s, %s, %s", template.name, x, y, z));
    } 
  }

public static int getTargetY(World world, int x, int z)
  {
  int id;
  Block block;
  for(int y = world.provider.getActualHeight(); y>=1; y--)
    {
    id = world.getBlockId(x, y, z);
    if(id==0){continue;}
    block = Block.blocksList[id];
    if(block==null){continue;}
    if(skippableWorldGenBlocks.contains(block.getUnlocalizedName())){continue;}
    return y;
    }
  return -1;
  }

public boolean attemptStructureGenerationAt(World world, int x, int y, int z, int face, StructureTemplate template, StructureMap map)
  {
  boolean generate = false;
  long t1, t2;
  t1 = System.currentTimeMillis();
  generate = template.getValidationSettings().validatePlacement(world, x, y, z, face, template);
  if(Statics.DEBUG)
    {
    AWLog.logDebug("validation took: "+(System.currentTimeMillis()-t1+" ms"));   
    }
  if(generate)
    {    
    t2 = System.currentTimeMillis();
    generateStructureAt(world, x, y, z, face, template, map);
    if(Statics.DEBUG)
      {
      AWLog.logDebug("generation took: "+(System.currentTimeMillis()-t2)+" ms");      
      }
    }  
  return generate;
  }

private void generateStructureAt(World world, int x, int y, int z, int face, StructureTemplate template, StructureMap map)
  {
  template.getValidationSettings().preGeneration(world, x, y, z, face, template);
  StructureBuilder builder = new StructureBuilder(world, template, face, x, y, z);
  builder.instantConstruction();
  map.setGeneratedAt(world, x, y, z, face, template);
  map.markDirty();
  }

private class DelayedGenerationEntry
{
int chunkX;
int chunkZ;
World world;
IChunkProvider generator;
IChunkProvider provider;

public DelayedGenerationEntry(int cx, int cz, World world, IChunkProvider gen, IChunkProvider prov)
  {
  this.chunkX = cx;
  this.chunkZ = cz;
  this.world = world;
  this.generator = gen;
  this.provider = prov;
  }
}

}
