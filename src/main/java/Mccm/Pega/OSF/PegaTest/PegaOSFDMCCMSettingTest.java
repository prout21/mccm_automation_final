package Mccm.Pega.OSF.PegaTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Mccm.Pega.OSF.OSFDMCCMSettings;
import Mccm.Pega.Outbound.PegaMain.HomePage;
import Mccm.Pega.Outbound.PegaMain.LoginPage;
import Mccm.Pega.Outbound.PegaMain.HomePageDetails;
//import Mccm.Pega.Outbound.PegaSubClass.HomePageDetails;
import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.QAUtil.TestUtil;

public class PegaOSFDMCCMSettingTest extends TestBase {

	private static final String priorty = null;
	LoginPage loginpage;
	HomePage  homepage;
//	HomePageDetails HomePageDetails1;
	OSFDMCCMSettings OSFDMCCMSettings1;
	TestUtil testutil;

	public PegaOSFDMCCMSettingTest()
	{
		super();
	}
	@BeforeMethod

	public void setup() throws InterruptedException {
		initialization();
		 
		loginpage = new LoginPage();
		testutil = new TestUtil();
		 
		//HomePageDetails1 =new HomePageDetails();
		OSFDMCCMSettings1 = new OSFDMCCMSettings();
		 
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password")); 
		 
	//	HomePageDetails1=homepage.ClickHomepage();
	//	OSFDMCCMSettings1=homepage.ClickHomepageOSF();
		 
	}
	@Test (priority=1)
	public void VerifyOSFDMCCMSettingDSSSuccessfully() throws InterruptedException { 
		OSFDMCCMSettings1.Recordclk();
		OSFDMCCMSettings1.SysAdmin();
		OSFDMCCMSettings1.javaexictor4();
		OSFDMCCMSettings1.DynamicSystemSettins();
		 
		//D_mccmsettings
		OSFDMCCMSettings1.D_mccmsettings();
		OSFDMCCMSettings1.SerchClick();
		OSFDMCCMSettings1.Clickdmccmsetting();
		testutil.SwitcTodefaultContent();
		testutil.SwitchToFrame("PegaGadget1Ifr");
		OSFDMCCMSettings1.ActionClkDmccmsetting();
		OSFDMCCMSettings1.RunActionClk();
		OSFDMCCMSettings1.FulshRunClick();
        //D_mccmsettings
	 

	}


	@AfterMethod

	public void teardown() {

		driver.quit();


		System.out.println("Pega OSF D_MCCM Setting DSS Done");  
	}

}
