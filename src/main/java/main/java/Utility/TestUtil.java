package main.java.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;
import java.util.IllegalFormatException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import main.java.base.Basecl;

public class TestUtil extends Basecl {
	
	
	
	static public void selectiondropdown(WebElement t, String s)
	{
		Select st = new Select(t);
		st.selectByValue(s);
	}
	
	public static long PAGE_LOAD_TIME = 10;
	public static long IMPLICIT_WAIT= 10;
	
	
		 public static void scrollpage(WebElement Element)
		 {
			 JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("arguments[0].scrollIntoView();", Element);

		 }
		 
		 public static void scrollpagetoclick(WebElement Element)
		 {
			 JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			 jsExecutor.executeScript("arguments[0].click();", Element);
		 }
		 
		 public static void Mousehover(WebElement ele)
		 {
			 Actions action = new Actions(driver);
			action.moveToElement(ele).click().perform();
			//action.doubleClick(ele).perform();
		 }

	 public static void waitcondition(WebElement t2)
	 {
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.elementToBeClickable(t2)).click();

	 }
       public static void getScreenshot(String filename) throws IOException
       {

    	   TakesScreenshot ts = (TakesScreenshot) driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);

			try {
				//FileUtils.copyFile(srcFile, new File("./Screenshots/" ));
				FileUtils.copyFile(srcFile, new File("./Screenshots/" + filename));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
       
       public static void changenewReportDirectory() throws IOException
       {
    	   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
    	   Date date = new Date();
    	   String dateTime = dateFormat.format(date);
    	   
    	   //File currentFolder = new File("Current test results/" + dateTime);
    	   File currentFolder = new File("Current test results/" +dateTime);
    	   currentFolder.mkdirs();


    	   File reports = new File("index.html");
    	   FileUtils.moveFileToDirectory(reports, currentFolder, true);

 	  
       }
       public static void movefromreportstocurrentresultsfolder() throws IOException
       {
    	   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
    	   Date date = new Date();
    	   String dateTime = dateFormat.format(date);
    	   
    	   //File currentFolder = new File("Current test results/" + dateTime);
    	   File currentFolder = new File("Current test results/" +dateTime);
    	   currentFolder.mkdirs();
    	   

    	  File path = new File("./reports/index.html");
    	 // Files.move(path, currentFolder);
    	  FileUtils.moveFileToDirectory(path, currentFolder, true);

 	  
       }
       
       
       
  public static void changetoarchiveddiretory() throws IOException
  {
	  
	  DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
	  Date date = new Date();
	  String dateTime = dateFormat.format(date);
	  File archivedFolder = new File("Archived test results/" +dateTime);
	
	  archivedFolder.mkdirs();
	 // String sourcepath = "./Current test results";
	 //File path = new File("./Current test results");
	 // FileUtils.moveFileToDirectory(path, archivedFolder,true);

	  File[] files = new File("Current test results/" ).listFiles();
	  for (File file : files) {
	      if (file.isFile()) {
	          FileUtils.moveFileToDirectory(file, archivedFolder, true);
	    	 
	      }
	  }

	  FileUtils.cleanDirectory(new File("Current test results/"));
  }
  
		 	 

}

