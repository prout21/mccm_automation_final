package Mccm.Pega.DMP.RealTime;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
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
import org.testng.Assert;

import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.QAUtil.TestUtil;
import Mccm.Pega.excel.utility.Excel_Reader;

public class PegaMarktDMPRealTime extends TestBase  {


	public static String ExcelFilePath;

	@FindBy(xpath="//a[@id='appview-nav-toggle-one']")
	WebElement Homepage;

	@FindBy(xpath="(//i[@class='pi pi-caret-down'])[2]")
	WebElement Pegalunch;


	@FindBy(xpath="(//span[@class='menu-item-title'])[5]")
	WebElement pegamrkting1;
	@FindBy(xpath="//a[@id='appview-nav-toggle-one']")
	WebElement ExpandPegMrkPage;

	@FindBy(xpath="//span[text()='Campaigns']")
	WebElement Campaigns;

	@FindBy(xpath="//*[@class='pi pi-caret-down']")
	WebElement Create;

	@FindBy(xpath="//span[text()='Multi-Channel Campaign']")
	WebElement MultiChannelCampaign;

	@FindBy(xpath="//input[@type='text'][@name='$PpyWorkPage$ppyLabel']")
	WebElement Campaigncode;

	@FindBy(xpath="//span[text()='Build']")
	WebElement Build;

	@FindBy(css="button[name='ContainerWithHeader_pyWorkPage.ProgramConfiguration.StrategyContainer_7']")
	WebElement MrktStrtgyConfig;

	@FindBy(xpath="//input[contains(@name,'pFilterCriteriaDisplay$ppyValue')]")
	WebElement SrchMrkStrtgy;

	@FindBy(xpath="//*[contains(@class,'pi-search')]")
	WebElement ClkSrchMrkStrtgy;

	@FindBy(xpath="(//div[contains(@data-repeat-source,'MultiSelectCardSelector')]//button[text()='Add'])[1]")
	WebElement AddMrkStrtgy;

	@FindBy(xpath="//button[text()='Apply']")
	WebElement Applay;

	@FindBy(xpath="//div[text()='Engagement']")
	WebElement webelement2;


	@FindBy(css="button[name='EngagementContainer_pyWorkPage_7']")
	WebElement Engagementconfig;


	@FindBy(xpath="//input[@type='checkbox'][@name='$PpyWorkPage$pEnableContainers']")
	WebElement Realtimecontainers;


	@FindBy(xpath="//img[@name='CalendarImg-8e50e8cd']")
	WebElement Calender;

	@FindBy(xpath="//a[text()='Today']")
	WebElement Currentdate;

	@FindBy(xpath="//text()[.='Configure containers']/ancestor::button[1]")
	WebElement ConfigureContainers;

	@FindBy(xpath="//input[@type='text'][@name='$PRealtimeContainerMultiPg$pFilterCriteriaDisplay$ppyValue']")
	WebElement SrchConfigEngagment;

	@FindBy(xpath="//*[@name='WideDetailsSelectorPanel_RealtimeContainerMultiPg_53']")
	WebElement ClkConfigEngagment;

	@FindBy(xpath="(//div[contains(@data-repeat-source,'RealtimeContainerMultiPg')]//button[text()='Add'])[1]")
	WebElement AddConfigureContainers;

	@FindBy(xpath="//button[text()='Add containers']")
	WebElement AddContainers;


	@FindBy(xpath="//button[text()='Apply']")   
	WebElement ApplayEngagement;

	//@FindBy(xpath="//button[text()='Save']")
	//	@FindBy(xpath="button[name='MKTNewCaseHeader_pyWorkPage_2']")
 	@FindBy(xpath="/html[1]/body[1]/div[3]/form[1]/div[3]/header[1]/div[1]/div[1]/div[1]/div[1]/div[2]/span[1]/button[1]")
	WebElement SaveCampgn;

	@FindBy(xpath="//button[text()='Run']")
	WebElement RunCampgn;

	@FindBy(xpath="//button[text()='Confirm']")
	WebElement ConfirmCampgn;

	@FindBy(xpath="//*[@class='pi pi-refresh']")
	WebElement RefreshCampgn;

	@FindBy(xpath="//h2[text()='Run schedule']")
	WebElement Runschedule;

	@FindBy(xpath="(//span[@class='menu-item-icon-imageclass pi pi-megaphone'])[1]")
	WebElement CampaignImage;



	Excel_Reader obj= new Excel_Reader(ExcelFilePath+"/UseCaseConfigFile/TestData/PegaTestData.xlsx");

	String DMPCampaigncd = obj.getCellValue("PegaTestDataDMP", 1, 0);

	String ConfigMrkStrtgy = obj.getCellValue("PegaTestDataDMP", 1, 1);

	String DMPRealtimecontainers = obj.getCellValue("PegaTestDataDMP", 1, 2);



	public PegaMarktDMPRealTime( ) {
		PageFactory.initElements(driver, this);
	}

	public PegaMarktDMPRealTime Pegamrklunch()throws InterruptedException {

		Actions  action = new Actions(driver);
		action.moveToElement(Pegalunch).click().build().perform();
		return new PegaMarktDMPRealTime();
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
		
		//	pegamrkting1.click( );
		System.out.println("element click pegamrkting1");
	}


	@SuppressWarnings("deprecation")
	public void ExpandPegMrkPage() throws InterruptedException
	{

		//	ExpandPegMrkPage.click( );

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(250,  TimeUnit.MILLISECONDS);
		wait.withTimeout(2, TimeUnit.MINUTES);
		wait.ignoring(NoSuchElementException.class);  

		WebElement element = wait.until(new Function<WebDriver, WebElement>()

		{
			public WebElement apply(WebDriver driver) {
				//	 System.out.println("Checking for the element!!");
				WebElement element = ExpandPegMrkPage;
				if(element != null)
				{
					System.out.println("Target element found");
				}
				return element;
			}
		});

		element.click();


	}

	public void ExpandPegMrkPage1() throws InterruptedException
	{

		boolean searchIconPresence = ExpandPegMrkPage.isDisplayed();
		boolean searchIconEnabled =  ExpandPegMrkPage.isEnabled();

		if (searchIconPresence==true && searchIconEnabled==true)

		{
			WebElement element20 = ExpandPegMrkPage;
			JavascriptExecutor executor14 = (JavascriptExecutor)driver;
			executor14.executeScript("arguments[0].click();", element20);

		}

	}


	public void Campaigns() throws InterruptedException
	{
		//wait.until(ExpectedConditions.visibilityOf(Campaigns));
		 
		Campaigns.click( );
		Thread.sleep(8000); 
		 
	}


	public void CampaignImage() throws InterruptedException
	{

	//	wait.until(ExpectedConditions.visibilityOf(CampaignImage));
		CampaignImage.click( );
		 
	}

	public void Create() throws InterruptedException
	{
	//	wait.until(ExpectedConditions.visibilityOf(Create));
		Create.click( );
		 
	}
	public void MultiChannelCampaign() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(MultiChannelCampaign));
		MultiChannelCampaign.click( );
		Thread.sleep(8000); 
		Thread.sleep(8000);
		 driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
	//	driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		System.out.println("Selected MultiChannel Campaign ");
	}
 
	@SuppressWarnings("deprecation")
	public void Campaigncode() throws InterruptedException
	{
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(250,  TimeUnit.MILLISECONDS);
		 
		wait.withTimeout(4, TimeUnit.MINUTES);
		wait.ignoring(NoSuchElementException.class);  

		WebElement element = wait.until(new Function<WebDriver, WebElement>()

		{
			public WebElement apply(WebDriver driver) {
				 
				WebElement element = Campaigncode;
				if(element != null)
				{
					 
				}
				return element;
			}
		});
	//	Thread.sleep(8000); 
	//	Campaigncode.sendKeys(DMPCampaigncd);
		
	 	element.sendKeys(DMPCampaigncd);
		 System.out.println("Entered the DMP Campaigncd");
		 Thread.sleep(8000); 
		//		wait.until(ExpectedConditions.visibilityOf(Campaigncode));
		//		Campaigncode.sendKeys(DMPCampaigncd);

	}
	public void Build() throws InterruptedException
	{
		//wait.until(ExpectedConditions.visibilityOf(Build));
		Thread.sleep(8000); 
		Build.click( );

	}
	public void MrktStrtgyConfig() throws InterruptedException
	{
		//	wait.until(ExpectedConditions.visibilityOf(MrktStrtgyConfig)); 
		Thread.sleep(3000); 
		MrktStrtgyConfig.click( );

	}
	public void SrchMrkStrtgy() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(SrchMrkStrtgy));
		SrchMrkStrtgy.sendKeys(ConfigMrkStrtgy);
		Thread.sleep(4000);
		//	wait.until(ExpectedConditions.visibilityOf(ClkSrchMrkStrtgy));
		ClkSrchMrkStrtgy.click();

	}

	public void AddMrkStrtgy() throws InterruptedException
	{
		//  wait.until(ExpectedConditions.visibilityOf(AddMrkStrtgy));
		Thread.sleep(4000);
		//AddMrkStrtgy.click( );
		try {

			AddMrkStrtgy.click();
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{

			AddMrkStrtgy.click();
		}
	}
	public void Applay() throws InterruptedException
	{
		//	wait.until(ExpectedConditions.visibilityOf(Applay)); 
		Thread.sleep(6000);
		Applay.click( );
		Thread.sleep(6000);
	}    

	public void javaexictor2() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(webelement2)); 
		TestUtil obj=new TestUtil();
		obj.JavascriptExecutor(webelement2);
	}

	public void Engagementconfig() throws InterruptedException
	{
		Thread.sleep(3000);
		//	wait.until(ExpectedConditions.visibilityOf(Engagementconfig)); 
		Engagementconfig.click( );

	}

	public void Realtimecontainers() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(Realtimecontainers)); 
		Realtimecontainers.click( );

	}

	public void Calender() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(Calender)); 
		Calender.click( );

	}

	public void Currentdate() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(Currentdate)); 
		Currentdate.click( );

	}

	public void ConfigureContainers() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(ConfigureContainers)); 
		ConfigureContainers.click( );

	}

	public void SrchConfigEngagment() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(SrchConfigEngagment)); 
		SrchConfigEngagment.sendKeys(DMPRealtimecontainers);
		Thread.sleep(4000);
		//wait.until(ExpectedConditions.visibilityOf(ClkConfigEngagment)); 
		ClkConfigEngagment.click();

	}
	public void AddConfigureContainers() throws InterruptedException
	{
		//	wait.until(ExpectedConditions.visibilityOf(AddConfigureContainers)); 
		Thread.sleep(4000);
		//AddMrkStrtgy.click( );
		try {

			AddConfigureContainers.click();
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{

			AddConfigureContainers.click();
		}

		//	AddConfigureContainers.click( );

	}

	public void Javascriptserch() throws InterruptedException
	{

		boolean searchIconPresence = AddContainers.isDisplayed();
		boolean searchIconEnabled =  AddContainers.isEnabled();

		if (searchIconPresence==true && searchIconEnabled==true)

		{
			WebElement element9 = AddContainers;
			JavascriptExecutor executor3 = (JavascriptExecutor)driver;
			executor3.executeScript("arguments[0].click();", element9);
			
			Thread.sleep(8000);
			System.out.println("AddContainers element clicked");
		}
	}

 
	public void ApplayEngagement() throws InterruptedException
	{
		//wait.until(ExpectedConditions.visibilityOf(ApplayEngagement));
		//	wait.until(ExpectedConditions.elementToBeClickable(ApplayEngagement)); 
		//	wait.until(ExpectedConditions.presenceOfElementLocated((By) ApplayEngagement));
		  Thread.sleep(8000);
	      ApplayEngagement.click( );

//		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
//		wait.pollingEvery(250,  TimeUnit.MILLISECONDS);
//		wait.withTimeout(2, TimeUnit.MINUTES);
//		wait.ignoring(NoSuchElementException.class);  
//
//		WebElement element = wait.until(new Function<WebDriver, WebElement>()
//
//		{
//			public WebElement apply(WebDriver driver) {
//				//	 System.out.println("Checking for the element!!");
//				WebElement element = ApplayEngagement;
//				if(element != null)
//				{
//					//	 System.out.println("Applay Target element found");
//				}
//				return element;
//			}
//		});
//
//		element.click();

 		Thread.sleep(8000); 
 		System.out.println("Applay element clicked");
//	 	ApplayEngagement.click( );
//		Thread.sleep(8000); 

	}



	public void SaveCampgn() throws InterruptedException
	{
	//	wait.until(ExpectedConditions.elementToBeClickable(SaveCampgn));
		 
	 	wait.until(ExpectedConditions.visibilityOf(SaveCampgn));
     	Thread.sleep(6000);
	//	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		SaveCampgn.click( );

		Thread.sleep(8000);
		System.out.println("Save element clicked");
//		WebElement ele = SaveCampgn;
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		jse.executeScript("arguments[0].click()", ele);
	//	Assert.assertTrue(ExpectedConditions.titleContains("Save").apply(driver).booleanValue());
	//	Assert.assertTrue(ExpectedConditions.elementToBeClickable(SaveCampgn).apply(driver).isDisplayed());
 	//	SaveCampgn.click( );
 
		
	}

	public void RunCampgn() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(RunCampgn));
		RunCampgn.click( );
		System.out.println("RunCampgn element clicked");
	}


	public void ConfirmCampgn() throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(ConfirmCampgn));
		ConfirmCampgn.click( );

	}
	public void RefreshCampgn() throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(RefreshCampgn));
		RefreshCampgn.click( );

	}

}



