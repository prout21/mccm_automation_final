//import com.jcraft.jsch.ChannelSftp;
package Mccm.Unix.Outbound;


import java.util.ArrayList;
import org.testng.annotations.Test;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class FilesAvailabilityCheck_Cassandra extends general_ReadProperty {

ChannelExec channelExec = null;
static Channel channel = null;

static String host = "localhost";
//static String user = "pegat02";
static String user = "mccm02";
static String password = "unix11";

  public static String filenameFCA;
  public static String filenameSCA;

@Test

public static void main(String[] args) {
	
//String filename = "file_list_oracle1.lst";
	
	// String[] filename = {"SCA_cass_20200807010201.csv.gz", "FCA_cass_202008070010201.csv.gz"};//, "file_list_oracle.lst";
	
	 String filenameFCA = general_ReadProperty("File_NameFCA");

    String filepath = "/opt/SP/mccm/SYSN/mccm_data/csv_cassandrafile/";
    
try {
    	
        Channel  channel = getChannelSftp(host, user, password);
        channel.connect();
        ChannelSftp channelSftp = (ChannelSftp) channel;
        channelSftp.cd(filepath);
        String path = channelSftp.ls(filenameFCA).toString();
        if (!path.contains(filenameFCA)) {
            System.out.println("File doesn't exist." + filenameFCA);
        } else
        	//            System.out.println("");            
         	System.out.println("Case 2:");     	
           // System.out.println("Case 2: File exist at the path -/opt/SP/mccm/SYSN/mccm_dataload/import/input.---  " + filename);
        String dir= channelSftp.pwd().toString();
        System.out.println("File exist at the path ---  " + dir);        
            System.out.println("---  " + filenameFCA);


    } catch (Exception e) {
        e.printStackTrace();
    }

String filenameSCA = general_ReadProperty("File_NameSCA");

//String filepath1 = "/opt/SP/mccm/SYSN/mccm_data/csv_cassandrafile/";

try {
	
    Channel  channel = getChannelSftp(host, user, password);
    channel.connect();
    ChannelSftp channelSftp = (ChannelSftp) channel;
    channelSftp.cd(filepath);
    String path = channelSftp.ls(filenameSCA).toString();
    if (!path.contains(filenameSCA)) {
        System.out.println("File doesn't exist." + filenameSCA);
    } else
    	//            System.out.println("");            
     	System.out.println("Case 2:");     	
       // System.out.println("Case 2: File exist at the path -/opt/SP/mccm/SYSN/mccm_dataload/import/input.---  " + filename);
    String dir= channelSftp.pwd().toString();
    System.out.println("File exist at the path ---  " + dir);        
        System.out.println("---  " + filenameSCA);


} catch (Exception e) {
    e.printStackTrace();
}

String filenameClose = general_ReadProperty("File_NameClose");

//String filepath1 = "/opt/SP/mccm/SYSN/mccm_data/csv_cassandrafile/";

try {
	
  Channel  channel = getChannelSftp(host, user, password);
  channel.connect();
  ChannelSftp channelSftp = (ChannelSftp) channel;
  channelSftp.cd(filepath);
  String path = channelSftp.ls(filenameClose).toString();
  if (!path.contains(filenameClose)) {
      System.out.println("File doesn't exist." + filenameClose);
  } else
  	//            System.out.println("");            
   	System.out.println("Case 2:");     	
     // System.out.println("Case 2: File exist at the path -/opt/SP/mccm/SYSN/mccm_dataload/import/input.---  " + filename);
  String dir= channelSftp.pwd().toString();
  System.out.println("File exist at the path ---  " + dir);        
      System.out.println("---  " + filenameClose);


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