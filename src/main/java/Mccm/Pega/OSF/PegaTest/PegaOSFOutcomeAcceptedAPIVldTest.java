package Mccm.Pega.OSF.PegaTest;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

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

public class PegaOSFOutcomeAcceptedAPIVldTest extends TestBase {
	private static final String priorty = null;
	LoginPageInbound loginpageinbound;

	PegaMarketIntrctnHistry pegaMarketIntrctnHistry;
	TestUtil testutil;
	
//	public static Logger log =LogManager.getLogger(PegaOSFOutcomeAcceptedAPIVldTest.class.getName());
	

	public PegaOSFOutcomeAcceptedAPIVldTest()
	{
		super();
	}
 @BeforeMethod
 
    public void setup() throws InterruptedException {
	// log.info("**** Started the OSF PegaOSFOutcomeAcceptedAPIVldTest ****");
	 System.out.println("Started the OSF PegaOSFOutcomeAcceptedAPIVldTest");  
	    initialization();
	     loginpageinbound = new LoginPageInbound();
	     pegaMarketIntrctnHistry = loginpageinbound.login(prop.getProperty("username"), prop.getProperty("password")); 
	     testutil=new TestUtil();
	     pegaMarketIntrctnHistry =new PegaMarketIntrctnHistry();
	//     pegaMarketIntrctnHistry=loginpageinbound.Pegamrklunch3();
	//     log.info("**** call the method accepted pegalinch3 ****");
	     driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	     System.out.println("call the method accepted pegalinch3");  
	     
	    }


 
@Test (priority=1)
 public void VerifyOSFOutcomeAPIAcceptedValidationRunSuccessfully() throws InterruptedException, AWTException { 
	
	 loginpageinbound.Pegamrklunch3();
//	 log.info("**** call the method accepted loginpageinbound pegalinch3 ****");
	 System.out.println("all the method accepted loginpageinbound pegalinch3");  
	 pegaMarketIntrctnHistry.pegamarkting();
	 System.out.println("pegamarkting");  
	 testutil.WindowHandling();
	 driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	 pegaMarketIntrctnHistry.ExpandReport();
	 System.out.println("xpandReport");  
	 pegaMarketIntrctnHistry.ClkIntractionHstry();
	 System.out.println("ClkIntractionHstry");  
	 testutil.SwitchToFrame("PegaGadget1Ifr");
	 pegaMarketIntrctnHistry.ClkRecentIntrctnHstry();
	 System.out.println("ClkRecentIntrctnHstry");  
	 pegaMarketIntrctnHistry.PegaOSFOutcomeAPIAcceptedVlidtion();
//	 log.info("**** Ended the OSF PegaOSFOutcomeAPIAcceptedVlidtion ****");
	 System.out.println("Ended the OSF PegaOSFOutcomeAPIAcceptedVlidtion");  
	 
 }
 
@AfterMethod
 

     public void teardown() {
	
    driver.quit();
	      
	 System.out.println("MCCM OSF Outcome API Accepted Validation Done");  
}
   
}
