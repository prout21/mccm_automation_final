package Mccm.Pega.Outbound.PegaMain;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.QAUtil.TestUtil;
import Mccm.Pega.excel.utility.Excel_Reader;

public class PreChkNBACampValu extends TestBase {

	public static String ExcelFilePath;

	@FindBy(xpath="(//h3[@class='layout-group-item-title'])[5]")
	WebElement Recordclk;

	@FindBy(xpath="(//div[@id='iconExpandCollapse'])[15]")
	WebElement SysAdmin;

	@FindBy(xpath="//a[text()='Dynamic System Settings']")
	WebElement webelement4;

	@FindBy(xpath="(/html[1]/body[1]/div[2]/form[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[1]/th[2]/div[1]/span[1]/a[1])")
	WebElement FilterNBAcamp;

	@FindBy(xpath="//input[@type='text'][@name='$PpyFilterCriteria_pgRepPgSubSectionpzViewInstancesB_pxResults_pzViewInstances_1$ppyColumnFilterCriteria$gpyPurpose2$ppySearchText']")
	WebElement NBACampaignName;

	@FindBy(xpath="//text()[.='Apply']/ancestor::button[1]")
	WebElement ApplayNBAfilter;

	@FindBy(xpath="//div[contains(text(),'MCCM')]")
	WebElement ClikMCCM;

	@FindBy(xpath="//input[@type='text'][@name='$PRH_1$ppySetting']")
	WebElement NBACampaignNamevalue;

	Excel_Reader obj= new Excel_Reader(ExcelFilePath+"/UseCaseConfigFile/TestData/PegaTestData.xlsx");

	String NBACampaignNmValue = obj.getCellValue("PegaTestData", 1, 1);




	public PreChkNBACampValu( ) {
		PageFactory.initElements(driver, this);
	}

	public void Recordclk() throws InterruptedException
	{
		Thread.sleep(6000);
		Recordclk.click( );
		Thread.sleep(6000);
	}
	public void SysAdmin() throws InterruptedException
	{
		Thread.sleep(6000);
		SysAdmin.click( );
		Thread.sleep(6000);
	}
	public void javaexictor4() throws InterruptedException
	{
		TestUtil obj=new TestUtil();
		obj.JavascriptExecutor(webelement4);
	}	
	public void DynamicSystemSettins() throws InterruptedException
	{
		Thread.sleep(6000);
		webelement4.click( );
		Thread.sleep(6000);
	}
	public void FilterNBAcamp() throws InterruptedException
	{
		Thread.sleep(6000);
		FilterNBAcamp.click( );
		Thread.sleep(6000);
	}
	public void NBACampaignName() throws InterruptedException
	{
		Thread.sleep(6000);
		NBACampaignName.sendKeys(NBACampaignNmValue);
		Thread.sleep(6000);
	}
	public void ApplayNBAfilter() throws InterruptedException
	{
		Thread.sleep(6000);
		ApplayNBAfilter.click( );
		Thread.sleep(6000);
	}
	public void ClikMCCM() throws InterruptedException
	{
		Thread.sleep(6000);
		ClikMCCM.click( );
		Thread.sleep(6000);
	}

	// Caputred NBA Camp value data into output file

	public void NBACampaignNamevalue() throws InterruptedException
	{
		WebElement w3= NBACampaignNamevalue;
		String NBACampaignNamevalue = w3.getAttribute("value");

		System.out.println(NBACampaignNamevalue);

		File file = new File(ExcelFilePath+"/UseCaseConfigFile/TestData/PegaOutputData1.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook();

		XSSFSheet sh = wb.createSheet("PegaOutputData");

		sh.createRow(1).createCell(0).setCellValue(NBACampaignNamevalue);

		sh.createRow(0).createCell(0).setCellValue("NBACampaignNamevalue");

		try {
			FileOutputStream fos = new FileOutputStream(file);
			wb.write(fos);
		}catch (Exception e) {

		}

	}
}