package Mccm.Pega.OSF.PegaTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import Mccm.Pega.Calc.NBA.StartOffer.osfDSS;
import Mccm.Pega.OSF.OSFDSS;
import Mccm.Pega.Outbound.PegaMain.HomePage;
import Mccm.Pega.Outbound.PegaMain.LoginPage;
import Mccm.Pega.Outbound.PegaMain.HomePageDetails;
//import Mccm.Pega.Outbound.PegaSubClass.HomePageDetails;
import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.QAUtil.TestUtil;

public class PegaOSFDSSTest extends TestBase {

	private static final String priorty = null;
	LoginPage loginpage;
	HomePage  homepage;
	OSFDSS osfDSS;
	TestUtil testutil;

	public PegaOSFDSSTest()
	{
		super();
	}
	@BeforeMethod

	public void setup() throws InterruptedException {
		initialization();
		loginpage = new LoginPage();
		testutil = new TestUtil();
		osfDSS =new OSFDSS();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password")); 
		osfDSS=homepage.OSFDSS();
	}
	@Test (priority=1)
	public void VerifyOSFDynamicSystemSettingSuccessfully() throws InterruptedException { 
		osfDSS.Recordclk();
		osfDSS.SysAdmin();
		osfDSS.javaexictor4();
		osfDSS.DynamicSystemSettins();
		//Internal_REST_URL_OSF
		testutil.SwitcToFrame(0);
		osfDSS.FilterosfDSS();
		osfDSS.CalNBAStartOffSrch();
		osfDSS.ApplaycALCNBAfilter();
		osfDSS.ClikMCCM();
		testutil.SwitcTodefaultContent();
		testutil.SwitchToFrame("PegaGadget1Ifr");
		osfDSS.CalNBAStartOff();
		osfDSS.SaveCalNBAStartOff();
		osfDSS.CloseCalNBAStartOff();
		//Internal_REST_URL_OSF

//		//OSFDirection
//		testutil.SwitcTodefaultContent();
//		testutil.SwitchToFrame("PegaGadget0Ifr");
//		osfDSS.FilterOSFDirection();
//		osfDSS.OSFDirectionSrch();
//		osfDSS.ApplayOSFDirection();
//		osfDSS.ClikMCCMOSFDirection();
//		testutil.SwitcTodefaultContent();
//		testutil.SwitchToFrame("PegaGadget1Ifr");
//		osfDSS.OSFDirection();
//		osfDSS.SaveOSFDirection();
//		osfDSS.CloseOSFDirection();
//		//OSFDirection
		
//		//OSFChannel
//		testutil.SwitcTodefaultContent();
//		testutil.SwitchToFrame("PegaGadget0Ifr");
//		osfDSS.FilterOSFChannel();
//		osfDSS.OSFChannelSrch();
//		osfDSS.ApplayOSFChannel();
//		osfDSS.ClikMCCMOSFChannel();
//		testutil.SwitcTodefaultContent();
//		testutil.SwitchToFrame("PegaGadget1Ifr");
//		osfDSS.OSFChannel();
//		osfDSS.SaveOSFChannel();
//		osfDSS.CloseOSFChannel();
//		//OSFChannel
		//OSFContainerName
		testutil.SwitcTodefaultContent();
		testutil.SwitchToFrame("PegaGadget0Ifr");
		osfDSS.FilterOSFContainerName();
		osfDSS.OSFContainerNameSrch();
		osfDSS.ApplayOSFContainerName();
		osfDSS.ClikMCCMOSFContainerName();
		testutil.SwitcTodefaultContent();
		testutil.SwitchToFrame("PegaGadget1Ifr");
		osfDSS.OSFContainerName();
		osfDSS.SaveOSFContainerName();
		osfDSS.CloseOSFContainerName();
		//OSFContainerName
	}


	@AfterMethod

	public void teardown() {
		
	 driver.quit();


		System.out.println("OSF Dynamic System Setting Run Successfully");  
	}

}
