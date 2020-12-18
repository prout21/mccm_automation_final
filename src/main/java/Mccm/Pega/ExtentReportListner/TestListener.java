package Mccm.Pega.ExtentReportListner;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

	public class TestListener implements ITestListener {
		ExtentReports extent;
		ExtentTest extentTest;
		ExtentTest logger;
		WebDriver driver;

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

		public void onTestSkipped(ITestResult result) {
			System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
			ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
		
		}
		public void onTestFailure(ITestResult result) {
			if(result.getStatus() == ITestResult.FAILURE){
				ExtentTestManager.getTest().log(Status.FAIL, "Test Case Failed is "+result.getName());
				ExtentTestManager.getTest().log(Status.FAIL, "Test Case Failed is "+result.getThrowable());
//				ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
//				extentTest.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
//				extentTest.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
				System.out.println("*** Test execution " + result.getMethod().getMethodName() + " Failed...");
// 				ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
	}
}
	}