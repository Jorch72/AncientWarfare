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

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import shadowmage.ancient_structures.common.config.AWLog;
import shadowmage.ancient_structures.common.config.AWStructureStatics;
import shadowmage.ancient_structures.common.manager.BlockDataManager;
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
public boolean shouldIncludeForSelection(World world, int x, int y, int z, int face, StructureTemplate template)
  {
  Block block = Block.blocksList[world.getBlockId(x, y-1, z)];
  if(block==null || !targetBlocksContains(BlockDataManager.getBlockName(block)))
    {
    AWLog.logDebug("rejecting template: "+template.name+" for non-target block:"+BlockDataManager.getBlockName(block) +" at "+x+","+y+","+z);
    return false;
    }
  return true;
  }

@Override
public boolean validatePlacement(World world, int x, int y, int z, int face, StructureTemplate template, StructureBB bb)
  {
  int minY = getMinY(template, bb);
  int maxY = getMaxY(template, bb);
  return validateBorderBlocks(world, template, bb, minY, maxY, false);
  }

@Override
public void preGeneration(World world, int x, int y, int z, int face, StructureTemplate template, StructureBB bb)
  {
  prePlacementBorder(world, template, bb);
  prePlacementUnderfill(world, template, bb);
  }

@Override
public void handleClearAction(World world, int x, int y, int z, StructureTemplate template, StructureBB bb)
  {  
  world.setBlock(x, y, z, 0);
  }

@Override
protected void borderLeveling(World world, int x, int z, StructureTemplate template, StructureBB bb)
  {
  if(maxLeveling<=0){return;}
  int topFilledY = WorldStructureGenerator.getTargetY(world, x, z, true);
  int step = WorldStructureGenerator.getStepNumber(x, z, bb.min.x, bb.max.x, bb.min.z, bb.max.z);  
  for(int y = bb.min.y + template.yOffset + step; y <= topFilledY ; y++)
    {
    handleClearAction(world, x, y, z, template, bb);
    }
  BiomeGenBase biome = world.getBiomeGenForCoords(x, z);  
  int fillBlockID = Block.grass.blockID;
  if(biome!=null && biome.topBlock>=1)
    {
    fillBlockID = biome.topBlock;
    }
  int y = bb.min.y + template.yOffset + step - 1;
  Block block = Block.blocksList[world.getBlockId(x, y, z)];
  if(block!=null && block!= Block.waterMoving && block!=Block.waterStill && !AWStructureStatics.skippableBlocksContains(BlockDataManager.getBlockName(block)))
    {
    world.setBlock(x, y, z, fillBlockID);
    }  
  if(validationType==StructureValidationType.GROUND)
    {
    int skipCount = 0;
    for(int y1 = y+1; y1<world.provider.getHeight(); y1++)//lazy clear block handling
      {
      block = Block.blocksList[world.getBlockId(x, y1, z)]; 
      if(block==null)
        {
        skipCount++;
        if(skipCount>=10)//exit out if 10 blocks are found that are not clearable
          {
          break;
          }
        continue;
        }
      skipCount = 0;//if we didn't skip this block, reset skipped count
      if(AWStructureStatics.skippableBlocksContains(BlockDataManager.instance().getBlockName(block)))
        {
        world.setBlockToAir(x, y1, z);      
        }      
      }
    }
  }

}
