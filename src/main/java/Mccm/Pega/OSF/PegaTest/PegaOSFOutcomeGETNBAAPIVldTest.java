package Mccm.Pega.OSF.PegaTest;

import java.awt.AWTException;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Mccm.Pega.Inbound.PegaMain.LoginPageInbound;
import Mccm.Pega.Inbound.PegaMain.PegaMarketIntrctnHistry;
//import Mccm.Pega.Outbound.PegaSubClass.HomePageDetails;
import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.QAUtil.TestUtil;
//import Mccm.Pega.Outbound.PegaSubClass.HomePageDetails;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

public class PegaOSFOutcomeGETNBAAPIVldTest extends TestBase {
	private static final String priorty = null;
	LoginPageInbound loginpageinbound;

	PegaMarketIntrctnHistry pegaMarketIntrctnHistry;
	TestUtil testutil;
//	public static Logger log =LogManager.getLogger(PegaOSFOutcomeGETNBAAPIVldTest.class.getName());

	public PegaOSFOutcomeGETNBAAPIVldTest()
	{
		super();
	}
 @BeforeMethod
 
    public void setup() throws InterruptedException {
	 
	// log.info("**** Started the OSF PegaOSFOutcomeGETNBAAPIVldTest ****");
	 System.out.println("Started the OSF PegaOSFOutcomeGETNBAAPIVldTest ");  
	    initialization();
	     loginpageinbound = new LoginPageInbound();
	     pegaMarketIntrctnHistry = loginpageinbound.login(prop.getProperty("username"), prop.getProperty("password")); 
	     testutil=new TestUtil();
	     pegaMarketIntrctnHistry =new PegaMarketIntrctnHistry();
	     pegaMarketIntrctnHistry=loginpageinbound.Pegamrklunch3();
	//     log.info("**** call the method new pegalinch3 ****");
	     System.out.println("call the method new pegalinch3 ");  
	
	    }


 
@Test (priority=1)
 public void VerifyOSFGETNBAAPIValidationRunSuccessfully() throws InterruptedException, AWTException { 

	 loginpageinbound.Pegamrklunch3();
	// log.info("**** call the method new loginpageinbound pegalinch3 ****");
	 System.out.println("call the method new loginpageinbound pegalinch3 ");  
	 pegaMarketIntrctnHistry.pegamarkting();
	 testutil.WindowHandling();
	 pegaMarketIntrctnHistry.ExpandReport();;
	 pegaMarketIntrctnHistry.ClkIntractionHstry();
	 testutil.SwitchToFrame("PegaGadget1Ifr");
	 pegaMarketIntrctnHistry.ClkRecentIntrctnHstry();
	 pegaMarketIntrctnHistry.PegaOSFGETNBAAPIVlidtion();
	 
	// log.info("**** Ended the OSF PegaOSFOutcomeGETNBAAPIVldTest ****");
	 System.out.println("Ended the OSF PegaOSFOutcomeGETNBAAPIVldTest");  
 }
 
@AfterMethod
 

     public void teardown() {
	
   driver.quit();
	      
	 System.out.println("MCCM OSF GET NBA API Validation Done");  
}
   
}
