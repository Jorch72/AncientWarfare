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
package shadowmage.ancient_warfare.common.vehicles.types;

import net.minecraft.nbt.NBTTagCompound;
import shadowmage.ancient_warfare.common.config.Config;
import shadowmage.ancient_warfare.common.item.ItemLoader;
import shadowmage.ancient_warfare.common.registry.ArmorRegistry;
import shadowmage.ancient_warfare.common.registry.VehicleUpgradeRegistry;
import shadowmage.ancient_warfare.common.research.ResearchGoal;
import shadowmage.ancient_warfare.common.utils.ItemStackWrapperCrafting;
import shadowmage.ancient_warfare.common.vehicles.VehicleBase;
import shadowmage.ancient_warfare.common.vehicles.helpers.VehicleFiringVarsHelper;
import shadowmage.ancient_warfare.common.vehicles.materials.VehicleMaterial;
import shadowmage.ancient_warfare.common.vehicles.missiles.Ammo;

public class VehicleTypeCannon extends VehicleType
{

/**
 * @param typeNum
 */
public VehicleTypeCannon(int typeNum)
  {
  super(typeNum);
  this.vehicleMaterial = VehicleMaterial.materialIron;
  this.materialCount = 5;
  this.maxMissileWeight = 10.f;
  
  this.validAmmoTypes.add(Ammo.ammoIronShot5);
  this.validAmmoTypes.add(Ammo.ammoIronShot10);
  this.validAmmoTypes.add(Ammo.ammoGrapeShot5);
  this.validAmmoTypes.add(Ammo.ammoGrapeShot10);
  this.validAmmoTypes.add(Ammo.ammoCanisterShot5);
  this.validAmmoTypes.add(Ammo.ammoCanisterShot10);
  
  if(Config.addOversizeAmmo)
    {
    this.validAmmoTypes.add(Ammo.ammoIronShot15);
    this.validAmmoTypes.add(Ammo.ammoIronShot25);
    this.validAmmoTypes.add(Ammo.ammoGrapeShot15);
    this.validAmmoTypes.add(Ammo.ammoGrapeShot25);
    this.validAmmoTypes.add(Ammo.ammoCanisterShot15);
    this.validAmmoTypes.add(Ammo.ammoCanisterShot25);
    }
  
  this.ammoBySoldierRank.put(0, Ammo.ammoIronShot5);
  this.ammoBySoldierRank.put(1, Ammo.ammoIronShot5);
  this.ammoBySoldierRank.put(2, Ammo.ammoIronShot5);
  
  this.validUpgrades.add(VehicleUpgradeRegistry.pitchDownUpgrade);
  this.validUpgrades.add(VehicleUpgradeRegistry.pitchUpUpgrade);
  this.validUpgrades.add(VehicleUpgradeRegistry.pitchExtUpgrade);
  this.validUpgrades.add(VehicleUpgradeRegistry.powerUpgrade);
  this.validUpgrades.add(VehicleUpgradeRegistry.reloadUpgrade);
  this.validUpgrades.add(VehicleUpgradeRegistry.aimUpgrade);

  this.validArmors.add(ArmorRegistry.armorStone);
  this.validArmors.add(ArmorRegistry.armorIron);
  this.validArmors.add(ArmorRegistry.armorObsidian);

  this.turretVerticalOffset = 11.5f*0.0625f;
  this.storageBaySize = 0; 
  this.accuracy = 0.98f;
  this.isDrivable = true;
  this.baseForwardSpeed = 0.f;
  this.baseStrafeSpeed = .5f;
  this.basePitchMax = 15;
  this.basePitchMin = -15; 
  this.isMountable = true;
  this.isCombatEngine = true;
  this.canAdjustPitch = true;
  this.canAdjustPower = false;
  this.canAdjustYaw = false;

  this.baseMissileVelocityMax = 42.f;   
  this.width = 2;
  this.height = 2;  

  this.armorBaySize = 3;
  this.upgradeBaySize = 3;
  this.ammoBaySize = 6;
  this.addNeededResearchForMaterials();
  this.addNeededResearch(0, ResearchGoal.vehicleGunpowderWeapons1);
  this.addNeededResearch(1, ResearchGoal.vehicleGunpowderWeapons2);
  this.addNeededResearch(2, ResearchGoal.vehicleGunpowderWeapons3);
  this.addNeededResearch(3, ResearchGoal.vehicleGunpowderWeapons4);
  this.addNeededResearch(4, ResearchGoal.vehicleGunpowderWeapons5);
  this.additionalMaterials.add(new ItemStackWrapperCrafting(ItemLoader.powderCase, 2, false, false));
  this.additionalMaterials.add(new ItemStackWrapperCrafting(ItemLoader.equipmentBay, 1, false, false));
  }

@Override
public String getTextureForMaterialLevel(int level)
  {
  switch(level)
    {
    case 0:
    return Config.texturePath + "models/cannon1.png";
    case 1:
    return Config.texturePath + "models/cannon2.png";
    case 2:
    return Config.texturePath + "models/cannon3.png";
    case 3:
    return Config.texturePath + "models/cannon4.png";
    case 4:
    return Config.texturePath + "models/cannon5.png";
    default:
    return Config.texturePath + "models/cannon1.png";
    }
  }


@Override
public VehicleFiringVarsHelper getFiringVarsHelper(VehicleBase veh)
  {
  return new CannonVarHelper(veh);
  }

public class CannonVarHelper extends VehicleFiringVarsHelper
{

int firingTicks = 0;
/**
 * @param vehicle
 */
public CannonVarHelper(VehicleBase vehicle)
  {
  super(vehicle);
  }

@Override
public NBTTagCompound getNBTTag()
  {
  NBTTagCompound tag = new NBTTagCompound();
  tag.setInteger("fT", firingTicks);
  return tag;
  }

@Override
public void readFromNBT(NBTTagCompound tag)
  {

  }

@Override
public void onFiringUpdate()
  {
  if(firingTicks==0 && !vehicle.worldObj.isRemote)
    {
    vehicle.worldObj.playSoundAtEntity(vehicle, "fireworks.launch", 0.50F, .25F);
    vehicle.playSound("random.fuse", 1.0F, 0.5F);
    }
  firingTicks++;
  if(vehicle.worldObj.isRemote)
    {    
    //TODO offset
    vehicle.worldObj.spawnParticle("smoke", vehicle.posX, vehicle.posY+1.2d, vehicle.posZ, 0.0D, 0.05D, 0.0D);
    }
  if(firingTicks>10)
    {
    if(!vehicle.worldObj.isRemote)
      {
      vehicle.playSound("random.explode", 1.f, 1.f);
      }
    this.vehicle.firingHelper.startLaunching();
    firingTicks=0;
    }
  }

@Override
public void onReloadUpdate()
  {

  }

@Override
public void onLaunchingUpdate()
  {
  vehicle.firingHelper.spawnMissile(0, 0, 0);
  //TODO play explosion sound
  //TODO spawn particles for explosion in direction of missile flight @ end of barrel (translate/offset)
  vehicle.firingHelper.setFinishedLaunching();
  }

@Override
public void onReloadingFinished()
  {
  firingTicks = 0;
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
