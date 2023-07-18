package TestNg_Classes;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import main.java.Utility.TestUtil;
import main.java.base.Basecl;
import pages.Add_to_cart_page;

@Listeners(main.java.Utility.TestListeners.class)
public class Add_to_cart_pageTest extends Basecl {
	
	

	Add_to_cart_page addtocart;

	private static final Logger logger = LogManager.getLogger(Add_to_cart_pageTest.class);

	public Add_to_cart_pageTest() {
		super();
	}

	@BeforeSuite(alwaysRun = true)
	public void setReporting() throws IOException {

		TestUtil.changetoarchiveddiretory();

		logger.debug("creating report and moving to directory");

	}

	@BeforeClass()
	public void setup() {
		initialization();
		addtocart = new Add_to_cart_page();

	}

	@Test(priority = 1)
	public void clickitemTest() {
		addtocart.clickitem();
		String urlrad = driver.getCurrentUrl();
		Assert.assertEquals(urlrad, prop.getProperty("urltee"));
		logger.debug("The user gets successfully navigated to selected shirt");
	}

	@Test(priority = 2)
	public void selectoptions() throws InterruptedException {
		addtocart.selectoptions();
		boolean value = addtocart.selectcolor.isDisplayed();
		Assert.assertEquals(value, true);
		logger.debug("the options are selected sucessfully");
		logger.error("options are selected accordingly");
	}

	@Test(priority = 3)
	public void addtocartTest() throws InterruptedException {

		addtocart.addtocart();
		AssertJUnit.assertEquals(true, addtocart.cartvalue.isDisplayed());
		logger.error("added to cart succesfully");
	}
	
	@Test(priority = 4)
	public void checkoutTest() throws InterruptedException {

		addtocart.movetocart();	
//		boolean checkoutvalue =addtocart.checkout.isEnabled();
//		Assert.assertEquals(checkoutvalue, true);
//		logger.error("Checkout pop up is displayed");
	}

	@AfterClass
	public void teardown() throws IOException {
		// TestUtil.changenewReportDirectory();
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
