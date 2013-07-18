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
package shadowmage.ancient_warfare.client.render.missile;

import shadowmage.ancient_warfare.client.model.ModelArrow2;
import shadowmage.ancient_warfare.client.render.RenderMissileBase;
import shadowmage.ancient_warfare.common.vehicles.missiles.IAmmoType;
import shadowmage.ancient_warfare.common.vehicles.missiles.MissileBase;

public class RenderArrow extends RenderMissileBase
{

public ModelArrow2 arrow2 = new ModelArrow2();

@Override
public void renderMissile(MissileBase missile, IAmmoType ammo, double x,   double y, double z, float yaw, float tick)
  {
  arrow2.render(missile, 0, 0, 0, 0, 0, 0.0625f);
  }

}
