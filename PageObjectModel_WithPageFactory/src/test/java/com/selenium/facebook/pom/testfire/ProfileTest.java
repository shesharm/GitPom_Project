package com.selenium.facebook.pom.testfire;
/*package com.qtpselenium.facebook.pom.testcases;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qtpselenium.facebook.pom.pages.LaunchPage;
import com.qtpselenium.facebook.pom.pages.LoginPage;
import com.qtpselenium.facebook.pom.pages.testfire.LandingPage;
import com.qtpselenium.facebook.pom.pages.testfire.ProfilePage;
import com.qtpselenium.facebook.pom.testcases.base.BaseTest;
import com.qtpselenium.facebook.pom.util.DataUtil;
import com.qtpselenium.facebook.pom.util.FBConstants;
import com.aventstack.extentreports.Status;

public class ProfileTest  extends BaseTest{
	String testCaseName="testProfile";
	
	@Test(dataProvider="getData")
	public void testProfile(Hashtable<String,String> data){
				
		test=extent.createTest("Profile Test");
		if(!DataUtil.isTestExecutable(xls, testCaseName)){
			test.log(Status.SKIP, "Skipping the test as Rnumode is N");
			throw new SkipException("Skipping the test as Rnumode is N");
		}
		
		test.log(Status.INFO, "Starting profile Test");
		init("Mozilla");
		LaunchPage launchPage =new LaunchPage(driver,test);
		PageFactory.initElements(driver, launchPage);
		
		LoginPage loginPage = launchPage.gotoLoginPage();
		loginPage.verifyTitle("Facebook Login");
		Object page=loginPage.doLogin(FBConstants.getEnvDetails().get("username"), FBConstants.getEnvDetails().get("password"));
		
		if(page instanceof LoginPage)
			Assert.fail("Login failed ");
		else if(page instanceof LandingPage)
			System.out.println("Logged in successfully");
		
		LandingPage landingPage=(LandingPage)page;
		//landingPage.getMenu().search();
		//landingPage.verifyTitle("xxxxxx");
		
		ProfilePage profPage=landingPage.gotoProfilePage();
		profPage.verifyProfile();
		test.log(Status.PASS, "Test Passed");
		//profPage.getMenu().logout();
		profPage.takeScreenShot();
		
		
	}
/*	@AfterMethod
	public void quit(){
		if(extent!=null){
			//extent.endTest(test);
			extent.flush();
		}
		if(driver!=null)
			driver.quit();
	}*/
	
	/*@DataProvider
	public Object[][] getData(Method method){
		System.out.println("Ind=side dataprovider "+method.getName());
		testCaseName =method.getName();
		return DataUtil.getTestData(xls, testCaseName);
	}

}*/
