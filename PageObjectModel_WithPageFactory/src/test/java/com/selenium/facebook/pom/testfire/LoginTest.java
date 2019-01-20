package com.selenium.facebook.pom.testfire;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selenium.facebook.pom.pages.LaunchPage;
import com.selenium.facebook.pom.pages.common.LoginPage;
import com.selenium.facebook.pom.pages.testfire.MyAccount;
import com.selenium.facebook.pom.testcases.base.BaseTest;
import com.selenium.facebook.pom.util.DataUtil;
import com.selenium.facebook.pom.util.FBConstants;

public class LoginTest extends BaseTest{
	String testCaseName="doLogin";
	
	@Test(dataProvider="getData")
	public void doLogin(Hashtable<String,String> data){
		test = extent.createTest("Login Test");
		
		if(!DataUtil.isTestExecutable(xls, testCaseName) ||  data.get(FBConstants.RUNMODE_COL).equals("N")){
			test.log(Status.SKIP, "Skipping the test as Rnumode is N");
			throw new SkipException("Skipping the test as Rnumode is N");
		}
		
		
		test.log(Status.INFO, "Starting login test");
		init(data.get("Browser"));

		LaunchPage launchPage =new LaunchPage(driver,test);
		PageFactory.initElements(driver, launchPage);
		
		LoginPage loginPage = launchPage.gotoLoginPage();
		test.log(Status.INFO, "Logging in");
		Object page=loginPage.doLogin(data.get("Username"), data.get("Password"));
		String actualResult="";
		// if i am logged in
		if(page instanceof MyAccount)
			actualResult="Success";
			
		else
			actualResult="Unsuccessful";
		
		if(!actualResult.equals(data.get("ExpectedResult"))){
			
			reportFailure("failure message");
		}
		
		test.log(Status.PASS, "Login Test Passed");
			
	}

	
	/*@DataProvider
	public Object[][] getData(Method method){
		System.out.println("Ind=side dataprovider "+method.getName());
		return DataUtil.getTestData(xls, testCaseName);
	}*/
	

}
