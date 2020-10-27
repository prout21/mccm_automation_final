package Mccm.Pega.Outbound.PegaTestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Demo.APIRestful.DemoDMPRTNBARestAPIGitTest;
import Mccm.Pega.DMP.RealTime.PegaMarktDMPRealTime;
import Mccm.Pega.Outbound.PegaMain.DBConfigValdtn;
import Mccm.Pega.Outbound.PegaMain.DataLoadDetails;
import Mccm.Pega.Outbound.PegaMain.ExtractChannelFile;
import Mccm.Pega.Outbound.PegaMain.HomePage;
import Mccm.Pega.Outbound.PegaMain.PegaMarketPage;
import Mccm.Pega.Outbound.PegaMain.PegaMrktNBAReSchd;
import Mccm.Pega.Outbound.PegaMain.PegaMrktNBAValuChk;
import Mccm.Pega.Outbound.PegaMain.PreChkNBACampValu;
import Mccm.Pega.Outbound.PegaMain.HomePageDetails;
import Mccm.Pega.Outbound.PegaMain.NBAOutboundValdtn;
//import Mccm.Pega.Outbound.PegaSubClass.HomePageDetails;
import Mccm.Pega.QAUtil.TestUtil;
import Mccm.RESTful.APICall.DMPRTPNBAMobHash;


public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	 public static String CampRunID;

	
	public TestBase()
	{
		try {
			prop=new Properties();
			
			String projectPath = System.getProperty("user.dir");
			
							
	  FileInputStream ip=new FileInputStream(projectPath+"/src/main/java/Mccm/Pega/ConfigPega/Config.properties");
	      prop.load(ip);
		   
	   PegaMarketPage.ExcelFilePath = System.getProperty("user.dir");
	   
	   HomePageDetails.ExcelFilePath = System.getProperty("user.dir");
	   
	   PegaMarktDMPRealTime.ExcelFilePath = System.getProperty("user.dir");
	   
	   DataLoadDetails.ExcelFilePath = System.getProperty("user.dir");
	   
	   DBConfigValdtn.ExcelFilePath = System.getProperty("user.dir");
	   
	   ExtractChannelFile.ExcelFilePath = System.getProperty("user.dir");
	   
	   NBAOutboundValdtn.ExcelFilePath = System.getProperty("user.dir");
	   
	   PegaMrktNBAValuChk.ExcelFilePath = System.getProperty("user.dir");
	   
	   PreChkNBACampValu.ExcelFilePath = System.getProperty("user.dir");
	   PegaMrktNBAReSchd.ExcelFilePath = System.getProperty("user.dir");
	 
  	      
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}      
	
	}

    public static void initialization() {
    	String browserName = prop.getProperty("browser");
    	String chromedriverPath = prop.getProperty("chromedriver.dir");
    	String chromeDriver = prop.getProperty("chromedriver");
    	String headLessMode = prop.getProperty("headless");
    	if(browserName.equals("chrome")) {
 

   System.setProperty("webdriver.chrome.driver", chromedriverPath + "/" + chromeDriver);


    		String projectPath = System.getProperty("user.dir");

  // System.setProperty("webdriver.chrome.driver", projectPath+"/chromedriver/chromedriver.exe");  

    	

//    		System.setProperty("java.awt.headless", "false");
     
			if(headLessMode.equals("true")) {
 
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--no-sandbox");
				chromeOptions.addArguments("--disable-dev-shm-usage");
				chromeOptions.addArguments("--headless");
				chromeOptions.addArguments("window-size=1920,1080");
			//	chromeOptions.addArguments("--disable-gpu", "--window-size=1024,768","--ignore-certificate-errors"); 
				driver = new ChromeDriver(chromeOptions);
			}
			else{
				driver = new ChromeDriver();
			}
    	}
    	
      driver.manage().window().maximize();
      driver.manage().deleteAllCookies();
      driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
      driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
      driver.get(prop.getProperty("url"));
    	}
  
  //  chromeOptions.addArguments("--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
  //*******************************************************************************************
  	//*Function:	general_ReadProperty														*
  	//*Arguments:	Property Key as String													 	*
  	//*Return 		Poverty Value as String														*
  	//*Descriptions: 																			*
  	//*	This function will read the Properties file and return property value to based on key.	*
  	//*Author: 														*
  	//*******************************************************************************************
  	public static String general_ReadProperty(String propertyKey)
  	{
  		String propertyValue="";
  		File cfgfile = new File("configurationFile.properties");
  		
  		if(cfgfile.exists())
  		{
  			  Properties propties = new Properties();
  			  FileInputStream propFile;

  			  try {
  				  propFile = new FileInputStream(cfgfile);
  				  propties.load(propFile);
  				  propertyValue=propties.getProperty(propertyKey);
  				  } catch (Exception e1) {
  					  
  					  e1.printStackTrace();
  				  } 
  		 }
  		return propertyValue;
  		
  	    
  }
 }
