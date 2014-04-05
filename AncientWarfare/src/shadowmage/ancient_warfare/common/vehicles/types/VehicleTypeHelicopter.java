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
package shadowmage.ancient_warfare.common.vehicles.types;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import shadowmage.ancient_warfare.common.config.Config;
import shadowmage.ancient_warfare.common.item.ItemLoader;
import shadowmage.ancient_warfare.common.registry.VehicleUpgradeRegistry;
import shadowmage.ancient_warfare.common.research.ResearchGoal;
import shadowmage.ancient_warfare.common.utils.ItemStackWrapperCrafting;
import shadowmage.ancient_warfare.common.vehicles.VehicleBase;
import shadowmage.ancient_warfare.common.vehicles.VehicleMovementType;
import shadowmage.ancient_warfare.common.vehicles.helpers.VehicleFiringVarsHelper;
import shadowmage.ancient_warfare.common.vehicles.materials.VehicleMaterial;
import shadowmage.ancient_warfare.common.vehicles.missiles.Ammo;

public class VehicleTypeHelicopter extends VehicleType
{

/**
 * @param typeNum
 */
public VehicleTypeHelicopter(int typeNum)
  {
  super(typeNum);
  this.configName = "aircraft_helicopter";  
  this.vehicleMaterial = VehicleMaterial.materialWood;  
  this.materialCount = 4;
  this.movementType = VehicleMovementType.AIR2;
  this.maxMissileWeight = 20.f;
  this.accuracy = 0.7f;
    
  this.validAmmoTypes.add(Ammo.ammoPebbleShot10);

  this.validAmmoTypes.add(Ammo.ammoArrow);
  this.validAmmoTypes.add(Ammo.ammoArrowFlame);
  this.validAmmoTypes.add(Ammo.ammoArrowIron);
  this.validAmmoTypes.add(Ammo.ammoArrowIronFlame);

  this.validAmmoTypes.add(Ammo.ammoRocket);
  this.validAmmoTypes.add(Ammo.ammoHwachaRocketFlame);
  this.validAmmoTypes.add(Ammo.ammoHwachaRocketExplosive);
  this.validAmmoTypes.add(Ammo.ammoHwachaRocketAirburst);
    
  this.ammoBySoldierRank.put(0, Ammo.ammoArrow);
  this.ammoBySoldierRank.put(1, Ammo.ammoArrowFlame);
  this.ammoBySoldierRank.put(2, Ammo.ammoArrowIronFlame);

    
  this.validUpgrades.add(VehicleUpgradeRegistry.speedUpgrade);
  this.validUpgrades.add(VehicleUpgradeRegistry.reloadUpgrade);
      
  this.armorBaySize = 0;
  this.upgradeBaySize = 6;
  this.ammoBaySize = 2;  
  this.storageBaySize = 0;    
  
  this.addNeededResearchForMaterials();
  
  this.addNeededResearch(0, ResearchGoal.vehicleMobility5);
  this.addNeededResearch(1, ResearchGoal.vehicleMobility5);
  this.addNeededResearch(2, ResearchGoal.vehicleMobility5);
  this.addNeededResearch(3, ResearchGoal.vehicleMobility5);
  this.addNeededResearch(4, ResearchGoal.vehicleMobility5);

  this.addNeededResearch(0, ResearchGoal.vehicleGunpowderWeapons5);
  this.addNeededResearch(1, ResearchGoal.vehicleGunpowderWeapons5);
  this.addNeededResearch(2, ResearchGoal.vehicleGunpowderWeapons5);
  this.addNeededResearch(3, ResearchGoal.vehicleGunpowderWeapons5);
  this.addNeededResearch(4, ResearchGoal.vehicleGunpowderWeapons5);
  
  this.addNeededResearch(1, ResearchGoal.upgradeMechanics5);
  this.addNeededResearch(2, ResearchGoal.upgradeMechanics5);
  this.addNeededResearch(3, ResearchGoal.upgradeMechanics5);
  this.addNeededResearch(4, ResearchGoal.upgradeMechanics5);
  this.addNeededResearch(5, ResearchGoal.upgradeMechanics5);
  
  this.additionalMaterials.add(new ItemStackWrapperCrafting(Item.silk, 8, false, false));
  this.additionalMaterials.add(new ItemStackWrapperCrafting(ItemLoader.powderCase, 2, false, false));
  this.additionalMaterials.add(new ItemStackWrapperCrafting(ItemLoader.equipmentBay, 1, false, false));
  this.additionalMaterials.add(new ItemStackWrapperCrafting(ItemLoader.mobilityUnit, 2, false, false));
  this.additionalMaterials.add(new ItemStackWrapperCrafting(Block.cloth, 10, true, false));
  
  this.baseHealth = 50;
  
  this.width = 2.7f;
  this.height = 1.4f;  
          
  this.baseStrafeSpeed = 2.f;
  this.baseForwardSpeed = 17f*0.05f;
  
  this.turretForwardsOffset = 0.f;
  this.turretVerticalOffset = 0.f;
  this.missileVerticalOffset = 0.25f;
  this.accuracy = 0.94f;
  this.basePitchMax = 0;
  this.basePitchMin = 0; 
  this.baseMissileVelocityMax = 50.f;   
  
  this.riderForwardsOffset = 0.0625f * 7;
  this.riderVerticalOffset = 0.0625f * 12;  
  this.shouldRiderSit = true;
  
  this.isMountable = true;
  this.isDrivable = true;//adjust based on isMobile or not
  this.isCombatEngine = true;
  this.canSoldiersPilot = false;
  
  this.canAdjustPitch = true;
  this.canAdjustPower = false;
  this.canAdjustYaw = false;
  this.turretRotationMax=0.f;//adjust based on mobile/stand fixed (0), stand fixed(90'), or mobile or stand turret (360) 
  this.displayName = "item.vehicleSpawner."+typeNum;
  this.displayTooltip.add("item.vehicleSpawner.tooltip.gunpowder");
  this.displayTooltip.add("item.vehicleSpawner.tooltip.air");
  this.displayTooltip.add("item.vehicleSpawner.tooltip.noturret");
  
  this.enabled = false;
  }

@Override
public VehicleFiringVarsHelper getFiringVarsHelper(VehicleBase veh)
  {
  return new AircraftVarsHelper(veh);
  }

@Override
public String getTextureForMaterialLevel(int level)
  {
  switch(level)
    {
    case 0:
    return Config.texturePath + "models/helicopter1.png";
    case 1:
    return Config.texturePath + "models/helicopter2.png";
    case 2:
    return Config.texturePath + "models/helicopter3.png";
    case 3:
    return Config.texturePath + "models/helicopter4.png";
    case 4:
    return Config.texturePath + "models/helicopter5.png";
    default:
    return Config.texturePath + "models/helicopter1.png";
    }
  }

public class AircraftVarsHelper extends VehicleFiringVarsHelper
{

int missileFired = 0;
int maxMissiles = 0;
int delayTick = 0;
/**
 * @param vehicle
 */
public AircraftVarsHelper(VehicleBase vehicle)
  {
  super(vehicle);
  }

@Override
public NBTTagCompound getNBTTag()
  {
  return new NBTTagCompound();
  }

@Override
public void readFromNBT(NBTTagCompound tag)
  {

  }

@Override
public void onFiringUpdate()
  {  
  this.maxMissiles = vehicle.firingHelper.getMissileLaunchCount();
  vehicle.firingHelper.startLaunching();  
  }

@Override
public void onReloadUpdate()
  {
  
  }

@Override
public void onLaunchingUpdate()
  {  
  delayTick++;
  if(delayTick>=2)
    {
    delayTick = 0;
    if(!vehicle.worldObj.isRemote && vehicle.ammoHelper.getCurrentAmmoCount()>0)
      {
      vehicle.worldObj.playSoundAtEntity(vehicle, "fireworks.launch", 1.0F, 0.5F);
      }
    vehicle.firingHelper.spawnMissile(0, 0, 0);
    this.missileFired++;
    if(missileFired>=maxMissiles)
      {
      vehicle.firingHelper.setFinishedLaunching();
      }
    }  
  }

@Override
public void onReloadingFinished()
  {
  this.missileFired = 0;
  this.delayTick = 0;
  }

@Override
public float getVar1()
  {
  return 0;
  }

@Override
public float getVar2()
  {
  return 0;
  }

@Override
public float getVar3()
  {
  return 0;
  }

@Override
public float getVar4()
  {
  return 0;
  }

@Override
public float getVar5()
  {
  return 0;
  }

@Override
public float getVar6()
  {
  return 0;
  }

@Override
public float getVar7()
  {
  return 0;
  }

@Override
public float getVar8()
  {
  return 0;
  }
}
}
