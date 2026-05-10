package com.swaglabs.pages;

import org.openqa.selenium.WebDriver;

import com.swaglabs.utils.SmartFunctions;

public class Loginpage extends SmartFunctions {

	public Loginpage(WebDriver driver, String pagename) {
		super(driver, pagename);
	}
	
	
	public void enterUsername(String uname)
	{
		enterText("username", uname);
	}
	
	public void enterPassword(String pass)
	{
		enterText("password", pass);
	}
	
	public void clickOnloginbtn()
	{
		click("loginbtn");
	}
	
	
	public String getErrorMsg()
	{
		return getText("errormsg");
	}

}
