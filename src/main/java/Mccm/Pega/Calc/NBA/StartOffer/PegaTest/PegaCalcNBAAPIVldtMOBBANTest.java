package Mccm.Pega.Calc.NBA.StartOffer.PegaTest;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Mccm.Pega.Calc.NBA.StartOffer.LoginPageCalcNBAandStartOff;
import Mccm.Pega.Calc.NBA.StartOffer.PegaMarktCalcNBAandStartOff;
import Mccm.Pega.Inbound.PegaMain.LoginPageInbound;
import Mccm.Pega.Inbound.PegaMain.PegaMarketIntrctnHistry;
import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.QAUtil.TestUtil;


public class PegaCalcNBAAPIVldtMOBBANTest extends TestBase {
	private static final String priorty = null;
	LoginPageInbound loginpageinbound;

	PegaMarketIntrctnHistry pegaMarketIntrctnHistry;
	PegaMarktCalcNBAandStartOff pegaMarktCalcNBAandStartOff; 
	LoginPageCalcNBAandStartOff loginPageCalcNBAandStartOff;
	
	TestUtil testutil;


	public PegaCalcNBAAPIVldtMOBBANTest()
	{
		super();
	}
	@BeforeMethod

	public void setup() throws InterruptedException {
		initialization();
		loginpageinbound = new LoginPageInbound();
		loginPageCalcNBAandStartOff = new LoginPageCalcNBAandStartOff();
		pegaMarketIntrctnHistry = loginpageinbound.login(prop.getProperty("username"), prop.getProperty("password")); 
		testutil=new TestUtil();
		pegaMarketIntrctnHistry =new PegaMarketIntrctnHistry();
	//	 pegaMarketIntrctnHistry=loginpageinbound.Pegamrklunch3();
		//driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		 driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
	}



	@Test (priority=1)
	public void VerifyPegaCalcNBAandStartOffAPIVldtTestSuccessfully() throws InterruptedException, AWTException { 

		loginpageinbound.Pegamrklunch3();
	//	loginPageCalcNBAandStartOff.PegamrklunchCalNBA3();
		pegaMarketIntrctnHistry.pegamarkting();
		testutil.WindowHandling();
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		pegaMarketIntrctnHistry.ExpandReport();
		pegaMarketIntrctnHistry.ClkIntractionHstry();
		testutil.SwitchToFrame("PegaGadget1Ifr");
		pegaMarketIntrctnHistry.ClkRecentIntrctnHstry();
		pegaMarketIntrctnHistry.PegaCalcNBAandStartOffAPIVlidtion();

	}
	@AfterMethod

	public void teardown() {

	 //	driver.quit();


		System.out.println("Calc NBAandStart Offer API IH Validation Done");
	}
}
