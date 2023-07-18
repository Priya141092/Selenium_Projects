package main.java.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.events.WebDriverListener;

import main.java.Utility.WebEventListener;


public class Basecl {

	public static WebDriver driver;
	public static Properties prop;
	
	
	public Basecl()
	{
		try
		{
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\priyasaxena\\eclipse-workspace\\NAGP_Selenium_Assignment\\src\\main\\resources\\data.properties");
			prop.load(ip);
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void initialization()
	{    
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--remote-allow-origins=*");
	    //WebDriver driver = new ChromeDriver(options);
		String browsername = prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
			
			driver= new ChromeDriver(options);
		
		}
			
		if(browsername.equals("FF"))
		{
			
			driver= new FirefoxDriver();
		}
		
		if(browsername.equals("IE"))
		{
			driver= new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
	}


}
