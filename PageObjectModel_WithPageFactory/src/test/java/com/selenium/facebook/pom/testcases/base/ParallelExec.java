package com.selenium.facebook.pom.testcases.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import org.testng.TestNG;

public class ParallelExec {
	 
	static Properties prop1;
	public static void main(String[] args) throws IOException {
		
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//env.properties");
		prop1 = new Properties();
		prop1.load(fs);// init env.properties
		TestNG testng = new TestNG(); 
		testng.setTestSuites(Arrays.asList(new String[] {System.getProperty("user.dir")+"//src/test/resources/testng.xml"}));
		if(prop1.getProperty("gridRun").equals("Y")) {
			System.out.println("Grid flag is Y");
			testng.setSuiteThreadPoolSize(3);
		}else {
			System.out.println("Grid flag is N");
			testng.setSuiteThreadPoolSize(1);
		}
		//testng.setSuiteThreadPoolSize(1);
		testng.run();

	}
	

}
