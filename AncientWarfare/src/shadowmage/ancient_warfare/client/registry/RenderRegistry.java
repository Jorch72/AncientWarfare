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
package shadowmage.ancient_warfare.client.registry;

import java.util.HashMap;

import net.minecraft.client.renderer.entity.Render;
import shadowmage.ancient_warfare.client.render.RenderArrow;
import shadowmage.ancient_warfare.client.render.RenderMissileHelper;
import shadowmage.ancient_warfare.client.render.RenderShot;
import shadowmage.ancient_warfare.client.render.RenderVehicleBase;
import shadowmage.ancient_warfare.client.render.RenderVehicleHelper;
import shadowmage.ancient_warfare.client.render.vehicle.RenderBallistaMobile;
import shadowmage.ancient_warfare.client.render.vehicle.RenderBallistaStand;
import shadowmage.ancient_warfare.client.render.vehicle.RenderBatteringRam;
import shadowmage.ancient_warfare.client.render.vehicle.RenderCatapultMobileFixed;
import shadowmage.ancient_warfare.client.render.vehicle.RenderCatapultMobileTurret;
import shadowmage.ancient_warfare.client.render.vehicle.RenderCatapultStandFixed;
import shadowmage.ancient_warfare.client.render.vehicle.RenderCatapultStandTurret;
import shadowmage.ancient_warfare.common.missiles.MissileBase;
import shadowmage.ancient_warfare.common.registry.VehicleRegistry;
import shadowmage.ancient_warfare.common.vehicles.IVehicleType;
import shadowmage.ancient_warfare.common.vehicles.VehicleBase;
import cpw.mods.fml.client.registry.RenderingRegistry;

/**
 * handle render information
 * @author Shadowmage
 *
 */
public class RenderRegistry
{

private RenderRegistry(){}
private static RenderRegistry INSTANCE;
public static RenderRegistry instance()
  {
  if(INSTANCE==null){INSTANCE = new RenderRegistry();}
  return INSTANCE;
  }

private HashMap<Integer, Render> missileRenders = new HashMap<Integer, Render>();
private HashMap<Integer, RenderVehicleBase> vehicleRenders = new HashMap<Integer, RenderVehicleBase>();

public void loadRenders()
  {  
  /**
   * vehicles..
   */  
  RenderingRegistry.registerEntityRenderingHandler(VehicleBase.class, new RenderVehicleHelper());
  this.addVehicleRender(VehicleRegistry.CATAPULT_STAND_FIXED, new RenderCatapultStandFixed());
  this.addVehicleRender(VehicleRegistry.CATAPULT_STAND_TURRET, new RenderCatapultStandTurret());
  this.addVehicleRender(VehicleRegistry.CATAPULT_MOBILE_FIXED, new RenderCatapultMobileFixed());
  this.addVehicleRender(VehicleRegistry.CATAPULT_MOBILE_TURRET, new RenderCatapultMobileTurret());
  this.addVehicleRender(VehicleRegistry.BALLISTA_STAND_FIXED, new RenderBallistaStand());
  this.addVehicleRender(VehicleRegistry.BALLISTA_STAND_TURRET, new RenderBallistaStand());
  this.addVehicleRender(VehicleRegistry.BALLISTA_MOBILE_FIXED, new RenderBallistaMobile());
  this.addVehicleRender(VehicleRegistry.BALLISTA_MOBILE_TURRET, new RenderBallistaMobile());
  this.addVehicleRender(VehicleRegistry.BATTERING_RAM, new RenderBatteringRam());
  
  
  /**
   * missiles...
   */
  RenderingRegistry.registerEntityRenderingHandler(MissileBase.class, new RenderMissileHelper());
  this.addMissileRender(0, new RenderArrow());  
  this.addMissileRender(1, new RenderShot());
  }

public void addVehicleRender(IVehicleType type, RenderVehicleBase rend)
  {
  this.vehicleRenders.put(type.getGlobalVehicleType(), rend);
  }
  
public void addMissileRender(int type, Render rend)
  {
  this.missileRenders.put(type, rend); 
  }

public Render getRenderForMissile(int type)
  {
  return this.missileRenders.get(type);
  }

public RenderVehicleBase getRenderForVehicle(int type)
  {
  return this.vehicleRenders.get(type);
  }


}
