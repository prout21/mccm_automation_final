package Mccm.Pega.Outbound.PegaMain;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Mccm.Pega.DMP.RealTime.PegaMarktDMPRealTime;
import Mccm.Pega.DMP.RealTime.PegaPreChkValidDMPCampCd;
//import Mccm.Pega.Outbound.PegaSubClass.HomePageDetails;
import Mccm.Pega.Outbound.PegaMain.HomePageDetails;
import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.Calc.NBA.StartOffer.CalcNBAStartOffDSS;

public class HomePage extends TestBase {
	//page factory - OR:
	
	@FindBy(xpath="//a[@id='appview-nav-toggle-one']")
	WebElement Homepage;
	@FindBy(xpath="(//i[@class='pi pi-caret-down'])[2]")
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
   public PegaMarketPage Pegamrklunch()throws InterruptedException {
	   
	     Actions  action = new Actions(driver);
	     action.moveToElement(Pegalunch).click().build().perform();
	     Thread.sleep(1000);
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
   
   public PegaMrktNBAValuChk Pegamrklunch1()throws InterruptedException {
		
	     Actions  action = new Actions(driver);
	     action.moveToElement(Pegalunch).click().build().perform();
	     Thread.sleep(1000);
	   	  return new PegaMrktNBAValuChk();
	   } 
   public PegaMrktNBAReSchd Pegamrklunch2()throws InterruptedException {
		
	     Actions  action = new Actions(driver);
	     action.moveToElement(Pegalunch).click().build().perform();
	     Thread.sleep(1000);
	   	  return new PegaMrktNBAReSchd();
	   }
   
   public PreChkNBACampValu PreChkNBACampValu() throws InterruptedException {
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
	   	   return new PreChkNBACampValu();
	   }
   public PegaPreChkValidCampCd Pegamrklunch3()throws InterruptedException {
		
	     Actions  action = new Actions(driver);
	     action.moveToElement(Pegalunch).click().build().perform();
	     Thread.sleep(1000);
	   	  return new PegaPreChkValidCampCd();
	   }
   public PegaPreChkValidDMPCampCd Pegamrklunch4()throws InterruptedException {
		
	     Actions  action = new Actions(driver);
	     action.moveToElement(Pegalunch).click().build().perform();
	     Thread.sleep(1000);
	   	  return new PegaPreChkValidDMPCampCd();
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
  
 
}
