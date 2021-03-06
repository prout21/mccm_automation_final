package ExecutionUSECase;

import java.io.File;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.testng.TestNG;
import Mccm.Pega.ExtentReportListner.TestListener;
import Mccm.Pega.Outbound.PegaTestBase.TestBase;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;


public class MainClass extends TestBase {

	public static String  TestSuite_UseCase1;
	public static String  TestSuite_UseCase2;
	public static String  TestSuite_UseCase3;
	public static String  TestSuite_UseCase4;
	public static String  TestSuite_UseCase5;

	public static void main(String[] args) throws MalformedURLException {

		TestListener ext = new TestListener();

		TestNG	testNG = new TestNG();

		BasicConfigurator.configure();
		
		// -Dlog4j.configuration=file:///C:/Users/ns32/git/mccm_automation/src/test/resources/Log4j2.xml
		 System.setProperty("log4j.configuration", new File("C:/Users/ns32/git/mccm_automation/src/test/resources", "log4j2.xml").toURL().toString());		
		String projectPath = System.getProperty("user.dir");

		TestSuite_UseCase1 = general_ReadProperty_UseCase("UseCase_Name1");
		TestSuite_UseCase2 = general_ReadProperty_UseCase("UseCase_Name2");
		TestSuite_UseCase3 = general_ReadProperty_UseCase("UseCase_Name3");
		TestSuite_UseCase4 = general_ReadProperty_UseCase("UseCase_Name4");
		TestSuite_UseCase5 = general_ReadProperty_UseCase("UseCase_Name5");


		List<String> suites = new ArrayList<String>();


		suites.add(TestSuite_UseCase1);
		suites.add(TestSuite_UseCase2);
		suites.add(TestSuite_UseCase3);
		suites.add(TestSuite_UseCase4);
		suites.add(TestSuite_UseCase5);



		testNG.setTestSuites(suites);

		testNG.addListener(ext);

		testNG.run();
	}

}
