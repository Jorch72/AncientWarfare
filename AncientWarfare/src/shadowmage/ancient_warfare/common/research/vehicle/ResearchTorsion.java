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
package shadowmage.ancient_warfare.common.research.vehicle;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import shadowmage.ancient_warfare.common.research.ResearchGoal;

public class ResearchTorsion extends ResearchGoal
{

/**
 * @param num
 */
public ResearchTorsion(int num, int level)
  {
  super(num);
  this.displayName = "Torsion Weapons " + (level+1);
  this.detailedDescription.add("Researching Torsion Weapons advances knowledge" +
  		" of safe conststruction and use of torsion based weapons (using twisted fibers" +
  		" to store energy).  Higher ranks unlock access to higher tiers of torsion" +
  		" based vehicles (if all other prerequisites for the vehicle have been met)." +
  		"  Torsion Weapons 1 is granted to all new players, to allow access to basic Catpult and" +
  		" Ballista vehicles.");
  this.researchTime = 900 * (level+1);
  this.addResource(new ItemStack(Block.planks, (level+1)), true, false);
  this.addResource(new ItemStack(Item.ingotIron, (level+2)/2), false, false);
  this.addResource(new ItemStack(Item.silk, level+1), false, false);
  this.addResource(new ItemStack(Item.paper, (level+1)), false, false);
  this.addResource(new ItemStack(Block.torchWood, level+1), false, false);
  }

}
