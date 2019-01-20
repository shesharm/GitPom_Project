package com.selenium.facebook.pom.pages.testfire;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.selenium.facebook.pom.base.BasePage;
import com.selenium.facebook.pom.util.FBConstants;

public class MyAccount extends BasePage{
	
	
	@FindBy(xpath=FBConstants.GO_BTN)
	public WebElement goBtn;
	
	public MyAccount(WebDriver driver,ExtentTest test){
		super(driver, test);	
	}
	
	public Object goToAccountHistory() {
		goBtn.click();
		boolean success=isElementPresent(FBConstants.AVAILABLE_BAL);
		if(success) {
			test.log(Status.INFO, "Navigated successfully to Account History Page");
			AccountHistory accountHistory = new AccountHistory(driver,test);
			return accountHistory;
		}else {
			test.log(Status.FAIL, "Not Navigated to Account History Page");
			MyAccount myaccount = new MyAccount(driver,test);
			return myaccount;
		}		
	}

}
