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
package shadowmage.ancient_vehicles.common.vehicles.missiles;

import net.minecraft.entity.Entity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import shadowmage.ancient_framework.common.config.Statics;
import shadowmage.ancient_framework.common.utils.ItemStackWrapperCrafting;

public class AmmoClusterShot extends Ammo
{

/**
 * @param ammoType
 */
public AmmoClusterShot(int ammoType, int weight)
  {
  super(ammoType);    
  this.ammoWeight = weight;
  float scaleFactor = weight + 45.f;
  this.renderScale = ( weight / scaleFactor ) * 2; 
  this.iconTexture = "ammoCluster1";
  this.configName = "cluster_shot_"+weight;
  this.modelTexture = Statics.TEXTURE_PATH+"models/ammo/ammoStoneShot.png";

  this.entityDamage = 5;
  this.vehicleDamage = 5;
  
  this.neededResearch.add(ResearchGoalNumbers.explosives1);
  this.numCrafted = 4;
  switch(weight)
  {
  case 10:
  this.neededResearch.add(ResearchGoalNumbers.ballistics1);
  this.resources.add(new ItemStackWrapperCrafting(ItemLoaderCore.explosiveCharge, 1, false, false));
  this.resources.add(new ItemStackWrapperCrafting(ItemLoaderCore.clusterCharge, 2, false, false));
  this.resources.add(new ItemStackWrapperCrafting(ItemLoaderCore.clayCasing, 2, false, false));
  break;
  
  case 15:
  this.neededResearch.add(ResearchGoalNumbers.ballistics1);
  this.resources.add(new ItemStackWrapperCrafting(ItemLoaderCore.explosiveCharge, 1, false, false));
  this.resources.add(new ItemStackWrapperCrafting(ItemLoaderCore.clusterCharge, 3, false, false));
  this.resources.add(new ItemStackWrapperCrafting(ItemLoaderCore.clayCasing, 3, false, false));
  break;
  
  case 30:
  this.neededResearch.add(ResearchGoalNumbers.ballistics2);
  this.resources.add(new ItemStackWrapperCrafting(ItemLoaderCore.explosiveCharge, 2, false, false));
  this.resources.add(new ItemStackWrapperCrafting(ItemLoaderCore.clusterCharge, 6, false, false));
  this.resources.add(new ItemStackWrapperCrafting(ItemLoaderCore.clayCasing, 6, false, false));
  break;
  
  case 45:
  this.neededResearch.add(ResearchGoalNumbers.ballistics3);
  this.resources.add(new ItemStackWrapperCrafting(ItemLoaderCore.explosiveCharge, 3, false, false));
  this.resources.add(new ItemStackWrapperCrafting(ItemLoaderCore.clusterCharge, 9, false, false));
  this.resources.add(new ItemStackWrapperCrafting(ItemLoaderCore.clayCasing, 9, false, false));
  break;
  }
  }

@Override
public void onImpactWorld(World world, float x, float y, float z, MissileBase missile, MovingObjectPosition hit)
  {   
  if(!world.isRemote)
    {
    double px = hit.hitVec.xCoord - missile.motionX;
    double py = hit.hitVec.yCoord - missile.motionY;
    double pz = hit.hitVec.zCoord - missile.motionZ;
    spawnGroundBurst(world, (float)px, (float)py, (float)pz, 10, Ammo.ammoBallShot, (int)ammoWeight, 35, hit.sideHit, missile.shooterLiving);
    }
  }

@Override
public void onImpactEntity(World world, Entity ent, float x, float y, float z, MissileBase missile)
  {
  if(!world.isRemote)
    {
    spawnAirBurst(world, (float)ent.posX, (float)ent.posY+ent.height, (float)ent.posZ, 10, Ammo.ammoBallShot, (int)ammoWeight, missile.shooterLiving);
    }
  }

}
