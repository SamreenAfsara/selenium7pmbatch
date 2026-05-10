package com.swaglabs.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Browser {
	
	protected static WebDriver driver;
	
	public static void launchBrowser(String browsername)
	{
		if(browsername.equals("chrome"))
			driver= new ChromeDriver();
		else
			driver = new EdgeDriver();
	}
	
	
	public static void openURL(String url)
	{
		driver.get(url);
	}
	
	public static void openURL()
	{
		driver.get("https://www.saucedemo.com/");
	}
	
	
	public  static void closeBrowser()
	{
		driver.close();
	}
	

}
