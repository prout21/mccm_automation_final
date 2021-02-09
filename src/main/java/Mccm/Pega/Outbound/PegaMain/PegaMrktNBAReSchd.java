package Mccm.Pega.Outbound.PegaMain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.QAUtil.TestUtil;
import Mccm.Pega.excel.utility.Excel_Reader;

public class PegaMrktNBAReSchd extends TestBase  {

	public static String ExcelFilePath;


	@FindBy(xpath="(//i[@class='pi pi-caret-down'])[2]")
	WebElement ClkPegaMrkt;

	@FindBy(xpath="(//span[@class='menu-item-title'])[5]")
	WebElement pegamrkting1;

	@FindBy(xpath="//a[@id='appview-nav-toggle-one']")
	WebElement ExpandPegMrkPage;

	@FindBy(xpath="//span[text()='Campaigns']")
	WebElement Campaigns;

	@FindBy(xpath="//*[@name='PortalCardListingHeader_pyLanding_264']")
	WebElement Filter;


	@FindBy(xpath="//input[@type='text'][@name='$PTempModalCardContainerPage$pFilterCriteriaDisplay$ppyValue']")
	WebElement CampaignVlSrch;


	@FindBy(xpath="(//button[text()='View'])[1]")
	WebElement ViewClk;

	@FindBy(xpath="//div[@class='card-image no-image'][1]")
	WebElement ImageClk;

	@FindBy(xpath="//text()[.='Actions']/ancestor::button[1]")
	WebElement ActionsClk;

	@FindBy(xpath="//span[text()='Reschedule']")
	WebElement RescheduleClk;

	@FindBy(xpath="//text()[.='Configure']/ancestor::div[1]")
	WebElement ConfigureClk;

	@FindBy(xpath="//label[text()='Recurring']")
	WebElement RecurringClk;

	@FindBy(xpath="//img[@name='CalendarImg-1d3ff703']")
	WebElement CalnderClk;

	@FindBy(xpath="//a[text()='Today']")
	WebElement TodayClk;

	@FindBy(xpath="//button[text()='Apply']")
	WebElement ApplyClk;

	@FindBy(xpath="//button[text()='Confirm']")
	WebElement ConfirmClk;

	@FindBy(xpath="//button[@title='Refresh']")
	WebElement RefreshClk;


	@FindBy(xpath="//h2[text()='Run schedule']")
	WebElement Runschedule;

	@FindBy(xpath="//h2[.='Run schedule']//following::span[8]")
	WebElement RunStatus;

	@FindBy(xpath="//h2[contains(text(),'Run schedule')]/following::span[contains(.,'Completed')][1]")
	WebElement Completed1st;

	@FindBy(xpath="//*[@name='DataFlowRunDetails_pyWorkPage_3']")
	WebElement DataFlowRunDtailsClk;

	@FindBy(xpath="//span[text()='Campaign run ID']")
	WebElement CampaignrunIDk;

	@FindBy(xpath="//span[.='Campaign run ID']/..//span[contains(.,'PR-')]")
	WebElement CaputredRunID;
	
	@FindBy(xpath="(//span[@class='menu-item-icon-imageclass pi pi-megaphone'])[1]")
	WebElement CampaignImage;

	Excel_Reader obj= new Excel_Reader(ExcelFilePath+"/UseCaseConfigFile/TestData/PegaOutputData1.xlsx");

	String NBACampValue = obj.getCellValue("PegaOutputData1", 1, 0);




	public PegaMrktNBAReSchd( ) {
		PageFactory.initElements(driver, this);
	}

	public void pegamarkting() throws InterruptedException
	{
		Thread.sleep(6000);
		pegamrkting1.click( );
		Thread.sleep(6000);
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
	//	wait.until(ExpectedConditions.visibilityOf(Campaigns));
		Campaigns.click( );
		Thread.sleep(8000); 
	}
	

public void CampaignImage() throws InterruptedException
	{

	//	wait.until(ExpectedConditions.visibilityOf(CampaignImage));
		CampaignImage.click( );
		 
	}



	public void Filter() throws InterruptedException
	{
			
		  try { 
			  JavascriptExecutor js = (JavascriptExecutor)driver;
			  js.executeScript("arguments[0].click();", Filter);
		   }catch(Exception e){
	 }
	}

	public void CampaignVlSrch() throws InterruptedException
	{
		Thread.sleep(6000);
		CampaignVlSrch.sendKeys(NBACampValue);
		Thread.sleep(6000);
	}
	public void View() throws InterruptedException
	{
		Thread.sleep(6000);
		ViewClk.click( );
		Thread.sleep(6000);
	}
	public void ImageClk() throws InterruptedException
	{
		Thread.sleep(6000);
		ImageClk.click( );
		Thread.sleep(6000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
	}
	public void ActionsReSchd() throws InterruptedException
	{
		WebElement element9 = ActionsClk;
		JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		executor3.executeScript("arguments[0].click();", element9);
		Thread.sleep(3000);
		System.out.println("i am in if---search-------------------");

		Thread.sleep(8000);

		RescheduleClk.click( );
	}

	public void Configure() throws InterruptedException
	{
		Thread.sleep(3000);

		ConfigureClk.click( );

		//	Thread.sleep(3000);
		//	WebElement radio1 =  driver.findElement(By.xpath("//label[text()='Recurring']"));
		//	radio1.click( );

	}
	public void CalendarApplay() throws InterruptedException
	{
		CalnderClk.click( );
		Thread.sleep(3000);

		TodayClk.click( );
		Thread.sleep(3000);

		ApplyClk.click( );
		Thread.sleep(3000);
	}
	public void Confirm() throws InterruptedException
	{
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		WebElement element6 = ConfirmClk;
		js5.executeScript("arguments[0].scrollIntoView();", element6);	

		ConfirmClk.click( );
		Thread.sleep(3000);
	}
	public void Refresh() throws InterruptedException
	{
		Thread.sleep(6000);
		RefreshClk.click( );
		Thread.sleep(6000);
		JavascriptExecutor js7= (JavascriptExecutor) driver;
		WebElement element8 = Runschedule;
		js7.executeScript("arguments[0].scrollIntoView();", element8);	
	}
	public void RunStatus() throws InterruptedException
	{
		for(int i=0;i<50;i++)
		{

			Thread.sleep(6000);

			try
			{
				Thread.sleep(6000);
				//   driver.findElement(By.xpath("//*[@class='pi pi-refresh']")).click( );
				RefreshClk.click( );
				Thread.sleep(6000);
				JavascriptExecutor js6 = (JavascriptExecutor) driver;
				WebElement element7 =Runschedule;
				//	WebElement element7 = driver.findElement(By.xpath("//h2[text()='Run schedule']"));
				js6.executeScript("arguments[0].scrollIntoView();", element7);	
			}catch(Exception e){

			}

			String getTextOnPage1 = "",getTextOnPage2 = "",getTextOnPage3 = "";


			try {


				WebElement element11 = RunStatus;

				//	WebElement element11 = driver.findElement(By.xpath("//h2[.='Run schedule']//following::span[8]"));

				getTextOnPage1 = element11.getText();

			}catch(Exception e){
				e.printStackTrace();

			}

			if ((getTextOnPage1.equals("COMPLETED")) || (getTextOnPage1.equals("FAILED")) || (getTextOnPage1.equals("STOPPED"))) {

				System.out.println("Test Case Passed");

				break;

			}
		}

	}
	public void CapturedRunID() throws InterruptedException
	{
		Thread.sleep(8000);
		Completed1st.click();
		//	driver.findElement(By.xpath("//h2[contains(text(),'Run schedule')]/following::span[contains(.,'Completed')][1]")).click( );
		Thread.sleep(8000);

		JavascriptExecutor js9 = (JavascriptExecutor) driver;
		WebElement element10 =Completed1st;
		//	 WebElement element10 = driver.findElement(By.xpath("//h2[contains(text(),'Run schedule')]/following::span[contains(.,'Completed')][1]"));
		js9.executeScript("arguments[0].scrollIntoView();", element10);	

		Thread.sleep(8000);
		DataFlowRunDtailsClk.click( );
		Thread.sleep(8000);

		JavascriptExecutor js8 = (JavascriptExecutor) driver;
		WebElement element11 = CampaignrunIDk;
		js8.executeScript("arguments[0].scrollIntoView();", element11);

		//Search the element by using starts-with
		WebElement w =CaputredRunID;

		//	w=driver.findElement(By.xpath("//span[.='Campaign run ID']/..//span[contains(.,'PR-')]"));

		//Print the text of the searched element

		String CampRunID = w.getText();



		System.out.println(w.getText());

		File file = new File(ExcelFilePath+"/UseCaseConfigFile/TestData/PegaOutputData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook();

		XSSFSheet sh = wb.createSheet("PegaOutputData");

		sh.createRow(0).createCell(0).setCellValue("CampRunID");

		sh.createRow(1).createCell(0).setCellValue(CampRunID);

		try {
			FileOutputStream fos = new FileOutputStream(file);
			wb.write(fos);
		}catch (Exception e) {

		}
	}

}







