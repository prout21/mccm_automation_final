package Mccm.Pega.Calc.NBA.StartOffer.PegaTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Mccm.Pega.Calc.NBA.StartOffer.CalNBADMCCMSettings;
import Mccm.Pega.OSF.OSFDMCCMSettings;
import Mccm.Pega.OSF.OSFDSS;
import Mccm.Pega.Outbound.PegaMain.HomePage;
import Mccm.Pega.Outbound.PegaMain.LoginPage;
import Mccm.Pega.Outbound.PegaMain.HomePageDetails;
//import Mccm.Pega.Outbound.PegaSubClass.HomePageDetails;
import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.QAUtil.TestUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PegaCalNBADMCCMSettingTest extends TestBase {

	private static final String priorty = null;
	LoginPage loginpage;
	HomePage  homepage;
	//	HomePageDetails HomePageDetails1;
	CalNBADMCCMSettings CalNBADMCCMSettings1;
	TestUtil testutil;
	 

	public PegaCalNBADMCCMSettingTest()
	{
		super();
	}
	@BeforeMethod

	public void setup() throws InterruptedException {
		initialization();

		loginpage = new LoginPage();
		testutil = new TestUtil();
		 

		//HomePageDetails1 =new HomePageDetails();
		CalNBADMCCMSettings1 = new CalNBADMCCMSettings();

		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password")); 
		 
		//	HomePageDetails1=homepage.ClickHomepage();
		CalNBADMCCMSettings1=homepage.ClickHomepageCalNBA();
		 
	}
	@Test (priority=1)
	public void VerifyOSFDynamicSystemSettingRunSuccessfully() throws InterruptedException { 
		System.out.println("CalNBA D_mccmsettings started");
		CalNBADMCCMSettings1.Recordclk();
		CalNBADMCCMSettings1.SysAdmin();
		CalNBADMCCMSettings1.javaexictor4();
		CalNBADMCCMSettings1.DynamicSystemSettins();
		 
		 
		//D_mccmsettings
		CalNBADMCCMSettings1.D_mccmsettings();
		CalNBADMCCMSettings1.SerchClick();
		CalNBADMCCMSettings1.Clickdmccmsetting();
		testutil.SwitcTodefaultContent();
		testutil.SwitchToFrame("PegaGadget1Ifr");
		CalNBADMCCMSettings1.ActionClkDmccmsetting();
		CalNBADMCCMSettings1.RunActionClk();
		CalNBADMCCMSettings1.FulshRunClick();
		//D_mccmsettings
		System.out.println("CalNBA  D_mccmsettings Ended");
	}


	@AfterMethod

	public void teardown() {

	 driver.quit();


		System.out.println("CalNBA Dynamic System Setting Test Case Executed");  
	}

}
