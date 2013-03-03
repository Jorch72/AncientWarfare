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
package shadowmage.ancient_warfare.common.utils;

import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

/**
 * because I hate it so much...why not make the 
 * computer do it all for me?
 * @author Shadowmage
 *
 */
public class Trig
{
public static final float PI = 3.141592653589793f;
public static final float TORADIANS = PI / 180.f;
public static final float TODEGREES = 180.f / PI;

public static int getPower(int num, int exp)
  {
  return Double.valueOf(Math.floor(Math.pow(num, exp))).intValue();
  }

public static float toRadians(float degrees)
  {
  return degrees * TORADIANS;
  }

public static float toDegrees(float radians)
  {
  return radians * TODEGREES;
  }

public static float cosDegrees(float degrees)
  {   
  return MathHelper.cos(degrees * TORADIANS);
  }

public static float sinDegrees(float degrees)
  {  
  return MathHelper.sin(degrees * TORADIANS);
  }

public static float cos(float radians)
  {
  return MathHelper.cos(radians);
  }

public static float sin(float radians)
  {
  return MathHelper.sin(radians);
  }

public static double wrapTo360(double in)
  {
  while(in>=360)
    {
    in-=360;
    }
  while(in<0)
    {
    in+=360;
    }
  return in;
  }

public static float wrapTo360(float in)
  {
  while(in>=360.f)
    {
    in-=360.f;
    }
  while(in<0)
    {
    in+=360.f;
    }
  return in;  
  }

public static int getAbsDiff(int a, int b)
  {
  if(a<b)
    {
    return b-a;
    }
  return a-b;
  }

public static float getAbsDiff(float a, float b)
  {
  if(a<b)
    {
    return b-a;
    }
  return a-b;
  }

public static double getAbsDiff(double a, double b)
  {
  if(a<b)
    {
    return b-a;
    }
  return a-b;
  }

/**
 * will return a NEW Pos3f containing the translated coordinate
 * ONLY translates on the x/z axis'
 * @param pos
 * @param originYaw
 * @param transYaw
 * @param transLength
 * @return a NEW vector (old is untouched) with the new position
 */
public static Pos3f translatePos(Pos3f pos, float originYaw, float transYaw, float transLength)
  {
  float newX = pos.x + sinDegrees(-originYaw -90 - transYaw) * transLength;
  float newZ = pos.z + cosDegrees(-originYaw -90 - transYaw) * transLength;
  return new Pos3f(newX, pos.y, newZ);
  }

/**
 * translates a position given a pitch and yaw
 * (to translate relative, add current pitch + pitchChange before calling, same for yaw)
 * @param pos
 * @param yaw
 * @param pitch
 * @param transLength
 * @return a NEW vector (old is untouched) with the new position
 */
public static Pos3f translatePosPitch(Pos3f pos, float yaw, float pitch, float transLength)
  {
  float newX = pos.x + sinDegrees(yaw) * sinDegrees(pitch) * transLength;
  float newY = pos.y + cosDegrees(pitch)  * transLength;
  float newZ = pos.z + cosDegrees(yaw) * sinDegrees(pitch) * transLength;  
  return new Pos3f(newX,newY,newZ);
  }

/**
 * 
 * @param test
 * @param target
 * @return
 */
public static float getHorizontalDistance(Entity test, Entity target)
  {  
  double x = test.posX>target.posX? test.posX-target.posX : target.posX-test.posX;
  double z = test.posZ>target.posZ? test.posZ-target.posZ : target.posZ-test.posZ;
  return MathHelper.sqrt_double(z*z+x*x);
  }

public static float getHeightDifference(Entity test, Entity target)
  {
  return (float)test.posY - (float)target.posY;
  }

/**
 * returns the sqrt velocity of the input vectors (asuming base zero)
 * @param x
 * @param y
 * @param z
 * @return
 */
public static float getVelocity(float x, float y, float z)
  {
  return MathHelper.sqrt_float(x*x + y*y + z*z);
  }

public static float getVelocity(double x, double y, double z)
  {
  return Trig.getVelocity((float)x,(float)y,(float)z);
  }

/**
 * get velocity of a 2d vector
 * @param x
 * @param z
 * @return
 */
public static float getVelocity(double x, double z)
  {
  return MathHelper.sqrt_float((float)(x*x + z*z));
  }

/**
 * returns a normalized vector from yaw and pitch
 */
public static Pos3f calcAngles(float yaw, float pitch)
  {
  Pos3f aim = new Pos3f();  
  aim.x = (MathHelper.cos(yaw) * MathHelper.cos(pitch));
  aim.z = (MathHelper.sin(yaw) * MathHelper.cos(pitch));
  aim.y = MathHelper.sin(pitch);
  return aim;
  }

}