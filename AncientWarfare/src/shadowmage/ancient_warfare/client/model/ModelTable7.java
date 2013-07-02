//auto-generated model template
//template generated by MEIM
//template v 1.0
//author Shadowmage45 (shadowage_catapults@hotmail.com)
 
package shadowmage.ancient_warfare.client.model;

import shadowmage.ancient_warfare.common.crafting.TEAWCrafting;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
 
 
public class ModelTable7 extends ModelTEBase
{
 
ModelRenderer tableTop;
ModelRenderer leg1;
ModelRenderer leg2;
ModelRenderer leg3;
ModelRenderer leg4;
ModelRenderer paperLarge;
ModelRenderer flaskBottom;
ModelRenderer flaskMid;
ModelRenderer flaskTop1;
ModelRenderer flaskTop2;
ModelRenderer flaskRim;
ModelRenderer flaskCork;
ModelRenderer bookBottomCover2;
ModelRenderer bookBottomCover;
public ModelTable7(){
  tableTop = new ModelRenderer(this,"tableTop");
  tableTop.setTextureOffset(0,0);
  tableTop.setTextureSize(128,128);
  tableTop.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(tableTop,0.0f, 0.0f, 0.0f);
  tableTop.addBox(-8.0f,-12.0f,-8.0f,16,1,16);
  leg1 = new ModelRenderer(this,"leg1");
  leg1.setTextureOffset(0,18);
  leg1.setTextureSize(128,128);
  leg1.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(leg1,0.0f, 0.0f, 0.0f);
  leg1.addBox(-7.0f,-11.0f,5.0f,2,11,2);
  tableTop.addChild(leg1);
  leg2 = new ModelRenderer(this,"leg2");
  leg2.setTextureOffset(9,18);
  leg2.setTextureSize(128,128);
  leg2.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(leg2,0.0f, 0.0f, 0.0f);
  leg2.addBox(-7.0f,-11.0f,-7.0f,2,11,2);
  tableTop.addChild(leg2);
  leg3 = new ModelRenderer(this,"leg3");
  leg3.setTextureOffset(18,18);
  leg3.setTextureSize(128,128);
  leg3.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(leg3,0.0f, 0.0f, 0.0f);
  leg3.addBox(5.0f,-11.0f,-7.0f,2,11,2);
  tableTop.addChild(leg3);
  leg4 = new ModelRenderer(this,"leg4");
  leg4.setTextureOffset(27,18);
  leg4.setTextureSize(128,128);
  leg4.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(leg4,0.0f, 0.0f, 0.0f);
  leg4.addBox(5.0f,-11.0f,5.0f,2,11,2);
  tableTop.addChild(leg4);
  paperLarge = new ModelRenderer(this,"paperLarge");
  paperLarge.setTextureOffset(65,0);
  paperLarge.setTextureSize(128,128);
  paperLarge.setRotationPoint(0.0f, -12.01f, 0.0f);
  setPieceRotation(paperLarge,-1.2483568E-8f, 0.052359983f, 0.0f);
  paperLarge.addBox(-6.0f,0.0f,-6.0f,12,0,12);
  flaskBottom = new ModelRenderer(this,"flaskBottom");
  flaskBottom.setTextureOffset(36,18);
  flaskBottom.setTextureSize(128,128);
  flaskBottom.setRotationPoint(5.0f, -1.0f, 4.0f);
  setPieceRotation(flaskBottom,0.0f, -0.19198596f, 0.0f);
  flaskBottom.addBox(0.0f,0.0f,0.0f,2,1,2);
  flaskMid = new ModelRenderer(this,"flaskMid");
  flaskMid.setTextureOffset(36,22);
  flaskMid.setTextureSize(128,128);
  flaskMid.setRotationPoint(0.0f, -2.0f, 0.0f);
  setPieceRotation(flaskMid,0.0f, 0.0f, 0.0f);
  flaskMid.addBox(-0.5f,0.0f,-0.5f,3,2,3);
  flaskTop1 = new ModelRenderer(this,"flaskTop1");
  flaskTop1.setTextureOffset(36,28);
  flaskTop1.setTextureSize(128,128);
  flaskTop1.setRotationPoint(0.0f, -1.0f, 0.0f);
  setPieceRotation(flaskTop1,0.0f, 0.0f, 0.0f);
  flaskTop1.addBox(0.0f,0.0f,0.0f,2,1,2);
  flaskTop2 = new ModelRenderer(this,"flaskTop2");
  flaskTop2.setTextureOffset(36,32);
  flaskTop2.setTextureSize(128,128);
  flaskTop2.setRotationPoint(1.0f, -2.0f, 1.0f);
  setPieceRotation(flaskTop2,0.0f, 0.0f, 0.0f);
  flaskTop2.addBox(-0.5f,0.0f,-0.5f,1,2,1);
  flaskRim = new ModelRenderer(this,"flaskRim");
  flaskRim.setTextureOffset(45,18);
  flaskRim.setTextureSize(128,128);
  flaskRim.setRotationPoint(-1.0f, 0.0f, -1.0f);
  setPieceRotation(flaskRim,0.0f, 0.0f, 0.0f);
  flaskRim.addBox(0.0f,0.0f,0.0f,2,1,2);
  flaskCork = new ModelRenderer(this,"flaskCork");
  flaskCork.setTextureOffset(46,22);
  flaskCork.setTextureSize(128,128);
  flaskCork.setRotationPoint(0.0f, -0.5f, 0.0f);
  setPieceRotation(flaskCork,0.0f, 0.0f, 0.0f);
  flaskCork.addBox(0.5f,0.0f,0.5f,1,1,1);
  flaskRim.addChild(flaskCork);
  flaskTop2.addChild(flaskRim);
  flaskTop1.addChild(flaskTop2);
  flaskMid.addChild(flaskTop1);
  flaskBottom.addChild(flaskMid);
  paperLarge.addChild(flaskBottom);
  tableTop.addChild(paperLarge);
  bookBottomCover2 = new ModelRenderer(this,"bookBottomCover2");
  bookBottomCover2.setTextureOffset(-9,45);
  bookBottomCover2.setTextureSize(128,128);
  bookBottomCover2.setRotationPoint(-1.5f, -13.02f, 1.5f);
  setPieceRotation(bookBottomCover2,1.0402973E-9f, -0.20943947f, 0.0f);
  bookBottomCover2.addBox(-5.5f,1.0f,-4.5f,11,0,9);
  bookBottomCover = new ModelRenderer(this,"bookBottomCover");
  bookBottomCover.setTextureOffset(0,35);
  bookBottomCover.setTextureSize(128,128);
  bookBottomCover.setRotationPoint(0.0f, -0.002f, 0.0f);
  setPieceRotation(bookBottomCover,0.0f, 0.0f, 0.0f);
  bookBottomCover.addBox(-5.0f,0.0f,-4.0f,10,1,8);
  bookBottomCover2.addChild(bookBottomCover);
  }
 
@Override
public void render(Entity entity, float f1, float f2, float f3, float f4, float f5, float f6)
  {
  super.render(entity, f1, f2, f3, f4, f5, f6);
  setRotationAngles(f1, f2, f3, f4, f5, f6, entity);
  tableTop.render(f6);
  bookBottomCover2.render(f6);
  }
 
public void setPieceRotation(ModelRenderer model, float x, float y, float z)
  {
  model.rotateAngleX = x;
  model.rotateAngleY = y;
  model.rotateAngleZ = z;
  }

@Override
public void renderModel(TEAWCrafting te)
  {
  tableTop.render(0.0625f);
  bookBottomCover2.render(0.0625f);
  }

@Override
public void renderModel()
  {
  tableTop.render(0.0625f);  
  bookBottomCover2.render(0.0625f);
  }

}
