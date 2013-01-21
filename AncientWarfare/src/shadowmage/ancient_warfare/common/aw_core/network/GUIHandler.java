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
package shadowmage.ancient_warfare.common.aw_core.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import shadowmage.ancient_warfare.client.aw_structure.gui.creative_selection.GuiCSB;
import shadowmage.ancient_warfare.client.aw_structure.gui.scanner.GuiStructureScanner;
import shadowmage.ancient_warfare.client.aw_structure.gui.survival_builder.GuiSurvivalBuilder;
import shadowmage.ancient_warfare.common.aw_core.AWCore;
import shadowmage.ancient_warfare.common.aw_core.container.ContainerBase;
import shadowmage.ancient_warfare.common.aw_structure.container.ContainerCSB;
import shadowmage.ancient_warfare.common.aw_structure.container.ContainerStructureScanner;
import shadowmage.ancient_warfare.common.aw_structure.container.ContainerSurvivalBuilder;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.common.network.IGuiHandler;

public class GUIHandler implements IGuiHandler
{

/**
 * GUI IDs....listed here for...uhh...keeping track of them
 */
public static final int STRUCTURE_SELECT = 0;
public static final int STRUCTURE_SCANNER = 1;
public static final int STRUCTURE_BUILD_DIRECT = 2;



private static GUIHandler INSTANCE;
private GUIHandler(){}
public static GUIHandler instance()
  {
  if(INSTANCE==null)
    {
    INSTANCE= new GUIHandler();
    }
  return INSTANCE;
  }

@Override
public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
  {
  System.out.println("getting server element: "+ID);
  switch(ID)
  {
  case STRUCTURE_SELECT:
  return new ContainerCSB(player, null);
  
  case STRUCTURE_SCANNER:
  return new ContainerStructureScanner(player);
  
  case STRUCTURE_BUILD_DIRECT:
  return new ContainerSurvivalBuilder(player);
  
  case 3:  
  return null;
  case 4:
  return null;
  case 5:
  return null;
  case 6:
  return null;
  case 7:
  return null;
  case 8:
  return null;
  case 9:
  return null;
  case 10:
  return null;  
  } 
  return null;
  }

@Override
public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
  {
  System.out.println("getting client element: "+ID);
  switch(ID)
  {
  case STRUCTURE_SELECT:
  return new GuiCSB(new ContainerCSB(player, null));
  
  case STRUCTURE_SCANNER:
  return new GuiStructureScanner(new ContainerStructureScanner(player));
  
  case STRUCTURE_BUILD_DIRECT:
  return new GuiSurvivalBuilder(new ContainerSurvivalBuilder(player));
  
  case 3:
  return null;
  case 4:
  return null;
  case 5:
  return null;
  case 6:
  return null;
  case 7:
  return null;
  case 8:
  return null;
  case 9:
  return null;
  case 10:
  return null;  
  } 
  return null;
  }

/**
 * auto-wrapper for sending an openGUI packet from client-server to open a server side GUI without
 * special scripting in every damn entity/TE, also handles sending init data after the GUI is opened
 * all synched containers must openGUI through here, or they must handle synching manually
 * @param ID
 * @param player
 * @param world
 * @param x
 * @param y
 * @param z
 */
public void openGUI(int ID, EntityPlayer player, World world, int x, int y, int z)
  {
  if(player.worldObj.isRemote)
    {
    Packet03GuiComs pkt = new Packet03GuiComs();
    pkt.setGuiToOpen((byte)ID, x, y, z);
    AWCore.proxy.sendPacketToServer(pkt);
    }
  else
    {
    FMLNetworkHandler.openGui(player, AWCore.instance, ID, world, x, y, z);
    if(player.openContainer instanceof ContainerBase)
      {
      NBTTagCompound tag = ((ContainerBase)player.openContainer).getInitData();
      if(tag!=null)
        {
        Packet03GuiComs pkt = new Packet03GuiComs();
        pkt.setInitData(tag);
        AWCore.proxy.sendPacketToPlayer(player, pkt);
        }      
      }
    }
  }

}
