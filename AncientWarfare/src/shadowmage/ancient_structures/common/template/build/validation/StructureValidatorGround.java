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
package shadowmage.ancient_structures.common.template.build.validation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import shadowmage.ancient_framework.common.config.AWLog;
import shadowmage.ancient_framework.common.utils.StringTools;
import shadowmage.ancient_structures.common.template.StructureTemplate;
import shadowmage.ancient_structures.common.template.build.StructureBB;
import shadowmage.ancient_structures.common.world_gen.WorldStructureGenerator;

public class StructureValidatorGround extends StructureValidator
{


public StructureValidatorGround()
  {
  super(StructureValidationType.GROUND);
  }

@Override
protected void readFromLines(List<String> lines)
  {
 
  }

@Override
protected void write(BufferedWriter writer) throws IOException
  {
 
  }

@Override
protected void setDefaultSettings(StructureTemplate template)
  {
//  this.validTargetBlocks.addAll(WorldStructureGenerator.defaultTargetBlocks); 
//  int size = (template.ySize-template.yOffset)/3;
//  this.borderSize = size;
//  this.maxLeveling = template.ySize-template.yOffset;
//  this.maxFill = size;
  }

@Override
public boolean shouldIncludeForSelection(World world, int x, int y, int z, int face, StructureTemplate template)
  {
  if( y <= template.yOffset+maxFill){return false;}
  Block block = Block.blocksList[world.getBlockId(x, y-1, z)];
  if(block==null || !validTargetBlocks.contains(block.getUnlocalizedName())){return false;}
  return true;
  }

@Override
public boolean validatePlacement(World world, int x, int y, int z, int face, StructureTemplate template, StructureBB bb)
  {
  return validateStructurePlacement(world, x, y, z, face, template, bb);
  }

@Override
public void preGeneration(World world, int x, int y, int z, int face, StructureTemplate template, StructureBB bb)
  {
  doStructurePrePlacement(world, x, y, z, face, template);
  }

private boolean validateStructurePlacement(World world, int x, int y, int z, int face, StructureTemplate template, StructureBB bb)
  {
  int bx, bz;
  int minY = getMinY(template, bb);
  int maxY = getMaxY(template, bb);
  for(bx = bb.min.x-borderSize; bx<=bb.max.x+borderSize; bx++)
    {
    bz = bb.min.z-borderSize;
    if(!validateBlockHeightAndType(world, bx, bz, minY, maxY, false, validTargetBlocks))
      {
      return false;
      }        
    bz = bb.max.z+borderSize;
    if(!validateBlockHeightAndType(world, bx, bz, minY, maxY, false, validTargetBlocks))
      {
      return false;
      }        
    }
  for(bz = bb.min.z-borderSize+1; bz<=bb.max.z+borderSize-1; bz++)
    {
    bx = bb.min.x-borderSize;
    if(!validateBlockHeightAndType(world, bx, bz, minY, maxY, false, validTargetBlocks))
      {
      return false;
      }        
    bx = bb.max.x+borderSize;
    if(!validateBlockHeightAndType(world, bx, bz, minY, maxY, false, validTargetBlocks))
      {
      return false;
      }        
    }
  return true;
  }

private void doStructurePrePlacement(World world, int x, int y, int z, int face, StructureTemplate template)
  {
  StructureBB bb = new StructureBB(x, y, z, face, template);  
  for(int bx = bb.min.x-borderSize; bx<= bb.max.x+borderSize; bx++)
    {
    for(int bz = bb.min.z-borderSize; bz<= bb.max.z+borderSize; bz++)
      {
      if(bx<bb.min.x || bx>bb.max.x || bz<bb.min.z || bz>bb.max.z)
        {//is border block, do border clear/fill
        doStructurePrePlacementBlockPlace(world, bx, bz, template, bb, true);
        }
      else
        {//is structure block, do structure clear/fill
        doStructurePrePlacementBlockPlace(world, bx, bz, template, bb, false);
        }
      }
    }  
  }

private void doStructurePrePlacementBlockPlace(World world, int x, int z, StructureTemplate template, StructureBB bb, boolean border)
  {
  int leveling = maxLeveling;
  int fill = maxFill;
  
  /**
   * most of this is just to try and minimize the total Y range that is examined for clear/fill
   */
  int minFillY = bb.min.y - fill;
  if(border){minFillY+=template.yOffset;}
  int maxFillY = (minFillY + fill) -1;
  
  int minLevelY = bb.min.y + template.yOffset;
  int maxLevelY = minLevelY + leveling;
  
  int minY = minFillY< minLevelY ? minFillY : minLevelY;
  if(!border)
    {
    if(fill>0)
      {//for inside-structure bounds, we want to fill down to whatever is existing if fill is>0    
      int topEmptyBlockY = WorldStructureGenerator.getTargetY(world, x, z, true)+1;
      minY = minY< topEmptyBlockY ? minY : topEmptyBlockY;
      }    
    }  
  else
    {
    int step = WorldStructureGenerator.getStepNumber(x, z, bb.min.x, bb.max.x, bb.min.z, bb.max.z);
    int stepHeight = fill / borderSize;
    maxFillY -= step*stepHeight;
    minLevelY += step*stepHeight;
    minY = minFillY < minLevelY ? minFillY : minLevelY;//reset minY from change to minLevelY
    }
  
  minY = minY<=0 ? 1 : minY;
  int maxY = maxFillY> maxLevelY ? maxFillY : maxLevelY;
  
  int xInChunk = x&15;
  int zInChunk = z&15;  
  Chunk chunk = world.getChunkFromBlockCoords(x, z);
  
  int id;
  Block block;
  BiomeGenBase biome = world.getBiomeGenForCoords(x, z);  
  int fillBlockID = Block.grass.blockID;
  if(biome!=null && biome.topBlock>=1)
    {
    fillBlockID = biome.topBlock;
    }
  for(int y = minY; y <=maxY; y++)
    {    
    id = world.getBlockId(x, y, z);
    block = Block.blocksList[id];
    if(leveling>0 && y>=minLevelY)
      {
      if(block!=null && !WorldStructureGenerator.skippableWorldGenBlocks.contains(block.getUnlocalizedName()) && validTargetBlocks.contains(block.getUnlocalizedName()))
        {
        chunk.setBlockIDWithMetadata(xInChunk, y, zInChunk, 0, 0);        
        }
      }
    if(fill>0 && y<=maxFillY)
      {
      if(block==null || !WorldStructureGenerator.skippableWorldGenBlocks.contains(block.getUnlocalizedName()))
        {
        chunk.setBlockIDWithMetadata(xInChunk, y, zInChunk, fillBlockID, 0);
        }
      }
    }
  }

@Override
public int getAdjustedSpawnY(World world, int x, int y, int z, int face, StructureTemplate template, StructureBB bb)
  {
  return y;
  }

@Override
public void handleClearAction(World world, int x, int y, int z, int face, StructureTemplate template, StructureBB bb)
  {
  
  }

}
