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


public class PegaOSFOutcomeSaveOffAPIVldTest extends TestBase {
	private static final String priorty = null;
	LoginPageInbound loginpageinbound;

	PegaMarketIntrctnHistry pegaMarketIntrctnHistry;
	TestUtil testutil;
	

	public PegaOSFOutcomeSaveOffAPIVldTest()
	{
		super();
	}
 @BeforeMethod
 
    public void setup() throws InterruptedException {
	    initialization();
	     loginpageinbound = new LoginPageInbound();
	     pegaMarketIntrctnHistry = loginpageinbound.login(prop.getProperty("username"), prop.getProperty("password")); 
	     testutil=new TestUtil();
	     pegaMarketIntrctnHistry =new PegaMarketIntrctnHistry();
	     pegaMarketIntrctnHistry=loginpageinbound.Pegamrklunch3();
	
	    }


 
@Test (priority=1)
 public void VerifyMCCMOSFOutcomeAPISaveOffValidationRunSuccessfully() throws InterruptedException, AWTException { 

	 loginpageinbound.Pegamrklunch3();
	 pegaMarketIntrctnHistry.pegamarkting();
	 testutil.WindowHandling();
	 pegaMarketIntrctnHistry.ExpandReport();;
	 pegaMarketIntrctnHistry.ClkIntractionHstry();
	 testutil.SwitchToFrame("PegaGadget1Ifr");
	 pegaMarketIntrctnHistry.ClkRecentIntrctnHstry();
	 pegaMarketIntrctnHistry.PegaOSFOutcomeAPISaveOfferVlidtion();
	 
	 
 }
 
@AfterMethod
 

     public void teardown() {
	
     driver.quit();
	      
	 System.out.println("MCCM OSF Outcome API Save Offer Validation Done");  
}
   
}
