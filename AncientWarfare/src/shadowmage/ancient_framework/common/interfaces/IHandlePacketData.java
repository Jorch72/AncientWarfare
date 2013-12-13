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
package shadowmage.ancient_framework.common.interfaces;

import net.minecraft.nbt.NBTTagCompound;


/**
 * an interface for containers or other abstract structures that need to directly 
 * handle data from packets.  Normally used for container server-client synching
 * @author Shadowmage
 *
 */
public interface IHandlePacketData
{


/**
 * intial data call, should be set by base container, not overriden
 * @param tag
 */
public void handleRawPacketData(NBTTagCompound tag);

/**
 * regular coms, should blindly update container.
 * @param tag
 */
public void handlePacketData(NBTTagCompound tag);



/**
 * server->client init data, should only exec client side, to setup any params not available
 * on client end.
 * @param tag
 */
public void handleInitData(NBTTagCompound tag);


}
