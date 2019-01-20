package com.selenium.facebook.pom.testcases.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.*;
import com.selenium.facebook.pom.util.DataUtil;
import com.selenium.facebook.pom.util.ExtentManager;
import com.selenium.facebook.pom.util.FBConstants;
import com.selenium.facebook.pom.util.Xls_Reader;

public class BaseTest {
	public ExtentReports extent = ExtentManager.getInstance(FBConstants.REPORTS_PATH);
	public ExtentTest test;
	//public Xls_Reader xls = new Xls_Reader(FBConstants.DATA_XLS_PATH);
	public Xls_Reader xls;
	public String testName;
	
	@BeforeTest
	public void start() {
		String arr[] = this.getClass().getPackage().getName().split("\\.");
		String suiteName= arr[arr.length-1];
		System.out.println(FBConstants.getSuiteFile(suiteName));
		xls = new Xls_Reader(FBConstants.getSuiteFile(suiteName));
	}

	
	public WebDriver driver;
	public void init(String bType){
		test.log(Status.INFO, "Opening browser - "+ bType);
		//testName=this.getClass().getSimpleName();
		//System.out.println("Test is "+testName);
		if(!FBConstants.GRID_RUN){
			// local machine
			if(bType.equals("Mozilla"))
				driver= new FirefoxDriver();
			else if(bType.equals("Chrome")){
				System.setProperty("webdriver.chrome.driver", FBConstants.CHROME_DRIVER_EXE);
				driver= new ChromeDriver();
			}
		}else{
			// grid
			DesiredCapabilities cap=null;
			if(bType.equals("Mozilla")){
				cap = DesiredCapabilities.firefox();
				cap.setBrowserName("firefox");
				cap.setJavascriptEnabled(true);
				cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
				
			}else if(bType.equals("Chrome")){
				 cap = DesiredCapabilities.chrome();
				 cap.setBrowserName("chrome");
				 cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
			}
			
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		test.log(Status.INFO, "Opened browser successfully - "+ bType);

	}
	
	public void reportFailure(String failureMessage){
		test.log(Status.FAIL, failureMessage);
		takeScreenShot();
		Assert.fail(failureMessage);
	}
	
	/*public void takeScreenShot(){
		Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		String filePath=FBConstants.REPORTS_PATH+"screenshots//"+screenshotFile;
		// store screenshot in that file
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(scrFile, new File(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.INFO,test.addScreenCapture(filePath));
	}*/
	
	@AfterMethod
	public void quit(){
		if(extent!=null){
			//extent.endTest(test);
			extent.flush();
		}
		if(driver!=null)
			driver.quit();
	}
	
	@DataProvider
	public Object[][] getData(Method method){
		// i can use xls file object to read data
		//System.out.println("Inside data Provider "+method.getName());
		testName=method.getName();
		return DataUtil.getTestData(xls,testName);
	}
	
	public void takeScreenShot(){
		// fileName of the screenshot
		Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		// take screenshot
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			// get the dynamic folder name
			FileUtils.copyFile(srcFile, new File(ExtentManager.screenshotFolderPath+screenshotFile));
			//put screenshot file in reports
			test.log(Status.FAIL,"Screenshot-> "+ test.addScreenCaptureFromPath(ExtentManager.screenshotFolderPath+screenshotFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
