package Mccm.Pega.Outbound.PegaTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Mccm.Pega.Outbound.PegaMain.HomePage;
import Mccm.Pega.Outbound.PegaMain.LoginPage;
import Mccm.Pega.Outbound.PegaMain.PreChkNBACampValu;
import Mccm.Pega.Outbound.PegaMain.DataLoadDetails;
//import Mccm.Pega.Outbound.PegaSubClass.DataLoadDetails;
import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.QAUtil.TestUtil;

public class PreChkNBACampValuTest extends TestBase {

	private static final String priorty = null;
	LoginPage loginpage;
	HomePage  homepage;
	PreChkNBACampValu PreChkNBACampValu1;
	TestUtil testutil;

	public PreChkNBACampValuTest()
	{
		super();
	}
	@BeforeMethod

	public void setup() throws InterruptedException {
		initialization();
		loginpage = new LoginPage();
		testutil = new TestUtil();
		PreChkNBACampValu1 =new PreChkNBACampValu();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password")); 
		PreChkNBACampValu1=homepage.PreChkNBACampValu();
	}
	@Test (priority=1)
	public void VerifyOutboundCapturedNBACampaignNameValueSuccessfully() throws InterruptedException { 
		PreChkNBACampValu1.Recordclk();
		PreChkNBACampValu1.SysAdmin();
		PreChkNBACampValu1.javaexictor4();
		PreChkNBACampValu1.DynamicSystemSettins();
		testutil.SwitcToFrame(0);
		PreChkNBACampValu1.FilterNBAcamp(); 
		PreChkNBACampValu1.NBACampaignName(); 
		PreChkNBACampValu1.ApplayNBAfilter(); 
		PreChkNBACampValu1.ClikMCCM(); 
		testutil.SwitcTodefaultContent();
		testutil.SwitchToFrame("PegaGadget1Ifr");
		PreChkNBACampValu1.NBACampaignNamevalue();

	}


	@AfterMethod

	public void teardown() {

		driver.quit();


		System.out.println("Outbound Captured NBACampaign Name Value Successfully Done");  
	}

}
