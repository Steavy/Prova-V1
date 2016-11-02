package nl.dictu.prova.plugins.output.web.scriptprinter;

import java.net.URL;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import nl.dictu.prova.TestRunner;
import nl.dictu.prova.framework.TestCase;
import nl.dictu.prova.plugins.output.OutputPlugin;
import nl.dictu.prova.plugins.output.ShellOutputPlugin;
import nl.dictu.prova.plugins.output.WebOutputPlugin;
import nl.dictu.prova.plugins.output.SoapOutputPlugin;

/**
 * Output plugin to print all actions to a file
 * 
 * @author Sjoerd Boerhout
 *
 */
public class ScriptPrinter implements WebOutputPlugin
{
  final static Logger LOGGER = LogManager.getLogger();
  
  private TestRunner testRunner = null;
  
  /**
   * Init the plug-in and check if a valid reference to a testRunner
   * was given
   */
  @Override
  public void init(TestRunner testRunner) throws Exception
  {
    LOGGER.debug("Init: output plugin ScriptPrinter!");
    
    if(testRunner == null)
       throw new Exception("No testRunner supplied!");
    
    this.testRunner = testRunner;
  }
  
  @Override
  public void setUp(TestCase testCase) throws Exception
  {
    LOGGER.debug("Setup: Test Case ID '{}'", () -> testCase.getId());
    // TODO start new file
    System.out.println("==================================================");
    System.out.println("Start of TC: '" + testCase.getId() + "'\n");
  }

  
  @Override
  public void shutDown()
  {
    // TODO Auto-generated method stub
    LOGGER.debug("Shutdown: output plugin ScriptPrinter!");
  }
  
  @Override
  public void doSelectDropdown(String xPath, String select) throws Exception {
  LOGGER.trace("DoSelectDropdown '{}' ({})", () -> xPath, () -> select);
      
      // TODO Auto-generated method stub
      System.out.println( "Selecting '" + select + "' in element: " + xPath + "'");
  	
  }

  @Override
  public void doSendKeys(String xPath, String keys) throws Exception
  {
    LOGGER.trace("DoSendKeys '{}'", () -> keys);
    
    System.out.println("Send keys '" + keys + "' to browser.");
  }

  @Override
  public void doSetText(String xPath, String text, Boolean replace) throws Exception
  {
    LOGGER.trace("DoSetText '{}'", () -> text);
    
    // TODO Auto-generated method stub
    System.out.println( (replace ? "Replace" : "Set") +  " text of '" + xPath + "' to '" + text + "'");
  }

  @Override
  public void doSleep(long waitTime) throws Exception
  {
    LOGGER.trace("DoSleep for '{}' Ms", () -> waitTime);
    
    // TODO Auto-generated method stub
    System.out.println( "Sleep for '" + waitTime + "' Ms");
  }

  @Override
  public void doValidateElement(String xPath, Boolean exists, double timeOut) throws Exception
  {
    LOGGER.trace("doValidateElement '{}' ({}, {})", () -> xPath, () -> exists, () -> timeOut);
    
    // TODO Implement function
    System.out.println("Validate that element '" + xPath + "' " +
                       (exists ? "" : "doesn't ") + "exists. " +
                       "TimeOut: " + timeOut);
  }

  @Override
  public void doValidateText(String xPath, String value, Boolean exists, double timeOut) throws Exception
  {
    LOGGER.trace("doValidateText '{}' ({}, {}, {})", () -> value, () -> exists, () -> timeOut, () -> xPath);
    
    // TODO Implement function
    System.out.println( "Validate that text '" + value + "' " +
                          (exists ? "" : "doesn't ") + "exists. " +
                          (xPath.length() > 0 ? "Element: " + xPath + ". " : "") +
                          "TimeOut: " + timeOut );
  }

  @Override
  public String getName()
  {
    return "ScriptPrinter";
  }

  @Override
  public void doSwitchFrame(String xPath, Boolean alert, Boolean accept) throws Exception {
	LOGGER.trace("doValidateText '{}' ({}, {}, {})", () -> alert, () -> accept, () -> xPath);
    
    // TODO Implement function
    System.out.println( "Swithing to frame '" + xPath + 
    					"' frame is alert?: " +
                        (alert ? "Yes" : "No")+
                        "' accept or dismiss?: " +
                        (accept ? "Accept" : "Dismiss"));
	// TODO Auto-generated method stub
  }	

    @Override
    public void doCaptureScreen(String string) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doClick(String string, Boolean bln, Boolean bln1) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doDownloadFile(String string, String string1) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doSelect(String string, Boolean bln) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doSwitchScreen() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doNavigate(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
