package Mccm.Pega.OSF.PegaTest;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

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

public class PegaOSFOutcomeSaveOffAPIVldTest extends TestBase {
	private static final String priorty = null;
	LoginPageInbound loginpageinbound;

	PegaMarketIntrctnHistry pegaMarketIntrctnHistry;
	TestUtil testutil;
	//public static Logger log =LogManager.getLogger(PegaOSFOutcomeSaveOffAPIVldTest.class.getName());

	public PegaOSFOutcomeSaveOffAPIVldTest()
	{
		super();
	}
 @BeforeMethod
 
    public void setup() throws InterruptedException {
//	 log.info("**** Started the OSF PegaOSFOutcomeSaveOffAPIVldTest ****");
	 System.out.println("started the OSF PegaOSFOutcomeSaveOffAPIVldTest ");  
	    initialization();
	     loginpageinbound = new LoginPageInbound();
	     pegaMarketIntrctnHistry = loginpageinbound.login(prop.getProperty("username"), prop.getProperty("password")); 
	     testutil=new TestUtil();
	     pegaMarketIntrctnHistry =new PegaMarketIntrctnHistry();
	 //    pegaMarketIntrctnHistry=loginpageinbound.Pegamrklunch3();
	//     log.info("**** call the method save offer pegalinch3 ****");
	     driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	     System.out.println("call the method save offer pegalinch3 ");  
	    }
 
 
@Test (priority=1)
 public void VerifyOSFOutcomeAPISaveOffValidationRunSuccessfully() throws InterruptedException, AWTException { 

	 loginpageinbound.Pegamrklunch3();
//	 log.info("**** call the method save offer loginpageinbound pegalinch3 ****");
	 System.out.println("call the method save offer loginpageinbound pegalinch3 ");  
	 pegaMarketIntrctnHistry.pegamarkting();
	 testutil.WindowHandling();
	 pegaMarketIntrctnHistry.ExpandReport();;
	 pegaMarketIntrctnHistry.ClkIntractionHstry();
	 testutil.SwitchToFrame("PegaGadget1Ifr");
	 pegaMarketIntrctnHistry.ClkRecentIntrctnHstry();
	 pegaMarketIntrctnHistry.PegaOSFOutcomeAPISaveOfferVlidtion();
	 
//	 log.info("**** Ended the OSF PegaOSFOutcomeSaveOffAPIVldTest ****");
	 System.out.println("Ended the OSF PegaOSFOutcomeSaveOffAPIVldTest ");  
 }
 
@AfterMethod
 

     public void teardown() {
	
     driver.quit();
	      
	 System.out.println("OSF Outcome API Save Offer Validation Done");  
}
   
}
