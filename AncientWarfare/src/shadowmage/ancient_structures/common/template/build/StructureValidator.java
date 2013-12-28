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
package shadowmage.ancient_structures.common.template.build;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import shadowmage.ancient_framework.common.utils.NBTTools;
import shadowmage.ancient_framework.common.utils.StringTools;
import shadowmage.ancient_structures.common.template.StructureTemplate;

public abstract class StructureValidator
{

private int selectionWeight;
private int clusterValue;
private int minDuplicateDistance;
public final StructureValidationType validationType;
private boolean worldGenEnabled;
private boolean isUnique;//should this structure generate only once?
private boolean preserveBlocks;
private boolean preserveWater;
private boolean preserveLava;

private boolean biomeWhiteList;//should treat biome list as white or blacklist?
private Set<String> biomeList;//list of biomes for white/black list.  treated as white/black list from whitelist toggle

private boolean dimensionWhiteList;//should treat dimension list as white or blacklist?
private int[] acceptedDimensions;//list of accepted dimensions treated as white/black list from whitelist toggle

protected StructureValidator(StructureValidationType validationType)
  {
  this.validationType = validationType;
  selectionWeight = 1;
  clusterValue = 1;
  }

protected abstract void readFromNBT(NBTTagCompound tag);
protected abstract void writeToNBT(NBTTagCompound tag);
protected abstract void setDefaultSettings(StructureTemplate template);

public StructureValidator setDefaults(StructureTemplate template)
  {
  setDefaultSettings(template);
  return this;
  }

public abstract boolean shouldIncludeForSelection(World world, int x, int y, int z, int face, StructureTemplate template);

public abstract boolean validatePlacement(World world, int x, int y, int z, int face, StructureTemplate template);

public abstract void preGeneration(World world, int x, int y, int z, int face, StructureTemplate template);

public int getSelectionWeight()
  {
  return selectionWeight;
  }

public int getClusterValue()
  {
  return clusterValue;
  }

public static final StructureValidator parseValidator(List<String> lines)
  {
  String type = null;
  List<String> tagLines = new ArrayList<String>();
  Iterator<String> it = lines.iterator();
  String line;
  while(it.hasNext() && (line=it.next())!=null)
    {    
    if(line.toLowerCase().startsWith("type="))
      {
      type = StringTools.safeParseString("=", line);
      }
    if(line.toLowerCase().startsWith("tag:"))
      {
      tagLines.add(line);
      while(it.hasNext() && (line=it.next())!=null)
        {
        tagLines.add(line);
        if(line.toLowerCase().startsWith(":endtag"))
          {
          break;
          }
        }
      }
    }
  StructureValidator validator = null;
  if(type==null)
    {
    validator = new StructureValidatorGround();
    }  
  NBTTagCompound tag = NBTTools.readNBTFrom(tagLines);
  validator.readFromNBT(tag);
  return validator;
  }

public static final void writeValidator(BufferedWriter out, StructureValidator validator) throws IOException
  {
  NBTTagCompound tag = new NBTTagCompound();
  validator.writeToNBT(tag);
  List<String> lines = new ArrayList<String>();
  NBTTools.writeNBTToLines(tag, lines);
  out.write("type="+validator.validationType.getName());  
  out.newLine();
  out.write("tag:");
  for(String line : lines)
    {
    out.write(line);
    out.newLine();
    }  
  out.write(":endtag");
  out.newLine();
  }

public boolean isWorldGenEnabled()
  {
  return worldGenEnabled;
  }

public Set<String> getBiomeList()
  {
  return biomeList;
  }

public boolean isPreserveBlocks()
  {
  return preserveBlocks;
  }

public boolean isBiomeWhiteList()
  {
  return biomeWhiteList;
  }

public boolean isUnique()
  {
  return isUnique;
  }

public boolean isDimensionWhiteList() 
  {
	return dimensionWhiteList;
	}

public int[] getAcceptedDimensions()
  {
  return acceptedDimensions;
  }

public int getMinDuplicateDistance()
  {
  return minDuplicateDistance;
  }
}