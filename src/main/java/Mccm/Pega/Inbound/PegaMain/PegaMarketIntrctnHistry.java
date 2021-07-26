package Mccm.Pega.Inbound.PegaMain;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import Mccm.Pega.OSF.PegaTest.CaptureResponseTest;
import Mccm.Pega.Outbound.PegaTestBase.TestBase;


public class PegaMarketIntrctnHistry extends TestBase  {
	
	public static String NBACalSubjectID;

	public static Logger log = LogManager.getLogger(PegaMarketIntrctnHistry.class.getName());
	

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
	
	//New WebElements defined--OSF
	
	@FindBy(xpath="//tr[@class='oddRow cellCont']")
	List<WebElement> oddrows;
	
	@FindBy(xpath="//tr[@class='evenRow cellCont']")
	List<WebElement> evenrows;
	
	@FindBy(xpath="//tr[@class='oddRow cellCont']/td[@data-attribute-name='Outcome time']")
	List<WebElement> Outcome_times;
	
	@FindBy(xpath="//tr[@class='evenRow cellCont']/td[@data-attribute-name='Outcome time']")
	List<WebElement> Outcome_times1;
	
	@FindBy(xpath="//tr[@class='oddRow cellCont']/td[@data-attribute-name='Fact ID']")
	List<WebElement> Fact;
	
	@FindBy(xpath="//tr[@class='oddRow cellCont']/td[@data-attribute-name='Subject ID']")
	List<WebElement> subject;
	
	@FindBy(xpath="//tr[@class='oddRow cellCont']/td[@data-attribute-name='Business issue']")
	List<WebElement> Business;
	
	@FindBy(xpath="//tr[@class='oddRow cellCont']/td[@data-attribute-name='Group']")
	List<WebElement> GroupValue;
	
	@FindBy(xpath="//tr[@class='oddRow cellCont']/td[@data-attribute-name='Outcome']")
	List<WebElement> OutcomeValue;
	
	@FindBy(xpath="//tr[@class='oddRow cellCont']/td[@data-attribute-name='Direction']")
	List<WebElement> Direction1;
	
	@FindBy(xpath="//tr[@class='oddRow cellCont']/td[@data-attribute-name='Channel']")
	List<WebElement> Channel1;
	
	@FindBy(xpath="//tr[@class='evenRow cellCont']/td[@data-attribute-name='Fact ID']")
	List<WebElement> Fact1;
	
	@FindBy(xpath="//tr[@class='evenRow cellCont']/td[@data-attribute-name='Subject ID']")
	List<WebElement> Subject1;
	
	@FindBy(xpath="//tr[@class='evenRow cellCont']/td[@data-attribute-name='Business issue']")
	List<WebElement> Business1;
	
	@FindBy(xpath="//tr[@class='evenRow cellCont']/td[@data-attribute-name='Group']")
	List<WebElement> Group1;
	
	@FindBy(xpath="//tr[@class='evenRow cellCont']/td[@data-attribute-name='Outcome']")
	List<WebElement> OutcomeValue1;
	
	@FindBy(xpath="//tr[@class='evenRow cellCont']/td[@data-attribute-name='Direction']")
	List<WebElement> Direction2;
	
	@FindBy(xpath="//tr[@class='evenRow cellCont']/td[@data-attribute-name='Channel']")
	List<WebElement> Channel2;
	
	@FindBy(xpath="//tr[@class='oddRow cellCont']/td[@data-attribute-name='Proposition']")
	List<WebElement> PropositionValue;
	
	@FindBy(xpath="//tr[@class='evenRow cellCont']/td[@data-attribute-name='Proposition']")
	List<WebElement> PropositionValue1;
	
	@FindBy(xpath="//a[@href='#']")
	List<WebElement> pagesize;
	
	public List<WebElement> oddrows()
	{
		
		return oddrows;
		
	}
	

	public List<WebElement> evenrows()
	{
		
		return evenrows;
		
	}

	public List<WebElement> Outcome_times()
	{
		
		return Outcome_times;
		
	}
	public List<WebElement> Fact()
	{
		
		return Fact;
		
	}
	
	public List<WebElement> subject()
	{
		
		return subject;
		
	}
	
	public List<WebElement> Business()
	{
		
		return Business;
		
	}
	
	public List<WebElement> GroupValue()
	{
		
		return GroupValue;
		
	}
	
	public List<WebElement> OutcomeValue()
	{
		
		return OutcomeValue;
		
	}
	
	public List<WebElement> Direction1()
	{
		
		return Direction1;
		
	}
	
	public List<WebElement> Channel1()
	{
		
		return Channel1;
		
	}
	
	
	public List<WebElement> Fact1()
	{
		
		return Fact1;
		
	}
	
	
	public List<WebElement> Subject1()
	{
		
		return Subject1;
		
	}
	
	
	public List<WebElement> Business1()
	{
		
		return Business1;
		
	}
	
	public List<WebElement> Outcome_times1()
	{
		
		return Outcome_times1;
		
	}
	
	public List<WebElement> Group1()
	{
		
		return Group1;
		
	}
	
	public List<WebElement> OutcomeValue1()
	{
		
		return OutcomeValue1;
		
	}
	
	public List<WebElement> Direction2()
	{
		
		return Direction2;
		
	}
	
	public List<WebElement> Channel2()
	{
		
		return Channel2;
		
	}
	
	public List<WebElement> PropositionValue()
	{
		
		return PropositionValue;
		
	}
	
	public List<WebElement> PropositionValue1()
	{
		
		return PropositionValue1;
		
	}
	
	public List<WebElement> pagesize()
	{
		
		return pagesize;
		
	}
	
	public PegaMarketIntrctnHistry() {
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
		Thread.sleep(4000);
	 	 
			{
				WebElement element9 = pegamrkting1;
				JavascriptExecutor executor3 = (JavascriptExecutor)driver;
				executor3.executeScript("arguments[0].click();", element9);
					}
					 
		Thread.sleep(8000);
		//	wait.until(ExpectedConditions.elementToBeClickable(pegamrkting1));
	//	pegamrkting1.click( );
	//	Thread.sleep(8000);
	 //	log.info("****OSF element click pegamrkting1 ****");
 	//	 driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	//	System.out.println("element click pegamrkting1");
	}


	public void ExpandReport() throws InterruptedException
	{
	//	wait.until(ExpectedConditions.elementToBeClickable(ClkReport));
		//Thread.sleep(3000);
		ClkReport.click( );
	//	Thread.sleep(3000);
 	//log.info("**** OSF element click ClkReport****");
	//	System.out.println(" element click ClkReport");
	}
	public void ClkIntractionHstry() throws InterruptedException
	{
		//wait.until(ExpectedConditions.visibilityOf(ClkIntractionHstry));
		//Thread.sleep(8000);
		ClkIntractionHstry.click( );
		//Thread.sleep(3000);
	 //	log.info("**** OSF element click ClkIntractionHstry****");
	//	System.out.println("element click ClkIntractionHstry");
	}
	public void ClkRecentIntrctnHstry() throws InterruptedException
	{
	//	wait.until(ExpectedConditions.visibilityOf(ClkRecentIntrctnHstry));
	//	Thread.sleep(1000);
		ClkRecentIntrctnHstry.click( );
	//	Thread.sleep(2000);
		//driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	 //	log.info("**** OSF element click ClkRecentIntrctnHstry ****");
	//	System.out.println(" element click ClkRecentIntrctnHstry");
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
//		 wait.until(ExpectedConditions.visibilityOf(Journey));
//		JavascriptExecutor js5 = (JavascriptExecutor) driver;
//		WebElement element6 = driver.findElement(By.xpath("//div[text()='Journey']"));
//		js5.executeScript("arguments[0].scrollIntoView();", element6);	
		 

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
//		 wait.until(ExpectedConditions.visibilityOf(Journey));
//		JavascriptExecutor js5 = (JavascriptExecutor) driver;
//		WebElement element6 = driver.findElement(By.xpath("//div[text()='Journey']"));
//		js5.executeScript("arguments[0].scrollIntoView();", element6);	
		

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
	public void PegaOSFAPIValidation() throws InterruptedException
	{

		driver.manage().window().maximize();
		int oddrowcount= oddrows.size();
		int evenrowcount =evenrows.size();
		for(int k=1;k<pagesize.size();k++)
		{
			Thread.sleep(3000);
			if (pagesize.get(k).getText().equals("1"))
			{
				
				log.info("------------");
			}
			else
			{
				pagesize.get(k).click();
				Thread.sleep(4000);
			}
			
			
			
		for(int i=0;i<oddrowcount;i++)
		{
			String outcomeTime= Outcome_times.get(i).getText();
			if (outcomeTime.equals("about a minute ago"))
			{
				log.info("-----Validated API Records in IH-----");
		
			String fact_id= Fact.get(i).getText();
			log.debug("Fact ID is :   " +fact_id);
			String subject_id= subject.get(i).getText();
			log.debug("Customer ID is :   " +subject_id);
			String Outcome_time= Outcome_times.get(i).getText();
			log.debug("Outcome time is :   " +Outcome_time);
			String Business_issue= Business.get(i).getText();
			log.debug("Business issue is :   " +Business_issue);
			String Group= GroupValue.get(i).getText();
			log.debug("Group value is :   " +Group);
			String PropositionValue1= PropositionValue.get(i).getText();
			log.debug("Proposition value is :   " +PropositionValue1);
			String Outcome_value= OutcomeValue.get(i).getText();
			log.debug("Outcome Value is :   " +Outcome_value);
			String Direction= Direction1.get(i).getText();
			log.debug("Direction value is :   " +Direction);
			String Channel= Channel1.get(i).getText();
			log.debug("Channel value is :   " +Channel);
			
			}
				
		}
			for(int j=0;j<evenrowcount;j++)
			{
				String outcomeTime1=Outcome_times1.get(j).getText();
			if(outcomeTime1.equals("about a minute ago"))
			{
				log.info("-----Validated API Records in IH-----");
			    String fact_id= Fact1.get(j).getText();
				log.debug("Fact ID is :   " +fact_id);
				String subject_id= Subject1.get(j).getText();
				log.debug("Customer ID is :   " +subject_id);	
				String Outcome_time= Outcome_times1.get(j).getText();
				log.debug("Outcome time is :   " +Outcome_time);
				String Business_issue= Business1.get(j).getText();
				log.debug("Business issue is :   " +Business_issue);
				String Group= Group1.get(j).getText();
				log.debug("Group value is :   " +Group);
				String PropositionValue2= PropositionValue1.get(j).getText();
				log.debug("Proposition value is :   " +PropositionValue2);
				String Outcome_value= OutcomeValue1.get(j).getText();
				log.debug("Outcome Value is :   " +Outcome_value);
				String Direction= Direction2.get(j).getText();
				log.debug("Direction value is :   " +Direction);
				String Channel= Channel2.get(j).getText();
				log.debug("Channel value is :   " +Channel);
			
			}
			
			}		
			Thread.sleep(3000);
			
		
	}
	}	
	
}