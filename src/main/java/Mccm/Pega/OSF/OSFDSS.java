package Mccm.Pega.OSF;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Mccm.Pega.OSF.PegaTest.PegaOSFDMCCMSettingTest;
import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.QAUtil.TestUtil;
import Mccm.Pega.excel.utility.Excel_Reader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OSFDSS extends TestBase {

	public static String ExcelFilePath;
	public static Logger log =LogManager.getLogger(PegaOSFDMCCMSettingTest.class.getName());

	@FindBy(xpath="(//h3[@class='layout-group-item-title'])[5]")
	WebElement Recordclk;

	@FindBy(xpath="(//div[@id='iconExpandCollapse'])[15]")
	WebElement SysAdmin;

	@FindBy(xpath="//a[text()='Dynamic System Settings']")
	WebElement webelement4;

	@FindBy(xpath="(/html[1]/body[1]/div[2]/form[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[1]/th[2]/div[1]/span[1]/a[1])")
	WebElement FilterCalcNBA;

	@FindBy(xpath="//input[@type='text'][@name='$PpyFilterCriteria_pgRepPgSubSectionpzViewInstancesB_pxResults_pzViewInstances_1$ppyColumnFilterCriteria$gpyPurpose2$ppySearchText']")
	WebElement CalNBAStartOffSrch;

	@FindBy(xpath="//text()[.='Apply']/ancestor::button[1]")
	WebElement ApplayNBAfilter;

	@FindBy(xpath="//div[contains(text(),'MCCM')]")
	WebElement ClikMCCM;

	@FindBy(xpath="//input[@type='text'][@name='$PRH_1$ppySetting']")
	WebElement CalNBAStartOff;

	@FindBy(xpath="//button[text()='Save']")
	WebElement Save;

	@FindBy(xpath="//*[@class='pi pi-close-circle']")
	WebElement Close;

	@FindBy(xpath="/html[1]/body[1]/div[3]/form[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[1]/th[2]/div[1]/span[1]/a[1]")
	WebElement FilterCalc;

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



	String OSFSClassificationDefault = obj.getCellValue("PegaTestDataOSF", 1, 0);

	String MaxNoOfAcntsForOSFGetNBAPerRqst = obj.getCellValue("PegaTestDataOSF", 1, 1);

	String OSFGetNBATimeout = obj.getCellValue("PegaTestDataOSF", 1, 2);

	String Internal_REST_URL_OSF = obj.getCellValue("PegaTestDataOSF", 1, 3);

	String OSFDirection = obj.getCellValue("PegaTestDataOSF", 1, 4);

	String OSFChannel = obj.getCellValue("PegaTestDataOSF", 1,5);

	String OSFContainerName = obj.getCellValue("PegaTestDataOSF", 1, 6);

	String Internal_REST_URL_OSFValue = obj.getCellValue("PegaTestDataOSF", 1,7);

	String OSFDirectionValue = obj.getCellValue("PegaTestDataOSF", 1, 8);

	String OSFChannelValue = obj.getCellValue("PegaTestDataOSF", 1, 9);

	String OSFContainerNameValue = obj.getCellValue("PegaTestDataOSF", 1, 10);

	String D_mccmsettingsValue = obj.getCellValue("PegaTestDataOSF", 1, 11);

	String OSFSClassificationDefaultValue = obj.getCellValue("PegaTestDataOSF", 1, 12);

	String MaxNoOfAcntsForOSFGetNBAPerRqstValue = obj.getCellValue("PegaTestDataOSF", 1, 13);

	String OSFGetNBATimeoutValue = obj.getCellValue("PegaTestDataOSF", 1, 14);


	public OSFDSS( ) {
		PageFactory.initElements(driver, this);
	}

	public void Recordclk() throws InterruptedException
	{ 
		Thread.sleep(8000);
		Recordclk.click( );
		Thread.sleep(8000);

	}

	public void SysAdmin() throws InterruptedException
	{
		Thread.sleep(8000);
		SysAdmin.click( );
		Thread.sleep(8000);

	}  
	public void javaexictor4() throws InterruptedException
	{
		TestUtil obj=new TestUtil();
		obj.JavascriptExecutor(webelement4);

	}	
	public void DynamicSystemSettins() throws InterruptedException
	{
	//	wait.until(ExpectedConditions.visibilityOf(webelement4));
		Thread.sleep(6000);
		webelement4.click( );
		Thread.sleep(6000);

	}
	//Internal_REST_URL_OSF
		public void FilterosfDSS() throws InterruptedException
		{
			//wait.until(ExpectedConditions.visibilityOf(FilterCalcNBA));
			Thread.sleep(6000);
			FilterCalcNBA.click( );
			Thread.sleep(6000);
			log.info("**** OSF DSS Clicking on webelement FilterosfDSS ****");

		}
		public void CalNBAStartOffSrch() throws InterruptedException
		{
			//wait.until(ExpectedConditions.visibilityOf(CalNBAStartOffSrch));
			Thread.sleep(6000);
			CalNBAStartOffSrch.sendKeys(Internal_REST_URL_OSF);
			Thread.sleep(6000);
			log.info("**** OSF DSS sending the Internal_REST_URL_OSF value ****");
		}
		public void ApplaycALCNBAfilter() throws InterruptedException
		{
		//	wait.until(ExpectedConditions.visibilityOf(ApplayNBAfilter));
			Thread.sleep(6000);
			ApplayNBAfilter.click( );
			Thread.sleep(6000);
			log.info("**** OSF DSS Clicking on webelement ApplaycALCNBAfilter ****");
		}
		public void ClikMCCM() throws InterruptedException
		{
			//	wait.until(ExpectedConditions.elementToBeClickable(ClikMCCM));
			Thread.sleep(1000);
			//	ClikMCCM.click( );
			try {

				ClikMCCM.click();
			}
			catch(org.openqa.selenium.StaleElementReferenceException ex)
			{

				ClikMCCM.click();
			}
			log.info("**** OSF DSS Clicking on webelement ClikMCCM ****");
		}
		public void CalNBAStartOff() throws InterruptedException
		{
			//wait.until(ExpectedConditions.visibilityOf(CalNBAStartOff));
			 Thread.sleep(3000);
			CalNBAStartOff.clear();
			log.info("**** OSF DSS Clear the CalNBAStartOff field****");
			CalNBAStartOff.sendKeys(Internal_REST_URL_OSFValue);
			Thread.sleep(6000);
			log.info("**** OSF DSS sending the Internal_REST_URL_OSFValue value ****");
		}

		public void SaveCalNBAStartOff() throws InterruptedException
		{
			//wait.until(ExpectedConditions.visibilityOf(Save));
			Thread.sleep(6000);
			Save.click( );
			Thread.sleep(6000);
			log.info("**** OSF DSS Clicking on webelement SaveCalNBAStartOff ****");
		}
		public void CloseCalNBAStartOff() throws InterruptedException
		{
			//wait.until(ExpectedConditions.visibilityOf(Close));
			Thread.sleep(6000);
			Close.click( );
			Thread.sleep(6000);
			log.info("**** OSF DSS Clicking on webelement CloseCalNBAStartOff ****");
		}
		//Internal_REST_URL_OSF

		//OSFDirection
		public void FilterOSFDirection() throws InterruptedException
		{
			//wait.until(ExpectedConditions.visibilityOf(FilterCalc));
			Thread.sleep(6000);
			FilterCalc.click( );
			Thread.sleep(6000);
			log.info("**** OSF DSS Clicking on webelement FilterOSFDirection ****");
		}
		public void OSFDirectionSrch() throws InterruptedException
		{
			//wait.until(ExpectedConditions.visibilityOf(CalNBAStartOffSrch));
			Thread.sleep(6000);
			CalNBAStartOffSrch.clear();
			log.info("**** OSF DSS Clear the OSFDirectionSrch field ****");
			CalNBAStartOffSrch.sendKeys(OSFDirection);
			Thread.sleep(6000);
			log.info("**** OSF DSS sending the OSFDirection value ****");
		}
		public void ApplayOSFDirection() throws InterruptedException
		{
			//wait.until(ExpectedConditions.visibilityOf(ApplayNBAfilter));
			Thread.sleep(6000);
			ApplayNBAfilter.click( );
			Thread.sleep(6000);
			log.info("**** OSF DSS Clicking on webelement ApplayOSFDirection ****");
		}
		public void ClikMCCMOSFDirection() throws InterruptedException
		{
			//	wait.until(ExpectedConditions.elementToBeClickable(ClikMCCM));
			Thread.sleep(1000);
			//	ClikMCCM.click( );
			try {

				ClikMCCM.click();
			}
			catch(org.openqa.selenium.StaleElementReferenceException ex)
			{

				ClikMCCM.click();
				log.info("**** OSF DSS Clicking on webelement ClikMCCMOSFDirection ****");
			}


		}
		public void OSFDirection() throws InterruptedException
		{
		//	wait.until(ExpectedConditions.visibilityOf(CalNBAStartOff));
			Thread.sleep(6000);
			CalNBAStartOff.clear();
			log.info("**** OSF DSS Clear the OSFDirection srch field ****");
			CalNBAStartOff.sendKeys(OSFDirectionValue);
			Thread.sleep(6000);
			log.info("**** OSF DSS sending the OSFDirection value ****");
		}

		public void SaveOSFDirection() throws InterruptedException
		{
			//wait.until(ExpectedConditions.visibilityOf(Save));
			Thread.sleep(6000);
			Save.click( );
			Thread.sleep(6000);
			log.info("**** OSF DSS Clicking on webelement SaveOSFDirection ****");
		}
		public void CloseOSFDirection() throws InterruptedException
		{
		//	wait.until(ExpectedConditions.visibilityOf(Close));
			Thread.sleep(6000);
			Close.click( );
			Thread.sleep(6000);
			log.info("**** OSF DSS Clicking on webelement CloseOSFDirection ****");
		}
		//OSFDirection

		//OSFChannel
		public void FilterOSFChannel() throws InterruptedException
		{
			//	wait.until(ExpectedConditions.visibilityOf(FilterCalc));
			Thread.sleep(6000);
			FilterCalc.click( );
			Thread.sleep(6000);
			log.info("**** OSF DSS Clicking on webelement FilterOSFChannel ****");
		}
		public void OSFChannelSrch() throws InterruptedException
		{
			//wait.until(ExpectedConditions.visibilityOf(CalNBAStartOffSrch));
			Thread.sleep(6000);
			CalNBAStartOffSrch.clear();
			log.info("**** OSF DSS Clear the OSFChannelSrch field ****");
			CalNBAStartOffSrch.sendKeys(OSFChannel);
			Thread.sleep(6000);
			log.info("**** OSF DSS sending the OSFChannel value ****");
		}
		public void ApplayOSFChannel() throws InterruptedException
		{
			//wait.until(ExpectedConditions.visibilityOf(ApplayNBAfilter));
			Thread.sleep(6000);
			ApplayNBAfilter.click( );
			Thread.sleep(6000);
			log.info("**** OSF DSS Clicking on webelement ApplayOSFChannel ****");
		}
		public void ClikMCCMOSFChannel() throws InterruptedException
		{
			//wait.until(ExpectedConditions.elementToBeClickable(ClikMCCM));
			Thread.sleep(1000);
			//	ClikMCCM.click( );
			try {

				ClikMCCM.click();
			}
			catch(org.openqa.selenium.StaleElementReferenceException ex)
			{

				ClikMCCM.click();
				log.info("**** OSF DSS Clicking on webelement ClikMCCMOSFChannel ****");
			}


		}
		public void OSFChannel() throws InterruptedException
		{
			//wait.until(ExpectedConditions.visibilityOf(CalNBAStartOff));
			Thread.sleep(6000);
			CalNBAStartOff.clear();
			log.info("**** OSF DSS Clear the field  OSFChannel ****");
			CalNBAStartOff.sendKeys(OSFChannelValue);
			Thread.sleep(6000);
			log.info("**** OSF DSS sending the OSFChannel value ****");
		}

		public void SaveOSFChannel() throws InterruptedException
		{
			//wait.until(ExpectedConditions.visibilityOf(Save));
			Thread.sleep(6000);
			Save.click( );
			Thread.sleep(6000);
			log.info("**** OSF DSS Clicking on webelement SaveOSFChannel ****");

		}
		public void CloseOSFChannel() throws InterruptedException
		{
		//	wait.until(ExpectedConditions.visibilityOf(Close));
			Thread.sleep(6000);
			Close.click( );
			Thread.sleep(6000);
			log.info("**** OSF DSS Clicking on webelement CloseOSFChannel ****");

		}
		//OSFChannel

		//OSFContainerName
		public void FilterOSFContainerName() throws InterruptedException
		{
			//	wait.until(ExpectedConditions.visibilityOf(FilterCalc));
			Thread.sleep(6000);
			FilterCalc.click( );
			Thread.sleep(6000);
			log.info("**** OSF DSS Clicking on webelement FilterOSFContainerName ****");

		}
		public void OSFContainerNameSrch() throws InterruptedException
		{
		//	wait.until(ExpectedConditions.visibilityOf(CalNBAStartOffSrch));
			Thread.sleep(6000);
			CalNBAStartOffSrch.clear();
			log.info("**** OSF DSS Clicking on webelement OSFContainerNameSrch ****");
			CalNBAStartOffSrch.sendKeys(OSFContainerName);
			Thread.sleep(6000);
			log.info("**** OSF DSS sending the OSFContainerName value ****");
		}
		public void ApplayOSFContainerName() throws InterruptedException
		{
		//	wait.until(ExpectedConditions.visibilityOf(ApplayNBAfilter));
			Thread.sleep(6000);
			ApplayNBAfilter.click( );
			Thread.sleep(6000);
			log.info("**** OSF DSS Clicking on webelement ApplayOSFContainerName ****");
		}
		public void ClikMCCMOSFContainerName() throws InterruptedException
		{
			//wait.until(ExpectedConditions.elementToBeClickable(ClikMCCM));
			Thread.sleep(1000);
			//	ClikMCCM.click( );
			try {

				ClikMCCM.click();
			}
			catch(org.openqa.selenium.StaleElementReferenceException ex)
			{

				ClikMCCM.click();
				log.info("**** OSF DSS Clicking on webelement ClikMCCMOSFContainerName ****");
			}

		}
		public void OSFContainerName() throws InterruptedException
		{
			//wait.until(ExpectedConditions.visibilityOf(CalNBAStartOff));
			Thread.sleep(6000);
			CalNBAStartOff.clear();
			log.info("**** OSF DSS Clicking on webelement OSFContainerName ****");
			CalNBAStartOff.sendKeys(OSFContainerNameValue);
			Thread.sleep(6000);
			log.info("**** OSF DSS sending the OSFContainerName value ****");
		}

		public void SaveOSFContainerName() throws InterruptedException
		{
		//	wait.until(ExpectedConditions.visibilityOf(Save));
			Thread.sleep(6000);
			Save.click( );
			Thread.sleep(6000);
			log.info("**** OSF DSS Clicking on webelement SaveOSFContainerName ****");
		}
		public void CloseOSFContainerName() throws InterruptedException
		{
			//wait.until(ExpectedConditions.visibilityOf(Close));
			Thread.sleep(6000);
			Close.click( );
			Thread.sleep(6000);
			log.info("**** OSF DSS Clicking on webelement CloseOSFContainerName ****");
		}
		//OSFContainerName

		//OSFSClassificationDefaultValue
		public void FilterOSFSClassificationDefaultValue() throws InterruptedException
		{
			//	wait.until(ExpectedConditions.visibilityOf(FilterCalc));
			Thread.sleep(6000);
			FilterCalc.click( );
			Thread.sleep(6000);
			log.info("**** OSF DSS Clicking on webelement FilterOSFSClassificationDefaultValue ****");
		}
		public void OSFSClassificationDefaultValueSrch() throws InterruptedException
		{
			//wait.until(ExpectedConditions.visibilityOf(CalNBAStartOffSrch));
			Thread.sleep(6000);
			CalNBAStartOffSrch.clear();
			log.info("**** OSF DSS Clicking on OSFSClassificationDefaultValueSrch ****");
			CalNBAStartOffSrch.sendKeys(OSFSClassificationDefault);
			Thread.sleep(3000);
			log.info("**** OSF DSS sending the OSFSClassificationDefault value ****");
		}
		public void ApplayOSFSClassificationDefaultValue() throws InterruptedException
		{
		//	wait.until(ExpectedConditions.visibilityOf(ApplayNBAfilter));
			Thread.sleep(6000);
			ApplayNBAfilter.click( );
			Thread.sleep(6000);
			log.info("**** OSF DSS Clicking on webelement ApplayOSFSClassificationDefaultValue ****");
		}
		public void ClikMCCMOSFSClassificationDefaultValue() throws InterruptedException
		{
			//	wait.until(ExpectedConditions.elementToBeClickable(ClikMCCM));
			Thread.sleep(1000);
			//	ClikMCCM.click( );
			try {

				ClikMCCM.click();
			}
			catch(org.openqa.selenium.StaleElementReferenceException ex)
			{

				ClikMCCM.click();
				log.info("**** OSF DSS Clicking on webelement ClikMCCMOSFSClassificationDefaultValue ****");
			}


		}
		public void OSFSClassificationDefaultValue() throws InterruptedException
		{
		//	wait.until(ExpectedConditions.visibilityOf(CalNBAStartOff));
			Thread.sleep(6000);
			CalNBAStartOff.clear();
			log.info("**** OSF DSS Clear the OSFSClassificationDefaultValue ****");
			CalNBAStartOff.sendKeys(OSFSClassificationDefaultValue);
			Thread.sleep(6000);
			log.info("**** OSF DSS sending the OSFSClassificationDefault Value ****");
		}

		public void SaveOSFSClassificationDefaultValue() throws InterruptedException
		{
			//wait.until(ExpectedConditions.visibilityOf(Save));
			Thread.sleep(6000);
			Save.click( );
			Thread.sleep(6000);
			log.info("**** OSF DSS Clicking on webelement SaveOSFSClassificationDefaultValue ****");
		}
		public void CloseOSFSClassificationDefaultValue() throws InterruptedException
		{
			//wait.until(ExpectedConditions.visibilityOf(Close));
			Thread.sleep(6000);
			Close.click( );
			Thread.sleep(6000);
			log.info("**** OSF DSS Clicking on webelement CloseOSFSClassificationDefaultValue ****");
		}
		//OSFSClassificationDefaultValue

		// MaxNoOfAcntsForOSFGetNBAPerRqst
		public void FilterOSFMaxNoOfAcntsForOSFGetNBAPerRqst() throws InterruptedException
		{
			//wait.until(ExpectedConditions.visibilityOf(FilterCalc));
			Thread.sleep(6000);
			FilterCalc.click( );
			Thread.sleep(6000);
			log.info("**** OSF DSS Clicking on webelement FilterOSFMaxNoOfAcntsForOSFGetNBAPerRqst ****");
		}
		public void OSFMaxNoOfAcntsForOSFGetNBAPerRqstSrch() throws InterruptedException
		{
		//	wait.until(ExpectedConditions.visibilityOf(CalNBAStartOffSrch));
			Thread.sleep(6000);
			CalNBAStartOffSrch.clear();
			CalNBAStartOffSrch.sendKeys(MaxNoOfAcntsForOSFGetNBAPerRqst);
			Thread.sleep(6000);
			log.info("**** OSF DSS sending MaxNoOfAcntsForOSFGetNBAPerRqst value ****");
		}
		public void ApplayOSFMaxNoOfAcntsForOSFGetNBAPerRqst() throws InterruptedException
		{
			//wait.until(ExpectedConditions.visibilityOf(ApplayNBAfilter));
			Thread.sleep(6000);
			ApplayNBAfilter.click( );
			Thread.sleep(6000);
			log.info("**** OSF DSS Clicking on webelement ApplayOSFMaxNoOfAcntsForOSFGetNBAPerRqst ****");
		}
		public void ClikMCCMOSFMaxNoOfAcntsForOSFGetNBAPerRqst() throws InterruptedException
		{
			//wait.until(ExpectedConditions.elementToBeClickable(ClikMCCM));
			Thread.sleep(1000);
			//	ClikMCCM.click( );
			try {

				ClikMCCM.click();
			}
			catch(org.openqa.selenium.StaleElementReferenceException ex)
			{
				ClikMCCM.click();
				log.info("**** OSF DSS Clicking on webelement ClikMCCMOSFMaxNoOfAcntsForOSFGetNBAPerRqst ****");
			}


		}
		public void OSFMaxNoOfAcntsForOSFGetNBAPerRqstValue() throws InterruptedException
		{
		//	wait.until(ExpectedConditions.visibilityOf(CalNBAStartOff));
			Thread.sleep(6000);
			CalNBAStartOff.clear();
			log.info("**** OSF DSS Clear  OSFMaxNoOfAcntsForOSFGetNBAPerRqstValue ****");
			CalNBAStartOff.sendKeys(MaxNoOfAcntsForOSFGetNBAPerRqstValue);
			Thread.sleep(3000);
			log.info("**** OSF DSS sending  OSFMaxNoOfAcntsForOSFGetNBAPerRqst Value ****");
		}

		public void SaveOSFMaxNoOfAcntsForOSFGetNBAPerRqst() throws InterruptedException
		{
		//	wait.until(ExpectedConditions.visibilityOf(Save));
			Thread.sleep(6000);
			Save.click( );
			Thread.sleep(6000);
			log.info("**** OSF DSS Clicking on webelement SaveOSFMaxNoOfAcntsForOSFGetNBAPerRqst ****");
		}
		public void CloseOSFMaxNoOfAcntsForOSFGetNBAPerRqst() throws InterruptedException
		{
		//	wait.until(ExpectedConditions.visibilityOf(Close));
			Thread.sleep(6000);
			Close.click( );
			Thread.sleep(6000);
			log.info("**** OSF DSS Clicking on webelement CloseOSFMaxNoOfAcntsForOSFGetNBAPerRqst ****");

		}

		// MaxNoOfAcntsForOSFGetNBAPerRqst

		//OSFGetNBATimeout
		public void FilterOSFGetNBATimeout() throws InterruptedException
		{
			//	wait.until(ExpectedConditions.visibilityOf(FilterCalc));
			Thread.sleep(6000);
			FilterCalc.click( );
			Thread.sleep(6000);
			log.info("**** OSF DSS Clicking on webelement FilterOSFGetNBATimeout ****");

		}
		public void OSFGetNBATimeoutSrch() throws InterruptedException
		{
		//	wait.until(ExpectedConditions.visibilityOf(CalNBAStartOffSrch));
			Thread.sleep(6000);
			CalNBAStartOffSrch.clear();
			log.info("**** OSF DSS Clear on webelement CalNBAStartOffSrch ****");
			CalNBAStartOffSrch.sendKeys(OSFGetNBATimeout);
			Thread.sleep(3000);
			log.info("**** OSF DSS  sending the OSFGetNBATimeout value****");
		}
		public void ApplayOSFGetNBATimeout() throws InterruptedException
		{
			//wait.until(ExpectedConditions.visibilityOf(ApplayNBAfilter));
			Thread.sleep(6000);
			ApplayNBAfilter.click( );
			Thread.sleep(6000);
			log.info("**** OSF DSS Clicking on webelement ApplayOSFGetNBATimeout ****");
		}
		public void ClikMCCMOSFGetNBATimeout() throws InterruptedException
		{

			//wait.until(ExpectedConditions.elementToBeClickable(ClikMCCM));
			Thread.sleep(1000);
			//	ClikMCCM.click( );
			try {

				ClikMCCM.click();
			}
			catch(org.openqa.selenium.StaleElementReferenceException ex)
			{
				ClikMCCM.click();
				log.info("**** OSF DSS Clicking on webelement ClikMCCMOSFGetNBATimeout ****");
			}


		}
		public void OSFGetNBATimeout() throws InterruptedException
		{
			//wait.until(ExpectedConditions.visibilityOf(CalNBAStartOff));
			Thread.sleep(6000);
			CalNBAStartOff.clear();
			log.info("**** OSF DSS Clear the CalNBAStartOff field ****");
			CalNBAStartOff.sendKeys(OSFGetNBATimeoutValue);
			Thread.sleep(3000);
			log.info("**** OSF DSS sending the OSFGetNBATimeout Value ****");
		}

		public void SaveOSFGetNBATimeout() throws InterruptedException
		{
		//	wait.until(ExpectedConditions.visibilityOf(Save));
			Thread.sleep(6000);
			Save.click( );
			Thread.sleep(6000);
			log.info("**** OSF DSS Clicking on webelement SaveOSFGetNBATimeout ****");
		}
		public void CloseOSFGetNBATimeout() throws InterruptedException
		{
		//	wait.until(ExpectedConditions.visibilityOf(Close));
			Thread.sleep(6000);
			Close.click( );
			Thread.sleep(6000);
			log.info("**** OSF DSS Clicking on webelement CloseOSFGetNBATimeout ****");
		}
		//OSFGetNBATimeout


		//D_mccmsettings
		public void D_mccmsettings() throws InterruptedException
		{
		//	wait.until(ExpectedConditions.visibilityOf(D_mccmsettings));
			Thread.sleep(6000);
			D_mccmsettings.sendKeys(D_mccmsettingsValue);
			Thread.sleep(6000);
			log.info("**** OSF DSS sending the D_mccmsettingsValue ****");
		}

		public void SerchClick() throws InterruptedException
		{
			//wait.until(ExpectedConditions.visibilityOf(SerchClick));
			Thread.sleep(6000);
			SerchClick.click( );
			Thread.sleep(6000);
			log.info("**** OSF DSS Clicking on webelement serch dmccmsetting ****");

		}
		public void Clickdmccmsetting() throws InterruptedException
		{
			//wait.until(ExpectedConditions.visibilityOf(Clickdmccmsetting));
			Thread.sleep(6000);
			Clickdmccmsetting.click( );
			Thread.sleep(6000);
			log.info("**** OSF DSS Clicking on webelement dmccmsetting ****");
		}
		public void ActionClkDmccmsetting() throws InterruptedException
		{
		//	wait.until(ExpectedConditions.visibilityOf(ActionClkDmccmsetting));
			Thread.sleep(6000);
			ActionClkDmccmsetting.click( );
			Thread.sleep(6000);
			log.info("**** OSF DSS Clicking on webelement ActionClkDmccmsetting ****");
		}

		public void RunActionClk() throws InterruptedException
		{
			TestUtil obj=new TestUtil();
			obj.ActionMouseMov(RunActionClk);
			log.info("**** OSF DSS Clicking on webelement RunActionClk ****");
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
			log.info("**** Ended the OSF Dynamic System Setting ****");
		}
		//D_mccmsettings




}