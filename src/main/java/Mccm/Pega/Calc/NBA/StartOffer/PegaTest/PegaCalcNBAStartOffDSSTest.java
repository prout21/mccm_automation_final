package Mccm.Pega.Calc.NBA.StartOffer.PegaTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Mccm.Pega.Calc.NBA.StartOffer.CalcNBAStartOffDSS;
import Mccm.Pega.Outbound.PegaMain.HomePage;
import Mccm.Pega.Outbound.PegaMain.LoginPage;
import Mccm.Pega.Outbound.PegaMain.HomePageDetails;
//import Mccm.Pega.Outbound.PegaSubClass.HomePageDetails;
import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.QAUtil.TestUtil;

public class PegaCalcNBAStartOffDSSTest extends TestBase {

	private static final String priorty = null;
	LoginPage loginpage;
	HomePage  homepage;
	CalcNBAStartOffDSS calcNBAStartOffDSS;
	TestUtil testutil;

	public PegaCalcNBAStartOffDSSTest()
	{
		super();
	}
	@BeforeMethod

	public void setup() throws InterruptedException {
		initialization();
		loginpage = new LoginPage();
		testutil = new TestUtil();
		calcNBAStartOffDSS =new CalcNBAStartOffDSS();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password")); 
		calcNBAStartOffDSS=homepage.CalcNBAStartOffDSS();
	}
	@Test (priority=1)
	public void VerifyCalcNBADynamicSystemSettingSuccessfully() throws InterruptedException { 
		calcNBAStartOffDSS.Recordclk();
		calcNBAStartOffDSS.SysAdmin();
		calcNBAStartOffDSS.javaexictor4();
		calcNBAStartOffDSS.DynamicSystemSettins();
		//Internal_REST_URL_OSF
		testutil.SwitcToFrame(0);
		calcNBAStartOffDSS.FilterCalcNBAStartOffDSS();
		calcNBAStartOffDSS.CalNBAStartOffSrch();
		calcNBAStartOffDSS.ApplaycALCNBAfilter();
		calcNBAStartOffDSS.ClikMCCM();
		testutil.SwitcTodefaultContent();
		testutil.SwitchToFrame("PegaGadget1Ifr");
		calcNBAStartOffDSS.CalNBAStartOff();
		calcNBAStartOffDSS.SaveCalNBAStartOff();
		calcNBAStartOffDSS.CloseCalNBAStartOff();
		//Internal_REST_URL_OSF

		//OSFDirection
		testutil.SwitcTodefaultContent();
		testutil.SwitchToFrame("PegaGadget0Ifr");
		calcNBAStartOffDSS.FilterOSFDirection();
		calcNBAStartOffDSS.OSFDirectionSrch();
		calcNBAStartOffDSS.ApplayOSFDirection();
		calcNBAStartOffDSS.ClikMCCMOSFDirection();
		testutil.SwitcTodefaultContent();
		testutil.SwitchToFrame("PegaGadget1Ifr");
		calcNBAStartOffDSS.OSFDirection();
		calcNBAStartOffDSS.SaveOSFDirection();
		calcNBAStartOffDSS.CloseOSFDirection();
		//OSFDirection

		//OSFChannel
		testutil.SwitcTodefaultContent();
		testutil.SwitchToFrame("PegaGadget0Ifr");
		calcNBAStartOffDSS.FilterOSFChannel();
		calcNBAStartOffDSS.OSFChannelSrch();
		calcNBAStartOffDSS.ApplayOSFChannel();
		calcNBAStartOffDSS.ClikMCCMOSFChannel();
		testutil.SwitcTodefaultContent();
		testutil.SwitchToFrame("PegaGadget1Ifr");
		calcNBAStartOffDSS.OSFChannel();
		calcNBAStartOffDSS.SaveOSFChannel();
		calcNBAStartOffDSS.CloseOSFChannel();
		//OSFChannel
		//OSFContainerName
		testutil.SwitcTodefaultContent();
		testutil.SwitchToFrame("PegaGadget0Ifr");
		calcNBAStartOffDSS.FilterOSFContainerName();
		calcNBAStartOffDSS.OSFContainerNameSrch();
		calcNBAStartOffDSS.ApplayOSFContainerName();
		calcNBAStartOffDSS.ClikMCCMOSFContainerName();
		testutil.SwitcTodefaultContent();
		testutil.SwitchToFrame("PegaGadget1Ifr");
		calcNBAStartOffDSS.OSFContainerName();
		calcNBAStartOffDSS.SaveOSFContainerName();
		calcNBAStartOffDSS.CloseOSFContainerName();
		//OSFContainerName
	}


	@AfterMethod

	public void teardown() {

		driver.quit();


		System.out.println("Calc NBA Start Offer DSS Done");  
	}

}
