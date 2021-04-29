//import com.jcraft.jsch.ChannelSftp;
package Mccm.Unix.Inbound;


import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class FileExistChk_Inbound_DMP extends App_Inbound_DMP_Test {

ChannelExec channelExec = null;
static Channel channel = null;
public static String TEST_ENV1;
public static String user;
public static String password;
public static String host;
public static XSSFWorkbook wb;
public static String name;

/*
 * static String host = "localhost"; //static String user = "pegat02"; static
 * String user = "mccm02"; static String password = "unix11";
 */
public static String filename;

@Test

public static void main(String[] args) {
	
 //String filename = "file_list_oracle1.lst";
	//pr String[] filename = {"TESTCYCL_1669_Auto2_Validate_DMP_Response_IP_Correct-3"};//, "file_list_oracle.lst";
//pr	String[] filename = {"SCA_cass_20200722010201.csv.gz", "FCA_cass_202007220010201.csv.gz"};//, "file_list_oracle.lst";
	PROJECT_FOLDER_PATH1=general_ReadProperty("PROJECT_FOLDER_PATH");
	/*
	 * ENV_WIKI=general_ReadProperty("ENV_WIKI"); String path=
	 * (PROJECT_FOLDER_PATH1+ENV_WIKI);
	 */
	 TEST_ENV1=general_ReadProperty("TEST_ENV");
	 user=general_ReadProperty("USER_NAME");
	 password=general_ReadProperty("PASSWORD");
	 host=general_ReadProperty("HOST_NAME");
	String  filename  = general_ReadProperty("File_DMP");
	
    String filepath = "/opt/SP/mccm/SYSN/input/DMP/";
  //pr  String filepath = "/opt/SP/mccm/SYSN/mccm_data/csv_cassandrafile/";

    try {
    	    Thread.sleep(2000);
	        Thread.sleep(2000);
        Channel  channel = getChannelSftp(host, user, password);
        channel.connect();
        ChannelSftp channelSftp = (ChannelSftp) channel;
        channelSftp.cd(filepath);
     	//System.out.println("Case 2:");  
         
     	int i;
     	String dir=null;
        String path=null;
		for (i = 0; i < 1; i++) {
			path = channelSftp.ls(filename ).toString();
			 Thread.sleep(2000);
			   Thread.sleep(2000);
		        Thread.sleep(2000);
        if (!path.contains(filename )) {
            System.out.println("File doesn't exist." + filename );
        } else
        	//            System.out.println("");            
           // System.out.println("Case 2: File exist at the path -/opt/SP/mccm/SYSN/mccm_dataload/import/input.---  " + filename);
        dir  = channelSftp.pwd().toString();
        System.out.println("File: " + filename  + " exist at the path ---  " + dir);        
           // System.out.println("---  " + filename[i]);
		}

    } catch (Exception e) {
        e.printStackTrace();
    }

}

private static Channel getChannelSftp(String host, String user, String password) 
{
    try {
        JSch jsch = new JSch();
        Session session = jsch.getSession(user, host, 9022);
        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        config.put("PreferredAuthentications", "publickey,keyboard-interactive,password");
        session.setConfig(config);
        session.setPassword(password);
        session.connect();
        channel = session.openChannel("sftp");

    } catch (Exception e) {
        System.out.println("Failed to get sftp channel. " + e);
    }
    return channel;
}
}