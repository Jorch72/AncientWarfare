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
package shadowmage.ancient_structures.common.template.plugin.default_plugins.block_rules;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import shadowmage.ancient_structures.api.TemplateRuleBlock;
import shadowmage.ancient_structures.common.manager.BlockDataManager;
import shadowmage.ancient_structures.common.utils.BlockInfo;
import shadowmage.ancient_warfare.common.utils.IDPairCount;

public class TemplateRuleVanillaBlocks extends TemplateRuleBlock
{

public String blockName;
public int meta;
public int buildPass = 0;

/**
 * constructor for dynamic construction.  passed world and coords so that the rule can handle its own logic internally
 * @param world
 * @param x
 * @param y
 * @param z
 * @param block
 * @param meta
 */
public TemplateRuleVanillaBlocks(World world, int x, int y, int z, Block block, int meta, int turns)
  {
  super(world, x, y, z, block, meta, turns);
  this.blockName = BlockDataManager.getBlockName(block);
  this.meta = BlockDataManager.getRotatedMeta(block, meta, turns);
  this.buildPass = BlockDataManager.getBlockPriority(block.blockID, meta);
  }

public TemplateRuleVanillaBlocks()
  {  
  
  }

@Override
public void handlePlacement(World world, int turns, int x, int y, int z)
  {
  Block block = BlockDataManager.getBlockByName(blockName);
  int localMeta = BlockDataManager.getRotatedMeta(block, this.meta, turns);  
  if(this.buildPass==0)
    {
    world.setBlock(x, y, z, block.blockID, localMeta, 2);//using flag=2 -- no block update, but send still send to clients (should help with issues of things popping off)
    }
  else
    {    
    Chunk chunk = world.getChunkFromBlockCoords(x, z);
    int cx = x&15; //(bitwise-and to scrub all bits above 15
    int cz = z&15;
    ExtendedBlockStorage[] st = chunk.getBlockStorageArray();
    ExtendedBlockStorage stc = st[y>>4];
    
    if (stc == null)
      {
      stc = st[y >> 4] = new ExtendedBlockStorage(y >> 4 << 4, !world.provider.hasNoSky);
      }
    TileEntity te = chunk.getChunkBlockTileEntityUnsafe(x & 0xf, y, z & 0xf);
    if (te != null)
      {
      world.removeBlockTileEntity(x, y, z);
      }
    stc.setExtBlockID(cx, y&15, cz, block.blockID);
    stc.setExtBlockMetadata(cx, y&15, cz, localMeta);
    world.markBlockForUpdate(x, y, z);       
    }
  }
  
@Override
public boolean shouldReuseRule(World world, Block block, int meta, int turns, TileEntity te, int x, int y, int z)
  {
  return block!=null && blockName.equals(BlockDataManager.getBlockName(block)) && BlockDataManager.getRotatedMeta(block, meta, turns) == this.meta;
  }

@Override
public void addResources(List<ItemStack> resources)
  {
  Block block = BlockDataManager.getBlockByName(blockName);
  if(block==Block.bed && meta>8){return;}
  IDPairCount count = BlockInfo.getInventoryBlock(block.blockID, meta);
  if(count!=null && count.id>0)
    {
    resources.add(new ItemStack(count.id, count.count, count.meta));
    }
  }

@Override
public boolean shouldPlaceOnBuildPass(World world, int turns, int x, int y, int z, int buildPass)
  {
  return buildPass == this.buildPass;
  }

@Override
public String toString()
  {
  return String.format("Vanilla Block Rule id: %s meta: %s buildPass: %s", blockName, meta, buildPass);
  }

@Override
public void writeRuleData(NBTTagCompound tag)
  {
  tag.setString("blockName", blockName);
  tag.setInteger("meta", meta);
  tag.setInteger("buildPass", buildPass);
  }

@Override
public void parseRuleData(NBTTagCompound tag)
  {
  this.blockName = tag.getString("blockName");
  this.meta = tag.getInteger("meta");
  this.buildPass = tag.getInteger("buildPass");      
  }

}
