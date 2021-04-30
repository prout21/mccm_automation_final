
package Mccm.Unix.Outbound;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class DBCheck_Mccm {

	
	public static String FCA;
	public static String SCA;
	public static String Close;
	public static String PROJECT_FOLDER_PATH1;
	public static String TEST_ENV1;
	public static String user;
	public static String password;
	public static String host;
	public static XSSFWorkbook wb;
	public static String DBCheck_Cassandra_oracle;

	/**
	 	 */
	public static void main(Object args) {
		/*
		 * String host="localhost"; String user="mccm02"; String password="unix11";
		 */
		 PROJECT_FOLDER_PATH1=general_ReadProperty("PROJECT_FOLDER_PATH");
		 TEST_ENV1=general_ReadProperty("TEST_ENV");
		 user=general_ReadProperty("USER_NAME");
		 password=general_ReadProperty("PASSWORD");
		 host=general_ReadProperty("HOST_NAME");
	 //  String command="sh /opt/SP/data/mccm02/temp/oracle.sh";
		 
	   String command= general_ReadProperty("DBCheck_Cassandra_oracle");
	  
	    try{
	    	
	    	java.util.Properties config = new java.util.Properties(); 
	    	config.put("StrictHostKeyChecking", "no");
	    	JSch jsch = new JSch();
	    	Session session=jsch.getSession(user, host, 9022);
	    	session.setPassword(password);
	    	session.setConfig(config);
	    	session.connect();
	       	
	    	System.out.println("Connected");
	    		  
	    	Channel channel=session.openChannel("exec");
	        ((ChannelExec)channel).setCommand(command);
	     
	        channel.setInputStream(null);
	        ((ChannelExec)channel).setErrStream(System.err);
	        
	        InputStream in=channel.getInputStream();
	        channel.connect();
	        
	        byte[] tmp=new byte[1024];
	        while(true){
	          while(in.available()>0){
	            int i=in.read(tmp, 0, 1024);
	            if(i<0)break;
	            System.out.print(new String(tmp, 0, i));
	          }
	          if(channel.isClosed()){
	            System.out.println("exit-status: "+channel.getExitStatus());
	            break;
	          }
	          try{Thread.sleep(1000);}catch(Exception ee){}
	        }
	        channel.disconnect();
	        session.disconnect();
	        System.out.println("DONE");
	    }catch(Exception e){
	    	e.printStackTrace();

	    		
	    	 
	 	    }
		}
	public static String general_ReadProperty(String propertyKey)
	{
		String propertyValue="";
		File cfgfile = new File("UseCaseConfigFile/configurationFile.properties");
		
		if(cfgfile.exists())
		{
			  Properties propties = new Properties();
			  FileInputStream propFile;

			  try {
				  propFile = new FileInputStream(cfgfile);
				  propties.load(propFile);
				  propertyValue=propties.getProperty(propertyKey);
				  } catch (Exception e1) {
					  
					  e1.printStackTrace();
				  } 
		 }
		return propertyValue;
		
	    
}
	}


