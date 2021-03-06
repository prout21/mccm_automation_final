package Mccm.Pega.Outbound.PegaTest;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Mccm.Pega.Outbound.PegaMain.HomePage;
import Mccm.Pega.Outbound.PegaMain.LoginPage;
import Mccm.Pega.Outbound.PegaMain.PegaMarketPage;
import Mccm.Pega.Outbound.PegaMain.HomePageDetails;
//import Mccm.Pega.Outbound.PegaSubClass.HomePageDetails;
import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.QAUtil.TestUtil;

public class PegamarktingTest extends TestBase {
	private static final String priorty = null;
	LoginPage loginpage;
	HomePage  homepage;
	PegaMarketPage pegamarketpage;
	TestUtil testutil;


	public PegamarktingTest()
	{
		super();
	}
	@BeforeMethod

	public void setup() throws InterruptedException {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password")); 
		testutil=new TestUtil();
		pegamarketpage =new PegaMarketPage();
		// pegamarketpage=homepage.Pegamrklunch();
		 driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}


	@Test (priority=1)
	public void VerifyOutboundNBACampaignRunSuccessfully() throws InterruptedException, AWTException { 
		 homepage.Pegamrklunch();
		pegamarketpage.pegamarkting();
		testutil.WindowHandling();
		 driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
 		pegamarketpage.ExpandPegMrkPage1();
    	pegamarketpage.CampaignImage();
		pegamarketpage.Campaigns();
		testutil.SwitcToFrame(1);
		testutil.RobertAction();
		pegamarketpage.Create();
		pegamarketpage.MultiChannelCampaign(); 
		testutil.SwitcTodefaultContent();
		testutil.SwitcToFrame(2); 
		pegamarketpage.Campaigncode();
		pegamarketpage.Build();
		pegamarketpage.MrktStrtgyConfig();
		pegamarketpage.SrchMrkStrtgy();
		pegamarketpage.AddMrkStrtgy();
		pegamarketpage.Applay();
		pegamarketpage.AudianceConfig();
		pegamarketpage.SrchConfigAudience();
		pegamarketpage.AddAdinceconfig();
		pegamarketpage.ApplayAdience(); 
		pegamarketpage.javaexictor2();
		pegamarketpage.Engagementconfig();
		pegamarketpage.Campaignschdul();
		pegamarketpage.Recurring();
		pegamarketpage.databasetemplate();
		pegamarketpage.configtemplate();
		pegamarketpage.SrchConfigEngagment();
		pegamarketpage.Addmcclbound();
		pegamarketpage.Javascriptserch();
		pegamarketpage.ApplayEngagement();
		pegamarketpage.SaveCampgn();
		pegamarketpage.RunCampgn();
		pegamarketpage.ConfirmCampgn();
		pegamarketpage.RefreshCampgn();
		pegamarketpage.Runstatus();
		pegamarketpage.CampRunIDCaptured();
	}

	@AfterMethod

	public void teardown() {

 
  //  driver.quit();
 
	 


		System.out.println("Outbound Pega Markting NBA Batch Campaign Run Finished");  
	}	 
}



