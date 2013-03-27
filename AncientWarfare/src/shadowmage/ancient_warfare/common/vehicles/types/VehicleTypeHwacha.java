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
import net.minecraft.util.MathHelper;
import shadowmage.ancient_warfare.common.config.Config;
import shadowmage.ancient_warfare.common.registry.ArmorRegistry;
import shadowmage.ancient_warfare.common.registry.VehicleUpgradeRegistry;
import shadowmage.ancient_warfare.common.utils.Trig;
import shadowmage.ancient_warfare.common.vehicles.VehicleBase;
import shadowmage.ancient_warfare.common.vehicles.helpers.VehicleFiringVarsHelper;
import shadowmage.ancient_warfare.common.vehicles.materials.VehicleMaterial;
import shadowmage.ancient_warfare.common.vehicles.missiles.Ammo;


public class VehicleTypeHwacha extends VehicleType
{

/**
 * @param typeNum
 */
public VehicleTypeHwacha(int typeNum)
  {
  super(typeNum);
  this.vehicleMaterial = VehicleMaterial.materialWood;  
  this.width = 1.5f;
  this.height = 1.8f;
  
  this.maxMissileWeight = 1.f;
  
  this.validAmmoTypes.add(Ammo.ammoRocket);
  
  this.validArmors.add(ArmorRegistry.armorStone);
  this.validArmors.add(ArmorRegistry.armorIron);
  this.validArmors.add(ArmorRegistry.armorObsidian);

  this.validUpgrades.add(VehicleUpgradeRegistry.aimUpgrade);
  this.validUpgrades.add(VehicleUpgradeRegistry.pitchDownUpgrade);
  this.validUpgrades.add(VehicleUpgradeRegistry.pitchUpUpgrade);
  this.validUpgrades.add(VehicleUpgradeRegistry.powerUpgrade);  
  this.validUpgrades.add(VehicleUpgradeRegistry.reloadUpgrade);
  this.validUpgrades.add(VehicleUpgradeRegistry.speedUpgrade);
  
  this.isMountable = true;
  this.isDrivable = true;
  this.shouldRiderSit = false;
  this.moveRiderWithTurret = false;
  this.isCombatEngine = true;
  this.canAdjustPower = true;
  this.canAdjustPitch = false;
  this.canAdjustYaw = false;
  this.accuracy = 0.75f;
  this.baseStrafeSpeed = 1.f;
  this.baseForwardSpeed = 3.5f*0.05f;  
  this.basePitchMax = 39;
  this.basePitchMin = 39;
  this.turretRotationMax = 0.f;  

  this.width = 2;
  this.height = 2; 
  this.baseMissileVelocityMax = 42.f;
  
  this.turretVerticalOffset = 8 * 0.0625f;
  this.missileForwardsOffset = -0.9375f-0.0625f;
  
  this.riderForwardsOffset = -1.4f;
  this.riderVerticalOffset = 0.5f;
  this.displayName = "Hwacha";
  this.displayTooltip = "OMGZ Rockets!";
  this.storageBaySize = 0;
  this.armorBaySize = 3;
  this.ammoBaySize = 6;
  this.upgradeBaySize = 3;
  }

@Override
public String getTextureForMaterialLevel(int level)
  {
  switch(level)
    {
    case 0:
    return Config.texturePath + "models/hwacha1.png";
    case 1:
    return Config.texturePath + "models/hwacha2.png";
    case 2:
    return Config.texturePath + "models/hwacha3.png";
    case 3:
    return Config.texturePath + "models/hwacha4.png";
    case 4:
    return Config.texturePath + "models/hwacha5.png";
    default:
    return Config.texturePath + "models/hwacha1.png";
    }
  }

@Override
public VehicleFiringVarsHelper getFiringVarsHelper(VehicleBase veh)
  {
  return new HwachaFiringVarsHelper(veh);
  }

public class HwachaFiringVarsHelper extends VehicleFiringVarsHelper
{

int missileFired = 0;
int delayTick = 0;
/**
 * @param vehicle
 */
public HwachaFiringVarsHelper(VehicleBase vehicle)
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
  if(delayTick>=5)
    {
    delayTick = 0;
    calcMissileOffset(missileFired);
    if(!vehicle.worldObj.isRemote && vehicle.ammoHelper.getCurrentAmmoCount()>0)
      {
      vehicle.worldObj.playSoundAtEntity(vehicle, "fireworks.launch", 1.0F, 0.5F);
      }
    vehicle.firingHelper.spawnMissile(missileOffsetX, missileOffsetY, missileOffsetZ);
    this.missileFired++;
    if(missileFired>=36)
      {
      vehicle.firingHelper.setFinishedLaunching();
      }
    }  
  }

float missileOffsetX;
float missileOffsetY;
float missileOffsetZ;

private void calcMissileOffset(int missileNum)
  {
  int currentRow = missileNum / 9;
  int currentCol = missileNum % 9;  
  float targetX = ((float)currentCol) * 0.0625f * 2.f;
  targetX -= 8.f*0.0625f;
  float targetY = ((float)currentRow) * 0.0625f * 2.f;
  float targetZ = 0.f;
  float targetAngle = 0.f+vehicle.rotationYaw;
  float len = MathHelper.sqrt_float(targetX*targetX+targetZ*targetZ);
  missileOffsetX = Trig.cosDegrees(targetAngle)*len;
  if(targetX<0){missileOffsetX *= -1;}
  missileOffsetZ = -Trig.sinDegrees(targetAngle)*len;    
  missileOffsetY = Trig.cosDegrees(vehicle.localTurretPitch)*targetY;
  missileOffsetZ += Trig.sinDegrees(vehicle.localTurretPitch)*targetY;
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
