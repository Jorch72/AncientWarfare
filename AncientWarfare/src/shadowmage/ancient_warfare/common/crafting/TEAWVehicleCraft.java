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
package shadowmage.ancient_warfare.common.crafting;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import shadowmage.ancient_warfare.common.config.Config;
import shadowmage.ancient_warfare.common.inventory.AWInventoryBasic;
import shadowmage.ancient_warfare.common.item.ItemLoader;
import shadowmage.ancient_warfare.common.network.GUIHandler;
import shadowmage.ancient_warfare.common.utils.InventoryTools;
import shadowmage.ancient_warfare.common.vehicles.IVehicleType;
import shadowmage.ancient_warfare.common.vehicles.types.VehicleType;

public class TEAWVehicleCraft extends TEAWCrafting implements IInventory, ISidedInventory
{

int progressPerWork = 20;

int vehicleType = -1;
int vehicleLevel = -1;

/**
 * 
 */
public TEAWVehicleCraft()
  {
  this.modelID = 3;
  this.craftMatrix = new int[]{0,1,2,3,4,5,6,7,8};
  this.resultSlot = new int[]{9};
  this.bookSlot = new int[]{10};
  this.inventory = new AWInventoryBasic(11);
  }

@Override
public void setRecipe(ResourceListRecipe recipe)
  {
  super.setRecipe(recipe);
  if(recipe!=null)
    {
    ItemStack result = recipe.getResult();    
    if(result!=null)
      {
      int type = result.getItemDamage();
      int level = 0;
      IVehicleType t = VehicleType.getVehicleType(type);
      if(result.hasTagCompound() && result.getTagCompound().hasKey("AWVehSpawner"))
        {
        level = result.getTagCompound().getCompoundTag("AWVehSpawner").getInteger("lev");
        }
      this.vehicleType = type;
      this.vehicleLevel = level;
      Config.logDebug("set working vehicle to "+t);
      }
    }
  this.recipeStartCheckDelayTicks = 0;
  this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
  }

@Override
public void readDescriptionPacket(NBTTagCompound tag)
  {
  if(tag.hasKey("type"))
    {
    this.vehicleType = tag.getInteger("type");
    this.vehicleLevel = tag.getInteger("lev");
    }
  }

@Override
public void writeDescriptionData(NBTTagCompound tag)
  {
  tag.setInteger("type", this.vehicleType);
  tag.setInteger("lev", this.vehicleLevel);
  }

@Override
public void writeExtraNBT(NBTTagCompound tag)
  {
 
  }

@Override
public void readExtraNBT(NBTTagCompound tag)
  {
  
  }

@Override
public void onBlockClicked(EntityPlayer player)
  {
  if(!player.worldObj.isRemote)
    {
    GUIHandler.instance().openGUI(GUIHandler.VEHICLE_CRAFT, player, player.worldObj, xCoord, yCoord, zCoord);
    }
  }

}
