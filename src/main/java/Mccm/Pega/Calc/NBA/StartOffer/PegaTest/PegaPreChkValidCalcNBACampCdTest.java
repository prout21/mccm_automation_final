package Mccm.Pega.Calc.NBA.StartOffer.PegaTest;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Mccm.Pega.Calc.NBA.StartOffer.LoginPageCalcNBAandStartOff;
import Mccm.Pega.Calc.NBA.StartOffer.PegaPreChkValidCalcNBACampCd;
import Mccm.Pega.Outbound.PegaMain.HomePage;
import Mccm.Pega.Outbound.PegaMain.LoginPage;
import Mccm.Pega.Outbound.PegaMain.PegaMarketPage;

import Mccm.Pega.Outbound.PegaMain.PegaPreChkValidCampCd;
import Mccm.Pega.Outbound.PegaMain.HomePageDetails;
//import Mccm.Pega.Outbound.PegaSubClass.HomePageDetails;
import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.QAUtil.TestUtil;

public class PegaPreChkValidCalcNBACampCdTest extends TestBase {

	private static final String priorty = null;
	LoginPage loginpage;
	LoginPageCalcNBAandStartOff loginPageCalcNBAandStartOff;
	HomePage  homepage;
	PegaPreChkValidCalcNBACampCd pegaPreChkValidCalcNBACampCd;
	TestUtil testutil;


	public PegaPreChkValidCalcNBACampCdTest()
	{
		super();
	}
	@BeforeMethod

	public void setup() throws InterruptedException {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password")); 
		testutil=new TestUtil();
		pegaPreChkValidCalcNBACampCd =new PegaPreChkValidCalcNBACampCd();
		pegaPreChkValidCalcNBACampCd= homepage.Pegamrklunch5();
	}



	@Test (priority=1)
	public void VerifyPreCheckCalcNBACampCodeValueValidSuccessfully() throws InterruptedException, AWTException { 

		homepage.Pegamrklunch5();
		pegaPreChkValidCalcNBACampCd.pegamarkting();
		testutil.WindowHandling();
		pegaPreChkValidCalcNBACampCd.ExpandPegMrkPage1();
		pegaPreChkValidCalcNBACampCd.CampaignImage();
		pegaPreChkValidCalcNBACampCd.Campaigns();
		testutil.SwitcToFrame(1);
		testutil.RobertAction();
		// pegaPreChkValidCampCd.Filter();
		//	 pegaPreChkValidCampCd.CampaignVlSrch();
		//	 pegaPreChkValidCampCd.View();
		pegaPreChkValidCalcNBACampCd.PreChkValidCalcNBACampCd();

	}

	@AfterMethod

	public void teardown() {

		driver.quit();

		System.out.println("Calc NBA pre check Campaign Code Validation Done");
	}	 
}



