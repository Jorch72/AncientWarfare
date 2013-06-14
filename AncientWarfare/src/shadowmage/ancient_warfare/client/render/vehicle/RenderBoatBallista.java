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
package shadowmage.ancient_warfare.client.render.vehicle;

import shadowmage.ancient_warfare.client.model.ModelBoatBallista;
import shadowmage.ancient_warfare.client.render.RenderVehicleBase;
import shadowmage.ancient_warfare.common.vehicles.VehicleBase;
import shadowmage.ancient_warfare.common.vehicles.helpers.VehicleFiringVarsHelper;

public class RenderBoatBallista extends RenderVehicleBase
{


ModelBoatBallista model = new ModelBoatBallista();

@Override
public void renderVehicle(VehicleBase veh, double x, double y, double z,  float yaw, float tick)
  {
  VehicleFiringVarsHelper var = veh.firingVarsHelper;
  model.setTurretRotation(yaw-veh.localTurretRotation + (1-tick)*veh.currentTurretYawSpeed, -veh.localTurretPitch + tick * veh.currentTurretPitchSpeed);
  model.setCrankRotations(var.getVar1() + (tick*var.getVar2()));
  model.setBowAndStringRotation(var.getVar3() + tick*var.getVar4(), var.getVar5() + tick*var.getVar6());
  model.setTriggerAngle(var.getVar7());
  float wheelAngle = veh.wheelRotation + (tick * (veh.wheelRotation-veh.wheelRotationPrev));
  model.setWheelRotations(wheelAngle, wheelAngle, wheelAngle, wheelAngle);
  model.render(veh, 0, 0, 0, 0, 0, 0.0625f);
  }

@Override
public void renderVehicleFlag()
  {
  model.renderFlag();
  }


}
