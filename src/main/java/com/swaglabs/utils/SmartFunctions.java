package com.swaglabs.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SmartFunctions {
	
	WebDriver driver;
	ReadLocator read;
	public SmartFunctions(WebDriver driver, String pagename)
	{
		this.driver=driver;
		read=new ReadLocator(pagename);
		
	}
	
	
	protected By getLocator(String elementname)
	{
		
		String locatorvalue=read.getLocator(elementname);
		String data[]=locatorvalue.split("-",2);
		
		switch(data[0])
		{
		case "id": return By.id(data[1]);
		case "name":return By.name(data[1]); 
		case "xpath":return By.xpath(data[1]);
		case "css":return By.cssSelector(data[1]);
		}
		
		return null;
	}
	
	protected WebElement getElement(String elementname)
	{
		return driver.findElement(getLocator(elementname));
	}
	
	protected List<WebElement> getElements(String elementname)
	{
		return driver.findElements(getLocator(elementname));
	}
	
	
	
	protected void enterText(String elementname,String data)
	{
		getElement(elementname).sendKeys(data);
	}
	
	protected void click(String elementname)
	{
		getElement(elementname).click();
	}
	
	protected String getText(String elementname)
	{
		return getElement(elementname).getText();
	}
	
	protected boolean isVisible(String elementname)
	{
		try {
		return getElement(elementname).isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
	
	

}
