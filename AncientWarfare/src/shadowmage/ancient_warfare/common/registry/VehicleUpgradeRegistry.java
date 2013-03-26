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
package shadowmage.ancient_warfare.common.registry;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.item.ItemStack;
import shadowmage.ancient_warfare.common.item.ItemLoader;
import shadowmage.ancient_warfare.common.vehicles.upgrades.IVehicleUpgradeType;
import shadowmage.ancient_warfare.common.vehicles.upgrades.VehicleUpgradeAim;
import shadowmage.ancient_warfare.common.vehicles.upgrades.VehicleUpgradePitchDown;
import shadowmage.ancient_warfare.common.vehicles.upgrades.VehicleUpgradePitchUp;
import shadowmage.ancient_warfare.common.vehicles.upgrades.VehicleUpgradePower;
import shadowmage.ancient_warfare.common.vehicles.upgrades.VehicleUpgradeReload;
import shadowmage.ancient_warfare.common.vehicles.upgrades.VehicleUpgradeSpeed;
import shadowmage.ancient_warfare.common.vehicles.upgrades.VehicleUpgradeTurretPitch;

public class VehicleUpgradeRegistry
{


public static final IVehicleUpgradeType speedUpgrade = new VehicleUpgradeSpeed(0);
public static final IVehicleUpgradeType aimUpgrade = new VehicleUpgradeAim(1);
public static final IVehicleUpgradeType reloadUpgrade = new VehicleUpgradeReload(2);

public static final IVehicleUpgradeType powerUpgrade = new VehicleUpgradePower(4);
public static final IVehicleUpgradeType pitchExtUpgrade = new VehicleUpgradeTurretPitch(5);
public static final IVehicleUpgradeType pitchUpUpgrade = new VehicleUpgradePitchUp(6);
public static final IVehicleUpgradeType pitchDownUpgrade = new VehicleUpgradePitchDown(7);

private Map<Integer, IVehicleUpgradeType> upgradeTypeMap = new HashMap<Integer, IVehicleUpgradeType>();

private VehicleUpgradeRegistry(){}
public static VehicleUpgradeRegistry instance()
  {
  if(INSTANCE==null)
    {
    INSTANCE = new VehicleUpgradeRegistry();
    }
  return INSTANCE;
  }
private static VehicleUpgradeRegistry INSTANCE;


/**
 * called during init to register upgrade types as items
 */
public void registerUpgrades()
  {
  this.registerUpgrade(speedUpgrade);
  this.registerUpgrade(aimUpgrade);
  this.registerUpgrade(reloadUpgrade);
  
  this.registerUpgrade(powerUpgrade);
  this.registerUpgrade(pitchExtUpgrade);
  this.registerUpgrade(pitchUpUpgrade);
  this.registerUpgrade(pitchDownUpgrade);
  }

/**
 * @param dmg
 * @param type
 * @param upgrade
 */
public void registerUpgrade(IVehicleUpgradeType upgrade)
  {  
  this.upgradeTypeMap.put(upgrade.getUpgradeGlobalTypeNum(), upgrade);
  ItemLoader.instance().addSubtypeToItem(ItemLoader.vehicleUpgrade, upgrade.getUpgradeGlobalTypeNum(), upgrade.getDisplayName(), upgrade.getDisplayTooltip());
  }

public IVehicleUpgradeType getUpgrade(int type)
  {
  return this.upgradeTypeMap.get(type);
  }

public IVehicleUpgradeType getUpgrade(ItemStack stack)
  {
  if(stack==null)
    {
    return null;
    }
  if(stack.itemID == ItemLoader.vehicleUpgrade.itemID)
    {
    return this.upgradeTypeMap.get(stack.getItemDamage());
    }
  return null;
  }

public boolean isStackUpgradeItem(ItemStack stack)
  {
  if(stack==null)
    {
    return false;
    }
  if(stack.itemID==ItemLoader.vehicleUpgrade.itemID)
    {
    return true;
    }  
  return false;
  }

}
