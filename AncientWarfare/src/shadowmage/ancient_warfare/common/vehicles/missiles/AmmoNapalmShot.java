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
package shadowmage.ancient_warfare.common.vehicles.missiles;

import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import shadowmage.ancient_framework.common.config.Config;
import shadowmage.ancient_framework.common.utils.ItemStackWrapperCrafting;
import shadowmage.ancient_warfare.common.item.ItemLoader;
import shadowmage.ancient_warfare.common.research.ResearchGoalNumbers;

public class AmmoNapalmShot extends Ammo
{

/**
 * @param ammoType
 */
public AmmoNapalmShot(int ammoType, int weight)
  {
  super(ammoType);
  this.ammoWeight = weight;
  this.entityDamage = weight;
  this.vehicleDamage = weight;
  float scaleFactor = weight + 45.f;
  this.renderScale = ( weight / scaleFactor ) * 2; 
  this.iconTexture = "ammoNapalm1";
  this.configName = "napalm_shot_"+weight;
  this.modelTexture = Config.texturePath+"models/ammo/ammoStoneShot.png";
  this.isFlaming = true;
  
  this.neededResearch.add(ResearchGoalNumbers.flammables3);
  int cases = 1;
  int explosives = 1;
  this.numCrafted = 2;
  switch(weight)
  {
  case 10:
  this.neededResearch.add(ResearchGoalNumbers.ballistics1);
  cases = 1;
  explosives = 1;
  break;
  
  case 15:
  this.neededResearch.add(ResearchGoalNumbers.ballistics1);
  cases = 2;
  explosives = 2;
  break;
  
  case 30:
  this.neededResearch.add(ResearchGoalNumbers.ballistics2);
  cases = 4;
  explosives = 4;
  break;
  
  case 45:
  this.neededResearch.add(ResearchGoalNumbers.ballistics3);
  cases = 6;
  explosives = 6;
  break;
  }
   
  this.resources.add(new ItemStackWrapperCrafting(ItemLoader.napalmCharge, explosives, false, false));
  this.resources.add(new ItemStackWrapperCrafting(ItemLoader.clayCasing, cases, false, false));
  }

@Override
public void onImpactWorld(World world, float x, float y, float z, MissileBase missile, MovingObjectPosition hit)
  {
  int bx = MathHelper.floor_float(x);
  int by = MathHelper.floor_float(y);  
  int bz = MathHelper.floor_float(z);  
  setBlockToLava(world, bx, by, bz, 5);
  double dx = missile.motionX;
  double dz = missile.motionZ;  
  if(Math.abs(dx)>Math.abs(dz))
    {
    dz = 0;
    }
  else
    {
    dx = 0;
    }
  dx = dx<0 ? -1 : dx > 0 ? 1 : dx;
  dz = dz<0 ? -1 : dz > 0 ? 1 : dz;
  if(ammoWeight>=15)//set the 'forward' block to lava as well
    {
    setBlockToLava(world, bx+ (int)dx, by, bz+(int)dz, 5);
    }
  if(ammoWeight>=30)//set the 'rear' block to lava as well
    {
    setBlockToLava(world, bx-(int)dx, by, bz-(int)dz, 5);
    }
  if(ammoWeight>=45)
    {
    if(dx==0)//have already done Z's
      {
      setBlockToLava(world, bx+1, by, bz, 5);
      setBlockToLava(world, bx-1, by, bz, 5);
      }
    else
      {
      setBlockToLava(world, bx, by, bz+1, 5);
      setBlockToLava(world, bx, by, bz-1, 5);
      }
    }
  }

@Override
public void onImpactEntity(World world, Entity ent, float x, float y, float z, MissileBase missile)
  {
  if(!world.isRemote)
    {
    ent.attackEntityFrom(DamageType.causeEntityMissileDamage(missile.shooterLiving, true, false), this.getEntityDamage());
    ent.setFire(3);
    onImpactWorld(world, x, (float)ent.posY, z, missile, null);
    }
  }

}
