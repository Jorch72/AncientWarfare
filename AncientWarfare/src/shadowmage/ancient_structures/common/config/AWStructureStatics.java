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
package shadowmage.ancient_structures.common.config;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import shadowmage.ancient_framework.common.config.ModConfiguration;

public class AWStructureStatics extends ModConfiguration
{

public static String templateExtension = "aws";

public static boolean enableVillageGen;

public static final Set<Class> validEntitiesToScan = new HashSet<Class>();

public static final String guiEditor = "StructureEditor";
public static final String guiScanner = "StructureScanner";
public static final String guiBuilder = "StructureBuilder";
public static final String guiBuilderOverrides = "StructureBuilderOverrides";

/**
 * @param configFile
 * @param log
 * @param version
 */
public AWStructureStatics(File configFile, Logger log, String version)
  {
  super(configFile, log, version);
  }

@Override
public void initializeCategories()
  {

  }

@Override
public void initializeValues()
  {
  this.validEntitiesToScan.add(EntityVillager.class);
  this.validEntitiesToScan.add(EntityPig.class);
  this.validEntitiesToScan.add(EntitySheep.class);
  this.validEntitiesToScan.add(EntityCow.class);
  this.validEntitiesToScan.add(EntityWolf.class);
  this.validEntitiesToScan.add(EntityOcelot.class);
  this.validEntitiesToScan.add(EntityBoat.class);
  this.validEntitiesToScan.add(EntityItemFrame.class);
  this.validEntitiesToScan.add(EntityPainting.class);
  this.validEntitiesToScan.add(EntityMinecart.class); 
  }

}
