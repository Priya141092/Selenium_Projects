package main.java.Utility;

import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import main.java.Utility.ExtentRepMethods;

 
public class Listener implements ITestListener , ISuiteListener{ 
	
	//ExtentReports report = ExtentRepMethods.setcreationExtentReport();
	//ExtentTest test;
	 ExtentReports extentReports = new ExtentReports();
	 ExtentTest test;

	
	@Override
	public void onFinish(ITestContext arg0) {
	// TODO Auto-generated method stub
		

	}

	public void onStart(ITestResult result ) {
		extentReports = new ExtentReports();
        String path = System.getProperty("user.dir")+"/reports/index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Extent Report");
        reporter.config().setTheme(Theme.STANDARD);
        extentReports.attachReporter(reporter);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
	// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		test.log(Status.FAIL, "Test has been failed");

	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
	// TODO Auto-generated method stub

	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Started successfully");
        test = extentReports.createTest((result).getMethod().getMethodName(), "ExtentReport");
        test.log(Status.PASS, "test done");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test has passed");

	}
	
	

}
