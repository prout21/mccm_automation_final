package Mccm.Pega.Outbound.PegaMain;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import Mccm.Pega.DMP.RealTime.PegaMarktDMPRealTime;
import Mccm.Pega.DMP.RealTime.PegaPreChkValidDMPCampCd;
import Mccm.Pega.OSF.OSFDMCCMSettings;
import Mccm.Pega.OSF.OSFDSS;
import Mccm.Pega.OSF.PegaPreChkValidOSFCampCd;
//import Mccm.Pega.Outbound.PegaSubClass.HomePageDetails;
import Mccm.Pega.Outbound.PegaMain.HomePageDetails;
import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.Calc.NBA.StartOffer.CalcNBAStartOffDSS;
import Mccm.Pega.Calc.NBA.StartOffer.PegaPreChkValidCalcNBACampCd;

public class HomePage extends TestBase {
	//page factory - OR:

	@FindBy(xpath="//a[@id='appview-nav-toggle-one']")
	WebElement Homepage;
	//@FindBy(xpath="(//i[@class='pi pi-caret-down'])[2]")
	@FindBy(xpath="//a[@title='Launch web interface']")
	WebElement Pegalunch;



	public HomePage( ) {
		PageFactory.initElements(driver, this);
	}

	public DataLoadDetails DataLoadValidation() throws InterruptedException {
		Thread.sleep(8000);
		//	  Homepage.click();

		boolean searchIconPresence = Homepage.isDisplayed();
		boolean searchIconEnabled =  Homepage.isEnabled();

		if (searchIconPresence==true && searchIconEnabled==true)

		{
			WebElement element20 = Homepage;
			JavascriptExecutor executor14 = (JavascriptExecutor)driver;
			executor14.executeScript("arguments[0].click();", element20);

		}
		return new DataLoadDetails();
	} 

	public HomePageDetails ClickHomepage() throws InterruptedException {
		Thread.sleep(8000);
		//  Homepage.click();
		boolean searchIconPresence = Homepage.isDisplayed();
		boolean searchIconEnabled =  Homepage.isEnabled();

		if (searchIconPresence==true && searchIconEnabled==true)

		{
			WebElement element20 = Homepage;
			JavascriptExecutor executor14 = (JavascriptExecutor)driver;
			executor14.executeScript("arguments[0].click();", element20);

		}

		return new HomePageDetails();
	} 	


	public OSFDMCCMSettings ClickHomepageOSF() throws InterruptedException {
		Thread.sleep(6000); // Homepage.click();

		boolean searchIconPresence = Homepage.isDisplayed(); boolean
		searchIconEnabled = Homepage.isEnabled();

		if (searchIconPresence==true && searchIconEnabled==true)

		{ 
			WebElement element20 = Homepage; JavascriptExecutor executor14 =
					(JavascriptExecutor)driver; executor14.executeScript("arguments[0].click();",
							element20);

		}

		return new OSFDMCCMSettings(); }

	public PegaMarketPage Pegamrklunch()throws InterruptedException {

		//	     Actions  action = new Actions(driver);
		//	     action.moveToElement(Pegalunch).click().build().perform();
		//	     Thread.sleep(6000);
		wait.until(ExpectedConditions.visibilityOf( Pegalunch));  
		wait.until(ExpectedConditions.elementToBeClickable( Pegalunch));
		Thread.sleep(8000);
		{
			WebElement element9 = Pegalunch;
			JavascriptExecutor executor3 = (JavascriptExecutor)driver;
			executor3.executeScript("arguments[0].click();", element9);
		}

		Thread.sleep(8000);

		System.out.println("Entered the PegaMarket");
		return new PegaMarketPage();
	}

	public DBConfigValdtn DBConfigValidation() throws InterruptedException {
		Thread.sleep(8000);
		// 	  Homepage.click();
		boolean searchIconPresence = Homepage.isDisplayed();
		boolean searchIconEnabled =  Homepage.isEnabled();

		if (searchIconPresence==true && searchIconEnabled==true)

		{
			WebElement element20 = Homepage;
			JavascriptExecutor executor14 = (JavascriptExecutor)driver;
			executor14.executeScript("arguments[0].click();", element20);

		}

		return new DBConfigValdtn();
	} 
	public ExtractChannelFile ExtractChannelFile() throws InterruptedException {
		Thread.sleep(8000);
		// 	  Homepage.click();
		boolean searchIconPresence = Homepage.isDisplayed();
		boolean searchIconEnabled =  Homepage.isEnabled();

		if (searchIconPresence==true && searchIconEnabled==true)

		{
			WebElement element20 = Homepage;
			JavascriptExecutor executor14 = (JavascriptExecutor)driver;
			executor14.executeScript("arguments[0].click();", element20);

		}

		return new ExtractChannelFile();
	} 
	public NBAOutboundValdtn NBAOutboundValdtn() throws InterruptedException {
		Thread.sleep(8000);
		//  	  Homepage.click();
		boolean searchIconPresence = Homepage.isDisplayed();
		boolean searchIconEnabled =  Homepage.isEnabled();

		if (searchIconPresence==true && searchIconEnabled==true)

		{
			WebElement element20 = Homepage;
			JavascriptExecutor executor14 = (JavascriptExecutor)driver;
			executor14.executeScript("arguments[0].click();", element20);

		}

		return new NBAOutboundValdtn();
	} 

	//   public PegaMrktNBAValuChk Pegamrklunch1()throws InterruptedException {
	//		
	//	     Actions  action = new Actions(driver);
	//	     action.moveToElement(Pegalunch).click().build().perform();
	//	     Thread.sleep(1000);
	//	   	  return new PegaMrktNBAValuChk();
	//	   } 
	//   public PegaMrktNBAReSchd Pegamrklunch2()throws InterruptedException {
	//		
	//	     Actions  action = new Actions(driver);
	//	     action.moveToElement(Pegalunch).click().build().perform();
	//	     Thread.sleep(1000);
	//	   	  return new PegaMrktNBAReSchd();
	//	   }
	//   
	//   public PreChkNBACampValu PreChkNBACampValu() throws InterruptedException {
	//	   	  Thread.sleep(8000);
	//	   //	  Homepage.click();
	//	   	boolean searchIconPresence = Homepage.isDisplayed();
	//		boolean searchIconEnabled =  Homepage.isEnabled();
	//
	//		if (searchIconPresence==true && searchIconEnabled==true)
	//
	//		{
	//			WebElement element20 = Homepage;
	//			JavascriptExecutor executor14 = (JavascriptExecutor)driver;
	//			executor14.executeScript("arguments[0].click();", element20);
	//	 
	//	}
	//	   	   return new PreChkNBACampValu();
	//	   }
	public PegaPreChkValidCampCd Pegamrklunch3()throws InterruptedException {

		//	     Actions  action = new Actions(driver);
		//	     action.moveToElement(Pegalunch).click().build().perform();
		//	     Thread.sleep(6000);
		wait.until(ExpectedConditions.visibilityOf( Pegalunch));  
		wait.until(ExpectedConditions.elementToBeClickable( Pegalunch));
		Thread.sleep(8000);
		{
			WebElement element9 = Pegalunch;
			JavascriptExecutor executor3 = (JavascriptExecutor)driver;
			executor3.executeScript("arguments[0].click();", element9);
		}

		Thread.sleep(8000);

		System.out.println("Entered the PegaMarket");
		return new PegaPreChkValidCampCd();
	}
	public PegaPreChkValidDMPCampCd Pegamrklunch4()throws InterruptedException {

		//	     Actions  action = new Actions(driver);
		//	     action.moveToElement(Pegalunch).click().build().perform();
		//	     Thread.sleep(6000);
		wait.until(ExpectedConditions.visibilityOf( Pegalunch));  
		wait.until(ExpectedConditions.elementToBeClickable( Pegalunch));
		Thread.sleep(8000);
		{
			WebElement element9 = Pegalunch;
			JavascriptExecutor executor3 = (JavascriptExecutor)driver;
			executor3.executeScript("arguments[0].click();", element9);
		}

		Thread.sleep(8000);

		System.out.println("Entered the PegaMarket");
		return new PegaPreChkValidDMPCampCd();
	}


	public PegaPreChkValidCalcNBACampCd Pegamrklunch5()throws InterruptedException {

		//    Actions  action = new Actions(driver);
		//   action.moveToElement(Pegalunch).click().build().perform();
		//   action.moveToElement(Pegalunch).doubleClick().build().perform();
		//    Pegalunch.click();
		//    Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOf( Pegalunch));  
		wait.until(ExpectedConditions.elementToBeClickable( Pegalunch));
		Thread.sleep(8000);
		{
			WebElement element9 = Pegalunch;
			JavascriptExecutor executor3 = (JavascriptExecutor)driver;
			executor3.executeScript("arguments[0].click();", element9);
		}

		Thread.sleep(8000);

		System.out.println("Entered the PegaMarket");
		return new PegaPreChkValidCalcNBACampCd();
	}

	public CalcNBAStartOffDSS CalcNBAStartOffDSS() throws InterruptedException {
		Thread.sleep(8000);
		//  Homepage.click();
		boolean searchIconPresence = Homepage.isDisplayed();
		boolean searchIconEnabled =  Homepage.isEnabled();

		if (searchIconPresence==true && searchIconEnabled==true)

		{
			WebElement element20 = Homepage;
			JavascriptExecutor executor14 = (JavascriptExecutor)driver;
			executor14.executeScript("arguments[0].click();", element20);

		}
		return new CalcNBAStartOffDSS();
	}
	public OSFDSS OSFDSS() throws InterruptedException {
		Thread.sleep(8000);
		//  Homepage.click();
		boolean searchIconPresence = Homepage.isDisplayed();
		boolean searchIconEnabled =  Homepage.isEnabled();

		if (searchIconPresence==true && searchIconEnabled==true)

		{
			WebElement element20 = Homepage;
			JavascriptExecutor executor14 = (JavascriptExecutor)driver;
			executor14.executeScript("arguments[0].click();", element20);

		}
		return new OSFDSS();
	}

	public PegaPreChkValidOSFCampCd Pegamrklunch6()throws InterruptedException {

		//	     Actions  action = new Actions(driver);
		//	     action.moveToElement(Pegalunch).click().build().perform();
		//	     Thread.sleep(6000);
		wait.until(ExpectedConditions.visibilityOf( Pegalunch));  
		wait.until(ExpectedConditions.elementToBeClickable( Pegalunch));
		Thread.sleep(8000);
		{
			WebElement element9 = Pegalunch;
			JavascriptExecutor executor3 = (JavascriptExecutor)driver;
			executor3.executeScript("arguments[0].click();", element9);
		}

		Thread.sleep(8000);

		System.out.println("Entered the PegaMarket");
		return new PegaPreChkValidOSFCampCd();
	}
}
