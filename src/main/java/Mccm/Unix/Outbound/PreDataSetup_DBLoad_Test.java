package Mccm.Unix.Outbound;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import org.apache.commons.io.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class PreDataSetup_DBLoad_Test  {
	
	public static String PROJECT_FOLDER_PATH1;
	public static String TEST_ENV1;
	public static String user;
	public static String password;
	public static String host;
	public static XSSFWorkbook wb;
	
	 public static String name;
	 public static String PreDataSetup_DBLoad_Test;

//	  public static String FCA;
//	  public static String SCA;
//	  public static String Close;
	  
	/**
	 	 */
@Test	
//	public static void main(Object args)

   public void VerifyOutboundPreDatasetupDBLoadsuccessfully()
 

	{
	PROJECT_FOLDER_PATH1=general_ReadProperty("PROJECT_FOLDER_PATH");
	/*
	 * ENV_WIKI=general_ReadProperty("ENV_WIKI"); String path=
	 * (PROJECT_FOLDER_PATH1+ENV_WIKI);
	 */
	 TEST_ENV1=general_ReadProperty("TEST_ENV");
	 user=general_ReadProperty("USER_NAME");
	 password=general_ReadProperty("PASSWORD");
	 host=general_ReadProperty("HOST_NAME");


	 
	/*
	 * String host="localhost"; String user="mccm02"; String password="unix11";
	 */
        String Status="COMPLETED";
        
//pr        String FCA="FCA_cass_20200707010201.csv";
//pr        String SCA="SCA_cass_20200707010201.csv";
        
//        String FCA="FCA_cass_20200922010201.csv";
//        String SCA="SCA_cass_20200922010201.csv";
//        
//        String FCA = general_ReadProperty("File_NameFCA");
//        String SCA = general_ReadProperty("File_NameSCA");
//        String Close = general_ReadProperty("File_NameClose");
        
	 //  String command="sh /opt/SP/data/mccm02/temp/DataSetup.sh";
        
            
       
        
       String command= general_ReadProperty("PreDataSetup_DBLoad_Test");
	   
	 

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
	        
 	     //    String contents = new String(in.readAllBytes(), StandardCharsets.UTF_8);
	        
	         
	         //System.out.println(contents);

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
	        
//	         System.out.println(contents);
	         System.out.println();
	         
//            if (contents.contains(FCA))
//            { 
//           	 System.out.println("The file:" + FCA +  ":  loaded to Cassandra DB  successfully.");
//            }else { 
//               	 System.out.println("The file:" + FCA +  ":  Not loaded  successfully.");
// 
//			}	    
//            if (contents.contains(SCA)) { 
//            	System.out.println();
//            	System.out.println("The file:" + SCA +":  loaded to Cassandra DB  successfully.");
//            }
//            	else { 
//                  	 System.out.println("The file:" + SCA +  ":  Not loaded to Cassandra DB  successfully.");
//                	
//   			}
//	            if (contents.contains(Status)) { 
//	            	 System.out.println();
//	              	 System.out.println("The file status updated successfully as : " + Status + " at Cassandra.");
//	   			}            
	        channel.disconnect();
	        session.disconnect();
	        System.out.println("Data setup Done DB Load");
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