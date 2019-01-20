package com.selenium.facebook.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.selenium.facebook.pom.base.BasePage;
import com.selenium.facebook.pom.pages.common.LoginPage;
import com.selenium.facebook.pom.util.FBConstants;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.Status;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class LaunchPage extends BasePage{
	
	
	public LaunchPage(WebDriver driver,ExtentTest test){
		super(driver, test);	
	}
	
	
	public LoginPage gotoLoginPage(){
		// log
		test.log(Status.INFO, "Opening the url - "+FBConstants.getEnvDetails().get("url"));
		driver.get(FBConstants.getEnvDetails().get("url"));
		test.log(Status.PASS, "URL Opened - "+FBConstants.getEnvDetails().get("url"));
		LoginPage loginPage = new LoginPage(driver,test);
		PageFactory.initElements(driver, loginPage);
		return loginPage;
	}

}
