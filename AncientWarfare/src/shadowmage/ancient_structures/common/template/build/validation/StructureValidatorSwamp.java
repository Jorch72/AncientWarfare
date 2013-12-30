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
import shadowmage.ancient_structures.common.template.StructureTemplate;
import shadowmage.ancient_structures.common.template.build.StructureBB;

public class StructureValidatorSwamp extends StructureValidator
{

/**
 * @param validationType
 */
public StructureValidatorSwamp(StructureValidationType validationType)
  {
  super(StructureValidationType.SWAMP);
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
public int getAdjustedSpawnY(World world, int x, int y, int z, int face, StructureTemplate template, StructureBB bb)
  {
  return y;
  }

@Override
public boolean validatePlacement(World world, int x, int y, int z, int face, StructureTemplate template, StructureBB bb)
  {
  return false;
  }

@Override
public void preGeneration(World world, int x, int y, int z, int face, StructureTemplate template, StructureBB bb)
  {
  
  }

@Override
public void handleClearAction(World world, int x, int y, int z, int face, StructureTemplate template, StructureBB bb)
  {

  }

}
