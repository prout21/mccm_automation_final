package Mccm.Pega.OSF.PegaTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.excel.utility.Excel_Reader;

public class Data_provider_class extends TestBase{
	

	@DataProvider(name = "jsondataCRerror")
	public File[] readjson_CRerror() throws FileNotFoundException
	{
		String projectfolderpath = System.getProperty("user.dir");
		File[] filedata;
		File file = new File(projectfolderpath + "/UseCaseConfigFile/TestData/CaptureResponseError_TestData");
		File[] files = file.listFiles();
		filedata = file.listFiles();
		return filedata;
    }
	

	@DataProvider(name = "jsondataPFerror")
	public File[] readjson_PFerror() throws FileNotFoundException
	{
		String projectfolderpath = System.getProperty("user.dir");
		File[] filedata;
		File file = new File(projectfolderpath + "/UseCaseConfigFile/TestData/ProcessFeedbackError_TestData");
		File[] files = file.listFiles();
		filedata = file.listFiles();
		return filedata;  
    }
	
	

	@DataProvider(name = "jsondataNBAerror")
	public File[] readjson_NBAerror() throws FileNotFoundException
	{
		String projectfolderpath = System.getProperty("user.dir");
		File[] filedata;
		File file = new File(projectfolderpath + "/UseCaseConfigFile/TestData/GetNBAError_TestData");
		File[] files = file.listFiles();
		filedata = file.listFiles();
		return filedata;
	}
	
	@DataProvider(name="files_CR")
	public File[] files_CR() throws IOException
	{
		String projectfolderpath=
				 System.getProperty("user.dir");
		  File[] filedata; 
		  File file = new File(projectfolderpath +"/UseCaseConfigFile/TestData/OSF_CaptureResponse_TestData"); 
		  File[] files = file.listFiles();
		  filedata= file.listFiles(); 
		return filedata;
    }

	
	@DataProvider(name="files_PF")
	public File[] files_PF() throws IOException
	{
		String projectfolderpath=
				 System.getProperty("user.dir");
		  File[] filedata; 
		  File file = new File(projectfolderpath +"/UseCaseConfigFile/TestData/OSF_ProcessFeedback_TestData"); 
		  File[] files = file.listFiles();
		  filedata= file.listFiles(); 
		return filedata;
    }
	
	@DataProvider(name="files_NBA")
	public File[] files_NBA() throws IOException
	{
		String projectfolderpath=
				 System.getProperty("user.dir");
		  File[] filedata; 
		  File file = new File(projectfolderpath +"/UseCaseConfigFile/TestData/OSF_GetNBA_TestData"); 
		  File[] files = file.listFiles();
		  filedata= file.listFiles(); 
		
		 
		return filedata;
    }

	
}
	
	
	
	
	

