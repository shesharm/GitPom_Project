package com.selenium.facebook.pom.pages.testfire;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.selenium.facebook.pom.base.BasePage;
import com.selenium.facebook.pom.util.FBConstants;

public class AccountHistory extends BasePage{
	
	@FindBy(xpath=FBConstants.AVAILABLE_BAL)
	public WebElement available_Bal;
	
	public AccountHistory(WebDriver driver,ExtentTest test){
		super(driver, test);	
	}
	
	public boolean ValidateAccountBalance(String balance) {
		String strAvailableBal = available_Bal.getText();
		if(strAvailableBal.equals(strAvailableBal)) {
			test.log(Status.PASS, "Matched the expected text :"+strAvailableBal);
			return true;
		}else {
			test.log(Status.FAIL, "Not Matched the expected text :"+strAvailableBal);
			return false;
		}
			
	}
}
