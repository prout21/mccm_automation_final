package Mccm.Pega.Outbound.PegaTest;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Mccm.Pega.Outbound.PegaMain.HomePage;
import Mccm.Pega.Outbound.PegaMain.LoginPage;
import Mccm.Pega.Outbound.PegaMain.PegaMarketPage;
import Mccm.Pega.Outbound.PegaMain.PegaMrktNBAReSchd;
import Mccm.Pega.Outbound.PegaMain.HomePageDetails;
//import Mccm.Pega.Outbound.PegaSubClass.HomePageDetails;
import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.QAUtil.TestUtil;

public class PegaMrktNBAReSchdTest extends TestBase {
	private static final String priorty = null;
	LoginPage loginpage;
	HomePage  homepage;
	PegaMrktNBAReSchd pegaMrktNBAReSchd;
	TestUtil testutil;
	

	public PegaMrktNBAReSchdTest()
	{
		super();
	}
 @BeforeMethod
 
    public void setup() throws InterruptedException {
	    initialization();
	     loginpage = new LoginPage();
	     homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password")); 
	     testutil=new TestUtil();
	     pegaMrktNBAReSchd =new PegaMrktNBAReSchd();
	 //    PegaMrktNBAReSchd=homepage.PegaMrktNBAReSchd();
	      pegaMrktNBAReSchd=homepage.Pegamrklunch2();
	    }
 

 
@Test (priority=1)
 public void VerifyNBACampReScheduleRunSuccessfully() throws InterruptedException, AWTException { 
	 
	 homepage.Pegamrklunch2();
	 pegaMrktNBAReSchd.pegamarkting();
	 testutil.WindowHandling();
	 pegaMrktNBAReSchd.ExpandPegMrkPage();
	 pegaMrktNBAReSchd.Campaigns();
	 testutil.SwitcToFrame(1);
	 testutil.RobertAction();
	 pegaMrktNBAReSchd.Filter();
	 pegaMrktNBAReSchd.CampaignVlSrch();
	 pegaMrktNBAReSchd.View();
	 pegaMrktNBAReSchd.ImageClk();
	 pegaMrktNBAReSchd.ActionsReSchd();
	 pegaMrktNBAReSchd.Configure();
	 pegaMrktNBAReSchd.CalendarApplay();
	 pegaMrktNBAReSchd.Confirm();
	 pegaMrktNBAReSchd.Refresh();
	 pegaMrktNBAReSchd.RunStatus();
	 pegaMrktNBAReSchd.CapturedRunID();
	

	}
	 
@AfterMethod

 public void teardown() {

    driver.quit();


     System.out.println("NBACamp ReSchedule Run Successfully Done");  
}	 
 }
 


