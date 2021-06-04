package Mccm.Pega.Outbound.PegaTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Mccm.Pega.Outbound.PegaMain.HomePage;
import Mccm.Pega.Outbound.PegaMain.LoginPage;
import Mccm.Pega.Outbound.PegaMain.HomePageDetails;
//import Mccm.Pega.Outbound.PegaSubClass.HomePageDetails;
import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.QAUtil.TestUtil;

public class HomePageTest extends TestBase {

	private static final String priorty = null;
	LoginPage loginpage;
	HomePage  homepage;
	HomePageDetails HomePageDetails1;
	TestUtil testutil;

	public HomePageTest()
	{
		super();
	}
	@BeforeMethod

	public void setup() throws InterruptedException {
		initialization();
		loginpage = new LoginPage();
		testutil = new TestUtil();
		HomePageDetails1 =new HomePageDetails();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password")); 
        HomePageDetails1=homepage.ClickHomepage();
	}
	@Test (priority=1)
	public void VerifyOutboundDynamicSystemSettingSuccessfully() throws InterruptedException { 
		HomePageDetails1.Recordclk();
		HomePageDetails1.SysAdmin();
		HomePageDetails1.javaexictor4();
		HomePageDetails1.DynamicSystemSettins();
		//NBANBACampaignName
		testutil.SwitcToFrame(0);
		HomePageDetails1.FilterNBAcamp();
		HomePageDetails1.NBACampaignName();
		HomePageDetails1.ApplayNBAfilter();
		HomePageDetails1.ClikMCCM();
		testutil.SwitcTodefaultContent();
		testutil.SwitchToFrame("PegaGadget1Ifr");
		HomePageDetails1.NBABatchCampaign();
		HomePageDetails1.SaveNBABatchCamp();
		HomePageDetails1.CloseNBABatchCamp();
		//NBANBACampaignName
		//NBADefultAudCount
		testutil.SwitcTodefaultContent();
		testutil.SwitchToFrame("PegaGadget0Ifr");
		HomePageDetails1.FilterNBADefultAudCount();
		HomePageDetails1.NBADefultAudCountName();
		HomePageDetails1.ApplayNBADefultAudCountfilter();
		HomePageDetails1.ClikMCCMDefultAudCount();
		testutil.SwitcTodefaultContent();
		testutil.SwitchToFrame("PegaGadget1Ifr");
		HomePageDetails1.NBADefultAudCountValue();
		HomePageDetails1.SaveDefultAudCount();
		HomePageDetails1.CloseDefultAudCount();
		////NBADefultAudCount
		//NBADefultMaxAudCountPercentage
		testutil.SwitcTodefaultContent();
		testutil.SwitchToFrame("PegaGadget0Ifr");
		HomePageDetails1.FilterMaxAudThresholdPercent();
		HomePageDetails1.NBACampMaxAudThresholdPercentName();
		HomePageDetails1.ApplayMaxAudThresholdPercentfilter();
		HomePageDetails1.ClikMCCMMaxAudThresholdPercent();
		testutil.SwitcTodefaultContent();
		testutil.SwitchToFrame("PegaGadget1Ifr");
		HomePageDetails1.NBAMaxAudThresholdPercentValue();
		HomePageDetails1.SaveMaxAudThresholdPercent();
		HomePageDetails1.CloseMaxAudThresholdPercent();
		//NBADefultMaxAudCountPercentage
		//NBADefultMinAudCountPercentage
		testutil.SwitcTodefaultContent();
		testutil.SwitchToFrame("PegaGadget0Ifr");
		HomePageDetails1.FilterMinAudThresholdPercent();
		HomePageDetails1.NBACampMinAudThresholdPercentName();
		HomePageDetails1.ApplayMinAudThresholdPercentfilter();
		HomePageDetails1.ClikMCCMMinAudThresholdPercent();
		testutil.SwitcTodefaultContent();
		testutil.SwitchToFrame("PegaGadget1Ifr");
		HomePageDetails1.NBAMinAudThresholdPercentValue();
		HomePageDetails1.SaveMinAudThresholdPercent();
		HomePageDetails1.CloseMinAudThresholdPercent();
		//NBADefultMinAudCountPercentage
		//NBANotifyErrList
		testutil.SwitcTodefaultContent();
		testutil.SwitchToFrame("PegaGadget0Ifr");
		HomePageDetails1.FilterNotifyErrList();
		HomePageDetails1.NotifyErrList();
		HomePageDetails1.ApplayNotifyErr();
		HomePageDetails1.ClikMCCMNotifyErr();
		testutil.SwitcTodefaultContent();
		testutil.SwitchToFrame("PegaGadget1Ifr");
		HomePageDetails1.MailNotifyErr();
		HomePageDetails1.SaveNotifyErrLst();
		HomePageDetails1.CloseNotifyErrLst();
		//NBANotifyErrList
		//D_mccmsettings
		HomePageDetails1.D_mccmsettings();
		HomePageDetails1.SerchClick();
		HomePageDetails1.Clickdmccmsetting();
		testutil.SwitcTodefaultContent();
		testutil.SwitchToFrame("PegaGadget1Ifr");
		HomePageDetails1.ActionClkDmccmsetting();
		HomePageDetails1.RunActionClk();
		HomePageDetails1.FulshRunClick();
        //D_mccmsettings
		//<----Override -remove commented during prod env run ------>
		//OverrideCampSrch
		HomePageDetails1.OverrideCampSrch();
		HomePageDetails1.OverrideCampSrchClk();
		HomePageDetails1.OverrideCampBlockrClk();
		testutil.SwitcTodefaultContent();
		testutil.SwitchToFrame("PegaGadget2Ifr");
		HomePageDetails1.OverrideCampActClk();
		HomePageDetails1.RunOverideBlkClk();
		HomePageDetails1.OverridCampBlkRun();
		//OverrideCampSrch

	}


	@AfterMethod

	public void teardown() {

		driver.quit();


		System.out.println("Pega Outbound Dynamic System Setting Done");  
	}

}
