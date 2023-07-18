package main.java.Utility;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import main.java.base.Basecl;

public class ExtentRepMethods  {
	  
	static ExtentReports extentReports = new ExtentReports();
	static ExtentTest test;
	 
   
	public static ExtentReports setcreationExtentReport() 
	{
		
		
		//String path = System.getProperty("user.dir")+"/reports/extent.html";
		
		String path = System.getProperty("user.dir")+"/reports/extent-report.html";
		  
		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(path);
		//ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("./test-ouput/extent-report.html"));
		extentReports.attachReporter(htmlReporter);
		return extentReports;
    
 
	}
	
	public static void failedtestcaseintegration() throws IOException
	{
		test=extentReports.createTest("HomePage_ShopnewYogaTest");
		test.fail("The test failed",MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/screenshot.png").build());
	}
	
	public static void extentflush() 
	{
		extentReports.flush();
	}
	
}
