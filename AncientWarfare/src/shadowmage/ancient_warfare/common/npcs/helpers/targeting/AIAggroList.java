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
package shadowmage.ancient_warfare.common.npcs.helpers.targeting;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.entity.Entity;
import shadowmage.ancient_warfare.common.interfaces.ITargetEntry;
import shadowmage.ancient_warfare.common.npcs.NpcBase;
import shadowmage.ancient_warfare.common.targeting.TargetPosition;
import shadowmage.ancient_warfare.common.targeting.TargetType;

public class AIAggroList
{

protected NpcBase npc;
public final TargetType targetType;
public ArrayList<AIAggroTargetWrapper> targetEntries = new ArrayList<AIAggroTargetWrapper>();

public AIAggroList(NpcBase owner, TargetType targetType)
  {
  this.npc = owner;
  this.targetType = targetType;
  }

public void addOrUpdateEntry(Entity ent, int aggroAmt, AITargetEntry type)
  {  
  for(AIAggroTargetWrapper entry : this.targetEntries)
    {
    if(entry.matches(ent))
      {      
      entry.aggroLevel+=aggroAmt;
      return;
      }
    }
  TargetPosition target = TargetPosition.getNewTarget(ent, type.getTypeName());
  AIAggroTargetWrapper wrap = new AIAggroTargetWrapper(target).setAggro(aggroAmt);
  this.targetEntries.add(wrap);
  }

public void addOrUpdateEntry(int x, int y, int z, int aggroAmt, AITargetEntry type)
  {
  for(AIAggroTargetWrapper entry : this.targetEntries)
    {
    if(entry.matches(x,y,z))
      {      
      entry.aggroLevel+=aggroAmt;
      return;
      }
    }
  TargetPosition target = TargetPosition.getNewTarget(x,y,z, type.getTypeName());
  AIAggroTargetWrapper wrap = new AIAggroTargetWrapper(target).setAggro(aggroAmt);
  this.targetEntries.add(wrap);
  }

public AIAggroTargetWrapper getEntryFor(Entity ent)
  {
  for(AIAggroTargetWrapper entry : this.targetEntries)
    {
    if(entry.matches(ent))
      {
      return entry;
      }
    }
  return null;
  }

public boolean areTargetsInRange(float range)
  {
//  Config.logDebug("checking for targets in range: "+range+" type: "+this.targetType);
  for(AIAggroTargetWrapper entry : this.targetEntries)
    {
    
//    float dist = npc.getDistanceFromTarget(entry);
//    Config.logDebug("testing :"+entry+" at range: "+dist);
    if(npc.getDistanceFromTarget(entry.target) < range)
      {
      return true;
      }    
    }
  return false;
  }

public ITargetEntry getHighestAggroTargetInRange(float range)
  {
  AIAggroTargetWrapper bestEntry = null;
  for(AIAggroTargetWrapper entry : this.targetEntries)
    {
    if(npc.getDistanceFromTarget(entry.target)>range)
      {
      continue;
      }
    if(entry.isValidEntry() && (bestEntry==null || entry.aggroLevel > bestEntry.aggroLevel))
      {
      bestEntry = entry;
      }
    }
  return bestEntry.target;
  }

public ITargetEntry getHighestAggroTarget()
  {  
  AIAggroTargetWrapper bestEntry = null;
  for(AIAggroTargetWrapper entry : this.targetEntries)
    {
    if(entry.isValidEntry() && (bestEntry==null || entry.aggroLevel > bestEntry.aggroLevel))
      {
      bestEntry = entry;
      }
    }
  return bestEntry.target;
  }

public void updateAggroEntries()
  {
  Iterator<AIAggroTargetWrapper> it = this.targetEntries.iterator();
  AIAggroTargetWrapper entry;
  float maxRange;
  while(it.hasNext())
    {
    entry = it.next();
    if(!entry.isValidEntry() || npc.getDistanceFromTarget(entry.target) > npc.targetHelper.getMaxRangeFor(entry) || entry.aggroLevel <= 0)
      {
      it.remove();
      return;
      }   
    entry.aggroLevel -= npc.targetHelper.getAggroAdjustmentFor(entry);//entry.targetEntry.getAggroAdjustment(entry);
    } 
  }

}