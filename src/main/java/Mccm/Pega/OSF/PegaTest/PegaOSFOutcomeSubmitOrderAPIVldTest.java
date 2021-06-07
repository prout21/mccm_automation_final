package Mccm.Pega.OSF.PegaTest;

import java.awt.AWTException;

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

public class PegaOSFOutcomeSubmitOrderAPIVldTest extends TestBase {
	private static final String priorty = null;
	LoginPageInbound loginpageinbound;

	PegaMarketIntrctnHistry pegaMarketIntrctnHistry;
	TestUtil testutil;
	
//	public static Logger log =LogManager.getLogger(PegaOSFOutcomeSubmitOrderAPIVldTest.class.getName());
	
	public PegaOSFOutcomeSubmitOrderAPIVldTest()
	{
		super();
	}
 @BeforeMethod
 
    public void setup() throws InterruptedException {
//	 log.info("**** Started the OSF PegaOSFOutcomeSubmitOrderAPIVldTest ****");
	 System.out.println(" Started the OSF PegaOSFOutcomeSubmitOrderAPIVldTest ");  
	    initialization();
	     loginpageinbound = new LoginPageInbound();
	     pegaMarketIntrctnHistry = loginpageinbound.login(prop.getProperty("username"), prop.getProperty("password")); 
	     testutil=new TestUtil();
	     pegaMarketIntrctnHistry =new PegaMarketIntrctnHistry();
	     pegaMarketIntrctnHistry=loginpageinbound.Pegamrklunch3();
//	     log.info("**** call the method submitted pegalinch3 ****");
	     System.out.println("call the method submitted pegalinch3");  
	    }


 
@Test (priority=1)
 public void VerifyOSFOutcomeAPISubmitOrderValidationRunSuccessfully() throws InterruptedException, AWTException { 

	 loginpageinbound.Pegamrklunch3();
//	 log.info("**** call the method submitted loginpageinbound pegalinch3 ****");
	 System.out.println("call the method submitted loginpageinbound pegalinch3  ");  
	 pegaMarketIntrctnHistry.pegamarkting();
	 testutil.WindowHandling();
	 pegaMarketIntrctnHistry.ExpandReport();;
	 pegaMarketIntrctnHistry.ClkIntractionHstry();
	 testutil.SwitchToFrame("PegaGadget1Ifr");
	 pegaMarketIntrctnHistry.ClkRecentIntrctnHstry();
	 pegaMarketIntrctnHistry.PegaOSFOutcomeAPISubmitOrderVlidtion();
	 
	// log.info("**** Ended the OSF PegaOSFOutcomeSubmitOrderAPIVldTest ****");
	 System.out.println("Ended the OSF PegaOSFOutcomeSubmitOrderAPIVldTest");  
 }
 
@AfterMethod
 

     public void teardown() {
	
    driver.quit();
	      
	 System.out.println("MCCM OSF Outcome API SubmitOrder Validation Done");  
}
   
}
