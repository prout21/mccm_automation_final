package DemoEtEFlow.Testcase;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.excel.utility.Excel_Reader;

public class PreCheckValidRunID extends TestBase {

	@Test  
	public void prechek()  throws InterruptedException, AWTException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\prout21\\Downloads\\chromedriver_win32\\chromedriver.exe");  
WebDriver driver = new ChromeDriver();
driver.get("http://mccm-191102761.eu-central-1.elb.amazonaws.com:8573/prweb");
driver.findElement(By.xpath("//input[@id='txtUserID']")).sendKeys("prafulla" );
driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("rules" );
driver.findElement(By.xpath("//span[@class='loginButtonText']")).click( );
Thread.sleep(8000);

String xpath = "(//i[@class='pi pi-caret-down'])[2]";
WebElement element =  driver.findElement(By.xpath(xpath));
Actions  action = new Actions(driver);
action.moveToElement(element).click().build().perform();
Thread.sleep(8000);
String  s1 = "(//span[@class='menu-item-title'])[5]";
driver.findElement(By.xpath(s1)).click( );
Thread.sleep(8000);
String mainWindow5=driver.getWindowHandle();
System.out.println(mainWindow5);
// It returns no. of windows opened by WebDriver and will return Set of Strings
Set<String> set5 =driver.getWindowHandles();
// Using Iterator to iterate with in windows
Iterator<String> itr5= set5.iterator();
while(itr5.hasNext())
{
	String childWindow3=itr5.next();
	// Compare whether the main windows is not equal to child window. If not equal, we will close.
if(!mainWindow5.equals(childWindow3)){
	driver.switchTo().window(childWindow3);

	/////**laptop 
	//	  Thread.sleep(8000);
	//   String s5 = "(//span[@class='menu-item-icon-imageclass pi pi-megaphone'])[1]";
	//     driver.findElement(By.xpath(s5)).click();
	/////**laptop  


	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[@id='appview-nav-toggle-one']")).click( );
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[text()='Campaigns']")).click( );
	Thread.sleep(3000);
	int size = driver.findElements(By.tagName("iframe")).size();
	System.out.println(size);

	driver.switchTo().frame(1);

	Actions actions = new Actions(driver);

	Robot robot = new Robot();

	robot.mouseMove(50,50);

	actions.click().build().perform();

	robot.mouseMove(200,70);

	actions.click().build().perform();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@name='PortalCardListingHeader_pyLanding_264']")).click( );
	Thread.sleep(3000);

	Excel_Reader obj= new Excel_Reader("C:\\Users\\prout21\\git\\mccm_automation\\src\\main\\java\\Mccm\\Pega\\TestData\\PegaTestData.xlsx");
                                     	
	String NBACampValue = obj.getCellValue("PegaTestData", 1, 0);

	Thread.sleep(3000);
	System.out.print(NBACampValue + "  Replace to  ");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@type='text'][@name='$PTempModalCardContainerPage$pFilterCriteriaDisplay$ppyValue']")).sendKeys(NBACampValue);
	Thread.sleep(3000);

	driver.findElement(By.xpath("(//button[text()='View'])[1]")).click( );
	Thread.sleep(8000);

	for(int i=0;i<1;i++){

		String NBACampCodeExits = "";
		
		try
		{
		WebElement w2=driver.findElement(By.xpath("//div[text()='There are no results returned, please try a new search term.']"));
		Thread.sleep(8000);
		 NBACampCodeExits= w2.getText();

		System.out.println(NBACampCodeExits);

		//			Assert.assertEquals(NBACampValueExits, "There are no results returned, please try a new search term.");

		System.out.println(NBACampValue   +  " is Valid Camp Code ");
		
		}catch(Exception e){

		}

		if (NBACampCodeExits.equals("There are no results returned, please try a new search term.")) {

			break;
		}
		else
		{
			
			Excel_Reader obj1= new Excel_Reader("C:\\Users\\prout21\\git\\mccm_automation\\src\\main\\java\\Mccm\\Pega\\TestData\\PegaTestData.xlsx");

			String CampCode = obj1.getCellValue("PegaTestData", 2, 0);
	 
			System.out.print(" Replaced Valid " + CampCode);
			
			 try {
			
			InputStream inp = new FileInputStream("C:\\Users\\prout21\\git\\mccm_automation\\src\\main\\java\\Mccm\\Pega\\TestData\\PegaTestData.xlsx");
			
	//		InputStream inp = new FileInputStream("C:\\Users\\prout21\\git\\mccm_automation\\src\\main\\java\\Mccm\\Pega\\TestData\\PegaTestDataValid.xlsx");

		//	Workbook wb = WorkbookFactory.create(inp);
			XSSFWorkbook wb = new XSSFWorkbook(inp);
			XSSFSheet sheet = wb.getSheet("PegaTestData");
			Row row = sheet.getRow(1);
			Cell cell = row.getCell(0);
			if (cell == null)
			    cell = row.createCell(0);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			cell.setCellValue(CampCode);
			
			Row row1 = sheet.getRow(1);
			Cell cell1 = row.getCell(2);
			if (cell1 == null)
			    cell1 = row1.createCell(2);
			cell1.setCellType(Cell.CELL_TYPE_STRING);
			cell1.setCellValue(CampCode);

			// Write the output to a file
		//	FileOutputStream fileOut = new FileOutputStream("C:\\Users\\prout21\\git\\mccm_automation\\src\\main\\java\\Mccm\\Pega\\TestData\\PegaTestDataValid.xlsx");
			FileOutputStream fileOut = new FileOutputStream("C:\\Users\\prout21\\git\\mccm_automation\\src\\main\\java\\Mccm\\Pega\\TestData\\PegaTestData.xlsx");
			wb.write(fileOut);
			fileOut.close();
			
			 } catch (FileNotFoundException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		//	old code
			
//						File file = new File("C:\\Users\\prout21\\git\\mccm_automation\\src\\main\\java\\Mccm\\Pega\\TestData\\PegaTestDataValid.xlsx");
//						XSSFWorkbook wb = new XSSFWorkbook();
//
//				          XSSFSheet sh = wb.createSheet("PegaTestData");
//				          
//				          
//						
//				//		XSSFSheet sheet = wb.getSheetAt("PegaTestData");
//						Cell cell2Update = sh.getRow(1).getCell(0);
//						cell2Update.setCellValue(CampCode);
//						
////						sh.createRow(0).createCell(0).setCellValue(CampCode);
////
////			        	sh.createRow(0).createCell(2).setCellValue(CampCode);
//			        	
//			        	
//
//				//		sh.createRow(1).createCell(0).setCellValue(CampCode);
//
//								try {
//									FileOutputStream fos = new FileOutputStream(file);
//									wb.write(fos);
//								}catch (Exception e) {
//
//								}
			
		//	old code
					}

				}
			}
		}
	}
}