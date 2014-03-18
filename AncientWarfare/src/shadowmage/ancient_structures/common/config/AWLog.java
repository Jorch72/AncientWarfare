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

import java.util.logging.Level;
import java.util.logging.Logger;

import shadowmage.ancient_warfare.common.config.Config;

public class AWLog
{

private static Logger log;

public static void setLogger(Logger logger)
  {
  log = logger;
  }

public static void log(String info)
  {
  log.log(Level.INFO, info);
  }

public static void logError(String info)
  {
  log.log(Level.SEVERE, info);
  }

public static void logDebug(String info)
  {
  if(Config.DEBUG)
    {
    log.log(Level.INFO, "[DEBUG] "+info);
    }
  }

}
