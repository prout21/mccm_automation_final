package Mccm.Pega.Calc.NBA.StartOffer.PegaTest;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Mccm.Pega.Calc.NBA.StartOffer.LoginPageCalcNBAandStartOff;
import Mccm.Pega.Calc.NBA.StartOffer.PegaMarktCalcNBAandStartOff;
import Mccm.Pega.Outbound.PegaMain.HomePage;
import Mccm.Pega.Outbound.PegaMain.HomePageDetails;
import Mccm.Pega.Outbound.PegaMain.LoginPage;
import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.QAUtil.TestUtil;

public class PegamarktCalcNBAandStartOffTest extends TestBase {

	private static final String priorty = null;
	LoginPage loginpage;
	HomePage  homepage;

	LoginPageCalcNBAandStartOff loginPageCalcNBAandStartOff;
	PegaMarktCalcNBAandStartOff pegaMarktCalcNBAandStartOff; 
	TestUtil testutil;
	
	


	public PegamarktCalcNBAandStartOffTest()
	{
		super();
	}
	@BeforeMethod

	public void setup() throws InterruptedException {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password")); 
		
 		loginPageCalcNBAandStartOff = new LoginPageCalcNBAandStartOff();
//		pegaMarktCalcNBAandStartOff = loginPageCalcNBAandStartOff.login(prop.getProperty("username"), prop.getProperty("password")); 
		testutil=new TestUtil();
		pegaMarktCalcNBAandStartOff  = new PegaMarktCalcNBAandStartOff();
	//	pegaMarktCalcNBAandStartOff=loginPageCalcNBAandStartOff.Pegamrklunch3(); 
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

	}

	@Test (priority=1)
	public void VerifyCalcNBAandStartOfferEventRunSuccessfully() throws InterruptedException, AWTException { 

	    loginPageCalcNBAandStartOff.Pegamrklunch3();
	//	pegaMarktCalcNBAandStartOff.Pegamrklunch();
		pegaMarktCalcNBAandStartOff.pegamarkting();
		testutil.WindowHandling();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		pegaMarktCalcNBAandStartOff.ExpandPegMrkPage1();
		pegaMarktCalcNBAandStartOff.CampaignImage();
		pegaMarktCalcNBAandStartOff.Campaigns();
		testutil.SwitcToFrame(1);
		testutil.RobertAction();
		pegaMarktCalcNBAandStartOff.Create();
		pegaMarktCalcNBAandStartOff.MultiChannelCampaign(); 
		testutil.SwitcTodefaultContent();
		testutil.SwitcToFrame(2);
		pegaMarktCalcNBAandStartOff.Campaigncode();
		pegaMarktCalcNBAandStartOff.Build();
		pegaMarktCalcNBAandStartOff.MrktStrtgyConfig();
		pegaMarktCalcNBAandStartOff.SrchMrkStrtgy();
		pegaMarktCalcNBAandStartOff.AddMrkStrtgy();
		pegaMarktCalcNBAandStartOff.Applay();
		pegaMarktCalcNBAandStartOff.javaexictor2();
		pegaMarktCalcNBAandStartOff.Engagementconfig();
		pegaMarktCalcNBAandStartOff.RealtimeEvents();
		pegaMarktCalcNBAandStartOff.Calender();
		pegaMarktCalcNBAandStartOff.Currentdate();
		pegaMarktCalcNBAandStartOff.ConfigureEvents();
		pegaMarktCalcNBAandStartOff.SrchConfigEngagment();
		pegaMarktCalcNBAandStartOff.AddConfigureEvents();
		pegaMarktCalcNBAandStartOff.Javascriptserch();
		pegaMarktCalcNBAandStartOff.ApplayEngagement();
		pegaMarktCalcNBAandStartOff.SaveCampgn();
		pegaMarktCalcNBAandStartOff.RunCampgn();
		pegaMarktCalcNBAandStartOff.ConfirmCampgn();
		//  pegaMarktCalcNBAandStartOff.RefreshCampgn();

	}
	@AfterMethod

	public void teardown() {

	 driver.quit();


		System.out.println("Calc NBAandStart Offer Event setup Run Done");
	}

}
