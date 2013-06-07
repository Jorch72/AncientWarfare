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
import shadowmage.ancient_warfare.common.inventory.AWInventoryBasic;
import shadowmage.ancient_warfare.common.item.ItemLoader;
import shadowmage.ancient_warfare.common.network.GUIHandler;

public class TEAWVehicleCraft extends TEAWCrafting implements IInventory, ISidedInventory
{

ResourceListRecipe recipe = null;
int displayProgress = 0;
int displayProgressMax = 0;
int progressPerWork = 20;
protected boolean isWorkSiteSet = false;
public boolean shouldUpdate = false;
public boolean isWorking = false;

AWInventoryBasic inventory = new AWInventoryBasic(10);

int[] craftMatrix= new int[]{0,1,2,3,4,5,6,7,8};
int[] outputSlot= new int[]{9};
int[] bookSlot = new int[]{10};

/**
 * 
 */
public TEAWVehicleCraft()
  {
  this.modelID = 3;
  }

@Override
public void updateEntity()
  {  
  super.updateEntity();
  if(this.isWorkSiteSet)
    {
    if(this.recipe!=null)
      {
      if(isWorking)
        {
        if(this.displayProgress>=this.displayProgressMax)
          {
          this.displayProgress = this.displayProgressMax;
          if(this.tryFinish())
            {
            this.displayProgress = 0;
            this.displayProgressMax = 0;
            this.isWorking = false;
            }
          }
        if(this.shouldUpdate)
          {
          this.displayProgress++;
          }
        }
      else
        {
        if(this.tryStart())
          {
          this.isWorking = true;
          }
        }
      } 
    }  
  }

public void validateAndSetRecipe(ResourceListRecipe recipe)
  {
  recipe = AWCraftingManager.instance().validateRecipe(recipe);
  if(recipe!=null)
    {
    this.recipe = recipe;
    }
  }

/**
 * try starting and removing items
 * @return
 */
protected boolean tryStart()
  {
  return false;
  }

/**
 * try finishing (place items into output slot)
 * @return
 */
protected boolean tryFinish()
  {
  return false;
  }

@Override
public boolean isStackValidForSlot(int i, ItemStack itemstack)
  {
  return i==10 ? itemstack.itemID== ItemLoader.researchBook.itemID: i== 9? false : true;
  }

@Override
public int[] getAccessibleSlotsFromSide(int var1)
  {
  if(var1==0)
    {
    return outputSlot;    
    }
  else if(var1==1)
    {
    return bookSlot;    
    }
  else
    {
    return craftMatrix;
    }
  }

@Override
public boolean canInsertItem(int i, ItemStack itemstack, int j)
  {
  return i == 9 ? false : i==10 ? itemstack.itemID==ItemLoader.researchBook.itemID : true;
  }

@Override
public boolean canExtractItem(int i, ItemStack itemstack, int j)
  {
  return i== 10 ? false : true;
  }

@Override
public void readDescriptionPacket(NBTTagCompound tag)
  {
  // TODO Auto-generated method stub  
  }

@Override
public void writeDescriptionData(NBTTagCompound tag)
  {
  // TODO Auto-generated method stub
  
  }

@Override
public void writeExtraNBT(NBTTagCompound tag)
  {
  // TODO Auto-generated method stub
  
  }

@Override
public void readExtraNBT(NBTTagCompound tag)
  {
  // TODO Auto-generated method stub
  
  }

@Override
public void onBlockClicked(EntityPlayer player)
  {
  if(!player.worldObj.isRemote)
    {
    GUIHandler.instance().openGUI(GUIHandler.VEHICLE_CRAFT, player, player.worldObj, xCoord, yCoord, zCoord);
    }
  }

@Override
public int getSizeInventory()
  {
  return inventory.getSizeInventory();
  }

@Override
public ItemStack getStackInSlot(int i)
  {
  return inventory.getStackInSlot(i);
  }

@Override
public ItemStack decrStackSize(int i, int j)
  {
  return inventory.decrStackSize(i, j);
  }

@Override
public ItemStack getStackInSlotOnClosing(int i)
  {
  return inventory.getStackInSlotOnClosing(i);
  }

@Override
public void setInventorySlotContents(int i, ItemStack itemstack)
  {
  inventory.setInventorySlotContents(i, itemstack);
  }

@Override
public String getInvName()
  {
  return "AW.VehicleCrafting";
  }

@Override
public boolean isInvNameLocalized()
  {  
  return false;
  }

@Override
public int getInventoryStackLimit()
  {  
  return 64;
  }

@Override
public boolean isUseableByPlayer(EntityPlayer entityplayer)
  {  
  return true;
  }

@Override
public void openChest()
  {
   
  }

@Override
public void closeChest()
  {
    
  }

}