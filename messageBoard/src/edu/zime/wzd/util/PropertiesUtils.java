package edu.zime.wzd.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取properties配置文件工具类
 * @author wchvt
 *
 */
public class PropertiesUtils {

	 private static Properties pros = null; 
     
	    public static void load(String fileName){  
	        pros = new Properties();
	        
	        InputStream in = PropertiesUtils.class.getResourceAsStream(fileName);  
	        try {  
	            pros.load(in);  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	    }  
	    
	    public static String get(String key){  
	    	load("/message.properties");
	        return pros.getProperty(key);
	    }  
	    
	    
	  /*  public static void main(String[] args) {
			
			System.out.println(get("size"));
		}*/
}
