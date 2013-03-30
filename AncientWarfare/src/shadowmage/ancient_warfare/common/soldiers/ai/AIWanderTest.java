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
package shadowmage.ancient_warfare.common.soldiers.ai;

import net.minecraft.nbt.NBTTagCompound;
import shadowmage.ancient_warfare.common.config.Config;
import shadowmage.ancient_warfare.common.soldiers.NpcAI;
import shadowmage.ancient_warfare.common.soldiers.NpcBase;
import shadowmage.ancient_warfare.common.soldiers.helpers.targeting.AIAggroEntry;
import shadowmage.ancient_warfare.common.soldiers.helpers.targeting.AITargetEntry;

public class AIWanderTest extends NpcAI
{

AITargetEntry wanderTarget;

int range;

/**
 * @param typeNum
 * @param npc
 */
public AIWanderTest(NpcBase npc, int wanderRange)
  {
  super(npc);
  this.successTicks = 80;
  this.failureTicks = 20;
  this.taskName = "Wander.Basic";
  this.taskType = WANDER;
  this.range = wanderRange;
  this.wanderTarget = new AITargetEntry(npc, TARGET_WANDER, null, 0, false, range);
  }
@Override
public int exclusiveTasks()
  {
  return ATTACK+MOUNT_VEHICLE+FOLLOW+REPAIR+HEAL+HARVEST;
  }

@Override
public void onTick()
  {
  if(npc.ridingEntity!=null || npc.getTarget()!=null)
    {    
    finished = true;
    return;
    }
  Config.logDebug("executing wander tick");
  double bX = npc.posX + rng.nextInt(range*2)-range;
  double bY = npc.posY;
  double bZ = npc.posZ + rng.nextInt(range*2)-range;
  
  AIAggroEntry target = new AIAggroEntry(npc, wanderTarget, (int)bX, (int)bY, (int)bZ);
  npc.setTargetAW(target);
  this.success = true;
  this.successTicks = rng.nextInt(100)+80;
  this.finished = true; 
  }

@Override
public void readFromNBT(NBTTagCompound tag)
  {

  }

@Override
public NBTTagCompound getNBTTag()
  {
  return new NBTTagCompound();
  }

@Override
public void onAiStarted()
  {

  }

}
