package com.selenium.facebook.pom.gmailsuite;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selenium.facebook.pom.testcases.base.BaseTest;
import com.selenium.facebook.pom.util.DataUtil;
import com.selenium.facebook.pom.util.FBConstants;

public class GmailLogin extends BaseTest{

	
	@Test(dataProvider="getData")
	public void GmailLogin(Hashtable<String,String> data) {
		test = extent.createTest("Gmail Login");
		//testCaseName="ResetPasswordTest";
		test.log(Status.INFO, "Logging into Gmail");
		if(!DataUtil.isTestExecutable(xls, "GmailLogin") ||  data.get(FBConstants.RUNMODE_COL).equals("N")){
			test.log(Status.SKIP, "Skipping the test as Rnumode is N");
			throw new SkipException("Skipping the test as Rnumode is N");
		}
		
		
		
	}
}
