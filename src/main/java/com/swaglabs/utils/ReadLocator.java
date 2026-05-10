package com.swaglabs.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadLocator {
	
	private Properties pro ;
	public ReadLocator(String pagename)
	{
         String filepath=".//src//main//resources//locators//"+pagename+".properties";	
         
         
			FileInputStream instream;
			try {
				instream = new FileInputStream(filepath);
				 pro = new Properties();
					pro.load(instream);
			} catch (Exception e) {
				e.printStackTrace();
			
			}
			
		
	}
	
	
	public String  getLocator(String locatorname)
	{
		return pro.getProperty(locatorname);
	}
	
	public static void main(String[] args) {
		
		ReadLocator read = new ReadLocator("loginpage");
		System.out.println(read.getLocator("errormsg"));
	}

}
