package shadowmage.ancient_structures.client.gui.elements;

import net.minecraft.client.Minecraft;
import shadowmage.ancient_structures.client.gui.GuiContainerBase.ActivationEvent;
import shadowmage.ancient_structures.client.gui.Listener;
import shadowmage.ancient_structures.client.render.RenderTools;

/**
 * Simple checkbox w/ label;<br><br>
 * 
 * Inner classes can override the onToggled() method instead of adding a mouse-event listener.<br>
 * 
 * Or, you may add listeners.<br>
 * Either onToggled() or listeners will be called _after_ the internal state
 * has been toggled, so when querying toggled/checked state, you will get the NEW state.<br><br>
 * 
 * 12x12 is the minimum supported size.<br>
 * 16x16 is the preferred size.<br>
 * 40x40 is the maximum supported size due to textures/rendering.  Functionality will 
 * work at larger sizes, but it will not render properly
 * 
 * 
 * 
 * @author Shadowmage
 *
 */
public class Checkbox extends GuiElement
{

private boolean checked = false;
String label;

/** 
 * @param topLeftX
 * @param topLeftY
 * @param width
 * @param height
 * @param label (optional -- use null for none)
 */
public Checkbox(int topLeftX, int topLeftY, int width, int height, String label)
  {
  super(topLeftX, topLeftY, width, height);
  this.label = label;
  this.addNewListener(new Listener(Listener.MOUSE_UP)
    {
    @Override
    public boolean onEvent(GuiElement widget, ActivationEvent evt)
      {
      if(visible && enabled && isMouseOverElement(evt.mx, evt.my))
        {
        Minecraft.getMinecraft().sndManager.playSoundFX("random.click", 1.0F, 1.0F);
        checked = !checked;
        onToggled();
        }
      return true;
      }
    });
  }

@Override
public void render(int mouseX, int mouseY, float partialTick)
  {
  if(visible)
    {
    Minecraft.getMinecraft().renderEngine.bindTexture(widgetTexture1);
    int y = enabled ? isMouseOverElement(mouseX, mouseY) ? 200 : 160 : 120;
    int x = checked ? 40 : 0;
    RenderTools.renderQuarteredTexture(256, 256, x, y, 40, 40, renderX, renderY, width, height);    
    
    if(label!=null)
      {
      int v = (height - 8) / 2;
      Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(label, renderX+width+2, renderY + v, 0xffffffff);
      }
    }
  }

/**
 * Anonymous classes can override this for an easy-access toggled-listener for this element
 */
public void onToggled()
  {
  
  }

public void setChecked(boolean val)
  {
  this.checked = val;
  }

public boolean checked()
  {
  return checked;
  }

}
