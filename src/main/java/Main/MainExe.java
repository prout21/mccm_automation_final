package Main;

import org.testng.TestNG;

import Mccm.Pega.ExtentReportListner.TestListener;

public class MainExe {

	public static void main(String[] args) {
		 try {
 	 		
			 TestNG	testNG = new TestNG();

			testNG.setTestClasses(new Class[] {Main.class});
			 
		 	testNG.run();

	    	 }catch(Exception e) {
	    		 
	    	 }
	}

}
