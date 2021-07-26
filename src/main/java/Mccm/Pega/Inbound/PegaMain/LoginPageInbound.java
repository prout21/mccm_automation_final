package Mccm.Pega.Inbound.PegaMain;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

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
import Mccm.Pega.Outbound.PegaTestBase.TestBase;


public class LoginPageInbound extends TestBase {
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
	
	//a[@title='Launch web interface']
  
	 
    public LoginPageInbound()
    {
    	PageFactory.initElements(driver, this);
    }
    			
   
    public PegaMarketIntrctnHistry login(String uid,String pwd)
    {
    	username.sendKeys(uid);
    	password.sendKeys(pwd);
    	loginbtm.click();
    	driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
    	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    	return new PegaMarketIntrctnHistry();
    }
  
	public PegaMarketIntrctnHistry Pegamrklunch3() throws InterruptedException {
		
	 //    Actions  action = new Actions(driver);
	  //   action.moveToElement(Pegalunch).click().build().perform();
	   //  action.moveToElement(Pegalunch).doubleClick().build().perform();
    	
		wait.until(ExpectedConditions.visibilityOf( Pegalunch));  
		wait.until(ExpectedConditions.elementToBeClickable( Pegalunch));
    	 Thread.sleep(8000);
	 	 			{
				WebElement element9 = Pegalunch;
				JavascriptExecutor executor3 = (JavascriptExecutor)driver;
				executor3.executeScript("arguments[0].click();", element9);
					}
					 
		Thread.sleep(5000);
     
    	// System.out.println("Entered the PegaMarket");
	   	  return new PegaMarketIntrctnHistry();
	   	  
	  
	   }
    
}
