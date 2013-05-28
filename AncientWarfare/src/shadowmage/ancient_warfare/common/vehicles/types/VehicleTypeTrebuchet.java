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
import shadowmage.ancient_warfare.common.registry.ArmorRegistry;
import shadowmage.ancient_warfare.common.research.ResearchGoal;
import shadowmage.ancient_warfare.common.vehicles.VehicleBase;
import shadowmage.ancient_warfare.common.vehicles.helpers.VehicleFiringVarsHelper;
import shadowmage.ancient_warfare.common.vehicles.materials.VehicleMaterial;
import shadowmage.ancient_warfare.common.vehicles.missiles.Ammo;

public class VehicleTypeTrebuchet extends VehicleType
{
/**
 * @param typeNum
 */
public VehicleTypeTrebuchet(int typeNum)
  {
  super(typeNum);
  this.vehicleMaterial = VehicleMaterial.materialWood;
  
  this.maxMissileWeight = 10.f;
  
  this.validAmmoTypes.add(Ammo.ammoStoneShot10);
  this.validAmmoTypes.add(Ammo.ammoStoneShot15); 
  this.validAmmoTypes.add(Ammo.ammoFireShot10);
  this.validAmmoTypes.add(Ammo.ammoFireShot15);
  this.validAmmoTypes.add(Ammo.ammoPebbleShot10);
  this.validAmmoTypes.add(Ammo.ammoPebbleShot15);
  this.validAmmoTypes.add(Ammo.ammoClusterShot10);
  this.validAmmoTypes.add(Ammo.ammoClusterShot15);
  this.validAmmoTypes.add(Ammo.ammoExplosive10);
  this.validAmmoTypes.add(Ammo.ammoExplosive15);
  this.validAmmoTypes.add(Ammo.ammoHE10);
  this.validAmmoTypes.add(Ammo.ammoHE15);
  this.validAmmoTypes.add(Ammo.ammoNapalm10);
  this.validAmmoTypes.add(Ammo.ammoNapalm15);
  
  
  this.validAmmoTypes.add(Ammo.ammoArrow);
  this.validAmmoTypes.add(Ammo.ammoArrowFlame);
  this.validAmmoTypes.add(Ammo.ammoArrowIron);
  this.validAmmoTypes.add(Ammo.ammoArrowIronFlame);
  
  if(Config.addOversizeAmmo)
    {
    this.validAmmoTypes.add(Ammo.ammoStoneShot30);
    this.validAmmoTypes.add(Ammo.ammoStoneShot45);
    this.validAmmoTypes.add(Ammo.ammoFireShot30);
    this.validAmmoTypes.add(Ammo.ammoFireShot45);
    this.validAmmoTypes.add(Ammo.ammoPebbleShot30);
    this.validAmmoTypes.add(Ammo.ammoPebbleShot45);
    this.validAmmoTypes.add(Ammo.ammoClusterShot30);
    this.validAmmoTypes.add(Ammo.ammoClusterShot45);
    this.validAmmoTypes.add(Ammo.ammoExplosive30);
    this.validAmmoTypes.add(Ammo.ammoExplosive45);
    this.validAmmoTypes.add(Ammo.ammoHE30);
    this.validAmmoTypes.add(Ammo.ammoHE45);    
    }
  
  this.ammoBySoldierRank.put(0, Ammo.ammoStoneShot10);
  this.ammoBySoldierRank.put(1, Ammo.ammoStoneShot10);
  this.ammoBySoldierRank.put(2, Ammo.ammoStoneShot10);
  
  this.validArmors.add(ArmorRegistry.armorStone);
  this.validArmors.add(ArmorRegistry.armorIron);
  this.validArmors.add(ArmorRegistry.armorObsidian);
 
  
  this.displayName = "Trebuchet";
//  this.displayTooltip.add("Trebuchet Firing Mechanism");
//  this.displayTooltip.add("Fixed-Emplacement");
//  this.displayTooltip.add("No Turret");
  this.canAdjustPitch = false;
  this.canAdjustPower = true;
  this.canAdjustYaw = false;
  this.isMountable = true;
  this.isCombatEngine = true;
  this.isDrivable = true;
  this.shouldRiderSit = false;
  this.moveRiderWithTurret = false;
  this.baseForwardSpeed = 0.f;
  this.baseStrafeSpeed = 0.5f;
  this.ammoBaySize = 6;
  this.armorBaySize = 3;
  this.upgradeBaySize = 3;
  this.storageBaySize = 0;
  this.accuracy = 0.85f;
  
  this.basePitchMax=70.f;
  this.basePitchMin=70.f;
  this.turretVerticalOffset = (34.f + 67.5f + 24.0f)*0.0625f;
  this.baseMissileVelocityMax = 40.f;
  this.addNeededResearchForMaterials();
  this.addNeededResearch(0, ResearchGoal.vehicleCounterweights1);
  this.addNeededResearch(1, ResearchGoal.vehicleCounterweights1);
  this.addNeededResearch(2, ResearchGoal.vehicleCounterweights2);
  this.addNeededResearch(3, ResearchGoal.vehicleCounterweights2);
  this.addNeededResearch(4, ResearchGoal.vehicleCounterweights3);
  }

@Override
public String getTextureForMaterialLevel(int level)
  {
  switch(level)
    {
    case 0:
    return Config.texturePath + "models/trebuchet1.png";
    case 1:
    return Config.texturePath + "models/trebuchet2.png";
    case 2:
    return Config.texturePath + "models/trebuchet3.png";
    case 3:
    return Config.texturePath + "models/trebuchet4.png";
    case 4:
    return Config.texturePath + "models/trebuchet5.png";
    default:
    return Config.texturePath + "models/trebuchet1.png";
    }
  }
@Override
public VehicleFiringVarsHelper getFiringVarsHelper(VehicleBase veh)
  {
  return new TrebuchetVarHelper(veh);
  }

public class TrebuchetVarHelper extends VehicleFiringVarsHelper
{

float armAngle = -27.f;
float armSpeed = 0.f;
float stringAngle  = -64.f;
float stringSpeed = 0.f;

/**
 * @param vehicle
 */
public TrebuchetVarHelper(VehicleBase vehicle)
  {
  super(vehicle);
  }

@Override
public NBTTagCompound getNBTTag()
  {
  NBTTagCompound tag = new NBTTagCompound();
  tag.setFloat("aA", this.armAngle);
  tag.setFloat("aS", armSpeed);
  tag.setFloat("sA", stringAngle);
  tag.setFloat("sS", stringSpeed);
  return tag;
  }

@Override
public void readFromNBT(NBTTagCompound tag)
  {
  this.armAngle = tag.getFloat("aA");
  this.armSpeed = tag.getFloat("aS");  
  this.stringAngle = tag.getFloat("sA");
  this.stringSpeed = tag.getFloat("sS");
  }

@Override
public void onFiringUpdate()
  {
  float increment = (90.f+27.f) / 20.f;
  armAngle += increment;
  armSpeed = increment;
  stringAngle += 1.3162316f * increment;
  stringSpeed = 1.3162316f * increment;
  if(armAngle>=90)
    {
    armSpeed = 0;
    armAngle = 90.f;
    stringAngle = 90.f;
    stringSpeed = 0.f;
    vehicle.firingHelper.startLaunching();    
    }
  }

@Override
public void onReloadUpdate()
  {
  float increment = (90.f + 27.f) / (float)vehicle.currentReloadTicks;
  if(armAngle>-27)
    {
    armAngle -= increment;
    armSpeed = -increment;   
    stringAngle -= 1.3162316f * increment;
    stringSpeed = -1.3162316f * increment;
    }
  else
    {
    armAngle = -27;
    armSpeed = 0;
    stringAngle = -64.f;
    stringSpeed = 0.f;
    }
  }

@Override
public void onLaunchingUpdate()
  {
  vehicle.firingHelper.spawnMissilesByWeightCount(0, 0, 0);
  vehicle.firingHelper.setFinishedLaunching();
  }

@Override
public void onReloadingFinished()
  {
  armAngle = -27;
  armSpeed = 0;
  stringAngle = -64.f;
  stringSpeed = 0.f;
  }

@Override
public float getVar1()
  {
  return armAngle;
  }

@Override
public float getVar2()
  {
  return armSpeed;
  }

@Override
public float getVar3()
  {
  return stringAngle;
  }

@Override
public float getVar4()
  {
  return stringSpeed;
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
