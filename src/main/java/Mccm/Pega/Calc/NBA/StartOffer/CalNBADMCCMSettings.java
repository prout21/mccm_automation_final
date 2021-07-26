package Mccm.Pega.Calc.NBA.StartOffer;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import Mccm.Pega.OSF.PegaTest.PegaOSF_DMCCM_SettingTest;
import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.QAUtil.TestUtil;
import Mccm.Pega.excel.utility.Excel_Reader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CalNBADMCCMSettings extends TestBase {

	public static String ExcelFilePath;

	public static Logger log =LogManager.getLogger(PegaOSF_DMCCM_SettingTest.class.getName());

	@FindBy(xpath="(//h3[@class='layout-group-item-title'])[5]")
	WebElement Recordclk;

	@FindBy(xpath="(//div[@id='iconExpandCollapse'])[15]")
	WebElement SysAdmin;

	@FindBy(xpath="//a[text()='Dynamic System Settings']")
	WebElement webelement4;

	@FindBy(xpath="(//*[@id=\"iconExpandCollapse\"]/a)[15]")
	WebElement SysAdmin1;
	@FindBy(xpath="/html/body/div[5]/aside/div[1]/div/div[1]/div/div/div[9]/div[2]/div/span/div/span/div[1]/span/div/span/div/div[2]/div/table/tbody/tr/td/div/div/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td/div/ul/li[16]/ul/li[1]/div/div[1]/a")
	WebElement SysAdmin2;



	@FindBy(xpath="//input[@type='text'][@name='$PpyDisplayHarness$ppySearchText']")
	WebElement D_mccmsettings;

	@FindBy(xpath="//*[@class='pi pi-search-2']")
	WebElement SerchClick;

	@FindBy(xpath="//a[text()='D_MCCMSettings']")
	WebElement Clickdmccmsetting;


	@FindBy(xpath="//*[@class='pi pi-caret-down margin-l-1x']")
	WebElement ActionClkDmccmsetting;

	@FindBy(xpath="(//text()[.='Run']/ancestor::a[1])[2]")
	WebElement RunActionClk;

	@FindBy(xpath="//input[@type='checkbox'][@name='$PD_pzRunRecord$ppxRunWindow$gTABTHREAD1$ppxRunParameters$ppyFlushAll']")
	WebElement FlushClk;

	@FindBy(xpath="(//div[@class='pzbtn-mid'])[3]")
	WebElement RunFlushClk;







	Excel_Reader obj= new Excel_Reader(ExcelFilePath+"/UseCaseConfigFile/TestData/PegaTestData.xlsx");


	//D_mccmsettingsValue

	String D_mccmsettingsValue = obj.getCellValue("PegaTestDataCalcNBA", 1, 3);

	//D_mccmsettingsValue





	public CalNBADMCCMSettings( ) {
		PageFactory.initElements(driver, this);
	}

	//	public void Recordclk() throws InterruptedException
	//	{
	//		//wait.until(ExpectedConditions.visibilityOf(Recordclk));
	//	 //	Recordclk.click( );
	//	      Thread.sleep(1000);
	//	//	System.out.println("hi");
	//		 Actions  action = new Actions(driver);
	//	     action.moveToElement(Recordclk).click().build().perform();
	//	  //   Thread.sleep(1000);
	//	
	// 
	//	}
	//	public void SysAdmin() throws InterruptedException
	//	{
	//	// 	wait.until(ExpectedConditions.elementToBeClickable(SysAdmin));
	//	  	 Thread.sleep(3000);
	//		
	//     SysAdmin.click( );
	//	 
	//	 
	//	}


	public void Recordclk() throws InterruptedException
	{ 
		log.info("**** Started the OSF Dynamic System Setting ****");
		Thread.sleep(8000);
		Recordclk.click( );
		Thread.sleep(8000);
		log.info("**** OSF DSS Clicking on webelement Record ****");
	}

	public void SysAdmin() throws InterruptedException
	{
		Thread.sleep(8000);
		SysAdmin.click( );
		Thread.sleep(8000);
		log.info("**** OSF DSS Clicking on webelement SysAdmin ****");
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
		log.info("**** OSF DSS Clicking on webelement DynamicSystemSettins ****");
	}

	//D_mccmsettings
	public void D_mccmsettings() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(D_mccmsettings));
		D_mccmsettings.sendKeys(D_mccmsettingsValue);
		log.info("**** OSF DSS sending the D_mccmsetting value ****");
	}

	public void SerchClick() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(SerchClick));
		SerchClick.click( );
		log.info("**** OSF DSS Clicking on webelement Search ****");
	}
	public void Clickdmccmsetting() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(Clickdmccmsetting));
		Clickdmccmsetting.click( );
		log.info("**** OSF DSS Clicking on webelement DmccmSettins ****");
	}
	public void ActionClkDmccmsetting() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(ActionClkDmccmsetting));
		ActionClkDmccmsetting.click( );
		log.info("**** OSF DSS Clicking on webelement Action ****");
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
				log.info("**** OSF DSS Clicking on webelement Flush ****");

				wait.until(ExpectedConditions.visibilityOf(RunFlushClk));
				RunFlushClk.click( );
				log.info("**** OSF DSS Clicking on webelement RunFlush ****");

				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);

	}
	//D_mccmsettings



}