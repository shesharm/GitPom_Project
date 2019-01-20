package com.selenium.facebook.pom.pages.common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.selenium.facebook.pom.base.BasePage;
import com.selenium.facebook.pom.util.FBConstants;

public class TopMenu extends BasePage{
	
	@FindBy(xpath=FBConstants.SIGNOFF_LINK)
	public WebElement signOff;

	ExtentTest test;
	
	
	WebDriver driver;
	
	public TopMenu(WebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
	}
	
	
	/*public GeneralSettingsPage gotoSettings(){
		test.log(Status.INFO, "Going to settings");
		//navigationLabel.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('userNavigationLabel').click()");
		settings.click();
		test.log(Status.INFO, "Settings page opened");
		GeneralSettingsPage settings =new GeneralSettingsPage(driver,test);
		PageFactory.initElements(driver, settings);
		return settings;
	}*/
	
	public boolean SignOff(){
		signOff.click();
		boolean logoffSuccess=isElementPresent(FBConstants.LOGIN_USERNAME);
		if(logoffSuccess) {
			return true;
		}else {
			return false;
		}
	}
	
	
}
