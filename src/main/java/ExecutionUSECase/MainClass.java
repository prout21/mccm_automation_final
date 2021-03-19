package ExecutionUSECase;

import java.util.ArrayList;
import java.util.List;
import org.testng.TestNG;
import Mccm.Pega.ExtentReportListner.TestListener;
import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;


public class MainClass extends TestBase {

	public static String  TestSuite_UseCase1;
	public static String  TestSuite_UseCase2;
	public static String  TestSuite_UseCase3;
	public static String  TestSuite_UseCase4;
	public static String  TestSuite_UseCase5;

	public static void main(String[] args) {

		TestListener ext = new TestListener();

		TestNG	testNG = new TestNG();

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
