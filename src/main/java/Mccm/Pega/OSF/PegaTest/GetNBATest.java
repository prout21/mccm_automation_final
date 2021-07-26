package Mccm.Pega.OSF.PegaTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.JsonNode;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Connection.Method;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.mongodb.util.JSON;
import com.sun.jersey.json.impl.provider.entity.JSONObjectProvider;

import Mccm.Pega.Outbound.PegaTestBase.TestBase;




public class GetNBATest extends TestBase {
	public static String KeystorePath;

	public static String Keystorepassword;
	public static String json;
	public static String mccminternaltrust;
	public static String css1identity;
	public static String OSF_URL_NBA, OSF_URL_CR, OSF_URL_PF;
	public static String Header1, Header2, Header3, Header4;
	public static String header_value1, header_value2, header_value3;
	JsonElement jsonvalue1= null;
	StringBuffer response;

	public static Logger log = LogManager.getLogger(GetNBATest.class.getName());


	@SuppressWarnings("unchecked")
	@Test(dataProviderClass = Data_provider_class.class, dataProvider = "files_NBA")
	public void OSFGetNBA_APIcall(File file){
		
		try {
			String projectfolderpath= System.getProperty("user.dir");
		/*	jsondata data1= new jsondata();
			Object json1 = data1.NBAdata();
			String json= json1.toString();
			System.out.println(json); */
				
			File filePath=file;
			JSONObject jobj=(JSONObject) new JSONParser().parse(new FileReader(filePath));
			String json= jobj.toJSONString();
			UUID uuid1 = UUID.randomUUID();
			String uuid = uuid1.toString();
			UUID uuid2 = UUID.randomUUID();
			String uuid3 = uuid2.toString();
			log.info(" {} : OSF GetNBA API call Started", uuid);
			KeystorePath = general_ReadProperty("KeystorePath");
			Keystorepassword = general_ReadProperty("Keystorepassword");
			mccminternaltrust = general_ReadProperty("KEYSTORE_TRUST_FILENAME");
			css1identity = general_ReadProperty("KEYSTORE_CLIENT_FILENAME");
			OSF_URL_NBA = general_ReadProperty("OSFNBA_URL");
			Header1 = general_ReadProperty("Header1");
			header_value1 = general_ReadProperty("header_value1");
			Header2 = general_ReadProperty("Header2");
			header_value2 = general_ReadProperty("header_value_NBA");
			Header3 = general_ReadProperty("Header3");
			header_value3 = general_ReadProperty("header_value3");
			Header4 = general_ReadProperty("Header4");
			URL url = new URL(OSF_URL_NBA);
			log.debug(" {} : [API URL] :{}" ,uuid,url); 
			String readLine = null;
			System.setProperty("javax.net.ssl.keyStore", (KeystorePath + css1identity));
			System.setProperty("javax.net.ssl.keyStorePassword", Keystorepassword);
			System.setProperty("javax.net.ssl.keyStoreType", "JKS");
			System.setProperty("javax.net.ssl.trustStore", (KeystorePath + mccminternaltrust));
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
			response = new StringBuffer();
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

			// reading NBA multiple accounts
			JsonObject obj1 = (JsonObject) new JsonParser().parse(response.toString());
			JsonArray arr = obj1.getAsJsonArray("RankedResults");
			JsonObject data1 = arr.get(0).getAsJsonObject();
			jsonvalue1 = data1.get("InteractionID");
			String str = jsonvalue1.getAsString();
			// System.out.println( jsonvalue1.getAsJsonObject().toString());
			String jsonvalue = str.toString().trim();

			// captureresponse
			File filecapt = new File(projectfolderpath + "/UseCaseConfigFile/TestData/OSF_CaptureResponse_TestData");
			File[] files = filecapt.listFiles();
			for (File f : files) {
				String filecr = f.toString();
				JSONObject jobj1 = (JSONObject) new JSONParser().parse(new FileReader(filecr));
				// String json1= jobj1.toJSONString();
				String id_cr = jobj1.get("InteractionID").toString();
				// System.out.println(id);
				jobj1.replace("InteractionID", id_cr, jsonvalue);
				String id_str = jobj1.get("InteractionID").toString();
				// System.out.println(id1);
				String json1 = jobj1.toJSONString();
				FileWriter file_capt = new FileWriter(filecr);
				file_capt.write(jobj1.toJSONString());
				file_capt.close();

			}
		
			// processfeedback
			File fileproc = new File(projectfolderpath + "/UseCaseConfigFile/TestData/OSF_ProcessFeedback_TestData");
			File[] files1 = fileproc.listFiles();
			for (File f : files1) {
				String filepf = f.toString();
				JsonObject jobj2 = (JsonObject) new JsonParser().parse(new FileReader(filepf));
				JsonArray arr1 = jobj2.getAsJsonArray("RankedResults");
			//	System.out.println(arr1.size());
				for (int i = 0; i < arr1.size(); i++) {

					JsonObject datavalue = arr1.get(i).getAsJsonObject();
					JsonElement jsonvalue2 = datavalue.get("InteractionID");
					String str1 = jsonvalue2.getAsString();
					str1.toString().trim();
					datavalue.addProperty("InteractionID", jsonvalue);
					JsonElement newvalueelement = datavalue.get("InteractionID");
					String newvalue = newvalueelement.getAsString();
					newvalue.toString().trim();
					String newjson = datavalue.toString();

				}
				FileWriter file_procc = new FileWriter(filepf);
				file_procc.write(jobj2.toString());
				file_procc.close();

			}	
			log.debug(" {} : [Response Payload] : {}  " , uuid, response.toString());
			log.debug(" {} : [HTTP Response Code] : {}   " , uuid,  responseCode);
			Assert.assertEquals(responseCode, 200, "Status code is not 200 ");
			log.info(" {} : OSF GetNBA API call Completed", uuid);
			log.info("           **************          ");

		
	}catch (Exception e) {
		e.printStackTrace();
	}

		
	}
	
	
}
