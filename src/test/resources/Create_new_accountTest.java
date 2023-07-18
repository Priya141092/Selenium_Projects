import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import main.java.Utility.ExcelData_Provider;
import main.java.Utility.ExtentRepMethods;

import main.java.Utility.TestUtil;

import main.java.base.Basecl;
import pages.Create_new_account;
import pages.HomePage_ShopnewYoga;
 
public class Create_new_accountTest extends Basecl {
	Create_new_account createaccount ;
	Logger logger = LogManager.getLogger(Create_new_accountTest.class);
	public Create_new_accountTest()
	{
		super();
	}
	@BeforeTest(alwaysRun = true)
	public void setReporting() throws IOException {

		ExtentRepMethods.setcreationExtentReport();

		logger.debug("creating report and moving to directory");

	}
	
	
	@BeforeClass()
	public void setup()
	{
		initialization();
		createaccount = new Create_new_account();
		
	}
	
	@DataProvider(name= "createaccountdata1")
	public static Object[][] createaccountdata() throws IOException
	{

		Object data [][] =ExcelData_Provider.exceldata(prop.getProperty("excelpath"), prop.getProperty("sheetname"));
		return data;
	}
	
	@Test
	public void ClickoncreateaccountTest()
	{
	 createaccount.Clickoncreateaccount();
	String actualtit = driver.getTitle();
	 Assert.assertEquals(actualtit, prop.getProperty("createpagetitle"));
	 logger.info("This has been successful and navigated to create account");
		
	}
	
	
	@Test(dataProvider= "createaccountdata1")
	public void fillalldetailsTest(String fname, String lname, String Email, String Newpass, String Cnfpass) throws InterruptedException
	{
		createaccount.fillalldetails(fname, lname, Email, Newpass, Cnfpass);
		String successtit = driver.getTitle();
		Thread.sleep(4000);
	    Assert.assertEquals(successtit, prop.getProperty("Aftercreationpagetitle"));
	    logger.debug("data has been inserted sucessfully");
		
	}
	@AfterClass
	public void teardown()
	{
		driver.quit();
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		
		if(ITestResult.FAILURE==result.getStatus())
		{
			if (ITestResult.FAILURE == result.getStatus()) {
				String fileName = result.getMethod().getMethodName() + ".png";
				TestUtil.getScreenshot(fileName);
				ExtentRepMethods.failedtestcaseintegration();
				TestUtil.changetoarchiveddiretory();
				ExtentRepMethods.extentflush();
				
		}

		
	}
	
		
	}
	
	
}
