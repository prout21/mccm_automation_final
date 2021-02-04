package ExecutionUSECase;

import java.util.ArrayList;
import java.util.List;
import org.testng.TestNG;
import Mccm.Pega.ExtentReportListner.TestListener;
import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;


public class MainClass extends TestBase {
	
	public static String  TestSuite_UseCase;

	public static void main(String[] args) {
		
		TestListener ext = new TestListener();

		TestNG	testNG = new TestNG();
		
		String projectPath = System.getProperty("user.dir");
		
		 TestSuite_UseCase = general_ReadProperty_UseCase("UseCase_Name");

		List<String> suites = new ArrayList<String>();
		
<<<<<<< HEAD
		suites.add(TestSuite_UseCase);
=======
	//	suites.add("src/test/resources/TestSuite/RegressionSuite.Outbound.xml");
		
	//suites.add(projectPath+/TestSuite_UseCase);
		
    	suites.add(TestSuite_UseCase);
>>>>>>> 6484e311590698076ae14e4fbc992554e5e9ae5f
	
		testNG.setTestSuites(suites);

		testNG.addListener(ext);

		testNG.run();

	}

}
