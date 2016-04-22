package nl.dictu.prova.framework.web;

import nl.dictu.prova.framework.TestAction;
import nl.dictu.prova.framework.parameters.Bool;
import nl.dictu.prova.framework.parameters.Xpath;

/**
 * Handles the Prova function 'select' to select an element on a web page.
 * 
 * @author  Sjoerd Boerhout
 * @since   0.0.1
 */
public class Select extends TestAction
{
  // Action attribute names
  public final static String ATTR_XPATH  = "XPATH";
  public final static String ATTR_SELECT = "SELECT";
  
  private Xpath  xPath;
  private Bool select;

  
  /**
   * Constructor
   * @throws Exception 
   */
  public Select() throws Exception
  {
    super();
    
    // Create parameters with (optional) defaults and limits
    xPath = new Xpath();
    select = new Bool(true);
  }

  
  /**
   * Set attribute <key> with <value>
   * - Unknown attributes are ignored
   * - Invalid values result in an exception
   * 
   * @param key
   * @param value
   * @throws Exception
   */
  @Override
  public void setAttribute(String key, String value) throws Exception
  {
    switch(key.toUpperCase())
    {
      case ATTR_XPATH:  
        xPath.setValue(value); 
      break;
      
      case ATTR_PARAMETER:
      case ATTR_SELECT:
        select.setValue(value); 
      break;
    } 
  }
  

  /**
   * Check if all requirements are met to execute this action
   */
  @Override
  public boolean isValid()
  {
    if(!xPath.isValid())  return false;
    if(!select.isValid()) return false;
    
    return true;
  }
  

  /**
   * Execute this action in the active output plug-in
   */
  @Override
  public void execute() throws Exception
  {
    // TODO Implement function
    System.out.println( (select.getValue() ? "Select" : "Deselect") + " '" + xPath.getValue() + "'");
  }
}