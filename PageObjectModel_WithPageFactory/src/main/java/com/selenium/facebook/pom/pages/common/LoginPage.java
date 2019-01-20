package com.selenium.facebook.pom.pages.common;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.facebook.pom.base.BasePage;
import com.selenium.facebook.pom.pages.testfire.MyAccount;
import com.selenium.facebook.pom.util.FBConstants;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class LoginPage extends BasePage{
	
	@FindBy(xpath=FBConstants.SIGNIN_BTN)
	public WebElement signin;
	
	@FindBy(xpath=FBConstants.LOGIN_USERNAME)
	public WebElement username;
	
	@FindBy(xpath=FBConstants.LOGIN_PASSWORD)
	public WebElement password;
	
	@FindBy(xpath=FBConstants.LOGIN_BTN)
	public WebElement loginBtn;
	
	
	public LoginPage(WebDriver driver, ExtentTest test){
		super(driver,test);
	}
	
	
	
	
	public Object doLogin(String usName,String pWord){
		test.log(Status.INFO, "Logging in -"+usName+"/"+pWord);
		signin.click();
		username.sendKeys(usName);
		password.sendKeys(pWord);
		loginBtn.click();
		//password.sendKeys(Keys.ENTER);
		// logic - validate
		WebDriverWait wait = new WebDriverWait(driver,50);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FBConstants.SIGNOFF_LINK)));
		boolean loginSuccess=isElementPresent(FBConstants.SIGNOFF_LINK);
		
		if(loginSuccess){
			test.log(Status.INFO, "Login Success");
			MyAccount myAccountPage = new MyAccount(driver,test);
			PageFactory.initElements(driver, myAccountPage);
			return myAccountPage;
		}
		else{
			test.log(Status.INFO, "Login Not Success");
			LoginPage loginPage = new LoginPage(driver,test);
			PageFactory.initElements(driver, loginPage);
			return loginPage;
		}		
	}
	

	
	

}
