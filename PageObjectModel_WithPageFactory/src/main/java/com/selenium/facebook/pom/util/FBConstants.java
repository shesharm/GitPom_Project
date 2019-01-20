package com.selenium.facebook.pom.util;

import java.util.Hashtable;

public class FBConstants {
	public static String ExpSuite;

	public static final boolean GRID_RUN=true;
	
	//paths
	public static final String CHROME_DRIVER_EXE="C:\\selenium\\drivers\\chromedriver.exe";
	
	
	// Login Page
	
	public static final String LOGIN_USERNAME = "//*[@id='uid']";
	public static final String LOGIN_PASSWORD = "//*[@id='passw']";
	public static final String LOGIN_BTN = "//*[@name='btnSubmit']";
	
	//Top Bar
	public static final String SIGNIN_BTN = "//a[@id='LoginLink']";
	public static final String CONTACT_US_LINK = "//*[text()='Contact Us']";
	public static final String ONLINE_FORM_LINK = "//*[text()='online form']";
	public static final String MYACCOUNT_LINK = "//*[text()='MY ACCOUNT']";
	public static final String SIGNOFF_LINK ="//*[text()='Sign Off']";
	
	//Feeddback form page
	public static final String YOUR_NAME_LINK ="//*[@name='name']";
	public static final String EMAIL_ADDRESS ="//*[@name='email_addr']";
	public static final String SUBJECT = "//*[@name='subject']";
	public static final String COMMENTS = "//*[@name='comments']";
	public static final String SUBMIT_BTN = "//*[@name='submit']";
	
	//MyAccount page
	public static final String GO_BTN = "//*[@id='btnGetAccount']";
	public static final String AVAILABLE_BAL = "//*[@id='_ctl0__ctl0_Content_Main_Balance2']";
	
	// URLs-prod
	public static final String PROD_HOMEPAGE_URL = "http://demo.testfire.net/";
	public static final String PROD_USERNAME = "jsmith";
	public static final String PROD_PASSWORD = "Demo1234";
	
	// URLs-uat
	public static final String UAT_HOMEPAGE_URL = "http://uatdemo.testfire.net/";
	public static final String UAT_USERNAME = "uat_jsmith";
	public static final String UAT_PASSWORD = "uat_demo1234";
		
	
	public static final String ENV="PROD"; //PROD, UAT,SAT 
			

	//paths
	public static final String REPORTS_PATH = "C:\\selenium\\Screenshots\\";
	public static final String TESTDATA_SHEET = "TestData";
	public static final Object RUNMODE_COL = "Runmode";
	public static final String TESTCASES_SHEET = "TestCases";
	
	public static Hashtable<String,String> table;
	
	public static Hashtable<String,String> getEnvDetails(){
		if(table==null){
			table = new Hashtable<String,String>();
			if(ENV.equals("PROD")){
				table.put("url", PROD_HOMEPAGE_URL);
				table.put("username", PROD_USERNAME);
				table.put("password", PROD_PASSWORD);
			}else if(ENV.equals("UAT")){
				table.put("url", UAT_HOMEPAGE_URL);
				table.put("username", UAT_USERNAME);
				table.put("password", UAT_PASSWORD);
			}
			
		}
		return table;	 
	}
	
	public static String getSuiteFile(String suiteName) {
		if(suiteName.toUpperCase().equals("GMAILSUITE"))
			ExpSuite= System.getProperty("user.dir")+"\\data\\gmailsuite.xlsx";
		if(suiteName.toUpperCase().equals("TESTFIRE"))	
			ExpSuite= System.getProperty("user.dir")+"\\data\\testfire.xlsx";
		return ExpSuite;
	}
}


