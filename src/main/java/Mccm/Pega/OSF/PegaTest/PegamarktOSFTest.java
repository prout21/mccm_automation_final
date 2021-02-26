package Mccm.Pega.OSF.PegaTest;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Mccm.Pega.DMP.RealTime.LoginPageDMPRealTime;
import Mccm.Pega.DMP.RealTime.PegaMarktDMPRealTime;
import Mccm.Pega.OSF.LoginPageOSF;
import Mccm.Pega.OSF.PegaMarktOSF;
import Mccm.Pega.Outbound.PegaMain.HomePage;
import Mccm.Pega.Outbound.PegaMain.HomePageDetails;
import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.QAUtil.TestUtil;

public class PegamarktOSFTest extends TestBase {
	
	private static final String priorty = null;
	
	//LoginPageDMPRealTime loginpageDMPrealtime;
	//PegaMarktDMPRealTime pegamarktDMPrealtime;
	LoginPageOSF loginPageOSF;
	PegaMarktOSF pegaMarktOSF;
	TestUtil testutil;
	

	public PegamarktOSFTest()
	{
		super();
	}
 @BeforeMethod
 
    public void setup() throws InterruptedException {
	    initialization();
	 //    loginpageDMPrealtime = new LoginPageDMPRealTime();
	     loginPageOSF = new LoginPageOSF();
	     pegaMarktOSF = loginPageOSF.login(prop.getProperty("username"), prop.getProperty("password")); 
	     testutil=new TestUtil();
	 //    pegamarktDMPrealtime  = new PegaMarktDMPRealTime();
	     pegaMarktOSF =new PegaMarktOSF();
	 //    pegamarktDMPrealtime=loginpageDMPrealtime.Pegamrklunch3();
	     pegaMarktOSF=loginPageOSF.Pegamrklunch3();
	
	    }


 
@Test (priority=1)
 public void VerifyOSFNBACampRunSuccessfully() throws InterruptedException, AWTException { 

	// loginPageOSF.Pegamrklunch3();
	 pegaMarktOSF.pegamarkting();
	 testutil.WindowHandling();
	 pegaMarktOSF.ExpandPegMrkPage1();
	 pegaMarktOSF.CampaignImage();
	 pegaMarktOSF.Campaigns();
	 testutil.SwitcToFrame(1);
	 testutil.RobertAction();
	 pegaMarktOSF.Create();
	 pegaMarktOSF.MultiChannelCampaign(); 
	 testutil.SwitcTodefaultContent();
	 testutil.SwitcToFrame(2);
	 pegaMarktOSF.Campaigncode();
	 pegaMarktOSF.Build();
	 pegaMarktOSF.MrktStrtgyConfig();
	 pegaMarktOSF.SrchMrkStrtgy();
	 pegaMarktOSF.AddMrkStrtgy();
	 pegaMarktOSF.Applay();
	 pegaMarktOSF.javaexictor2();
	 pegaMarktOSF.Engagementconfig();
	 pegaMarktOSF.OSFContainers();
	 pegaMarktOSF.Calender();
	 pegaMarktOSF.Currentdate();
	 pegaMarktOSF.ConfigureContainers();
	 pegaMarktOSF.SrchConfigEngagment();
	 pegaMarktOSF.AddConfigureContainers();
	 pegaMarktOSF.Javascriptserch();
	 pegaMarktOSF.ApplayEngagement();
	 pegaMarktOSF.SaveCampgn();
	 pegaMarktOSF.RunCampgn();
	 pegaMarktOSF.ConfirmCampgn();
	// pegaMarktOSF.RefreshCampgn();
	 
 }
@AfterMethod

public void teardown() {

 driver.quit();


	System.out.println("OSF Containers NBACamp Run Done");
}

}
