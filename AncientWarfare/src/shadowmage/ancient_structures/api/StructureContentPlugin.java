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
package shadowmage.ancient_structures.api;

import shadowmage.ancient_structures.common.template.plugin.StructurePluginManager;


public abstract class StructureContentPlugin
{

/**
 * implementing classes should use this callback to register any 
 * block handlers with the passed in manager<br>
 * call manager.registerBlockHandler() to register your rule classes
 * @param manager
 */
public abstract void addHandledBlocks(StructurePluginManager manager);

/**
 * implementing classes should use this callback to register any 
 * entity handlers with the passed in manager
 * call manager.registerEntityHandler() to register your rule classes
 * @param manager
 */
public abstract void addHandledEntities(StructurePluginManager manager);



}
