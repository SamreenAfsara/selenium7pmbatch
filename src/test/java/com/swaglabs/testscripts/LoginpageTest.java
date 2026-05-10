package com.swaglabs.testscripts;

import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.swaglabs.pages.InventoryPage;
import com.swaglabs.pages.Loginpage;
import com.swaglabs.utils.Browser;
import com.swaglabs.utils.DataConfig;
import com.swaglabs.utils.ReadData;

public class LoginpageTest extends Browser {
	
	
	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	public void setup(@Optional("chrome") String bname)
	{
		launchBrowser(bname);
		openURL();
	}
	
	@AfterMethod(alwaysRun=false)
	public void teardown()
	{
		closeBrowser();
	}
	
	@Test(priority=1, groups="sanity")
	public void verifyLoginBtnFunctionalityWithBlankUsername()
	{
		Loginpage login = new Loginpage(driver,"loginpage");
		login.clickOnloginbtn();
		String actualErrorMsg=login.getErrorMsg();
		System.out.println(actualErrorMsg);
		Assert.assertEquals(actualErrorMsg, DataConfig.BLANK_USERNAME_ERRORMSG);
		Reporter.log("Test Passed Actual Error msg is as Expected : "+actualErrorMsg);
	}
	
	@Test(priority=2,groups="smoke")
	public void verifyLoginBtnFunctionalityWithBlankPassword() throws InterruptedException
	{
		ReadData read = new ReadData("loginpage");
		String uname=read.getData(2, 0);
		Loginpage login = new Loginpage(driver,"loginpage");
		login.enterUsername(uname);
		Thread.sleep(3000);
		login.clickOnloginbtn();
		String actualErrorMsg=login.getErrorMsg();
		System.out.println(actualErrorMsg);
		Assert.assertEquals(actualErrorMsg, DataConfig.BLANK_PASSWORD_ERRORMSG);
		Reporter.log("Test Passed Actual Error msg is as Expected : "+actualErrorMsg);

	}
	
	@Test(priority=3, groups="sanity")
	public void verifyLoginBtnFunctionalityWithInvalidCredentials() throws InterruptedException
	{
		ReadData read = new ReadData("loginpage");
		List<String> logindata=read.getData(9);
		String uname=logindata.get(0);
		String pass=logindata.get(1);
		Loginpage login = new Loginpage(driver,"loginpage");
		login.enterUsername(uname);
		login.enterPassword(pass);
		Thread.sleep(3000);
		login.clickOnloginbtn();
		String actualErrorMsg=login.getErrorMsg();
		System.out.println(actualErrorMsg);
		Assert.assertEquals(actualErrorMsg, DataConfig.INVALID_CRDENTIALS_ERRORMSG);
		Reporter.log("Test Passed Actual Error msg is as Expected : "+actualErrorMsg);

	}
	@Test(priority=4,groups="smoke")
	public void verifyLoginBtnFunctionalityWithValidCredentials() throws InterruptedException
	{
		ReadData read = new ReadData("loginpage");
		List<String> logindata=read.getData(8);
		String uname=logindata.get(0);
		String pass=logindata.get(1);
		Loginpage login = new Loginpage(driver,"loginpage");
		login.enterUsername(uname);
		login.enterPassword(pass);
		Thread.sleep(3000);
		login.clickOnloginbtn();
		
		InventoryPage inventoryPage = new InventoryPage(driver, "inventory");
		boolean status=inventoryPage.isProductTitleVisible();
		Assert.assertTrue(status);
		Reporter.log("Test Passed Product Title is visible");

	}
	
	
	@Test(priority=5,dataProvider="logindata",groups="smoke")
	public void verifyLoginBtnFunctionalityWithValidCredentials(String  uname,String pass) throws InterruptedException
	{
		
		Loginpage login = new Loginpage(driver,"loginpage");
		login.enterUsername(uname);
		login.enterPassword(pass);
		Thread.sleep(3000);
		login.clickOnloginbtn();
		
		InventoryPage inventoryPage = new InventoryPage(driver, "inventory");
		boolean status=inventoryPage.isProductTitleVisible();
		Assert.assertTrue(status);
		Reporter.log("Test Passed Product Title is visible");

	}
	
	
	@DataProvider(name="logindata")
	public String[][] logindata()
	{
		ReadData read = new ReadData("loginpage");
	     return read.getData();
		
	}
	

}
