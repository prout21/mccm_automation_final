package Mccm.Pega.DMP.RealTime;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Mccm.Pega.Outbound.PegaTestBase.TestBase;

public class LoginPageDMPRealTime extends TestBase {
	//page factory - OR:
	
	@FindBy(xpath="//input[@id='txtUserID']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='txtPassword']")
	WebElement password;
	
	@FindBy(xpath="//span[@class='loginButtonText']")
	WebElement loginbtm;
	
	@FindBy(xpath="//a[@id='appview-nav-toggle-one']")
	WebElement Homepage;
	//@FindBy(xpath="(//i[@class='pi pi-caret-down'])[2]")
	@FindBy(xpath="//a[@title='Launch web interface']")
	WebElement Pegalunch;

  
	 
    public LoginPageDMPRealTime()
    {
    	PageFactory.initElements(driver, this);
    }
    			
   
    public PegaMarktDMPRealTime login(String uid,String pwd)
    {
    	username.sendKeys(uid);
    	password.sendKeys(pwd);
    	loginbtm.click();
    	 driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
    	return new PegaMarktDMPRealTime();    	
    	    }
    
    public PegaMarktDMPRealTime Pegamrklunch3()throws InterruptedException {
		
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
	    	 
	   	  return new PegaMarktDMPRealTime();
	   }
    
}
