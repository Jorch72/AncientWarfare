/**
   Copyright 2012-2013 John Cummens (aka Shadowmage, Shadowmage4513)
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
package shadowmage.ancient_vehicles.common.vehicle;

import java.util.HashMap;

public class VehicleType
{

public static HashMap<String, VehicleType> vehicleTypes = new HashMap<String, VehicleType>();

String name;//translation key/unique registered name for this vehicle type
Object movementType;//enum / flag for movement type for this vehicle
int maxHealth;//max health for this vehicle type
float mass;//un-adjusted mass for this vehicle
float thrust;//used with mass to determine acceleration/handling for this vehicle
float firePower;//used with ammo mass to determine final projectile velocity

String renderId;//used by rendering to..well..render
String modelTexture;//used by rendering to bind the proper texture
String modelId;//used by rendering to select the proper model

public VehicleType(int id, String name)
  {
  this.name = name;
  vehicleTypes.put(name, this);
  }

public static final VehicleType getVehicleType(String name)
  {
  return vehicleTypes.get(name);
  }

}
