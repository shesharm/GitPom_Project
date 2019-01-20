package com.selenium.facebook.pom.testfire;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selenium.facebook.pom.pages.LaunchPage;
import com.selenium.facebook.pom.pages.common.LoginPage;
import com.selenium.facebook.pom.pages.common.TopMenu;
import com.selenium.facebook.pom.pages.testfire.FeedbackPage;
import com.selenium.facebook.pom.pages.testfire.MyAccount;
import com.selenium.facebook.pom.testcases.base.BaseTest;
import com.selenium.facebook.pom.util.DataUtil;
import com.selenium.facebook.pom.util.FBConstants;

public class FeedbackTest extends BaseTest{

	String testCaseName="provideFeedback";
	@Test(dataProvider="getData")
	public void provideFeedback(Hashtable<String,String> data){
				
		test=extent.createTest("Feedback Test");
		if(!DataUtil.isTestExecutable(xls, testCaseName)||  data.get(FBConstants.RUNMODE_COL).equals("N")){
			test.log(Status.SKIP, "Skipping the test as Rnumode is N");
			throw new SkipException("Skipping the test as Rnumode is N");
		}
		
		test.log(Status.INFO, "Starting profile Test");
		init(data.get("Browser"));
		LaunchPage launchPage =new LaunchPage(driver,test);
		PageFactory.initElements(driver, launchPage);
		
		LoginPage loginPage = launchPage.gotoLoginPage();
		loginPage.verifyTitle("Altoro Mutual: Account Information");
		Object page=loginPage.doLogin(FBConstants.getEnvDetails().get("username"), FBConstants.getEnvDetails().get("password"));
		
		if(page instanceof LoginPage)
			Assert.fail("Login failed ");
		else if(page instanceof MyAccount)
			test.log(Status.PASS, "Logged in successfully");
		
		FeedbackPage feedback = new FeedbackPage(driver , test);
		PageFactory.initElements(driver, feedback);
		feedback.ClickContactUs();
		feedback.VerifyFeedback();
		test.log(Status.PASS, "Test Passed");
		//profPage.getMenu().logout();
		
		
	}
}
