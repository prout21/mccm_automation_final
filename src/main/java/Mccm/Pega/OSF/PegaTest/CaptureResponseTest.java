package Mccm.Pega.OSF.PegaTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.Properties;
import java.util.UUID;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Connection.Method;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.sun.jersey.json.impl.provider.entity.JSONObjectProvider;

import Mccm.Pega.Outbound.PegaTestBase.TestBase;





public class CaptureResponseTest extends TestBase {
	public static String KeystorePath;

	public static String Keystorepassword;
	public static String json;
	public static String mccminternaltrust;
	public static String css1identity;
	public static String OSF_URL_CR,hostName,port;
	public static String Header1, Header2, Header3, Header4;
	public static String header_value1, header_value2, header_value3;

	public static Logger log = LogManager.getLogger(CaptureResponseTest.class.getName());

	
	@Test(dataProviderClass = Data_provider_class.class, dataProvider = "files_CR")

	public void OSFCaptureResponse_APIcall(File file) {

		try {
			String projectfolderpath= System.getProperty("user.dir");
			
			File filePath= file;
		//	String j1= j.toString();
		//	System.out.println(j1);
		/*	jsondata data1= new jsondata();
			Object json1 = data1.CRdata();
			String json= json1.toString();
			System.out.println(json); */
			
			JSONObject jobj=	(JSONObject) new JSONParser().parse(new FileReader(filePath));
			String json= jobj.toJSONString();
			String json2= json.toString();
			UUID uuid1 = UUID.randomUUID();
			String uuid = uuid1.toString();
			UUID uuid2 = UUID.randomUUID();
			String uuid3 = uuid2.toString();
			log.info(" {} : OSF Capture Response API call Started", uuid);
			KeystorePath = general_ReadProperty("KeystorePath");
			Keystorepassword = general_ReadProperty("Keystorepassword");
			hostName=general_ReadProperty("HTTPS_OSF_HOSTNAME");
			port=general_ReadProperty("HTTPS_OSF_PORT");
			mccminternaltrust = general_ReadProperty("KEYSTORE_TRUST_FILENAME");
			css1identity = general_ReadProperty("KEYSTORE_CLIENT_FILENAME");
			//OSF_URL_CR = general_ReadProperty("OSFCR_URL");
			Header1 = general_ReadProperty("Header1");
			header_value1 = general_ReadProperty("header_value1");
			Header2 = general_ReadProperty("Header2");
			header_value2 = general_ReadProperty("header_value_CR");
			Header3 = general_ReadProperty("Header3");
			header_value3 = general_ReadProperty("header_value3");
			Header4 = general_ReadProperty("Header4");
			//hostName=general_ReadProperty("HTTPS_OSF_HOSTNAME");
		//	port=general_ReadProperty("HTTPS_OSF_PORT");
			URL url = new URL("https://" + hostName + ":" + port +
					"/prweb/PRRestService/MCCMOSF/Services/CaptureResponse");
			//String url1= "https://" +hostName + ":" +port + "/prweb/PRRestService/MCCMOSF/Services/CaptureResponse";
			//URL url = new URL(OSF_URL_CR);
			log.debug(" {} : [API URL] :{}" ,uuid,url); 
			String readLine = null;
			System.setProperty("javax.net.ssl.keyStore", (KeystorePath + "/css1identity.jks"));
			System.setProperty("javax.net.ssl.keyStorePassword", Keystorepassword);
			System.setProperty("javax.net.ssl.keyStoreType", "JKS");
			System.setProperty("javax.net.ssl.trustStore", (KeystorePath +"/mccminternaltrust.jks"));
			System.setProperty("javax.net.ssl.trustStorePassword", Keystorepassword);
			System.setProperty("javax.net.ssl.trustStoreType", "JKS");

			// Create all-trusting host name verifier

			HostnameVerifier allHostsValid = new HostnameVerifier() {
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			};

			// Install the all-trusting host verifier
			HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty(Header2, header_value2);
			connection.setRequestProperty(Header4, uuid);
			connection.setRequestProperty(Header1, uuid3);
			connection.setRequestProperty(Header3, header_value3);
			log.debug(" {} : [HTTP Request Headers] : {} = {}" ,uuid, Header1 , uuid3);
			log.debug(" {} : [HTTP Request Headers] : {} = {}" ,uuid, Header2 , header_value2);
			log.debug(" {} : [HTTP Request Headers] : {} = {}" ,uuid,Header3 , header_value3);
			log.debug(" {} : [HTTP Request Headers] : {} = {}", uuid, Header4 , uuid);
			//json = data.getAsJsonObject().toString();
			log.debug(" {} : [Request Payload] :{} ", uuid, json);
			StringBuffer response = new StringBuffer();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			OutputStream os = connection.getOutputStream();
			os.write(json.getBytes());
			os.flush();
			os.close();
			int responseCode = connection.getResponseCode();
			BufferedReader in = null;
			if (responseCode == 200)
				in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			else
				in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
			while ((readLine = in.readLine()) != null) {
				response.append(readLine);
			}
			in.close();

			log.debug(" {} : [Response Payload] : {}  " , uuid, response.toString());
			log.debug(" {} : [HTTP Response Code] : {}   " , uuid,  responseCode);
			Assert.assertEquals(responseCode, 200, "Status code is not 200 ");
			log.info(" {} : OSF Capture Response API call Completed", uuid);
			log.info("           **************          ");

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	
}
