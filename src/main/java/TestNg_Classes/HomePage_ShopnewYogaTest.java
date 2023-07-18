package TestNg_Classes;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import main.java.Utility.ExtentRepMethods;
import main.java.Utility.TestUtil;
import main.java.base.Basecl;
import pages.HomePage_ShopnewYoga;

@Listeners(main.java.Utility.TestListeners.class)
public class HomePage_ShopnewYogaTest extends Basecl {

	HomePage_ShopnewYoga homepage;
	Logger logger = LogManager.getLogger(HomePage_ShopnewYogaTest.class);

	public HomePage_ShopnewYogaTest() {
		super();
	}

	@BeforeSuite(alwaysRun = true)
	public void setReporting() throws IOException {

		TestUtil.changetoarchiveddiretory();
        logger.debug("creating report and moving to directory");

	}

	@BeforeClass()
	public void setup() throws IOException {

		initialization();
		homepage = new HomePage_ShopnewYoga();

	}

	@Test(priority = 1)
	public void clickShopnewyogaTest() throws IOException

	{

		homepage.clickShopnewyoga();
		Assert.assertTrue(true, prop.getProperty("title"));
		logger.info("The page has navigated to the desired yoga shop");
		

	}
	
	@Test(priority = 2)
	public void clickonstyleTest() throws IOException, InterruptedException

	{

		homepage.clickonstyle();
		logger.info("The page has navigated to the desired yoga shop");
		

	}
	
//	@Test(priority = 2)
//	public void count_items_on_pageTest() throws IOException
//
//	{
//
//		homepage.count_items_on_page();
//		Assert.assertEquals(12,12);
//		logger.info("The page has navigated to the desired yoga shop");
//		
//
//	}
//	
//
//	@Test(priority = 3)
//	public void sortByPriceCollection() {
//
//		homepage.sortByPriceCollection();
//		String urlsorting = driver.getCurrentUrl();
//		Assert.assertEquals(urlsorting, prop.getProperty("urlsort"));
//		logger.info("The page has been sorted by price");
//		logger.debug("Page found woth sorting");
//	}
//
//	@Test(priority = 4)
//	public void modesTest() {
//		homepage.modes();
//		String url = driver.getCurrentUrl();
//		Assert.assertEquals(url, prop.getProperty("modesurl"));
//		logger.debug("listing has been done");
//
//	}
//
//	@Test(priority = 5)
//	public void additemtocartTest() throws InterruptedException {
//		homepage.addanitemtocart();
//		Assert.assertEquals(true, homepage.cartvalue.isDisplayed());
//		logger.debug("item has been added of required sku");
//
//	}

	@AfterClass
	public void teardown() throws IOException {
		
		driver.quit();

	}

	@AfterMethod
	public synchronized void afterMethod(ITestResult result) throws IOException {

		if (ITestResult.FAILURE == result.getStatus()) {
			String fileName = result.getMethod().getMethodName() + ".png";
			TestUtil.getScreenshot(fileName);

		}
		
	}
	@AfterSuite
	public void runaftersuite() throws IOException
	{
		TestUtil.movefromreportstocurrentresultsfolder();
	}
}
