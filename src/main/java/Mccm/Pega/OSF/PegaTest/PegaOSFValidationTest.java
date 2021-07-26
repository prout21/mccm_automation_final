package Mccm.Pega.OSF.PegaTest;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Mccm.Pega.Inbound.PegaMain.LoginPageInbound;
import Mccm.Pega.Inbound.PegaMain.PegaMarketIntrctnHistry;
import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.QAUtil.TestUtil;
//import Mccm.Pega.Outbound.PegaSubClass.HomePageDetails;




public class PegaOSFValidationTest extends TestBase {
	private static final String priorty = null;
	LoginPageInbound loginpageinbound;

	PegaMarketIntrctnHistry pegaMarketIntrctnHistry;
	TestUtil testutil;

	 

	 public static Logger log = LogManager.getLogger(PegaOSFValidationTest.class.getName());
	public PegaOSFValidationTest()
	{
		super();
	}
	@BeforeMethod

	public void setup() throws InterruptedException {
		log.info("OSF API Calls Validation Started");
		initialization();
		loginpageinbound = new LoginPageInbound();
		pegaMarketIntrctnHistry = loginpageinbound.login(prop.getProperty("username"), prop.getProperty("password")); 
		testutil=new TestUtil();
		pegaMarketIntrctnHistry =new PegaMarketIntrctnHistry();
	 

	}



	@Test (priority=1)
	public void OSFAPICallsValidation() throws InterruptedException, AWTException { 

		loginpageinbound.Pegamrklunch3();
		pegaMarketIntrctnHistry.pegamarkting();
		testutil.WindowHandling();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		pegaMarketIntrctnHistry.ExpandReport();
		pegaMarketIntrctnHistry.ClkIntractionHstry();
		testutil.SwitchToFrame("PegaGadget1Ifr");
		pegaMarketIntrctnHistry.ClkRecentIntrctnHstry();
		pegaMarketIntrctnHistry.PegaOSFAPIValidation();
		log.info("OSF API Calls Validation Completed");


	}

	@AfterMethod


	public void teardown() {

		driver.quit();

	
	}

}
