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
package shadowmage.ancient_framework.client.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import shadowmage.ancient_framework.common.config.AWLog;
import shadowmage.ancient_framework.common.utils.StringTools;

public class ModelBaseAW
{
//name needs changed to something...else

static float ratio = 0.0625f;//possibly not needed?

int textureWidth;
int textureHeight;

HashMap<Integer, Primitive> primitives = new HashMap<Integer, Primitive>();
HashMap<String, ModelPiece> pieces = new HashMap<String, ModelPiece>();
private List<ModelPiece> basePieces = new ArrayList<ModelPiece>();
int nextPrimitiveNumber = 0;

public void renderModel()
  {
  for(ModelPiece piece : this.getBasePieces())
    {
    piece.render();
    }
  }

public void renderForSelection()
  {
  for(ModelPiece piece : this.getBasePieces())
    {
    piece.renderForSelection();
    }
  }

public void setTextureSize(int width, int height)
  {
  this.textureWidth = width;
  this.textureHeight = height;
  }

public void parseFromLines(List<String> lines)
  {
  String[] bits;
  for(String line : lines)
    {
    if(line.toLowerCase().startsWith("#"))
      {
      continue;
      }
    else if(line.toLowerCase().startsWith("texturesize="))
      {
      bits = line.split("=")[1].split(",");
      textureWidth = StringTools.safeParseInt(bits[0]);
      textureHeight = StringTools.safeParseInt(bits[1]);
      }
    else if(line.startsWith("part="))
      {      
      ModelPiece piece = new ModelPiece(this, line.split("=")[1]);
      addPiece(piece);      
      AWLog.logDebug("parsed a new piece: "+piece.getName());      
      }
    else if(line.startsWith("box="))
      {
      bits = line.split("=")[1].split(",");
      //parse old-style x,y,z, w,h,l
      String parentName = bits[0];
      ModelPiece piece = getPiece(parentName);
      if(piece==null)
        {
        throw new IllegalArgumentException("could not construct model, improper piece reference for: "+parentName);
        }
      PrimitiveBox box = new PrimitiveBox(piece);
      box.x = StringTools.safeParseFloat(bits[1]);
      box.y = StringTools.safeParseFloat(bits[2]);
      box.z = StringTools.safeParseFloat(bits[3]);
      
      box.rx = StringTools.safeParseFloat(bits[4]);
      box.ry = StringTools.safeParseFloat(bits[5]);
      box.rz = StringTools.safeParseFloat(bits[6]);
      
      box.tx = StringTools.safeParseFloat(bits[7]);
      box.ty = StringTools.safeParseFloat(bits[8]);
      
      box.x1 = StringTools.safeParseFloat(bits[9]);
      box.y1 = StringTools.safeParseFloat(bits[10]);
      box.z1 = StringTools.safeParseFloat(bits[11]);
      
      box.x2 = StringTools.safeParseFloat(bits[12]);
      box.y2 = StringTools.safeParseFloat(bits[13]);
      box.z2 = StringTools.safeParseFloat(bits[14]);
      
      piece.addPrimitive(box);
      AWLog.logDebug("parsed new box for piece: "+parentName);
      }    
    }
  }

public List<String> getModelLines()
  {
  ArrayList<String> lines = new ArrayList<String>();
  lines.add("textureSize="+textureWidth+","+textureHeight);
  for(ModelPiece piece : this.basePieces)
    {
    piece.addPieceLines(lines);
    }  
  return lines;
  }

/**
 * should only be called from ModelPiece
 * @param primitive
 */
protected void addPrimitive(Primitive primitive)
  {
  primitive.primitiveNumber = this.nextPrimitiveNumber;
  this.nextPrimitiveNumber++;
  primitives.put(primitive.primitiveNumber, primitive);
  }

public void addPiece(ModelPiece piece)
  {
  pieces.put(piece.getName(), piece);
  if(piece.getParent()==null)
    {
    getBasePieces().add(piece);
    }
  }

public void getPieces(List<ModelPiece> input)
  {
  for(ModelPiece piece : this.basePieces)
    {
    piece.getPieces(input);
    }
  }

public void setPieceRotation(String name, float x, float y, float z)
  {
  ModelPiece piece = this.getPiece(name);
  if(piece==null){return;}
  piece.setRotation(x, y, z);
  }

public ModelPiece getPiece(String name)
  {
  return this.pieces.get(name);
  }

public void removePrimitive(Primitive primitive)
  {
  this.primitives.remove(primitive.primitiveNumber);
  }

public void removePiece(String name)
  {
  ModelPiece piece = this.getPiece(name);
  removePiece(piece);
  }

public void removePiece(ModelPiece piece)
  {
  if(piece.getParent()!=null)
    {
    piece.getParent().removeChild(piece);    
    }
  this.pieces.remove(piece.getName());
  }

public List<ModelPiece> getBasePieces()
  {
  return basePieces;
  }

public Primitive getPrimitive(int num)
  {
  return primitives.get(num);
  }

}
