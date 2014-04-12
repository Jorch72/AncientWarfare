package shadowmage.ancient_structures.client.gui.elements;

import net.minecraft.client.Minecraft;
import shadowmage.ancient_structures.client.gui.GuiContainerBase.ActivationEvent;
import shadowmage.ancient_structures.client.gui.IScrollableCallback;
import shadowmage.ancient_structures.client.gui.Listener;
import shadowmage.ancient_structures.client.render.RenderTools;

public class CompositeScrolled extends Composite implements IScrollableCallback
{

private Scrollbar scrollbar;
int currentTop = 0;

public CompositeScrolled(int topLeftX, int topLeftY, int width, int height)
  {
  super(topLeftX, topLeftY, width, height);
  scrollbar = new Scrollbar(width-12, 0, 12, height, this);
//  this.addGuiElement(scrollbar);  
  }

@Override
public void onScrolled(int newTop)
  {
  currentTop = newTop;
  this.updateElementPositions();
  }

@Override
protected void updateElementPositions()
  { 
  scrollbar.updateGuiPosition(renderX, renderY);
  for(GuiElement element : this.elements)
    {
    element.updateGuiPosition(renderX, renderY-currentTop);
    }
  }

public void setAreaSize(int height)
  {
  this.scrollbar.setAreaSize(height);  
  }

@Override
public void render(int mouseX, int mouseY, float partialTick)
  {
  if(!isMouseOverElement(mouseX, mouseY))
    {
    mouseX = Integer.MIN_VALUE;
    mouseY = Integer.MIN_VALUE;
    } 
  Minecraft.getMinecraft().renderEngine.bindTexture(backgroundTextureLocation);
  //render background before setting viewport so that it is not cropped
  RenderTools.renderQuarteredTexture(256, 256, 0, 0, 256, 240, renderX, renderY, width, height);
  setViewport();
  for(GuiElement element : this.elements)
    {
    if(element.renderY > renderY + height || element.renderY + element.height < renderY)
      {
      continue;//manual frustrum culling of elements, on Y axis
      }
    if(element.renderX > renderX + width || element.renderX + element.width < renderX)
      {
      continue;//manual frustrum culling of elements, on X axis
      }
    element.render(mouseX, mouseY, partialTick);
    }   
  popViewport();
 //render scrollbar after resetting viewport so that it is not cropped
  scrollbar.render(mouseX, mouseY, partialTick);
  }

@Override
protected void addDefaultListeners()
  {
  this.addNewListener(new Listener(Listener.ALL_EVENTS)
    {
    @Override
    public boolean onEvent(GuiElement widget, ActivationEvent evt)
      {
      if((evt.type & Listener.KEY_TYPES) != 0)
        {
        for(GuiElement element : elements)
          {
          element.handleKeyboardInput(evt);
          }
        }
      else if((evt.type & Listener.MOUSE_TYPES) != 0)
        {
        if(isMouseOverElement(evt.mx, evt.my))
          {
          scrollbar.handleMouseInput(evt);
          for(GuiElement element : elements)
            {
            element.handleMouseInput(evt);
            }
          }
        else
          {
          if(evt.type==Listener.MOUSE_UP)
            {
            for(GuiElement element : elements)
              {
              element.setSelected(false);
              }
            }
          //handle mouse leaving window, cancel scrollbar interaction
          scrollbar.dragging = false;
          scrollbar.pressed = false;
          }
        }
      return true;
      }
    });
  }

@Override
public void setSize(int width, int height)
  {
  this.width = width;
  this.height = height;
  int h = scrollbar.totalAreaSize;
  this.elements.remove(scrollbar);
  scrollbar = new Scrollbar(width-12, 0, 12, height, this);
  scrollbar.setAreaSize(h);
  }
  
  

}
