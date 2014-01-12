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
package shadowmage.ancient_warfare.common.vehicles.upgrades;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import shadowmage.ancient_warfare.common.research.ResearchGoalNumbers;
import shadowmage.ancient_warfare.common.utils.ItemStackWrapperCrafting;
import shadowmage.ancient_warfare.common.vehicles.VehicleBase;

public class VehicleUpgradeAim extends VehicleUpgradeBase
{

/**
 * @param num
 */
public VehicleUpgradeAim(int num)
  {
  super(num);
  this.displayName = "item.vehicleUpgrade.aim";
  this.tooltip = "item.vehicleUpgrade.aim.tooltip1";
  this.iconTexture = "upgradeAim1";
  this.neededResearch.add(ResearchGoalNumbers.ballistics2);
  this.resources.add(new ItemStackWrapperCrafting(Item.paper, 3));
  this.resources.add(new ItemStackWrapperCrafting(new ItemStack(Block.planks, 1), true, false));
  }

@Override
public void applyVehicleEffects(VehicleBase vehicle)
  {  
  float adj = 1-vehicle.currentAccuracy;
  vehicle.currentAccuracy += adj * .5f;
  if(vehicle.currentAccuracy>1)
    {
    vehicle.currentAccuracy = 1;
    }
  }

}
