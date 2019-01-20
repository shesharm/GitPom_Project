package com.selenium.facebook.pom.base;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.selenium.facebook.pom.pages.common.TopMenu;
import com.selenium.facebook.pom.util.ExtentManager;
import com.selenium.facebook.pom.util.FBConstants;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
public class BasePage {

	public WebDriver driver;
	public TopMenu menu;
	public ExtentTest test;

	
	public BasePage(){}
	
	public BasePage(WebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
		menu = new TopMenu(driver, test);
		PageFactory.initElements(driver, menu);
	}
	
	public String verifyTitle(String expTitle){
		test.log(Status.INFO, "Verifying the title " + expTitle);
		// webdriver code
		return "";
	}
	
	public String verifyText(String locator,String expText){
		return "";
	}
	
	public boolean isElementPresent(String locator){
		test.log(Status.INFO, "Trying to find element -> "+locator);
		int s = driver.findElements(By.xpath(locator)).size();
		if(s==0){
			test.log(Status.INFO, "Element not found");
			return false;
		}
		else{
			test.log(Status.INFO, "Element found");
			return true;
		}
			
	}
	
	public TopMenu getMenu(){
		return menu;
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
	
	public void reportFailure(String failureMessage){
		test.log(Status.FAIL, failureMessage);
		takeScreenShot();
		Assert.fail(failureMessage);
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
	
	/*
	public void waitForPageToLoad() {
		wait(1);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String state = (String)js.executeScript("return document.readyState");
		
		while(!state.equals("complete")){
			wait(2);
			state = (String)js.executeScript("return document.readyState");
		}
	}
	
	public void wait(int timeToWaitInSec){
		try {
			Thread.sleep(timeToWaitInSec * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
}
