package shadowmage.ancient_structures.common.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class InventoryBasic implements IInventorySaveable
{

private ItemStack[] inventorySlots;
private boolean isDirty;

public InventoryBasic(int size)
  {
  inventorySlots = new ItemStack[size];
  }

@Override
public int getSizeInventory()
  {
  return inventorySlots.length;
  }

@Override
public ItemStack getStackInSlot(int var1)
  {
  return inventorySlots[var1];
  }

@Override
public ItemStack decrStackSize(int slotIndex, int amount)
  {
  ItemStack slotStack = inventorySlots[slotIndex];
  if(slotStack!=null)
    {
    if(amount>slotStack.stackSize){amount = slotStack.stackSize;}
    if(amount>slotStack.getMaxStackSize()){amount = slotStack.getMaxStackSize();}
    ItemStack returnStack = slotStack.copy();
    slotStack.stackSize-=amount;
    returnStack.stackSize = amount;    
    return returnStack;
    }
  return null;
  }

@Override
public ItemStack getStackInSlotOnClosing(int var1)
  {
  ItemStack slotStack = inventorySlots[var1];
  inventorySlots[var1] = null;
  return slotStack;
  }

@Override
public void setInventorySlotContents(int var1, ItemStack var2)
  {
  inventorySlots[var1] = var2;
  }

@Override
public String getInvName()
  {
  return "AW.InventoryBasic";
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
public void onInventoryChanged()
  {
  this.isDirty = true;
  }

@Override
public boolean isUseableByPlayer(EntityPlayer var1)
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

@Override
public boolean isItemValidForSlot(int var1, ItemStack var2)
  {
  return true;
  }

@Override
public void readFromNBT(NBTTagCompound tag)
  {
  NBTTagList itemList = tag.getTagList("itemList");  
  NBTTagCompound itemTag;  
  ItemStack item;
  int slot;
  for(int i = 0; i < itemList.tagCount(); i++)
    {
    itemTag = (NBTTagCompound) itemList.tagAt(i);
    slot = itemTag.getShort("slot");
    item = ItemStack.loadItemStackFromNBT(itemTag);
    inventorySlots[slot]=item;
    }
  }

@Override
public void writeToNBT(NBTTagCompound tag)
  {
  NBTTagList itemList = new NBTTagList();
  NBTTagCompound itemTag;  
  ItemStack item;
  for(int i = 0; i < inventorySlots.length; i++)
    {
    item = inventorySlots[i];
    if(item==null){continue;}
    itemTag = new NBTTagCompound();
    item.writeToNBT(itemTag);
    itemTag.setShort("slot", (short)i);
    itemList.appendTag(itemTag);
    }  
  tag.setTag("itemList", itemList);
  }

@Override
public boolean isDirty()
  {
  return isDirty;
  }

}
