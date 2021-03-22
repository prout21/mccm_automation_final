package Mccm.Pega.OSF.PegaTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.testng.Assert;
import org.testng.annotations.Test;

import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.excel.utility.Excel_Reader;


public class OSFAPICallGetNBAMultiAccTest extends TestBase  {

	public static String KeystorePath;
	public static String hostName;
	public static String port;
	public static String Keystorepassword;
	public static String json;


	@Test

	public void VerifyOSFGetNBAMultipleAccountsAPIcallSuccessfully() {

		//   public static void main(String[] args) {

		try {
			//          String hostName="mccm-191102761.eu-central-1.elb.amazonaws.com";
			//          String hostName = "192.57.138.25";
			//          String port = "18576";// 8573


			hostName=general_ReadProperty("NBA_hostName");
			port=general_ReadProperty("NBA_port");
			KeystorePath=general_ReadProperty("KeystorePath");
			Keystorepassword=general_ReadProperty("Keystorepassword");


			URL urlForGetRequest = new URL("https://" + hostName + ":" + port +
					"/prweb/PRRestService/MCCMOSF/Services/GetNBA");


			//	  	URL urlForGetRequest = new URL("https://ukwtsvulx386.elabs.svcs.entsvcs.net:18576/prweb/PRRestService/MCCMOSF/Services/GetNBA");  


			String readLine = null;
			System.setProperty("javax.net.ssl.keyStore",(KeystorePath+"/css1identity.jks"));   
			System.setProperty("javax.net.ssl.keyStorePassword", Keystorepassword);
			System.setProperty("javax.net.ssl.keyStoreType", "JKS");
			System.setProperty("javax.net.ssl.trustStore",(KeystorePath+"/mccminternaltrust.jks"));
			System.setProperty("javax.net.ssl.trustStorePassword", Keystorepassword);
			System.setProperty("javax.net.ssl.trustStoreType", "JKS");


			json = general_ReadProperty("OSF_Json_MultiAcc");


			//   String   json ="{\"Accounts\":[{\"AccountID\":\"1130542249\",\"SI\":\"MobileBAN\"},{\"AccountID\":\"30541253\",\"SI\":\"Cable\"},{\"AccountID\":\"13013453\",\"SI\":\"Fixnet\"}],\"VOID\":\"12345678\",\"SCClassification\":\"SCL\",\"ContainerName\":\"OSF\",\"Channel\":\"OSF\",\"Direction\":\"Inbound\"}";

			// Create all-trusting host name verifier
			HostnameVerifier allHostsValid = new HostnameVerifier() {
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			};

			// Install the all-trusting host verifier
			HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
			HttpsURLConnection connection = (HttpsURLConnection) urlForGetRequest.openConnection();
			connection.setRequestMethod("POST");

			connection.setRequestProperty("x-mccm-usecase", "OSF_GetNBA");
			connection.setRequestProperty("X-MCCM-CorrelationID", "GUID like a45ed-eded");
			connection.setRequestProperty("x-request-id", "GUID like 45656-eade");
			connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");

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
			System.out.println("response: " + response.toString());

			System.out.println(responseCode);

			Assert.assertEquals(responseCode, 200, "Status code is not 200 ,");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

