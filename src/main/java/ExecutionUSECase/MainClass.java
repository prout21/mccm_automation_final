package ExecutionUSECase;

import java.util.ArrayList;
import java.util.List;
import org.testng.TestNG;
import Mccm.Pega.ExtentReportListner.TestListener;
import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
public class MainClass extends TestBase {

	public static void main(String[] args) {
		
		TestListener ext = new TestListener();

		TestNG	testNG = new TestNG();

		List<String> suites = new ArrayList<String>();
		
		suites.add("src/test/resources/TestSuite/RegressionSuite.Outbound.xml");
	
		testNG.setTestSuites(suites);

		testNG.addListener(ext);

		testNG.run();

	}

}
