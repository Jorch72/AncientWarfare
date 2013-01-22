/**
   Copyright 2012 John Cummens (aka Shadowmage, Shadowmage4513)
   This software is distributed under the terms of the GNU General Public Licence.
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
package shadowmage.ancient_warfare.common.aw_core.utils;

import net.minecraft.nbt.NBTTagCompound;

public class IDPairCount extends IDPair
{

/**
 * @param id
 * @param meta
 */
public IDPairCount(int id, int meta)
  {
  super(id, meta);
  }

public IDPairCount(NBTTagCompound tag)
  {
  super(tag.getInteger("id"), tag.getInteger("mt"));
  count=tag.getInteger("ct");
  }

public IDPairCount(int id, int meta, int count)
  {
  this(id, meta);
  this.count = count;
  }

public NBTTagCompound getTag()
  {
  NBTTagCompound tag = new NBTTagCompound();
  tag.setInteger("id", id);
  tag.setInteger("mt", meta);
  tag.setInteger("ct", count);
  return tag;
  }

public IDPairCount copy()
  {
  return new IDPairCount(id, meta, count);
  }

public int count = 1;

public String toString()
  {
  return String.valueOf("ID: "+id+" MT: "+meta+" CT: "+count);
  }


}
