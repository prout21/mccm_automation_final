package Mccm.Pega.OSF;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.QAUtil.TestUtil;
import Mccm.Pega.excel.utility.Excel_Reader;
 
public class PegaPreChkValidOSFCampCd extends TestBase  {

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
	
	@FindBy(xpath="(//span[@class='menu-item-icon-imageclass pi pi-megaphone'])[1]")
	WebElement CampaignImage;

	@FindBy(xpath="(//i[@class='pi pi-caret-down'])[2]")
	WebElement Pegalunch;
	
	

	public PegaPreChkValidOSFCampCd( ) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void pegamarkting() throws InterruptedException
	{
		Thread.sleep(8000);
		pegamrkting1.click();
		Thread.sleep(8000);
	}


	public void ExpandPegMrkPage() throws InterruptedException
	{
	  
		ExpandPegMrkPage.click();
		 
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
		Campaigns.click();
		Thread.sleep(8000); 
	}
	

public void CampaignImage() throws InterruptedException
	{

	//	wait.until(ExpectedConditions.visibilityOf(CampaignImage));
		CampaignImage.click();
		 
	}


//	public void Filter() throws InterruptedException
//	{
//		Thread.sleep(6000);
//		Filter.click( );
//		Thread.sleep(6000);
//	}

//	public void CampaignVlSrch() throws InterruptedException
//	{
//		Thread.sleep(6000);
//		CampaignVlSrch.sendKeys(NBACampValue);
//		Thread.sleep(6000);
//		System.out.println(NBACampValue);
//	}
//	public void View() throws InterruptedException
//	{
//		Thread.sleep(6000);
//		View.click( );
//		Thread.sleep(6000);
//	}
	public void PreChkValdOSFCampCd() throws InterruptedException
	{
		for(int i=1;i<10;i++){
			
			  try { 
				  JavascriptExecutor js = (JavascriptExecutor)driver;
				  js.executeScript("arguments[0].click();", Filter);
			   }catch(Exception e){
		 }
			wait.until(ExpectedConditions.visibilityOf(CampaignVlSrch));
			CampaignVlSrch.clear();
		 
			Excel_Reader obj= new Excel_Reader(ExcelFilePath+"/UseCaseConfigFile/TestData/PegaTestData.xlsx");
		 	String NBACampValue1 = obj.getCellValue("PegaTestDataOSF", 1, 0);
		 	wait.until(ExpectedConditions.visibilityOf(CampaignVlSrch));
 			CampaignVlSrch.sendKeys(NBACampValue1);
 			 
 			System.out.println(NBACampValue1);
 			wait.until(ExpectedConditions.visibilityOf(View));
 			View.click();
 			 

			String NBACampCodeExits1 = "";

			try
			{
				WebElement w2=driver.findElement(By.xpath("//div[text()='There are no results returned, please try a new search term.']"));
		 
				NBACampCodeExits1= w2.getText();

				System.out.println(NBACampCodeExits1);

				//			Assert.assertEquals(NBACampValueExits, "There are no results returned, please try a new search term.");

				
			}catch(Exception e){

			}

			if (NBACampCodeExits1.equals("There are no results returned, please try a new search term.")) {
				
				System.out.println(NBACampValue1   +  " is Valid Camp Code ");

				break;
			}
			else
			{

				Excel_Reader obj1= new Excel_Reader(ExcelFilePath+"/UseCaseConfigFile/TestData/PegaTestData.xlsx");

				String CampCode1 = obj1.getCellValue("PegaTestDataOSF", i+1, 0);

				System.out.print(CampCode1 + "  ");

				try {

					InputStream inp = new FileInputStream(ExcelFilePath+"/UseCaseConfigFile/TestData/PegaTestData.xlsx");


					//	Workbook wb = WorkbookFactory.create(inp);
					XSSFWorkbook wb = new XSSFWorkbook(inp);
					XSSFSheet sheet = wb.getSheet("PegaTestDataOSF");
					Row row = sheet.getRow(1);
					Cell cell = row.getCell(0);
					if (cell == null)
						cell = row.createCell(0);
					cell.setCellType(Cell.CELL_TYPE_STRING);
					cell.setCellValue(CampCode1);

				 	// Write the output to a file
					FileOutputStream fileOut = new FileOutputStream(ExcelFilePath+"/UseCaseConfigFile/TestData/PegaTestData.xlsx");
					wb.write(fileOut);
					fileOut.close();

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		}
	}
}







