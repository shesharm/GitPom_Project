package com.selenium.facebook.pom.testfire;
/*package com.qtpselenium.facebook.pom.testcases;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qtpselenium.facebook.pom.pages.LaunchPage;
import com.qtpselenium.facebook.pom.pages.LoginPage;
import com.qtpselenium.facebook.pom.pages.session.settings.GeneralSettingsPage;
import com.qtpselenium.facebook.pom.pages.testfire.LandingPage;
import com.qtpselenium.facebook.pom.testcases.base.BaseTest;
import com.qtpselenium.facebook.pom.util.DataUtil;
import com.qtpselenium.facebook.pom.util.FBConstants;
import com.aventstack.extentreports.Status;

public class ChangePasswordTest extends BaseTest{
	String testCaseName;
	
	@Test(dataProvider="getData")
	public void ChangePasswordTest(Hashtable<String,String> data){
		//testCaseName="ChangePasswordTest";
		test = extent.createTest("Change Password");
		
		if(!DataUtil.isTestExecutable(xls, testCaseName) ||  data.get(FBConstants.RUNMODE_COL).equals("N")){
			test.log(Status.SKIP, "Skipping the test as Rnumode is N");
			throw new SkipException("Skipping the test as Rnumode is N");
		}
		test.log(Status.INFO, "Starting test");
		init(data.get("Browser"));
		LaunchPage launchPage =new LaunchPage(driver,test);
		PageFactory.initElements(driver, launchPage);
		
		LoginPage loginPage = launchPage.gotoLoginPage();
		test.log(Status.INFO, "Logging in");
		Object page=loginPage.doLogin(data.get("Username"), data.get("OldPassword"));
		
		if(page instanceof LoginPage)
			reportFailure("Could not login");
		// change password
		LandingPage landingPage = (LandingPage)page;
		GeneralSettingsPage settings = landingPage.getMenu().gotoSettings();
		settings.gotoPasswordChange();
		String actualResult=settings.doPasswordChange(data.get("OldPassword"),data.get("NewPassword"));
		test.log(Status.INFO, "Result of changing password - "+actualResult);

		//validation
		if(!actualResult.equals(data.get("ExpectedResult")))
			reportFailure("Got password change result as - "+actualResult);
		
		test.log(Status.PASS, "Test Passed");
		
	}
	
	@Test(dataProvider="getData")
	public void ResetPasswordTest(Hashtable<String,String> data) {
		test = extent.createTest("Reset password");
		//testCaseName="ResetPasswordTest";
		test.log(Status.INFO, "Password is getting reset.");
		if(!DataUtil.isTestExecutable(xls, "ResetPasswordTest") ||  data.get(FBConstants.RUNMODE_COL).equals("N")){
			test.log(Status.SKIP, "Skipping the test as Rnumode is N");
			throw new SkipException("Skipping the test as Rnumode is N");
		}
	}

	
	/*@DataProvider
	public Object[][] getData(Method method){
		System.out.println("Ind=side dataprovider "+method.getName());
		testCaseName =method.getName();
		return DataUtil.getTestData(xls, testCaseName);
	}
	
}*/
