package Mccm.Pega.Outbound.PegaTest;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Mccm.Pega.Outbound.PegaMain.HomePage;
import Mccm.Pega.Outbound.PegaMain.LoginPage;
import Mccm.Pega.Outbound.PegaMain.PegaMarketPage;
import Mccm.Pega.Outbound.PegaMain.PegaMrktNBAValuChk;
import Mccm.Pega.Outbound.PegaMain.HomePageDetails;
//import Mccm.Pega.Outbound.PegaSubClass.HomePageDetails;
import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.QAUtil.TestUtil;

public class PegaMrktNBAValuChkTest extends TestBase {
	private static final String priorty = null;
	LoginPage loginpage;
	HomePage  homepage;
	PegaMrktNBAValuChk pegaMrktNBAValuChk;
	TestUtil testutil;
	

	public PegaMrktNBAValuChkTest()
	{
		super();
	}
 @BeforeMethod
 
    public void setup() throws InterruptedException {
	    initialization();
	     loginpage = new LoginPage();
	     homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password")); 
	     testutil=new TestUtil();
	     pegaMrktNBAValuChk =new PegaMrktNBAValuChk();
	 //    pegaMrktNBAValuChk=homepage.PegaMrktNBAValuChk();
	      pegaMrktNBAValuChk=homepage.Pegamrklunch1();
	    }
 

 
@Test (priority=1)
 public void VerifyNBACampValueChkPresentTestSuccessfully() throws InterruptedException, AWTException { 
	 
	 homepage.Pegamrklunch1();
	 pegaMrktNBAValuChk.pegamarkting();
	 testutil.WindowHandling();
	 pegaMrktNBAValuChk.ExpandPegMrkPage1();
	 pegaMrktNBAValuChk.CampaignImage();
	 pegaMrktNBAValuChk.Campaigns();
	 testutil.SwitcToFrame(1);
	 testutil.RobertAction();
	 pegaMrktNBAValuChk.Filter();
	 pegaMrktNBAValuChk.CampaignVlSrch();
	 pegaMrktNBAValuChk.View();
	 pegaMrktNBAValuChk.DisplayMsg(); 

	}
	 
@AfterMethod

 public void teardown() {

   // driver.quit();

    System.out.println("NBACampaignName Value is not Present..Goto Main Flow");
}	 
 }
 


