package Mccm.Pega.ExtentReportListner;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
 

	public class TestListener implements ITestListener  {
		ExtentReports extent;
		ExtentTest extentTest;
		ExtentTest logger;
		WebDriver driver;
	//	WebDriver driver=null;

		public void onStart(ITestContext context) {
			System.out.println("*** Test Suite " + context.getName() + " started ***");
		}

		public void onFinish(ITestContext context) {
			System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
		}

		public void onTestStart(ITestResult result) {
			System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
			ExtentTestManager.startTest(result.getMethod().getMethodName());
		}

		public void onTestSuccess(ITestResult result) {
			System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
			ExtentTestManager.getTest().log(Status.PASS, "Test passed");
		}

//		public void onTestFailure(ITestResult result) {
//			System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
//			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
//		}

//		public void onTestSkipped(ITestResult result) {
//			System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
//			ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
//		}
		
		public void onTestSkipped(ITestResult result) {
			if(result.getStatus() == ITestResult.SKIP){
				ExtentTestManager.getTest().log(Status.SKIP, "Test Case Skipped is "+result.getName());
				ExtentTestManager.getTest().log(Status.SKIP, "Test Case Skipped is "+result.getThrowable());
		    	System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
			}
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			
			ExtentTestManager.getTest().log(Status.FAIL, "percentage % " + result.SUCCESS_PERCENTAGE_FAILURE);
			System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
		
		}
		public void onTestFailure(ITestResult result) {
		
			if(result.getStatus() == ITestResult.FAILURE){
				ExtentTestManager.getTest().log(Status.FAIL, "Test Case Failed is "+result.getName());
				ExtentTestManager.getTest().log(Status.FAIL, "Test Case Failed is "+result.getThrowable());
				System.out.println("*** Test execution " + result.getMethod().getMethodName() + " Failed...");
				////////////////////
//				ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
//				extentTest.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
//				extentTest.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
// 				ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
				///////////
			//	String screenShotPath;
				
//				try {	
//				 	String screenShotPath = TestListener.getScreenshot(driver, "screenShotName");
//				 	ExtentTestManager.getTest().log(Status.FAIL, "Test Case Failed is "+result.getName());
//				    ExtentTestManager.getTest().log(Status.FAIL, "Test Case Failed is "+result.getThrowable());
//					ExtentTestManager.getTest().log(Status.FAIL, "Snapshot below: " + extentTest.addScreenCapture(screenShotPath));
//				 }catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
 			}	 
	}             
 
		public static String capture(WebDriver driver,String screenShotName) throws IOException
	    {
	        TakesScreenshot ts = (TakesScreenshot)driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        String dest = System.getProperty("user.dir") +"ErrorScreenshots"+screenShotName+".png";
	        File destination = new File(dest);
	        FileUtils.copyFile(source, destination);        
	                     
	        return dest;
	    }
		public static String getScreenshot(WebDriver driver, String screenShotName)  {
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		 
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
	                //after execution, you could see a folder "FailedTestsScreenshots" under src folder
			String destination = ("C:/Users/prout21/git/mccm_automation/TestReport/ScreenShots1.png");
			 try {
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
			
			 } catch (IOException e) {
					e.printStackTrace();
				}
			 return destination;
		}
		 public void onTestFailureScreen(ITestResult result) {
				if(result.getStatus() == ITestResult.FAILURE){
					ExtentTestManager.getTest().log(Status.FAIL, "Test Case Failed is "+result.getName());
					ExtentTestManager.getTest().log(Status.FAIL, "Test Case Failed is "+result.getThrowable());
		    	System.out.println("***** Error "+result.getName()+" test has failed *****");
		    	String methodName=result.getName().toString().trim();
		        ITestContext context = result.getTestContext();
		       WebDriver driver = (WebDriver)context.getAttribute("driver");
		    	takeScreenShot(methodName, driver);
		    }
		 }
		 public void takeScreenShot(String methodName, WebDriver driver) {
			 String filePath = "C:/Users/prout21/git/mccm_automation/TestReport/ScreenShots1.png";
	    	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	         //The below method will save the screen shot in d drive with test method name 
	            try {
				//	FileUtils.copyFile(scrFile, new File(filePath+methodName+".png"));
					FileHandler.copy(scrFile, new File("C:/Users/prout21/git/mccm_automation/TestReport/ScreenShots1.png"));
					System.out.println("***Placed screen shot in "+filePath+" ***");
				} catch (IOException e) {
					e.printStackTrace();
				}
	    }
		 
	}