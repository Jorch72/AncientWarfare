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

import java.util.Collection;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import shadowmage.ancient_framework.common.utils.ItemStackWrapperCrafting;
import shadowmage.ancient_vehicles.common.vehicles.VehicleBase;

/**
 * interfaced used by ammo types, implemented for possible future API use and 
 * ease of future expansion without necessitating extension/inheritance
 * @author Shadowmage
 */
public interface IAmmoType
{

/**
 * get this ammo types global reference/ID number (used by vehicles to determine usability)
 * @return
 */
int getAmmoType();//the global unique ammo type, used by structure spawning to fill ammo bays
int getEntityDamage();
int getVehicleDamage();

String getConfigName();
boolean isEnabled();
void setEnabled(boolean val);
void setEntityDamage(int damage);
void setVehicleDamage(int damage);
String getDisplayName();//the displayed item-name/ammo name for this ammo
List<String> getDisplayTooltip();//the display tooltip for this ammo
String getModelTexture();//get the display texture
String getIconTexture();
ItemStack getDisplayStack();//should be a persistent stack in the ammo instance, used to display ammo...
ItemStack getAmmoStack(int qty);//used to create a stack of this ammo.  used in structure spawning
IAmmoType getSecondaryAmmoType();//if this is just a 'container' ammo, get the contained type
Icon getDisplayIcon();//pull the icon for this item from..wherever (desc. registry).
int getSecondaryAmmoTypeCount();//get the contained qty of what this ammo represents (used by cluster/grapeshot)
boolean hasSecondaryAmmo();
boolean isFlaming();//used by client-side rendering to render the missile on-fire, does nothing else
boolean isAmmoValidFor(VehicleBase vehicle);//can be used for per-upgrade compatibility.  vehicle will check this before firing or adding ammo to the vehicle
boolean updateAsArrow();//should update pitch like an arrow (relative to flight direction)
boolean isRocket();//determines flight characteristics
boolean isPersistent();//should die on impact, or stay on ground(arrows)
boolean isPenetrating();//if persistent, and penetrating==true, will not bounce off of stuff, but instead go through it (heavy projectiles)
boolean isProximityAmmo();//should detonate when coming CLOSE to something? (range for entity/ground set below)
boolean isAvailableAsItem();
boolean isTorpedo();
float entityProximity();
float groundProximity();
float getGravityFactor();//statically set..should techincally be depricated in favor of a const
float getAmmoWeight();//weight of the missile in KG
float getRenderScale();//get relative render scale of the ammo compared to the model default scale...(varies per ammo/model)

void onImpactWorld(World world, float x, float y, float z, MissileBase missile, MovingObjectPosition hit);//called when the entity impacts a world block
void onImpactEntity(World world, Entity ent, float x, float y, float z, MissileBase missile);//called when the entity impacts another entity

ResourceListRecipe constructRecipe();
Collection<Integer> getNeededResearch();
void addResearch(Integer num);
void addResearch(IResearchGoal goal);
Collection<ItemStackWrapperCrafting> getResources(); 
int getNumCrafted();

}
