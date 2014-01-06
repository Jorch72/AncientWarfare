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
package shadowmage.ancient_framework.common.network;

import net.minecraft.network.packet.Packet250CustomPayload;
import shadowmage.ancient_framework.common.config.AWLog;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

public class Packet00MultiPart extends PacketBase
{

static int nextUniquePacketID = 0;

public int sourcePacketType;//
public int chunkNumber;//
public int totalChunks;//

public int uniquePacketID;//to identify which multi-part packets belong to this packet
public int startIndex;//the start index of this data chunk
public int chunkLength;//the length of this data chunk
public int totalLength;//the total length of the entire original data packet

public byte[] datas;

public Packet00MultiPart()
  {
  
  }

public static int getNextPacketID()
  {
  return nextUniquePacketID++;
  }

@Override
public String getChannel()
  {
  return "AW_mod";
  }

@Override
public int getPacketType()
  {
  return 0;
  }

@Override
public void writeDataToStream(ByteArrayDataOutput data)
  {
  data.writeInt(uniquePacketID);
  data.writeInt(sourcePacketType);  
  data.writeInt(chunkNumber);
  data.writeInt(totalChunks);
  data.writeInt(startIndex);
  data.writeInt(chunkLength);  
  data.writeInt(totalLength);
  data.write(datas);
  }

@Override
public void readDataStream(ByteArrayDataInput data)
  {
  uniquePacketID = data.readInt();
  sourcePacketType = data.readInt();
  chunkNumber = data.readInt();
  totalChunks = data.readInt();
  startIndex = data.readInt();
  chunkLength = data.readInt();  
  totalLength = data.readInt();
  datas = new byte[chunkLength];
  data.readFully(datas);
  }

@Override
public Packet250CustomPayload get250Packet()
  {
  AWLog.logDebug("get250 called for MP packet");
  return super.get250Packet();
  }

@Override
public void execute()
  {
  AWLog.logDebug("executing multi-part packet. number: "+chunkNumber + " of: "+totalChunks);
  PacketHandler.handleMultiPartPacketReceipt(this, this.player);
  }

}
