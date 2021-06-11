package Mccm.Pega.Outbound.PegaTest;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Mccm.Pega.Outbound.PegaMain.HomePage;
import Mccm.Pega.Outbound.PegaMain.LoginPage;
import Mccm.Pega.Outbound.PegaMain.PegaMarketPage;

import Mccm.Pega.Outbound.PegaMain.PegaPreChkValidCampCd;
import Mccm.Pega.Outbound.PegaMain.HomePageDetails;
//import Mccm.Pega.Outbound.PegaSubClass.HomePageDetails;
import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.QAUtil.TestUtil;

public class PegaPreChkValidCampCdTest extends TestBase {

	private static final String priorty = null;
	LoginPage loginpage;
	HomePage  homepage;
	PegaPreChkValidCampCd pegaPreChkValidCampCd;
	TestUtil testutil;


	public PegaPreChkValidCampCdTest()
	{
		super();
	}
	@BeforeMethod

	public void setup() throws InterruptedException {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password")); 
		testutil=new TestUtil();
		pegaPreChkValidCampCd =new PegaPreChkValidCampCd();
		//    pegaMrktNBAValuChk=homepage.PegaMrktNBAValuChk();
		// pegaPreChkValidCampCd=homepage.Pegamrklunch3();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	}



	@Test (priority=1)
	public void VerifyOutboundPreCheckNBACampCodeValueValidSuccessfully() throws InterruptedException, AWTException { 

    	homepage.Pegamrklunch3();
		pegaPreChkValidCampCd.pegamarkting();
		testutil.WindowHandling();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		pegaPreChkValidCampCd.ExpandPegMrkPage1();
		pegaPreChkValidCampCd.CampaignImage();
		pegaPreChkValidCampCd.Campaigns();
		testutil.SwitcToFrame(1);
		testutil.RobertAction();
		// pegaPreChkValidCampCd.Filter();
		//	 pegaPreChkValidCampCd.CampaignVlSrch();
		//	 pegaPreChkValidCampCd.View();
		pegaPreChkValidCampCd.PreChkValdCampCd();

	}

	@AfterMethod

	public void teardown() {

		driver.quit();

		System.out.println("Outbound NBA Precheck Campaign Code Validation Done");
	}	 
}



