package com.swaglabs.pages;

import org.openqa.selenium.WebDriver;

import com.swaglabs.utils.SmartFunctions;

public class InventoryPage  extends SmartFunctions{

	public InventoryPage(WebDriver driver, String pagename) {
		super(driver, pagename);
	
	}
	
	public boolean isProductTitleVisible()
	{
		return isVisible("producttitle");
	}

}
