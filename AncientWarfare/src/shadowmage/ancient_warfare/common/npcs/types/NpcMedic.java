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
package shadowmage.ancient_warfare.common.npcs.types;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import shadowmage.ancient_warfare.common.config.Config;
import shadowmage.ancient_warfare.common.npcs.NpcBase;
import shadowmage.ancient_warfare.common.npcs.NpcTypeBase;
import shadowmage.ancient_warfare.common.npcs.ai.NpcAIObjective;
import shadowmage.ancient_warfare.common.npcs.ai.objectives.AIAttackTargets;
import shadowmage.ancient_warfare.common.npcs.ai.objectives.AIChooseCommander;
import shadowmage.ancient_warfare.common.npcs.ai.objectives.AIDepositGoods;
import shadowmage.ancient_warfare.common.npcs.ai.objectives.AIFollowPlayer;
import shadowmage.ancient_warfare.common.npcs.ai.objectives.AIHealTargets;
import shadowmage.ancient_warfare.common.npcs.ai.objectives.AINpcUpkeepObjective;
import shadowmage.ancient_warfare.common.npcs.ai.objectives.AIPatrolPoints;
import shadowmage.ancient_warfare.common.npcs.ai.objectives.AIStayNearCommander;
import shadowmage.ancient_warfare.common.npcs.ai.objectives.AIStayNearHome;
import shadowmage.ancient_warfare.common.npcs.ai.objectives.AIWander;
import shadowmage.ancient_warfare.common.npcs.helpers.NpcTargetHelper;
import shadowmage.ancient_warfare.common.npcs.helpers.targeting.AITargetEntry;
import shadowmage.ancient_warfare.common.npcs.helpers.targeting.AITargetEntryNpc;
import shadowmage.ancient_warfare.common.npcs.helpers.targeting.AITargetEntryPlayer;
import shadowmage.ancient_warfare.common.npcs.helpers.targeting.AITargetEntryTeamHealing;
import shadowmage.ancient_warfare.common.registry.NpcRegistry;
import shadowmage.ancient_warfare.common.targeting.TargetType;

public class NpcMedic extends NpcTypeBase
{

/**
 * @param type
 */
public NpcMedic(int type)
  {
  super(type);
  this.displayName = "Medic";
  this.configName = "medic";
  this.tooltip = "Heals nearby troops";
  this.isCombatUnit = true;
  this.iconTexture = "npcSoldier1";
  this.defaultTargets = new String[]{"Zombie", "Spider", "CaveSpider", "Blaze", 
      "Enderman", "Ghast", "Giant", "LavaSlime", "PigZombie", "Silverfish", "Skeleton", "Slime"};
  this.addLevel("Medic Novice", Config.texturePath + "models/npcDefault.png", getToolStack(0), getArmorStack(0)).setAttackDamage(3);
  this.addLevel("Medic Adept", Config.texturePath + "models/npcDefault.png", getToolStack(1), getArmorStack(1)).setAttackDamage(4);
  this.addLevel("Medic Expert", Config.texturePath + "models/npcDefault.png", getToolStack(2), getArmorStack(2)).setAttackDamage(5);
  }


@Override
protected ItemStack getToolStack(int level)
  {
  ItemStack sword1 = null;
  sword1 = new ItemStack(Item.axeStone,1);
  return sword1;
  }

@Override
protected ItemStack[] getArmorStack(int level)
  {
  ItemStack[] stacks = new ItemStack[4];  
  stacks[0] = new ItemStack(Item.helmetLeather, 1);
  stacks[1] = new ItemStack(Item.plateLeather, 1);
  stacks[2] = new ItemStack(Item.legsLeather, 1);
  stacks[3] = new ItemStack(Item.bootsLeather, 1);
  return stacks;
  }

@Override
public void addTargets(NpcBase npc, NpcTargetHelper helper)
  {
  helper.addTargetEntry(new AITargetEntryPlayer(npc, TargetType.ATTACK,  40, false, true));
  helper.addTargetEntry(new AITargetEntryNpc(npc, TargetType.ATTACK, 0, 40, false, true));
  helper.addTargetEntry(new AITargetEntryNpc(npc, TargetType.COMMANDER, 0, 40, true, false, NpcTypeBase.npcCommander.getGlobalNpcType()));
  helper.addTargetEntry(new AITargetEntryTeamHealing(npc, TargetType.HEAL, EntityLiving.class, 0, 40));
  }

@Override
public List<NpcAIObjective> getAI(NpcBase npc, int level)
  {
  ArrayList<NpcAIObjective> aiEntries = new ArrayList<NpcAIObjective>(); 
//  aiEntries.add(new AIAttackTargets(npc, 100, 20, 20));
  aiEntries.add(new AIFollowPlayer(npc, 90));
  aiEntries.add(new AINpcUpkeepObjective(npc, 85));
  aiEntries.add(new AIDepositGoods(npc, 80));
  aiEntries.add(new AIHealTargets(npc, 75));
  aiEntries.add(new AIPatrolPoints(npc, 70, 20));
  aiEntries.add(new AIStayNearHome(npc, 60, 40, 15));
  aiEntries.add(new AIStayNearCommander(npc, 55, 20, 10));
  aiEntries.add(new AIAttackTargets(npc, 50, 40, 40));  
  aiEntries.add(new AIWander(npc, 20));
  aiEntries.add(new AIChooseCommander(npc, 10));
  return aiEntries;
  }
}
