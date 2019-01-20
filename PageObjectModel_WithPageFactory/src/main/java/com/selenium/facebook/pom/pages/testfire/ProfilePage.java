package com.selenium.facebook.pom.pages.testfire;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.selenium.facebook.pom.base.BasePage;

public class ProfilePage extends BasePage{

	
	public ProfilePage(WebDriver driver,ExtentTest test){
		super(driver,test);
	}
	
	
	public void verifyProfile() {
		test.log(Status.INFO, "Verifying profile");
	}


}
