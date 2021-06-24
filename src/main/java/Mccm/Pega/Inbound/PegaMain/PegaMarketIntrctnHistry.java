package Mccm.Pega.Inbound.PegaMain;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
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
import org.testng.Assert;

import Mccm.Pega.OSF.PegaTest.OSFAPICallCaptResponseTest;
import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.QAUtil.TestUtil;
import Mccm.Pega.excel.utility.Excel_Reader;

// import org.apache.logging.log4j.LogManager;
// import org.apache.logging.log4j.Logger;
 
 import org.apache.log4j.Logger;

public class PegaMarketIntrctnHistry extends TestBase  {
	
	public static String NBACalSubjectID;

	
	Logger log = Logger.getLogger(PegaMarketIntrctnHistry.class.getName());

	@FindBy(xpath="//a[@id='appview-nav-toggle-one']")
	WebElement Homepage;

	//@FindBy(xpath="(//i[@class='pi pi-caret-down'])[2]")
		@FindBy(xpath="//a[@title='Launch web interface']")
    	WebElement Pegalunch;
	
	
 

	@FindBy(xpath="(//span[@class='menu-item-title'])[5]")
	WebElement pegamrkting1;
	@FindBy(xpath="//a[@id='appview-nav-toggle-one']")
	WebElement ExpandPegMrkPage;

	@FindBy(xpath="//i[@class='icons pi pi-clipboard-check pi-white']")
	WebElement ClkReport;

	@FindBy(xpath="//span[text()='Interaction History']")
	WebElement ClkIntractionHstry;

	@FindBy(xpath="//span[text()='Recent interactions']")
	WebElement ClkRecentIntrctnHstry;

	@FindBy(xpath="//div[text()='Journey']")
	WebElement Journey ;

	@FindBy(xpath="/html[1]/body[1]/div[2]/form[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/span[1]/div[1]/span[1]/div[1]/span[2]/div[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[2]/td[12]")
	WebElement Channel ;

	//	@FindBy(xpath="/html[1]/body[1]/div[2]/form[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/span[1]/div[1]/span[1]/div[1]/span[2]/div[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[2]/td[12]/div[1]/span[1]")
	//	WebElement Channel ;

	@FindBy(xpath="/html[1]/body[1]/div[2]/form[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/span[1]/div[1]/span[1]/div[1]/span[2]/div[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[2]/td[6]/div[1]/span[1]")
	WebElement BusinessIssue ;


	@FindBy(xpath="/html[1]/body[1]/div[2]/form[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/span[1]/div[1]/span[1]/div[1]/span[2]/div[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[2]/td[7]/div[1]/span[1]")
	WebElement Group ;

	@FindBy(xpath="/html[1]/body[1]/div[2]/form[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/span[1]/div[1]/span[1]/div[1]/span[2]/div[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[2]/td[8]/div[1]/span[1]")
	WebElement Proposition ;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/form[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/span[1]/div[1]/span[1]/div[1]/span[2]/div[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[2]/td[9]/div[1]/span[1]")
	WebElement Outcome;

	@FindBy(xpath="/html[1]/body[1]/div[2]/form[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/span[1]/div[1]/span[1]/div[1]/span[2]/div[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[2]/td[3]/div[1]/span[1]")
    WebElement SubjectID;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/form[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/span[1]/div[1]/span[1]/div[1]/span[2]/div[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[2]/td[11]/div[1]/span[1]")
    WebElement Direction;
	
	

	public PegaMarketIntrctnHistry( ) {
		PageFactory.initElements(driver, this);
	}

	public PegaMarketIntrctnHistry Pegamrklunch()throws InterruptedException {

		Actions  action = new Actions(driver);
		action.moveToElement(Pegalunch).click().build().perform();
		Thread.sleep(3000);
		return new PegaMarketIntrctnHistry();
		 
	}

	public void pegamarkting() throws InterruptedException
	{
		Thread.sleep(8000);
	 	 
			{
				WebElement element9 = pegamrkting1;
				JavascriptExecutor executor3 = (JavascriptExecutor)driver;
				executor3.executeScript("arguments[0].click();", element9);
					}
					 
		Thread.sleep(8000);
		//	wait.until(ExpectedConditions.elementToBeClickable(pegamrkting1));
	//	pegamrkting1.click( );
	//	Thread.sleep(8000);
	 	log.info("****OSF element click pegamrkting1 ****");
 	//	 driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		System.out.println("element click pegamrkting1");
	}


	public void ExpandReport() throws InterruptedException
	{
	//	wait.until(ExpectedConditions.elementToBeClickable(ClkReport));
		Thread.sleep(8000);
		ClkReport.click( );
		Thread.sleep(8000);
 	log.info("**** OSF element click ClkReport****");
		System.out.println(" element click ClkReport");
	}
	public void ClkIntractionHstry() throws InterruptedException
	{
		//wait.until(ExpectedConditions.visibilityOf(ClkIntractionHstry));
		Thread.sleep(8000);
		ClkIntractionHstry.click( );
		Thread.sleep(8000);
	 	log.info("**** OSF element click ClkIntractionHstry****");
		System.out.println("element click ClkIntractionHstry");
	}
	public void ClkRecentIntrctnHstry() throws InterruptedException
	{
	//	wait.until(ExpectedConditions.visibilityOf(ClkRecentIntrctnHstry));
		Thread.sleep(8000);
		ClkRecentIntrctnHstry.click( );
		Thread.sleep(8000);
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	 	log.info("**** OSF element click ClkRecentIntrctnHstry ****");
		System.out.println(" element click ClkRecentIntrctnHstry");
	}
	@SuppressWarnings("deprecation")
	public void InboundValidation() throws InterruptedException
	{
//		Thread.sleep(8000);
//		driver.manage().window().maximize();
		 driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(Journey));
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		//	 WebElement element6 = driver.findElement(By.xpath("//div[text()='Journey']"));
		WebElement element6 = Journey;
		js5.executeScript("arguments[0].scrollIntoView();", element6);	
		 
		String getTextOnPage1 = "";

	//	wait.until(ExpectedConditions.visibilityOf(Channel));
		Thread.sleep(8000);
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		 wait.pollingEvery(250,  TimeUnit.MILLISECONDS);
		   wait.withTimeout(4, TimeUnit.MINUTES);
		 wait.ignoring(NoSuchElementException.class);  
		  WebElement element1 = wait.until(new Function<WebDriver, WebElement>()  
		 {
		 public WebElement apply(WebDriver driver) {
	 	 WebElement element1 = Channel;
		 if(element1 != null)
		 {
			 System.out.println("Display the Outcome value for inbound  Channel");
		 			 }
		 return element1;
		 }
		 });
		 
		  element1 = Channel;
		Thread.sleep(8000);
		getTextOnPage1 = element1.getText();
		System.out.println(getTextOnPage1);
		Thread.sleep(8000);
		boolean result = getTextOnPage1.equals("O") ||
				getTextOnPage1.equals("J") ||
				getTextOnPage1.equals("C") ||
				getTextOnPage1.equals("B");
		assertTrue(result);
		System.out.println("Selected value inbound from channel");
	}
	@SuppressWarnings("deprecation")
	public void DMPRealTimeVlidtion() throws InterruptedException
	{
//		Thread.sleep(8000);
//		driver.manage().window().maximize();
		 driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		WebElement element6 = driver.findElement(By.xpath("//div[text()='Journey']"));
		js5.executeScript("arguments[0].scrollIntoView();", element6);	
		 

		String getTextOnPage1 = "";


	//	wait.until(ExpectedConditions.visibilityOf(Channel));
		Thread.sleep(8000);
	//	WebElement element11 = Channel;
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		 wait.pollingEvery(250,  TimeUnit.MILLISECONDS);
		   wait.withTimeout(4, TimeUnit.MINUTES);
		 wait.ignoring(NoSuchElementException.class);  
		  WebElement element1 = wait.until(new Function<WebDriver, WebElement>()  
		 {
		 public WebElement apply(WebDriver driver) {
	 	 WebElement element1 = Channel;
		 if(element1 != null)
		 {
			 System.out.println("Display the Outcome value for Channel");
		 			 }
		 return element1;
		 }
		 });
		 
		  element1 = Channel;
		Thread.sleep(8000);
		getTextOnPage1 = element1.getText();
		System.out.println(getTextOnPage1);
		Thread.sleep(8000);
		boolean result = getTextOnPage1.equals("DMP")|| 
				getTextOnPage1.equals("Online"); 
		assertTrue(result);
		System.out.println("Selected value from Channel DMP Real Time");
	}
	@SuppressWarnings("deprecation")
	public void PegaCalcNBAandStartOffAPIVlidtion() throws InterruptedException
	{
		//Thread.sleep(8000);
	//	driver.manage().window().maximize();
		 driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		WebElement element6 = driver.findElement(By.xpath("//div[text()='Journey']"));
		js5.executeScript("arguments[0].scrollIntoView();", element6);	
		

		String getTextOnPage1 = "",getTextOnPage2="",getTextOnPage3="";


	//	wait.until(ExpectedConditions.visibilityOf(BusinessIssue));
		Thread.sleep(8000);
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		 wait.pollingEvery(250,  TimeUnit.MILLISECONDS);
		   wait.withTimeout(4, TimeUnit.MINUTES);
		 wait.ignoring(NoSuchElementException.class);  
		  WebElement element12 = wait.until(new Function<WebDriver, WebElement>()  
		 {
		 public WebElement apply(WebDriver driver) {
	 	 WebElement element12 = SubjectID;
		 if(element12 != null)
		 {
			 System.out.println("Display the Outcome value for subbjct id");
		 			 }
		 return element12;
		 }
		 });
		 
		  element12 =SubjectID;
		
	//	WebElement element12 =SubjectID;
		Thread.sleep(8000);
		// 	 wait.until(ExpectedConditions.visibilityOf(Group));
		FluentWait<WebDriver> wait1 = new FluentWait<WebDriver>(driver);
		 wait.pollingEvery(250,  TimeUnit.MILLISECONDS);
		   wait.withTimeout(4, TimeUnit.MINUTES);
		 wait.ignoring(NoSuchElementException.class);  
		  WebElement element13 = wait1.until(new Function<WebDriver, WebElement>()  
		 {
		 public WebElement apply(WebDriver driver) {
	 	 WebElement element13 = Direction;
		 if(element13 != null)
		 {
			 System.out.println("Display the Outcome value for Direction");
		 			 }
		 return element13;
		 }
		 });
		 
		  element13 = Direction;
		//WebElement element13 = Direction;
		Thread.sleep(8000);
		//  	 wait.until(ExpectedConditions.visibilityOf(Proposition));
		FluentWait<WebDriver> wait2 = new FluentWait<WebDriver>(driver);
		 wait.pollingEvery(250,  TimeUnit.MILLISECONDS);
		   wait.withTimeout(4, TimeUnit.MINUTES);
		 wait.ignoring(NoSuchElementException.class);  
		  WebElement element14 = wait2.until(new Function<WebDriver, WebElement>()  
		 {
		 public WebElement apply(WebDriver driver) {
	 	 WebElement element14 =  Channel;
		 if(element14 != null)
		 {
			 System.out.println("Display the Outcome value for Channel");
		 			 }
		 return element14;
		 }
		 });
		 
		  element14 =  Channel;
		  
	//	WebElement element14 = Channel;
		Thread.sleep(8000);
		
		NBACalSubjectID = general_ReadProperty("NBACalSubjectID");
		System.out.println("Subject Id is "+ NBACalSubjectID);
		Thread.sleep(2000);
		getTextOnPage1 = element12.getText();
		Thread.sleep(2000);
		System.out.println(getTextOnPage1);
		getTextOnPage2 = element13.getText();
		System.out.println(getTextOnPage2);
		Thread.sleep(2000);
		getTextOnPage3 = element14.getText();
		System.out.println(getTextOnPage3);
		Thread.sleep(2000);
		boolean result = getTextOnPage1.equals(NBACalSubjectID) && getTextOnPage2.equals("Inbound")&&
				getTextOnPage3.equals("OSF"); 
		assertTrue(result);
		System.out.println("MCCM Calc NBAandStart Offer Use Cases Passed");
	}
	@SuppressWarnings("deprecation")
	public void PegaOSFOutcomeAPIAcceptedVlidtion() throws InterruptedException
	{
//		Thread.sleep(8000);		
//		driver.manage().window().maximize();
		 driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		WebElement element6 = driver.findElement(By.xpath("//div[text()='Journey']"));
		js5.executeScript("arguments[0].scrollIntoView();", element6);	
		//Thread.sleep(8000);
	 	log.info("****  OSF webelement view accepted Journey ****");
		System.out.println("  OSF webelement view accepted Journey");
		String getTextOnPage1 = "";


	//	wait.until(ExpectedConditions.visibilityOf(Outcome));
		Thread.sleep(8000);
	//	WebElement element1 = Outcome;
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		 wait.pollingEvery(250,  TimeUnit.MILLISECONDS);
		   wait.withTimeout(4, TimeUnit.MINUTES);
		 wait.ignoring(NoSuchElementException.class);  
		  WebElement element = wait.until(new Function<WebDriver, WebElement>()  
		 {
		 public WebElement apply(WebDriver driver) {
	 	 WebElement element = Outcome;
		 if(element != null)
		 {
			 System.out.println("Display the Outcome value for accepted");
		 			 }
		 return element;
		 }
		 });
		 
		  element = Outcome;
	 	log.info("****  OSF webelement click outcome accepted****");
		System.out.println(" OSF webelement click outcome accepted");
		Thread.sleep(8000);
	//	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		getTextOnPage1 = element.getText();
		System.out.println(getTextOnPage1);
	 	log.info("**** Outcome value : " +getTextOnPage1);
		System.out.println(" Outcome value");
	 

		Thread.sleep(8000);
		boolean result = getTextOnPage1.equals("Accepted") ; 

		assertTrue(result);
		//System.out.println("MCCM OSF Outcome API Accepted Validation Done");
		
 		log.info("**** OSF display Accepted ****");
		System.out.println(" OSF display Accepted");
	}
	@SuppressWarnings("deprecation")
	public void PegaOSFOutcomeAPISaveOfferVlidtion() throws InterruptedException
	{
//		Thread.sleep(8000);
//		driver.manage().window().maximize();
		 driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		WebElement element6 = driver.findElement(By.xpath("//div[text()='Journey']"));
		js5.executeScript("arguments[0].scrollIntoView();", element6);	
		//Thread.sleep(8000);
	 	log.info("****  OSF webelement view Journey save offer****");
		System.out.println(" OSF webelement view Journey save offer");
		String getTextOnPage1 = "";


	//	wait.until(ExpectedConditions.visibilityOf(Outcome));
		Thread.sleep(8000);
	//	WebElement element1 = Outcome;
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		 wait.pollingEvery(250,  TimeUnit.MILLISECONDS);
		   wait.withTimeout(4, TimeUnit.MINUTES);
		 wait.ignoring(NoSuchElementException.class);  
		  WebElement element = wait.until(new Function<WebDriver, WebElement>()  
		 {
		 public WebElement apply(WebDriver driver) {
	 	 WebElement element = Outcome;
		 if(element != null)
		 {
			 System.out.println("Display the Outcome value for save offer");
		 			 }
		 return element;
		 }
		 });
		 
		  element = Outcome;
		 
		Thread.sleep(8000);
	 	log.info("****  OSF webelement outcome click save offer ****");
		System.out.println(" OSF webelement outcome click save offer");
	//	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		getTextOnPage1 = element.getText();
		System.out.println(getTextOnPage1);
	 	log.info("**** Outcome value : " +getTextOnPage1);
	 	log.info("****  OSF webelement outcome save offer ****");
		System.out.println(" OSF webelement outcome save offer");

		Thread.sleep(8000);
		boolean result = getTextOnPage1.equals("SaveOffer") ; 

		assertTrue(result);
 		log.info("**** OSF display save offer ****");
		System.out.println(" OSF display save offer");
	}
	@SuppressWarnings("deprecation")
	public void PegaOSFOutcomeAPISubmitOrderVlidtion() throws InterruptedException
	{
//		Thread.sleep(8000);
//		driver.manage().window().maximize();
		 driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		WebElement element6 = driver.findElement(By.xpath("//div[text()='Journey']"));
		js5.executeScript("arguments[0].scrollIntoView();", element6);	
 		log.info("****  OSF webelement view Journey submitted order****");
		System.out.println(" OSF webelement view Journey submitted order");

		String getTextOnPage1 = "";


	//	wait.until(ExpectedConditions.visibilityOf(Outcome));
		Thread.sleep(8000);
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		 wait.pollingEvery(250,  TimeUnit.MILLISECONDS);
		   wait.withTimeout(4, TimeUnit.MINUTES);
		 wait.ignoring(NoSuchElementException.class);  
		  WebElement element = wait.until(new Function<WebDriver, WebElement>()  
		 {
		 public WebElement apply(WebDriver driver) {
	 	 WebElement element = Outcome;
		 if(element != null)
		 {
			 System.out.println("Display the Outcome value for submitted order");
		 			 }
		 return element;
		 }
		 });
		 
		  element = Outcome;
	//	WebElement element1 = Outcome;
 		log.info("****  OSF webelement outcome click submitted order ****");
		System.out.println(" OSF webelement outcome click submitted order");
		Thread.sleep(8000);
	//	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		getTextOnPage1 = element.getText();
		System.out.println(getTextOnPage1);

		Thread.sleep(8000);
 		log.info("**** Outcome value : " +getTextOnPage1);
 		log.info("****  OSF webelement outcome submitted order ****");
		System.out.println(" OSF webelement outcome submitted order");
		boolean result = getTextOnPage1.equals("SubmitOrder") ; 

		assertTrue(result);
	 	log.info("**** OSF display Submitted order ****");
		System.out.println(" OSF display Submitted order");
	}
	
	@SuppressWarnings("deprecation")
	public void PegaOSFGETNBAAPIVlidtion() throws InterruptedException {
//		Thread.sleep(8000);
//		driver.manage().window().maximize();
		 driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		WebElement element6 = driver.findElement(By.xpath("//div[text()='Journey']"));
		js5.executeScript("arguments[0].scrollIntoView();", element6);	
		//Thread.sleep(8000);
	 	log.info("****  OSF webelement view Journey new****");
		System.out.println(" OSF webelement view Journey new");
		String getTextOnPage1 = "";

	 	Thread.sleep(8000);
		// wait.until(ExpectedConditions.visibilityOf(Outcome));
	 	 
		 	FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
			 wait.pollingEvery(250,  TimeUnit.MILLISECONDS);
			   wait.withTimeout(4, TimeUnit.MINUTES);
			 wait.ignoring(NoSuchElementException.class);  
			  WebElement element = wait.until(new Function<WebDriver, WebElement>()  
			 {
			 public WebElement apply(WebDriver driver) {
		 	 WebElement element = Outcome;
			 if(element != null)
			 {
				 System.out.println("Display the Outcome value for new");
			 			 }
			 return element;
			 }
			 });
			 
			  element = Outcome;
		 
			
		 
	//	WebElement element1 = Outcome;
 		Thread.sleep(8000);
	 	log.info("****  OSF webelement outcome click new****");
		System.out.println(" OSF webelement outcome click new");
	//	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		getTextOnPage1 = element.getText();
		System.out.println(getTextOnPage1);

		Thread.sleep(8000);
	 	log.info("**** Outcome value : " +getTextOnPage1);
	 	log.info("****  OSF webelement outcome new ****");
		System.out.println(" OSF webelement outcome new");
		boolean result = getTextOnPage1.equals("New") ; 

		assertTrue(result);	 
	 	log.info("**** OSF display New ****");
		System.out.println(" OSF display New");
	}

}	 