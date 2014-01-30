package shadowmage.meim.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelModel extends ModelBase
{
ModelRenderer Shape1;

public ModelModel()
  {
  textureWidth = 256;
  textureHeight = 256;

  Shape1 = new ModelRenderer(this, 0, 0);
  Shape1.addBox(0F, 0F, 0F, 1, 96, 96);
  Shape1.setRotationPoint(48F, 0F, -48F);
  Shape1.setTextureSize(256, 256);
  Shape1.mirror = true;
  setRotation(Shape1, 0F, 0F, 1.570796F);
  }

public void render()
  {
  Shape1.render(0.0625f);
  }

public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
  super.render(entity, f, f1, f2, f3, f4, f5);
  setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  Shape1.render(f5);
  }

private void setRotation(ModelRenderer model, float x, float y, float z)
  {
  model.rotateAngleX = x;
  model.rotateAngleY = y;
  model.rotateAngleZ = z;
  }


}