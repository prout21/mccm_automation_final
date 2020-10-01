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
	
	public class PegaMrktNBAValuChk extends TestBase  {
	
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
		WebElement View;
		
		@FindBy(xpath="//div[text()='There are no results returned, please try a new search term.']")
		WebElement DisplayMsg;
	
		
		
	
	
		Excel_Reader obj= new Excel_Reader(ExcelFilePath+"/src/main/java/Mccm/Pega/TestData/PegaOutputData1.xlsx");
	
		String NBACampValue = obj.getCellValue("PegaOutputData", 1, 0);
	

	
	
		public PegaMrktNBAValuChk( ) {
			PageFactory.initElements(driver, this);
		}
		
		public void pegamarkting() throws InterruptedException
		{
			Thread.sleep(6000);
			pegamrkting1.click( );
			Thread.sleep(6000);
		}
	
	
		public void ExpandPegMrkPage() throws InterruptedException
		{
			Thread.sleep(6000);
			ExpandPegMrkPage.click( );
			Thread.sleep(6000);
		}
	
		public void Campaigns() throws InterruptedException
		{
			Thread.sleep(6000);
			Campaigns.click( );
			Thread.sleep(6000);
		}
	
	 
		public void Filter() throws InterruptedException
		{
			Thread.sleep(6000);
			Filter.click( );
			Thread.sleep(6000);
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
			View.click( );
			Thread.sleep(6000);
		}
		public void DisplayMsg() throws InterruptedException
		{
			WebElement w2= DisplayMsg;
			Thread.sleep(8000);
			String NBACampValueExits= w2.getText();
			
			System.out.println(NBACampValueExits);
			
			Assert.assertEquals(NBACampValueExits, "There are no results returned, please try a new search term.");
			
			System.out.println(NBACampValue + " NBACampaignName Value is not Present");
			
			 System.out.println("NBACampaignName Value is not Present..Goto Main Flow"); 
		 
		}
		 
		}
 
	
	
	
	
	
	
