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
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import shadowmage.ancient_framework.common.config.AWLog;
import shadowmage.ancient_framework.common.utils.StringTools;
import shadowmage.ancient_structures.common.template.StructureTemplate;
import shadowmage.ancient_structures.common.template.build.StructureBB;
import shadowmage.ancient_structures.common.world_gen.WorldStructureGenerator;

public class StructureValidatorWater extends StructureValidator
{

public StructureValidatorWater()
  {
  super(StructureValidationType.WATER);
  }

@Override
protected void readFromLines(List<String> lines)
  {
 
  }

@Override
protected void write(BufferedWriter out) throws IOException
  {
  
  }

@Override
protected void setDefaultSettings(StructureTemplate template)
  {
  
  }

@Override
public boolean shouldIncludeForSelection(World world, int x, int y, int z, int face, StructureTemplate template)
  {
  int id = world.getBlockId(x, y-1, z);
  return id==Block.waterMoving.blockID || id==Block.waterStill.blockID;
  }

@Override
public int getAdjustedSpawnY(World world, int x, int y, int z, int face, StructureTemplate template, StructureBB bb)
  {
  return y;
  }

@Override
public boolean validatePlacement(World world, int x, int y, int z, int face, StructureTemplate template, StructureBB bb)
  {
  int minY = getMinY(template, bb);
  int maxY = getMaxY(template, bb);
  int bx, bz;
  for(bx = bb.min.x-borderSize; bx<=bb.max.x+borderSize; bx++)
    {
    bz = bb.min.z-borderSize;
    if(!validateBlockHeightAndType(world, bx, bz, 0, minY, true, WorldStructureGenerator.defaultTargetBlocks))
      {
      return false;
      }
              
    bz = bb.max.z+borderSize;
    if(!validateBlockHeightAndType(world, bx, bz, 0, minY, true, WorldStructureGenerator.defaultTargetBlocks))
      {
      return false;
      }
    }
  for(bz = bb.min.z-borderSize+1; bz<=bb.max.z+borderSize-1; bz++)
    {
    bx = bb.min.x-borderSize;
    if(!validateBlockHeightAndType(world, bx, bz, 0, minY, true, WorldStructureGenerator.defaultTargetBlocks))
      {
      return false;
      }
    
    bx = bb.max.x+borderSize;
    if(!validateBlockHeightAndType(world, bx, bz, 0, minY, true, WorldStructureGenerator.defaultTargetBlocks))
      {
      return false;
      }
    }
  return true;
  }

@Override
public void preGeneration(World world, int x, int y, int z, int face, StructureTemplate template, StructureBB bb)
  {

  }

@Override
public void handleClearAction(World world, int x, int y, int z, int face, StructureTemplate template, StructureBB bb)
  {
  if( y < bb.min.y+template.yOffset)
    {
    world.setBlock(x, y, z, Block.waterStill.blockID);
    }
  else
    {
    world.setBlock(x, y, z, 0);
    }
  }
}
