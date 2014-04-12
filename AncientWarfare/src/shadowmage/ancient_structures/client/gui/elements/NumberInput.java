package shadowmage.ancient_structures.client.gui.elements;

import shadowmage.ancient_structures.client.gui.GuiContainerBase.ActivationEvent;
import shadowmage.ancient_structures.client.gui.IWidgetSelection;
import shadowmage.ancient_structures.client.gui.Listener;

public class NumberInput extends Text
{

boolean allowDecimal = true;
boolean allowNeg;
boolean integerValue;
float value;
int decimalPlaces = 2;
float incrementAmount = 1.f;

public NumberInput(int topLeftX, int topLeftY, int width, float defaultText, IWidgetSelection selector)
  {
  super(topLeftX, topLeftY, width, String.format("%.2f", defaultText), selector);
  this.value = defaultText;
  this.setAllowedChars(allowedNums);
  
  }

public int getIntegerValue()
  {
  return (int)value;
  }

public float getFloatValue()
  {
  return value;
  }

public NumberInput setAllowNegative()
  {
  this.allowNeg = true;
  return this;
  }

public NumberInput setIntegerValue()
  {
  this.integerValue = true;
  this.decimalPlaces = 0;
  this.incrementAmount = 1.f;
  this.allowDecimal = false;
  this.text = String.format("%."+decimalPlaces+"f", value);  
  return this;
  }

public NumberInput setIncrementAmount(float amount)
  {
  this.incrementAmount = amount;
  return this;
  }

@Override
protected void addDefaultListeners()
  {  
  this.addNewListener(new Listener(Listener.MOUSE_UP)
    {
    @Override
    public boolean onEvent(GuiElement widget, ActivationEvent evt)
      {
      if(enabled && visible && isMouseOverElement(evt.mx, evt.my))
        {
        setSelected(true);
        selector.onWidgetSelected(NumberInput.this);
        cursorIndex = text.length();
        }
      else
        {
        if(selected)
          {
          selector.onWidgetDeselected(NumberInput.this);
          }
        setSelected(false);
        }
      return true;
      }
    });
  
  this.addNewListener(new Listener(Listener.KEY_DOWN)
    {
    @Override
    public boolean onEvent(GuiElement widget, ActivationEvent evt)
      {
      if(enabled && visible && selected)
        {
        handleKeyInput(evt.key, evt.ch);
        }
      return true;
      }
    });
  
  this.addNewListener(new Listener(Listener.MOUSE_WHEEL)
    {
    @Override
    public boolean onEvent(GuiElement widget, ActivationEvent evt)
      {
      if(isMouseOverElement(evt.mx, evt.my))
        {
        int d = evt.mw;
        if(d<0)
          {
          setValue(value-incrementAmount);
          }
        else if(d>0)
          {
          setValue(value+incrementAmount);
          }
        }
      return true;
      }
    });
  }

@Override
public void setText(String text)
  {
  try
    {
    Float fl = Float.parseFloat(text);
    setValue(fl);    
    }
  catch(NumberFormatException e)
    {
    this.text = "0";
    this.value = 0.f;
    this.onValueUpdated(value);
    }
  }

public NumberInput setValue(float val)
  {
  if(!allowNeg && val<0)
    {
    val = 0.f;
    }
  this.text = String.format("%."+decimalPlaces+"f", val);  
  this.value = val;
  this.onValueUpdated(value);
  return this;
  }

protected void handleCharacter(char ch)
  {  
  boolean allowed = false;
  if(ch=='.' && allowDecimal){allowed = true;}
  else if(ch=='-' && allowNeg){allowed = true;}
  if(!allowed)
    {
    for(char ch1 : allowedNums)
      {
      if(ch1==ch)
        {
        allowed = true;
        break;
        }
      }    
    }
  if(allowed)//is allowed character
    {
    String newText = "";
    for(int i = 0; i <= text.length(); i++)
      {
      if(i==cursorIndex)
        {
        newText = newText + ch;
        }
      if(i<text.length())
        {
        newText = newText + text.charAt(i);        
        }
      }
    text = newText;
    cursorIndex++;
    }
  }

protected void onEnterPressed()
  {
  this.setText(getText());
  }

/**
 * anonymous classes should implement this for a callback for when value is updated/changed via user input (either manual, mouse,or keyboard)
 * @param value
 */
public void onValueUpdated(float value)
  {
  
  }
}
