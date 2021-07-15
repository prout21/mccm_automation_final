package Mccm.Pega.OSF.PegaTest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.stream.Stream;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sun.tools.sjavac.Log;
import com.sun.xml.fastinfoset.sax.Properties;

//import com.sun.tools.sjavac.Log;

import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.excel.utility.Excel_Reader;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;

public class OSF_API_ErrorCasesTest extends TestBase {

	public static String KeystorePath;
	public static String hostName;
	public static String port;
	public static String Keystorepassword;
	public static String json;
	public static String ExcelFilePath;
	public static String OSF_URL_CR;
	public static String OSF_URL_PF;
	public static String OSF_URL_NBA;
	public static String Header;
	public static String header_value;
	public static Logger log = LogManager.getLogger(TestBase.class.getName());
	DataFormatter formatter = new DataFormatter();

	
	
	@Test(dataProviderClass = Data_provider_class.class,dataProvider = "exceldata")

	public void VerifyOSFOutcomeAPIcallSuccessfully(String URL ,String json1) throws IOException {

		log.info("**** Capturing the NBA_Hostname , NBA_PORT , Keystorepath , Keystorepassword ****");
		hostName = general_ReadProperty("NBA_hostName");
		port = general_ReadProperty("NBA_port");
		KeystorePath = general_ReadProperty("KeystorePath");
		Keystorepassword = general_ReadProperty("Keystorepassword");

		log.info("**** Getting the OSF  URL  ****");
		log.info("OSF API Call URL :  " +URL);
		System.out.println("OSF API Call URL :" + URL);
		OSF_URL_CR= general_ReadProperty("OSFCR_URL");
		OSF_URL_PF= general_ReadProperty("OSFPF_URL");
		OSF_URL_NBA= general_ReadProperty("OSFNBA_URL");
		Excel_Reader obj = new Excel_Reader(ExcelFilePath + "/UseCaseConfigFile/TestData/OSF_Error_Scenarios.xlsx");
       	URL url = new URL(URL);
		URL OSF_URL_CR1 = new URL(OSF_URL_CR);
		URL OSF_URL_PF1 = new URL(OSF_URL_PF);
		URL OSF_URL_NBA1 = new URL(OSF_URL_NBA);
		String readLine = null;
		System.setProperty("javax.net.ssl.keyStore", (KeystorePath + "/css1identity.jks"));
		
		System.setProperty("javax.net.ssl.keyStorePassword", Keystorepassword);
		System.setProperty("javax.net.ssl.keyStoreType", "JKS");
		System.setProperty("javax.net.ssl.trustStore", (KeystorePath + "/mccminternaltrust.jks"));
		
		System.setProperty("javax.net.ssl.trustStorePassword", Keystorepassword);
		System.setProperty("javax.net.ssl.trustStoreType", "JKS");

		log.info("-----Reading the OSF Request file------");

		json = json1;
		System.out.println("json file is:" + json);

		log.info("-----Successfully read the OSF  Request file------");

		// Create all-trusting host name verifier

		HostnameVerifier allHostsValid = new HostnameVerifier() {
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		};

		// Install the all-trusting host verifier
		HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setRequestMethod("POST");
		String header1= obj.getCellValue("Headers", 1, 0);
		String header2= obj.getCellValue("Headers", 2, 0);
		String header3= obj.getCellValue("Headers", 3, 0);
		String header4= obj.getCellValue("Headers", 4, 0);
	
		if (url.equals(OSF_URL_CR1))
		{
		String header_value1= obj.getCellValue("Headers", 1, 1);
		String header_value2= obj.getCellValue("Headers", 2, 1);
		String header_value3= obj.getCellValue("Headers", 3, 1);
		String header_value4= obj.getCellValue("Headers", 4, 1);
		
		connection.setRequestProperty(header1, header_value1);
		connection.setRequestProperty(header2, header_value2);
		connection.setRequestProperty(header3, header_value3);
		connection.setRequestProperty(header4, header_value4);
		}
		
		else if (url.equals(OSF_URL_PF1))
		{
			String header_value1= obj.getCellValue("Headers", 1, 2);
			String header_value2= obj.getCellValue("Headers", 2, 2);
			String header_value3= obj.getCellValue("Headers", 3, 2);
			String header_value4= obj.getCellValue("Headers", 4, 2);
			
			connection.setRequestProperty(header1, header_value1);
			connection.setRequestProperty(header2, header_value2);
			connection.setRequestProperty(header3, header_value3);
			connection.setRequestProperty(header4, header_value4);
			
		}

		else if (url.equals(OSF_URL_NBA1))
		{
			String header_value1= obj.getCellValue("Headers", 1, 3);
			String header_value2= obj.getCellValue("Headers", 2, 3);
			String header_value3= obj.getCellValue("Headers", 3, 3);
			String header_value4= obj.getCellValue("Headers", 4, 3);
			
			connection.setRequestProperty(header1, header_value1);
			connection.setRequestProperty(header2, header_value2);
			connection.setRequestProperty(header3, header_value3);
			connection.setRequestProperty(header4, header_value4);
			
			
		}
		
		else
		{
			
			System.out.println("No Headers listed ");
		}
		
		OutputStream os = connection.getOutputStream();
		os.write(json.getBytes());
		os.flush();
		os.close();
		int responseCode = connection.getResponseCode();
		System.out.println("response code is " + responseCode);
		BufferedReader in = null;
		StringBuffer response = new StringBuffer();

		if (responseCode == 200)
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		else
			in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
		while ((readLine = in.readLine()) != null) {
			response.append(readLine);
		}
		in.close();

		System.out.println("response: " + response.toString());
		log.info("response: " + response.toString());
		log.info(+responseCode);
		Assert.assertEquals(responseCode, 400, "Status code is not 200 ,");

	}



    

}
