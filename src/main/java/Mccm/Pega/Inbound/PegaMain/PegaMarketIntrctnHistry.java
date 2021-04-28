package Mccm.Pega.Inbound.PegaMain;

import static org.testng.Assert.assertTrue;

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

public class PegaMarketIntrctnHistry extends TestBase  {


	@FindBy(xpath="//a[@id='appview-nav-toggle-one']")
	WebElement Homepage;

	@FindBy(xpath="(//i[@class='pi pi-caret-down'])[2]")
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




	public PegaMarketIntrctnHistry( ) {
		PageFactory.initElements(driver, this);
	}

	public PegaMarketIntrctnHistry Pegamrklunch()throws InterruptedException {

		Actions  action = new Actions(driver);
		action.moveToElement(Pegalunch).click().build().perform();
		Thread.sleep(1000);
		return new PegaMarketIntrctnHistry();
	}

	public void pegamarkting() throws InterruptedException
	{
		Thread.sleep(8000);
		//	wait.until(ExpectedConditions.elementToBeClickable(pegamrkting1));
		pegamrkting1.click( );
		Thread.sleep(8000);
	}


	public void ExpandReport() throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(ClkReport));
		ClkReport.click( );

	}
	public void ClkIntractionHstry() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(ClkIntractionHstry));
		ClkIntractionHstry.click( );

	}
	public void ClkRecentIntrctnHstry() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(ClkRecentIntrctnHstry));
		ClkRecentIntrctnHstry.click( );

	}
	public void InboundValidation() throws InterruptedException
	{
		driver.manage().window().maximize();
		wait.until(ExpectedConditions.visibilityOf(Journey));
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		//	 WebElement element6 = driver.findElement(By.xpath("//div[text()='Journey']"));
		WebElement element6 = Journey;
		js5.executeScript("arguments[0].scrollIntoView();", element6);	
		Thread.sleep(8000);

		String getTextOnPage1 = "";



		//	 String xpath11 = "/html[1]/body[1]/div[2]/form[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/span[1]/div[1]/span[1]/div[1]/span[2]/div[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[2]/td[12]/div[1]/span[1]";
		//	 WebElement element11 =  driver.findElement(By.xpath(xpath11));
		wait.until(ExpectedConditions.visibilityOf(Channel));
		WebElement element11 = Channel;
		Thread.sleep(2000);
		getTextOnPage1 = element11.getText();
		System.out.println(getTextOnPage1);
		Thread.sleep(2000);
		boolean result = getTextOnPage1.equals("O") ||
				getTextOnPage1.equals("J") ||
				getTextOnPage1.equals("C") ||
				getTextOnPage1.equals("B");
		assertTrue(result);
		System.out.println("MCCM Inbound Use Cases Passed");
	}
	public void DMPRealTimeVlidtion() throws InterruptedException
	{
		driver.manage().window().maximize();
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		WebElement element6 = driver.findElement(By.xpath("//div[text()='Journey']"));
		js5.executeScript("arguments[0].scrollIntoView();", element6);	
		Thread.sleep(8000);

		String getTextOnPage1 = "";


		wait.until(ExpectedConditions.visibilityOf(Channel));
		//	 String xpath11 = "/html[1]/body[1]/div[2]/form[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/span[1]/div[1]/span[1]/div[1]/span[2]/div[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[2]/td[12]/div[1]/span[1]";
		WebElement element11 = Channel;
		Thread.sleep(2000);
		getTextOnPage1 = element11.getText();
		System.out.println(getTextOnPage1);
		Thread.sleep(2000); 
		boolean result = getTextOnPage1.equals("DMP")|| 
				getTextOnPage1.equals("Online"); 
		assertTrue(result);
		System.out.println("MCCM DMP Real Time Use Cases Passed");
	}
	public void PegaCalcNBAandStartOffAPIVlidtion() throws InterruptedException
	{
		driver.manage().window().maximize();
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		WebElement element6 = driver.findElement(By.xpath("//div[text()='Journey']"));
		js5.executeScript("arguments[0].scrollIntoView();", element6);	
		Thread.sleep(8000);

		String getTextOnPage1 = "",getTextOnPage2="",getTextOnPage3="";


		wait.until(ExpectedConditions.visibilityOf(BusinessIssue));
		// 	 String xpath11 = "/html[1]/body[1]/div[2]/form[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/span[1]/div[1]/span[1]/div[1]/span[2]/div[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[2]/td[6]/div[1]/span[1]";
		WebElement element12 = BusinessIssue;
		Thread.sleep(2000);
		// 	 wait.until(ExpectedConditions.visibilityOf(Group));
		// 	 String xpath11 = "/html[1]/body[1]/div[2]/form[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/span[1]/div[1]/span[1]/div[1]/span[2]/div[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[2]/td[6]/div[1]/span[1]";
		WebElement element13 = Group;
		Thread.sleep(2000);
		//  	 wait.until(ExpectedConditions.visibilityOf(Proposition));
		// 	 String xpath11 = "/html[1]/body[1]/div[2]/form[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/span[1]/div[1]/span[1]/div[1]/span[2]/div[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[2]/td[6]/div[1]/span[1]";
		WebElement element14 = Proposition;
		Thread.sleep(2000);

		getTextOnPage1 = element12.getText();
		System.out.println(getTextOnPage1);
		getTextOnPage2 = element13.getText();
		System.out.println(getTextOnPage2);
		getTextOnPage3 = element14.getText();
		System.out.println(getTextOnPage3);

		boolean result = getTextOnPage1.equals("Event") && getTextOnPage2.equals("real time")&&
				getTextOnPage3.equals("NBAOF"); 
		assertTrue(result);
		System.out.println("MCCM Calc NBAandStart Offer Use Cases Passed");
	}
	public void PegaOSFOutcomeAPIAcceptedVlidtion() throws InterruptedException
	{
		driver.manage().window().maximize();
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		WebElement element6 = driver.findElement(By.xpath("//div[text()='Journey']"));
		js5.executeScript("arguments[0].scrollIntoView();", element6);	
		Thread.sleep(8000);

		String getTextOnPage1 = "";


		wait.until(ExpectedConditions.visibilityOf(Outcome));
		WebElement element1 = Outcome;
		Thread.sleep(2000);

		getTextOnPage1 = element1.getText();
		System.out.println(getTextOnPage1);

		Thread.sleep(2000);
		boolean result = getTextOnPage1.equals("Accepted") ; 

		assertTrue(result);
		System.out.println("MCCM OSF Outcome API Accepted Validation Done");
	}
	public void PegaOSFOutcomeAPISaveOfferVlidtion() throws InterruptedException
	{
		driver.manage().window().maximize();
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		WebElement element6 = driver.findElement(By.xpath("//div[text()='Journey']"));
		js5.executeScript("arguments[0].scrollIntoView();", element6);	
		Thread.sleep(8000);

		String getTextOnPage1 = "";


		wait.until(ExpectedConditions.visibilityOf(Outcome));
		WebElement element1 = Outcome;
		Thread.sleep(2000);

		getTextOnPage1 = element1.getText();
		System.out.println(getTextOnPage1);

		Thread.sleep(2000);
		boolean result = getTextOnPage1.equals("SaveOffer") ; 

		assertTrue(result);
		//	 System.out.println("MCCM OSF Outcome API SaveOffer Validation Done");
	}
	public void PegaOSFOutcomeAPISubmitOrderVlidtion() throws InterruptedException
	{
		driver.manage().window().maximize();
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		WebElement element6 = driver.findElement(By.xpath("//div[text()='Journey']"));
		js5.executeScript("arguments[0].scrollIntoView();", element6);	
		Thread.sleep(8000);

		String getTextOnPage1 = "";


		wait.until(ExpectedConditions.visibilityOf(Outcome));
		WebElement element1 = Outcome;

		Thread.sleep(2000);
		getTextOnPage1 = element1.getText();
		System.out.println(getTextOnPage1);

		Thread.sleep(2000);
		boolean result = getTextOnPage1.equals("SubmitOrder") ; 

		assertTrue(result);
		//	 System.out.println("MCCM OSF Outcome API SubmitOrder Validation Done");
	}

}	 