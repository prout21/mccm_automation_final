package Mccm.Pega.Calc.NBA.StartOffer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Mccm.Pega.Calc.NBA.StartOffer.PegaTest.PegaPreChkValidCalcNBACampCdTest;
import Mccm.Pega.Outbound.PegaTestBase.TestBase;

public class LoginPageCalcNBAandStartOff extends TestBase {
	//page factory - OR:
	
	@FindBy(xpath="//input[@id='txtUserID']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='txtPassword']")
	WebElement password;
	
	@FindBy(xpath="//span[@class='loginButtonText']")
	WebElement loginbtm;
	
	@FindBy(xpath="//a[@id='appview-nav-toggle-one']")
	WebElement Homepage;
//	@FindBy(xpath="(//i[@class='pi pi-caret-down'])[2]")
	@FindBy(xpath="//a[@title='Launch web interface']")
	WebElement Pegalunch;

  
	 
    public LoginPageCalcNBAandStartOff()
    {
    	PageFactory.initElements(driver, this);
    }
       
    public PegaMarktCalcNBAandStartOff login(String uid,String pwd)
    {
    	username.sendKeys(uid);
    	password.sendKeys(pwd);
    	loginbtm.click();
    	return new PegaMarktCalcNBAandStartOff();    	
    	    }
    
   
    public PegaMarktCalcNBAandStartOff Pegamrklunch3()throws InterruptedException {
		
//	     Actions  action = new Actions(driver);
//	     action.moveToElement(Pegalunch).click().build().perform();
    	 Thread.sleep(6000);
	     Pegalunch.click();
	     Thread.sleep(6000);
	   	  return new PegaMarktCalcNBAandStartOff();
	   }
    
    public PegaPreChkValidCalcNBACampCd Pegamrklunch5()throws InterruptedException {
		
	     Actions  action = new Actions(driver);
	     action.moveToElement(Pegalunch).click().build().perform();
	     Thread.sleep(6000);
	   	  return new PegaPreChkValidCalcNBACampCd();
	   }
}
