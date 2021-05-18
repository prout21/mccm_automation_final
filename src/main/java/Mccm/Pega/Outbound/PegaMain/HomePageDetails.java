package Mccm.Pega.Outbound.PegaMain;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.QAUtil.TestUtil;
import Mccm.Pega.excel.utility.Excel_Reader;

public class HomePageDetails extends TestBase {
	
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
	WebElement NBABatchCampaign;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement Save;
	
	@FindBy(xpath="//*[@class='pi pi-close-circle']")
	WebElement Close;
	
	@FindBy(xpath="/html[1]/body[1]/div[3]/form[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[1]/th[2]/div[1]/span[1]/a[1]")
	WebElement FilterNotifyErrList;
	
	@FindBy(xpath="//input[@type='text'][@name='$PpyFilterCriteria_pgRepPgSubSectionpzViewInstancesB_pxResults_pzViewInstances_1$ppyColumnFilterCriteria$gpyPurpose2$ppySearchText']")
	WebElement NotifyErrList;
	
	@FindBy(xpath="//text()[.='Apply']/ancestor::button[1]")
	WebElement ApplayNotifyErr;
	
	@FindBy(xpath="//input[@type='text'][@name='$PRH_1$ppySetting']")
	WebElement MailNotifyErr;
	
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
	
	@FindBy(xpath="//input[@type='text'][@name='$PpyDisplayHarness$ppySearchText']")
	WebElement OverrideCampSrch;
	
	@FindBy(xpath="//*[@class='pi pi-search-2']")
	WebElement OverrideCampSrchClk;

	@FindBy(xpath="//a[text()='OverrideCampaignBlockers']")
	WebElement OverrideCampBlockrClk;
	 
	@FindBy(xpath="//*[@class='pi pi-caret-down margin-l-1x']")
	WebElement OverrideCampActClk;
	
	 
	@FindBy(xpath="(//text()[.='Run']/ancestor::a[1])[2]")
	WebElement RunOverideBlkClk;
	
	@FindBy(xpath="//input[@type='text'][@name='$PD_pzRunRecord$ppxRunWindow$gTABTHREAD2$ppxRunParameters$ppxResults$l1$ppyValue']")
	WebElement OverridCampBlk;
	
	@FindBy(xpath="(//div[@class='pzbtn-mid'])[3]")
	WebElement RunOverideBlk;
	
	
   
	
	
	Excel_Reader obj= new Excel_Reader(ExcelFilePath+"/UseCaseConfigFile/TestData/PegaTestData.xlsx");
			
	String NBACampaignNmValue = obj.getCellValue("PegaTestData", 1, 1);
	
	String NBABthCmpignValue = obj.getCellValue("PegaTestData", 1, 2);
	
	String NotifyErrListValue = obj.getCellValue("PegaTestData", 1, 3);
	
	String MailNotifyErrValue = obj.getCellValue("PegaTestData", 1, 4);
	
	String D_mccmsettingsValue = obj.getCellValue("PegaTestData", 1, 5);
	
	String OverrideCampSrchValue = obj.getCellValue("PegaTestData", 1, 6);
	
	String OverridCampBlkvalue = obj.getCellValue("PegaTestData", 1, 7);
	
	String NBACampDefaultAudienceCountValue = obj.getCellValue("PegaTestData", 1, 11);
	
	String NBACampMaxAudThresholdPercentValue = obj.getCellValue("PegaTestData", 1, 18);
	
	String NBACampMinAudThresholdPercentValue = obj.getCellValue("PegaTestData", 1, 19);
	
	String NBACampDefaultAudCountName = obj.getCellValue("PegaTestData", 1, 20);
	
	String NBACampMaxAudThresholdPercentName = obj.getCellValue("PegaTestData", 1, 21);
	
	String NBACampMinAudThresholdPercentName = obj.getCellValue("PegaTestData", 1, 22);
	
	
	
	
	public HomePageDetails( ) {
    	PageFactory.initElements(driver, this);
    }
	
	public void Recordclk() throws InterruptedException
	{
		//wait.until(ExpectedConditions.visibilityOf(Recordclk));
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
		wait.until(ExpectedConditions.visibilityOf(webelement4));
		webelement4.click( );
		 
	}
	 //NBANBACampaignName
	public void FilterNBAcamp() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(FilterNBAcamp));
		FilterNBAcamp.click( );
		 
	}
	public void NBACampaignName() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(NBACampaignName));
		NBACampaignName.sendKeys(NBACampaignNmValue);
        
	}
	public void ApplayNBAfilter() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(ApplayNBAfilter));
		ApplayNBAfilter.click( );
        
	}
	public void ClikMCCM() throws InterruptedException
	{
	//	wait.until(ExpectedConditions.elementToBeClickable(ClikMCCM));
		Thread.sleep(1000);
		ClikMCCM.click( );
        
	}
	public void NBABatchCampaign() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(NBABatchCampaign));
		NBABatchCampaign.clear();
		
		NBABatchCampaign.sendKeys(NBABthCmpignValue);
         
	}
	
	public void SaveNBABatchCamp() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(Save));
		Save.click( );
        
	}
	public void CloseNBABatchCamp() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(Close));
		Close.click( );
         
	}
	 //NBANBACampaignName
	
	 //NBADefultAudCount
		public void FilterNBADefultAudCount() throws InterruptedException
		{
			wait.until(ExpectedConditions.visibilityOf(FilterNotifyErrList));
			FilterNotifyErrList.click( );
			 
		}
		public void NBADefultAudCountName() throws InterruptedException
		{
			wait.until(ExpectedConditions.visibilityOf(NBACampaignName));
			NBACampaignName.clear();
			 
			NBACampaignName.sendKeys(NBACampDefaultAudCountName);
	        
		}
		public void ApplayNBADefultAudCountfilter() throws InterruptedException
		{
			wait.until(ExpectedConditions.visibilityOf(ApplayNBAfilter));
			ApplayNBAfilter.click( );
	        
		}
		public void ClikMCCMDefultAudCount() throws InterruptedException
		{
		//	wait.until(ExpectedConditions.visibilityOf(ClikMCCM));
			Thread.sleep(1000);
			ClikMCCM.click( );
	         
		}
		public void NBADefultAudCountValue() throws InterruptedException
		{
			wait.until(ExpectedConditions.visibilityOf(NBABatchCampaign));
			NBABatchCampaign.clear();
			 
			NBABatchCampaign.sendKeys(NBACampDefaultAudienceCountValue);
	        
		}
		
		public void SaveDefultAudCount() throws InterruptedException
		{
			wait.until(ExpectedConditions.visibilityOf(Save));
			Save.click( );
	        
		}
		public void CloseDefultAudCount() throws InterruptedException
		{
			wait.until(ExpectedConditions.visibilityOf(Close));
			Close.click( );
	        
		}
		 //NBADefultAudCount
		
		 //NBADefultMaxAudCountPercentage
		public void FilterMaxAudThresholdPercent() throws InterruptedException
		{
			wait.until(ExpectedConditions.visibilityOf(FilterNotifyErrList));
			FilterNotifyErrList.click( );
			 
		}
		public void NBACampMaxAudThresholdPercentName() throws InterruptedException
		{
			wait.until(ExpectedConditions.visibilityOf(NBACampaignName));
			NBACampaignName.clear();
			 
			NBACampaignName.sendKeys(NBACampMaxAudThresholdPercentName);
	        
		}
		public void ApplayMaxAudThresholdPercentfilter() throws InterruptedException
		{
			wait.until(ExpectedConditions.visibilityOf(ApplayNBAfilter));
			ApplayNBAfilter.click( );
	         
		}
		public void ClikMCCMMaxAudThresholdPercent() throws InterruptedException
		{
		//	wait.until(ExpectedConditions.visibilityOf(ClikMCCM));
			Thread.sleep(1000);
			ClikMCCM.click( );
	       
		}
		public void NBAMaxAudThresholdPercentValue() throws InterruptedException
		{
			wait.until(ExpectedConditions.visibilityOf(NBABatchCampaign));
			NBABatchCampaign.clear();
		
			NBABatchCampaign.sendKeys(NBACampMaxAudThresholdPercentValue);
	       
		}
		
		public void SaveMaxAudThresholdPercent() throws InterruptedException
		{
			wait.until(ExpectedConditions.visibilityOf(Save));
			Save.click( );
	        
		}
		public void CloseMaxAudThresholdPercent() throws InterruptedException
		{
			wait.until(ExpectedConditions.visibilityOf(Close));
			Close.click( );
	       
		}
	 
		 //NBADefultMaxAudCountPercentage
//		<--------------------------------------------->
		
		 //NBADefultMaxAudCountPercentage
		public void FilterMinAudThresholdPercent() throws InterruptedException
		{
			wait.until(ExpectedConditions.visibilityOf(FilterNotifyErrList));
			FilterNotifyErrList.click( );
			
		}
		public void NBACampMinAudThresholdPercentName() throws InterruptedException
		{
			wait.until(ExpectedConditions.visibilityOf(NBACampaignName));
			NBACampaignName.clear();
			
			NBACampaignName.sendKeys(NBACampMinAudThresholdPercentName);
	        
		}
		public void ApplayMinAudThresholdPercentfilter() throws InterruptedException
		{
			wait.until(ExpectedConditions.visibilityOf(ApplayNBAfilter));
			ApplayNBAfilter.click( );
	       
		}
		public void ClikMCCMMinAudThresholdPercent() throws InterruptedException
		{
		//	wait.until(ExpectedConditions.visibilityOf(ClikMCCM));
			Thread.sleep(1000);
			ClikMCCM.click( );
	       
		}
		public void NBAMinAudThresholdPercentValue() throws InterruptedException
		{
			wait.until(ExpectedConditions.visibilityOf(NBABatchCampaign));
			NBABatchCampaign.clear();
			
			NBABatchCampaign.sendKeys(NBACampMinAudThresholdPercentValue);
	       
		}
		
		public void SaveMinAudThresholdPercent() throws InterruptedException
		{
			wait.until(ExpectedConditions.visibilityOf(Save));
			Save.click( );
	       
		}
		public void CloseMinAudThresholdPercent() throws InterruptedException
		{
			wait.until(ExpectedConditions.visibilityOf(Close));
			Close.click( );
	        
		}
	 
		 //NBADefultMinAudCountPercentage
//		<--------------------------------------------->
		 //NBANotifyErrList
		
	public void FilterNotifyErrList() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(FilterNotifyErrList));
		FilterNotifyErrList.click( );
		
	}
	
	public void NotifyErrList() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(NotifyErrList));
		NotifyErrList.clear();
		
		NotifyErrList.sendKeys(NotifyErrListValue);
        
	}
	public void ApplayNotifyErr() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(ApplayNotifyErr));
		ApplayNotifyErr.click( );
		
	}
	
	public void ClikMCCMNotifyErr() throws InterruptedException
	{
		//wait.until(ExpectedConditions.visibilityOf(ClikMCCM));
		Thread.sleep(1000);
		ClikMCCM.click( );
        
	}
	
	public void MailNotifyErr() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(MailNotifyErr));
		MailNotifyErr.clear();
		
		MailNotifyErr.sendKeys(MailNotifyErrValue);
        
	}
	
	public void SaveNotifyErrLst() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(Save));
		Save.click( );
       
	}
	public void CloseNotifyErrLst() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(Close));
		Close.click( );
        
	}
	//NBANotifyErrList
	//D_mccmsettings
	public void D_mccmsettings() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(D_mccmsettings));
		D_mccmsettings.sendKeys(D_mccmsettingsValue);
        
	}
	
	public void SerchClick() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(SerchClick));
		SerchClick.click( );
       
	}
	public void Clickdmccmsetting() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(Clickdmccmsetting));
		Clickdmccmsetting.click( );
       
	}
	public void ActionClkDmccmsetting() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(ActionClkDmccmsetting));
		ActionClkDmccmsetting.click( );
       
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
	//OverrideCampSrch
	public void OverrideCampSrch() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(OverrideCampSrch));
		OverrideCampSrch.clear();
		 
		OverrideCampSrch.sendKeys(OverrideCampSrchValue);
        
	}
	
	public void OverrideCampSrchClk() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(OverrideCampSrchClk));
		OverrideCampSrchClk.click( );
        
	}
	
	public void OverrideCampBlockrClk() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(OverrideCampBlockrClk));
		OverrideCampBlockrClk.click( );
        
	}
	public void OverrideCampActClk() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(OverrideCampActClk));
		OverrideCampActClk.click( );
        
	}
	
	public void RunOverideBlkClk() throws InterruptedException
	{
		TestUtil obj=new TestUtil();
		obj.ActionMouseMov(RunOverideBlkClk);
	}

	public void OverridCampBlkRun() throws InterruptedException
	{
	
	String winHandleBefore = driver.getWindowHandle();
    for (String winHandle : driver.getWindowHandles()) {
      // Switch to child window
      driver.switchTo().window(winHandle);
    }
    wait.until(ExpectedConditions.visibilityOf(OverridCampBlk));
     OverridCampBlk.clear();       
	 OverridCampBlk.sendKeys(OverridCampBlkvalue); 
	 
	 wait.until(ExpectedConditions.visibilityOf(RunOverideBlk));
	 RunOverideBlk.click( );
	 Thread.sleep(2000);
	 
	 String winHandleAfter = driver.getWindowHandle();
	 for(String winChildHandle : driver.getWindowHandles()) {
		  // Switch to child window of the 1st child window.
		  if(!winChildHandle.equals(winHandleBefore) 
		  && !winChildHandle.equals(winHandleAfter)) {
		    driver.switchTo().window(winChildHandle);
		   }
		 }
	 Thread.sleep(2000);
	 driver.close();
	 
	 driver.switchTo().window(winHandleAfter);
	 
	  
	// to close the child window.
	driver.close();
	 
	// to switch to parent window.
	driver.switchTo().window(winHandleBefore);
	
}
	//OverrideCampSrch
}