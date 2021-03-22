package Mccm.Pega.Outbound.PegaTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Mccm.Pega.Outbound.PegaMain.HomePage;
import Mccm.Pega.Outbound.PegaMain.LoginPage;
import Mccm.Pega.Outbound.PegaTestBase.TestBase;

public class LoginPageTest extends TestBase {
	
	private static final String priorty = null;
	LoginPage loginpage;
	HomePage  Homepage;
//	ExtentReports extent;
//	ExtentTest logger;
	public LoginPageTest()
	{
		super();
	}
 @BeforeMethod
 
    public void setup() throws InterruptedException {
	    initialization();
	    loginpage = new LoginPage();
	    
 }
 
 
 @Test (priority=1)
 public void VerifyPegaApplicationLoginPageTitleTest() { 
	 String title = loginpage.PageTitle();
	 Assert.assertEquals(title, "Pega Platform");
	
	 
 }

 @Test (priority=2)
 public void VerifyPegaApplicationPegaLogoTest() { 
	 boolean flag = loginpage.veryfyLogo();
	 Assert.assertTrue(flag);
	 
 }
 @Test (priority=3)
 public void VerifyPegaApplicationLoginSuccessfulTest() { 
	 loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	 	 
 }
 
 @AfterMethod
 
    public void teardown() {
	 driver.quit();
	    
 }
    
}
