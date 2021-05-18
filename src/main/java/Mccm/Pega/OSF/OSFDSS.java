package Mccm.Pega.OSF;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.QAUtil.TestUtil;
import Mccm.Pega.excel.utility.Excel_Reader;

public class OSFDSS extends TestBase {

	public static String ExcelFilePath;

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
		System.out.println("test 1");
		}

	public void SysAdmin() throws InterruptedException
	{
		Thread.sleep(8000);
		SysAdmin.click( );
		Thread.sleep(8000);
		System.out.println("test 2");
	}  
	public void javaexictor4() throws InterruptedException
	{
		TestUtil obj=new TestUtil();
		obj.JavascriptExecutor(webelement4);
		System.out.println("test 3");
	}	
	public void DynamicSystemSettins() throws InterruptedException
	{
		//wait.until(ExpectedConditions.visibilityOf(webelement4));
		Thread.sleep(6000);
		webelement4.click( );
		Thread.sleep(6000);;
		System.out.println("test 4");
	}
	//Internal_REST_URL_OSF
	public void FilterosfDSS() throws InterruptedException
	{
		//wait.until(ExpectedConditions.visibilityOf(FilterCalcNBA));
		Thread.sleep(8000);
		FilterCalcNBA.click( );
		Thread.sleep(8000);
		System.out.println("test 5");
	}
	public void CalNBAStartOffSrch() throws InterruptedException
	{
		//wait.until(ExpectedConditions.visibilityOf(CalNBAStartOffSrch));
		Thread.sleep(6000);
		CalNBAStartOffSrch.sendKeys(Internal_REST_URL_OSF);
		Thread.sleep(6000);
		System.out.println("test 6");
	}
	public void ApplaycALCNBAfilter() throws InterruptedException
	{
		//wait.until(ExpectedConditions.visibilityOf(ApplayNBAfilter));
		Thread.sleep(6000);
		ApplayNBAfilter.click( );
		Thread.sleep(6000);
		System.out.println("test 7");
	}
	public void ClikMCCM() throws InterruptedException
	{
		//	wait.until(ExpectedConditions.elementToBeClickable(ClikMCCM));
		Thread.sleep(6000);
			//	ClikMCCM.click( );
				try {
				     
					ClikMCCM.click();
				}
				catch(org.openqa.selenium.StaleElementReferenceException ex)
				{
				    
					ClikMCCM.click();
				}
				System.out.println("test 8");
	}
	public void CalNBAStartOff() throws InterruptedException
	{
	//	wait.until(ExpectedConditions.visibilityOf(CalNBAStartOff));
		Thread.sleep(6000);
		CalNBAStartOff.clear();

		CalNBAStartOff.sendKeys(Internal_REST_URL_OSFValue);
		Thread.sleep(6000);
		System.out.println("test 9");
	}

	public void SaveCalNBAStartOff() throws InterruptedException
	{
		//wait.until(ExpectedConditions.visibilityOf(Save));
		Thread.sleep(6000);
		Save.click( );
		Thread.sleep(6000);
		System.out.println("test 10");
	}
	public void CloseCalNBAStartOff() throws InterruptedException
	{
	//	wait.until(ExpectedConditions.visibilityOf(Close));
		Thread.sleep(6000);
		Close.click( );
		Thread.sleep(6000);
		System.out.println("test 11");
	}
	//Internal_REST_URL_OSF

	//OSFDirection
	public void FilterOSFDirection() throws InterruptedException
	{
		//wait.until(ExpectedConditions.visibilityOf(FilterCalc));
		Thread.sleep(6000);
		FilterCalc.click( );
		Thread.sleep(6000);
		System.out.println("test 12");
	}
	public void OSFDirectionSrch() throws InterruptedException
	{
		//wait.until(ExpectedConditions.visibilityOf(CalNBAStartOffSrch));
		Thread.sleep(6000);
		CalNBAStartOffSrch.clear();
		CalNBAStartOffSrch.sendKeys(OSFDirection);
		Thread.sleep(6000);
		System.out.println("test 13");
	}
	public void ApplayOSFDirection() throws InterruptedException
	{
		//wait.until(ExpectedConditions.visibilityOf(ApplayNBAfilter));
		Thread.sleep(6000);
		ApplayNBAfilter.click( );
		Thread.sleep(6000);
		System.out.println("test 14");
	}
	public void ClikMCCMOSFDirection() throws InterruptedException
	{
		//	wait.until(ExpectedConditions.elementToBeClickable(ClikMCCM));
		 Thread.sleep(2000);
			//	ClikMCCM.click( );
				try {
				     
					ClikMCCM.click();
				}
				catch(org.openqa.selenium.StaleElementReferenceException ex)
				{
				    
					ClikMCCM.click();
				}
				System.out.println("test 15");

	}
	public void OSFDirection() throws InterruptedException
	{
		//wait.until(ExpectedConditions.visibilityOf(CalNBAStartOff));
		Thread.sleep(6000);
		CalNBAStartOff.clear();

		CalNBAStartOff.sendKeys(OSFDirectionValue);
		Thread.sleep(6000);
		System.out.println("test 16");
	}

	public void SaveOSFDirection() throws InterruptedException
	{
		//wait.until(ExpectedConditions.visibilityOf(Save));
		Thread.sleep(6000);
		Save.click( );
		Thread.sleep(6000);
		System.out.println("test 17");
	}
	public void CloseOSFDirection() throws InterruptedException
	{
		//wait.until(ExpectedConditions.visibilityOf(Close));
		Thread.sleep(6000);
		Close.click( );
		Thread.sleep(6000);
		System.out.println("test 18");
	}
	//OSFDirection

	//OSFChannel
	public void FilterOSFChannel() throws InterruptedException
	{
	//	wait.until(ExpectedConditions.visibilityOf(FilterCalc));
		Thread.sleep(6000);
		FilterCalc.click( );
		Thread.sleep(6000);
		System.out.println("test 19");
	}
	public void OSFChannelSrch() throws InterruptedException
	{
	//	wait.until(ExpectedConditions.visibilityOf(CalNBAStartOffSrch));
		Thread.sleep(6000);
		CalNBAStartOffSrch.clear();
		CalNBAStartOffSrch.sendKeys(OSFChannel);
		Thread.sleep(6000);
		System.out.println("test 20");
	}
	public void ApplayOSFChannel() throws InterruptedException
	{
		//wait.until(ExpectedConditions.visibilityOf(ApplayNBAfilter));
		Thread.sleep(6000);
		ApplayNBAfilter.click( );
		Thread.sleep(6000);
		System.out.println("test 21");
	}
	public void ClikMCCMOSFChannel() throws InterruptedException
	{
		//wait.until(ExpectedConditions.elementToBeClickable(ClikMCCM));
		  Thread.sleep(2000);
		//	ClikMCCM.click( );
			try {
			     
				ClikMCCM.click();
			}
			catch(org.openqa.selenium.StaleElementReferenceException ex)
			{
			    
				ClikMCCM.click();
			}
			
			System.out.println("test 22");
	}
	public void OSFChannel() throws InterruptedException
	{
	//	wait.until(ExpectedConditions.visibilityOf(CalNBAStartOff));
		Thread.sleep(6000);
		CalNBAStartOff.clear();

		CalNBAStartOff.sendKeys(OSFChannelValue);
		Thread.sleep(6000);
		System.out.println("test 23");
	}

	public void SaveOSFChannel() throws InterruptedException
	{
		//wait.until(ExpectedConditions.visibilityOf(Save));
		Thread.sleep(6000);
		Save.click( );
		Thread.sleep(6000);
		System.out.println("test 24");
	}
	public void CloseOSFChannel() throws InterruptedException
	{
		//wait.until(ExpectedConditions.visibilityOf(Close));
		Thread.sleep(6000);
		Close.click( );
		Thread.sleep(6000);
		System.out.println("test 25");
	}
	//OSFChannel

	//OSFContainerName
	public void FilterOSFContainerName() throws InterruptedException
	{
	//	wait.until(ExpectedConditions.visibilityOf(FilterCalc));
		Thread.sleep(6000);
		FilterCalc.click( );
		Thread.sleep(6000);
		System.out.println("test 26");
	}
	public void OSFContainerNameSrch() throws InterruptedException
	{
		//wait.until(ExpectedConditions.visibilityOf(CalNBAStartOffSrch));
		Thread.sleep(6000);
		CalNBAStartOffSrch.clear();
		CalNBAStartOffSrch.sendKeys(OSFContainerName);
		Thread.sleep(6000);
		System.out.println("test 27");
	}
	public void ApplayOSFContainerName() throws InterruptedException
	{
		//wait.until(ExpectedConditions.visibilityOf(ApplayNBAfilter));
		Thread.sleep(6000);
		ApplayNBAfilter.click( );
		Thread.sleep(6000);
		System.out.println("test 28");
	}
	public void ClikMCCMOSFContainerName() throws InterruptedException
	{
		//wait.until(ExpectedConditions.elementToBeClickable(ClikMCCM));
		  Thread.sleep(2000);
		//	ClikMCCM.click( );
			try {
			     
				ClikMCCM.click();
			}
			catch(org.openqa.selenium.StaleElementReferenceException ex)
			{
			    
				ClikMCCM.click();
			}
			System.out.println("test 29");
	}
	public void OSFContainerName() throws InterruptedException
	{
	//	wait.until(ExpectedConditions.visibilityOf(CalNBAStartOff));
		Thread.sleep(6000);
		CalNBAStartOff.clear();

		CalNBAStartOff.sendKeys(OSFContainerNameValue);
		Thread.sleep(6000);
		System.out.println("test 30");
	}

	public void SaveOSFContainerName() throws InterruptedException
	{
	//	wait.until(ExpectedConditions.visibilityOf(Save));
		Thread.sleep(6000);
		Save.click( );
		Thread.sleep(6000);
		System.out.println("test 31");
	}
	public void CloseOSFContainerName() throws InterruptedException
	{
		//wait.until(ExpectedConditions.visibilityOf(Close));
		Thread.sleep(6000);
		Close.click( );
		Thread.sleep(6000);
		System.out.println("test 32");
	}
	//OSFContainerName
	
	//OSFSClassificationDefaultValue
		public void FilterOSFSClassificationDefaultValue() throws InterruptedException
		{
		//	wait.until(ExpectedConditions.visibilityOf(FilterCalc));
			Thread.sleep(6000);
			FilterCalc.click( );
			Thread.sleep(6000);
			System.out.println("test 33");
		}
		public void OSFSClassificationDefaultValueSrch() throws InterruptedException
		{
		//	wait.until(ExpectedConditions.visibilityOf(CalNBAStartOffSrch));
			Thread.sleep(6000);
			CalNBAStartOffSrch.clear();
			Thread.sleep(6000);
			CalNBAStartOffSrch.sendKeys(OSFSClassificationDefault);
			Thread.sleep(6000);
			System.out.println("test 34");
		}
		public void ApplayOSFSClassificationDefaultValue() throws InterruptedException
		{
		//	wait.until(ExpectedConditions.visibilityOf(ApplayNBAfilter));
			Thread.sleep(6000);
			ApplayNBAfilter.click( );
			Thread.sleep(6000);
			System.out.println("test 35");
		}
		public void ClikMCCMOSFSClassificationDefaultValue() throws InterruptedException
		{
			//	wait.until(ExpectedConditions.elementToBeClickable(ClikMCCM));
		  Thread.sleep(2000);
		//	ClikMCCM.click( );
			try {
			     
				ClikMCCM.click();
			}
			catch(org.openqa.selenium.StaleElementReferenceException ex)
			{
			    
				ClikMCCM.click();
			}
			
			System.out.println("test 36");
		}
		public void OSFSClassificationDefaultValue() throws InterruptedException
		{
		//	wait.until(ExpectedConditions.visibilityOf(CalNBAStartOff));
			Thread.sleep(6000);
			CalNBAStartOff.clear();

			CalNBAStartOff.sendKeys(OSFSClassificationDefaultValue);
			Thread.sleep(6000);
			System.out.println("test 37");
		}

		public void SaveOSFSClassificationDefaultValue() throws InterruptedException
		{
			//wait.until(ExpectedConditions.visibilityOf(Save));
			Thread.sleep(6000);
			Save.click( );
			Thread.sleep(6000);
			System.out.println("test 38");
		}
		public void CloseOSFSClassificationDefaultValue() throws InterruptedException
		{
			//wait.until(ExpectedConditions.visibilityOf(Close));
			Thread.sleep(6000);
			Close.click( );
			Thread.sleep(6000);
			System.out.println("test 39");
		}
		//OSFSClassificationDefaultValue
		
		// MaxNoOfAcntsForOSFGetNBAPerRqst
				public void FilterOSFMaxNoOfAcntsForOSFGetNBAPerRqst() throws InterruptedException
				{
					//wait.until(ExpectedConditions.visibilityOf(FilterCalc));
					Thread.sleep(6000);
					FilterCalc.click( );
					Thread.sleep(6000);
				}
				public void OSFMaxNoOfAcntsForOSFGetNBAPerRqstSrch() throws InterruptedException
				{
					//wait.until(ExpectedConditions.visibilityOf(CalNBAStartOffSrch));
					Thread.sleep(6000);
					CalNBAStartOffSrch.clear();
					CalNBAStartOffSrch.sendKeys(MaxNoOfAcntsForOSFGetNBAPerRqst);
					Thread.sleep(6000);
					System.out.println("test 40");
				}
				public void ApplayOSFMaxNoOfAcntsForOSFGetNBAPerRqst() throws InterruptedException
				{
				//	wait.until(ExpectedConditions.visibilityOf(ApplayNBAfilter));
					Thread.sleep(6000);
					ApplayNBAfilter.click( );
					Thread.sleep(6000);
				}
				public void ClikMCCMOSFMaxNoOfAcntsForOSFGetNBAPerRqst() throws InterruptedException
				{
					//wait.until(ExpectedConditions.elementToBeClickable(ClikMCCM));
					  Thread.sleep(2000);
					//	ClikMCCM.click( );
						try {
						     
							ClikMCCM.click();
						}
						catch(org.openqa.selenium.StaleElementReferenceException ex)
						{
						    
							ClikMCCM.click();
						}
						
						System.out.println("test 41");
				}
				public void OSFMaxNoOfAcntsForOSFGetNBAPerRqstValue() throws InterruptedException
				{
					//wait.until(ExpectedConditions.visibilityOf(CalNBAStartOff));
					Thread.sleep(6000);
					CalNBAStartOff.clear();

					CalNBAStartOff.sendKeys(MaxNoOfAcntsForOSFGetNBAPerRqstValue);
					Thread.sleep(6000);
				}

				public void SaveOSFMaxNoOfAcntsForOSFGetNBAPerRqst() throws InterruptedException
				{
				//	wait.until(ExpectedConditions.visibilityOf(Save));
					Thread.sleep(6000);
					Save.click( );
					Thread.sleep(6000);
				}
				public void CloseOSFMaxNoOfAcntsForOSFGetNBAPerRqst() throws InterruptedException
				{
				//	wait.until(ExpectedConditions.visibilityOf(Close));
					Thread.sleep(6000);
					Close.click( );
					Thread.sleep(6000);
					System.out.println("test 42");
				}
				
				// MaxNoOfAcntsForOSFGetNBAPerRqst
				
				//OSFGetNBATimeout
				public void FilterOSFGetNBATimeout() throws InterruptedException
				{
				//	wait.until(ExpectedConditions.visibilityOf(FilterCalc));
					Thread.sleep(6000);
					FilterCalc.click( );
					Thread.sleep(6000);
					System.out.println("test 43");
				}
				public void OSFGetNBATimeoutSrch() throws InterruptedException
				{
				//	wait.until(ExpectedConditions.visibilityOf(CalNBAStartOffSrch));
					
					CalNBAStartOffSrch.clear();
					Thread.sleep(6000);
					CalNBAStartOffSrch.sendKeys(OSFGetNBATimeout);
					Thread.sleep(6000);
				}
				public void ApplayOSFGetNBATimeout() throws InterruptedException
				{
					//wait.until(ExpectedConditions.visibilityOf(ApplayNBAfilter));
					Thread.sleep(6000);
					ApplayNBAfilter.click( );
					Thread.sleep(6000);
					System.out.println("test 44");
				}
				public void ClikMCCMOSFGetNBATimeout() throws InterruptedException
				{
					
 				//wait.until(ExpectedConditions.elementToBeClickable(ClikMCCM));
					  Thread.sleep(2000);
					//	ClikMCCM.click( );
						try {
						     
							ClikMCCM.click();
						}
						catch(org.openqa.selenium.StaleElementReferenceException ex)
						{
						    
							ClikMCCM.click();
						}
						

				}
				public void OSFGetNBATimeout() throws InterruptedException
				{
					//wait.until(ExpectedConditions.visibilityOf(CalNBAStartOff));
					Thread.sleep(6000);
					CalNBAStartOff.clear();
					Thread.sleep(6000);
					CalNBAStartOff.sendKeys(OSFGetNBATimeoutValue);
					Thread.sleep(6000);
				}

				public void SaveOSFGetNBATimeout() throws InterruptedException
				{
					//wait.until(ExpectedConditions.visibilityOf(Save));
					Thread.sleep(6000);
					Save.click( );
					Thread.sleep(6000);
				}
				public void CloseOSFGetNBATimeout() throws InterruptedException
				{
					//wait.until(ExpectedConditions.visibilityOf(Close));
					Thread.sleep(6000);
					Close.click( );
					Thread.sleep(6000);
					System.out.println("test 45");
				}
				//OSFGetNBATimeout


				//D_mccmsettings
				public void D_mccmsettings() throws InterruptedException
				{
					//wait.until(ExpectedConditions.visibilityOf(D_mccmsettings));
					Thread.sleep(6000);
					D_mccmsettings.sendKeys(D_mccmsettingsValue);
					Thread.sleep(6000);
				}

				public void SerchClick() throws InterruptedException
				{
				//	wait.until(ExpectedConditions.visibilityOf(SerchClick));
					Thread.sleep(6000);
					SerchClick.click( );
					Thread.sleep(6000);
					System.out.println("test 45");
				}
				public void Clickdmccmsetting() throws InterruptedException
				{
				//	wait.until(ExpectedConditions.visibilityOf(Clickdmccmsetting));
					Thread.sleep(6000);
					Clickdmccmsetting.click( );
					Thread.sleep(6000);
				}
				public void ActionClkDmccmsetting() throws InterruptedException
				{
					//wait.until(ExpectedConditions.visibilityOf(ActionClkDmccmsetting));
					Thread.sleep(6000);
					ActionClkDmccmsetting.click( );
					Thread.sleep(6000);
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


							driver.close();
						}
					}
					driver.switchTo().window(mainWindow);

				}
				//D_mccmsettings




}