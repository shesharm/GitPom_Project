package com.selenium.facebook.pom.pages.testfire;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.selenium.facebook.pom.base.BasePage;
import com.selenium.facebook.pom.util.FBConstants;

public class FeedbackPage extends BasePage{

	@FindBy(xpath=FBConstants.CONTACT_US_LINK)
	public WebElement contactUs;
	
	public FeedbackPage(WebDriver driver,ExtentTest test){
		super(driver,test);
	}
	
	public void ClickContactUs() {
		contactUs.click();
		test.log(Status.INFO, "Clicked on Contact Us");
	}
	public void VerifyFeedback() {
		test.log(Status.INFO, "Filling feedback form ");
	}

}
