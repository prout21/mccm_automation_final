package Mccm.Pega.Outbound.PegaMain;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.QAUtil.TestUtil;
import Mccm.Pega.excel.utility.Excel_Reader;

public class DataLoadDetails extends TestBase {
	
	public static String ExcelFilePath;

	
	@FindBy(xpath="(//h3[@class='layout-group-item-title'])[5]")
	WebElement Recordclk;
	
	@FindBy(xpath="(//div[@id='iconExpandCollapse'])[15]")
	WebElement SysAdmin;
	
	@FindBy(xpath="//a[text()='Dynamic System Settings']")
	WebElement webelement4;
		
	@FindBy(xpath="//input[@type='text'][@name='$PpyDisplayHarness$ppySearchText']")
	WebElement d_latestdataloadFlag;
	
	@FindBy(xpath="//*[@class='pi pi-search-2']")
	WebElement SerchClick;
	
	@FindBy(xpath="//a[text()='Data Page']")
	WebElement ClickDataPage;
	
	@FindBy(xpath="//a[text()='D_LatestDataLoadFlag']")
	WebElement Clickd_latestdataloadFlag;


	@FindBy(xpath="//*[@class='pi pi-caret-down margin-l-1x']")
	WebElement ActionClkd_latestdataloadFlag;
	 
	@FindBy(xpath="(//text()[.='Run']/ancestor::a[1])[2]")
	WebElement RunActionClk;
	 
	@FindBy(xpath="//input[@type='checkbox'][@name='$PD_pzRunRecord$ppxRunWindow$gTABTHREAD1$ppxRunParameters$ppyFlushAll']")
	WebElement FlushClk;
	
	@FindBy(xpath="(//div[@class='pzbtn-mid'])[3]")
	WebElement RunFlushClk;
	
	@FindBy(xpath="(//a[@href='#'])[11]//following::span[31]")
	WebElement DataLoadCmpltdCsndra;
	
	@FindBy(xpath="(//a[@href='#'])[13]//following::span[33]")
	WebElement DataLoadCmpltdOracle;
	
	 	
	Excel_Reader obj= new Excel_Reader(ExcelFilePath+"/src/main/java/Mccm/Pega/TestData/PegaTestData.xlsx");
			
	String dlatestdataloadFlag = obj.getCellValue("PegaTestData", 1, 12);
	
	
	
	public DataLoadDetails( ) {
    	PageFactory.initElements(driver, this);
    }


	public void Recordclk() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(Recordclk));
		Recordclk.click( );
        
	}
	public void SysAdmin() throws InterruptedException
	{
		//wait.until(ExpectedConditions.elementToBeClickable(SysAdmin));
	//	waitVisibility(SysAdmin);
		Thread.sleep(6000);
		 SysAdmin.click( );
		  
	}
	public void javaexictor4() throws InterruptedException
	{
		TestUtil obj=new TestUtil();
		obj.JavascriptExecutor(webelement4);
	}	
	public void DynamicSystemSettins() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(webelement4));
		webelement4.click( );
		 
	}
		
	public void d_latestdataloadFlag() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(d_latestdataloadFlag));
		d_latestdataloadFlag.sendKeys(dlatestdataloadFlag);
         
	}
	
	public void SerchClick() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(SerchClick));
		SerchClick.click( );
        
	}
	public void Clickd_latestdataloadFlag() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(ClickDataPage));
		ClickDataPage.click();
		wait.until(ExpectedConditions.visibilityOf(Clickd_latestdataloadFlag));
		Clickd_latestdataloadFlag.click( );
       
	}
	public void ActionClkd_latestdataloadFlag() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(ActionClkd_latestdataloadFlag));
		ActionClkd_latestdataloadFlag.click( );
       
	}
	
	public void RunActionClk() throws InterruptedException
	{
		TestUtil obj=new TestUtil();
		obj.ActionMouseMov(RunActionClk);
	}	
	
	public void FulshRunClick() throws InterruptedException
	{
	String mainWindow=driver.getWindowHandle();
    Set<String> set =driver.getWindowHandles();
    Iterator<String> itr= set.iterator();
     while(itr.hasNext())
     {
     String childWindow=itr.next();
      if(!mainWindow.equals(childWindow)){
     driver.switchTo().window(childWindow);

     wait.until(ExpectedConditions.visibilityOf(FlushClk));
      FlushClk.click();

      wait.until(ExpectedConditions.visibilityOf(RunFlushClk));
	 RunFlushClk.click( );
	 
      }
  
	}
	}
	// display validation of the DataLoadCmpltdCsndra data
	
	public void DataLoadCmpltdCsndra() throws InterruptedException
	{

	WebElement w3;

//	w3=driver.findElement(By.xpath("(//a[@href='#'])[11]//following::span[31]"));
	w3=DataLoadCmpltdCsndra;

	String DataLoadCmpltdCsndra = w3.getText();

	System.out.println(w3.getText());

	Assert.assertEquals(DataLoadCmpltdCsndra, "Y"); 
	
	}
	
	// display validation of the DataLoadCmpltdOracle data
	
	public void DataLoadCmpltdOracle() throws InterruptedException
	{

	//WebElement w4;
	
	WebElement w4=DataLoadCmpltdOracle;

//	w4=driver.findElement(By.xpath("(//a[@href='#'])[13]//following::span[33]"));

	String DataLoadCmpltdOracle = w4.getText();

	System.out.println(w4.getText());

	Assert.assertEquals(DataLoadCmpltdOracle, "Y"); 
	}
}