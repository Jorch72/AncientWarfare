/**
   Copyright 2012 John Cummens (aka Shadowmage, Shadowmage4513)
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
package shadowmage.ancient_warfare.common.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import shadowmage.ancient_warfare.common.gates.EntityGate;
import shadowmage.ancient_warfare.common.gates.types.Gate;
import shadowmage.ancient_warfare.common.interfaces.IScannerItem;
import shadowmage.ancient_warfare.common.tracker.TeamTracker;
import shadowmage.ancient_warfare.common.utils.BlockPosition;
import shadowmage.ancient_warfare.common.utils.BlockTools;

public class ItemGateSpawner extends AWItemClickable implements IScannerItem
{

/**
 * @param itemID
 * @param hasSubTypes
 */
public ItemGateSpawner(int itemID)
  {
  super(itemID, true);
  this.hasLeftClick = true;
  }

@Override
public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
  {
  super.addInformation(stack, player, list, par4);
  NBTTagCompound tag = null;
  if(stack.hasTagCompound() && stack.getTagCompound().hasKey("AWGateInfo"))
    {
    tag = stack.getTagCompound().getCompoundTag("AWGateInfo");
    }
  else
    {
    tag = new NBTTagCompound();
    }
  if(tag.hasKey("pos1") && tag.hasKey("pos2"))
    {
    list.add("Right Click: Construct Gate");
    list.add("(Shift)Right Click: Cancel/clear");
    }
  else if(tag.hasKey("pos1"))
    {
    list.add("Left Click: Set second bound");
    list.add("(Shift)Right Click: Cancel/clear");    
    }
  else
    {
    list.add("Left Click: Set first bound");
    list.add("(Shift)Right Click: Cancel/clear");
    }
  }



@Override
public boolean onUsedFinal(World world, EntityPlayer player, ItemStack stack, BlockPosition hit, int side)
  {
  if(world.isRemote)
    {
    return true;
    }  
  NBTTagCompound tag;
  if(stack.hasTagCompound() && stack.getTagCompound().hasKey("AWGateInfo"))
    {
    tag = stack.getTagCompound().getCompoundTag("AWGateInfo");
    }
  else
    {
    tag = new NBTTagCompound();
    }
  if(isShiftClick(player))
    {
    tag = new NBTTagCompound();
    stack.setTagCompound(tag);
    }
  else if(tag.hasKey("pos1") && tag.hasKey("pos2"))
    {
	  byte facing = (byte) BlockTools.getPlayerFacingFromYaw(player.rotationYaw);
	  BlockPosition pos1 = new BlockPosition(tag.getCompoundTag("pos1"));
	  BlockPosition pos2 = new BlockPosition(tag.getCompoundTag("pos2"));
	  BlockPosition avg = BlockTools.getAverageOf(pos1, pos2);
	  if(player.getDistance(avg.x+0.5d, pos1.y, avg.z+0.5d) > 10)
	    {
	    player.addChatMessage("You are too far away to construct that gate, move closer");
	    return false;
	    }
	  if(!canSpawnGate(world, pos1, pos2))
	    {
	    player.addChatMessage("There is already a gate in that location!!");
	    return false;
	    }
    EntityGate entity = Gate.constructGate(world, pos1, pos2, Gate.getGateByID(stack.getItemDamage()), facing);
    if(entity!=null)
      {
      entity.teamNum = TeamTracker.instance().getTeamForPlayer(player);
      world.spawnEntityInWorld(entity);
      if(!player.capabilities.isCreativeMode)
        {
        ItemStack item = player.getHeldItem();
        if(item!=null)
          {
          item.stackSize--;
          if(item.stackSize<=0)
            {          
            player.setCurrentItemOrArmor(0, null);
            }
          }
        }
      }
    else
      {
      player.addChatMessage("Chosen area is not clear!!");
      }
    }
  return false;
  }

protected boolean canSpawnGate(World world, BlockPosition pos1, BlockPosition pos2)
  {  
  BlockPosition min = BlockTools.getMin(pos1, pos2);
  BlockPosition max = BlockTools.getMax(pos1, pos2);
  AxisAlignedBB newGateBB = AxisAlignedBB.getAABBPool().getAABB(min.x, min.y, min.z, max.x+1, max.y+1, max.z+1);
  AxisAlignedBB oldGateBB = null;
  List<EntityGate> gates = world.getEntitiesWithinAABB(EntityGate.class, newGateBB);
  for(EntityGate gate : gates)
    {  
    min = BlockTools.getMin(gate.pos1, gate.pos2);
    max = BlockTools.getMax(gate.pos1, gate.pos2);
    oldGateBB = AxisAlignedBB.getAABBPool().getAABB(min.x, min.y, min.z, max.x+1, max.y+1, max.z+1);
    if(oldGateBB.intersectsWith(newGateBB))
      {
      return false;
      }
    }
  return true;
  }

@Override
public boolean onUsedFinalLeft(World world, EntityPlayer player, ItemStack stack, BlockPosition hit, int side)
  {
  if(world.isRemote || hit==null)
    {
    return true;
    }
  hit.offsetForMCSide(side);
  NBTTagCompound tag;
  if(stack.hasTagCompound() && stack.getTagCompound().hasKey("AWGateInfo"))
    {
    tag = stack.getTagCompound().getCompoundTag("AWGateInfo");
    }
  else
    {
    tag = new NBTTagCompound();
    }
  if(tag.hasKey("pos1") && tag.hasKey("pos2"))
    {
    /**
     * do nothing, wait for right click for build order
     */
    }
  else if(tag.hasKey("pos1"))
    {
    Gate g = Gate.getGateByID(stack.getItemDamage());
    if(g.arePointsValidPair(new BlockPosition(tag.getCompoundTag("pos1")), hit))
      {
      tag.setCompoundTag("pos2", hit.writeToNBT(new NBTTagCompound()));
      player.addChatMessage("Setting second gate bounds position");      
      }
    else
      {
      player.addChatMessage("Invalid second coordinate, please re-select");
      }
    }
  else
    {
    tag.setCompoundTag("pos1", hit.writeToNBT(new NBTTagCompound()));
    player.addChatMessage("Setting first gate bounds position");
    }
  stack.setTagInfo("AWGateInfo", tag);
  return false;
  }

@Override
public BlockPosition getScanPos1(ItemStack stack)
  {
  if(stack.hasTagCompound() && stack.getTagCompound().hasKey("AWGateInfo") && stack.getTagCompound().getCompoundTag("AWGateInfo").hasKey("pos1"))
    {
    return new BlockPosition(stack.getTagCompound().getCompoundTag("AWGateInfo").getCompoundTag("pos1"));
    }
  return null;
  }

@Override
public BlockPosition getScanPos2(ItemStack stack)
  {
  if(stack.hasTagCompound() && stack.getTagCompound().hasKey("AWGateInfo") && stack.getTagCompound().getCompoundTag("AWGateInfo").hasKey("pos2"))
    {
    return new BlockPosition(stack.getTagCompound().getCompoundTag("AWGateInfo").getCompoundTag("pos2"));
    }
  return null;
  }

}
