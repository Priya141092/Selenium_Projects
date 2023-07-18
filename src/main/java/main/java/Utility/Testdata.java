package main.java.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.IllegalFormatException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Testdata {
	static String projpath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	String excelpath = System.getProperty("excelpath");
	//String excelpath ="C:\\Users\\priyasaxena\\eclipse-workspace\\NAGP_Selenium_Assignment\\Datafiles\\Details.xlsx";
	String sheetname="Details";
	
	public Testdata(String excelpath, String sheetname)
	{
		
		  try {
			  projpath = System.getProperty("user.dir");
			//workbook = new XSSFWorkbook(projpath+"/Datafiles/Details.xlsx");
			workbook = new XSSFWorkbook(excelpath);
			//sheet = workbook.getSheet("Details");
			sheet = workbook.getSheet(sheetname);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	}
	
	 
	public static void main(String args[]) throws IOException
	{
		//getRowCount();	
		getCellDataString(1,1);
	}
	
	 public static int getRowCount() throws IOException
	 {
		 int rowscount=0;
		 
		 try
		 {
		  
		  rowscount = sheet.getPhysicalNumberOfRows();
	     System.out.println("no of rwos"+rowscount);
		 }
		 catch(Exception e)
		 {
			 System.out.println(e.getMessage());
		 }
		 return rowscount;
	 }
		 
		 public static String getCellDataString(int rowNum, int colNum) throws IOException
		 {  String celldata =null;
			 
			 try
			 {
			 
			   celldata = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			
			 }
			 catch(Exception e)
			 {
				System.out.println(e.getMessage());
			 }
			 return celldata;
			 
		 }
		 public static void getCellDataNumeric(int rowNum, int colNum) throws IOException
		 {
			 
			 try
			 {
//			 projpath = System.getProperty("user.dir");
//			  workbook = new XSSFWorkbook(projpath+"/Datafiles/Details.xlsx");
//			  sheet = workbook.getSheet("Details");
			  double celldata = sheet.getRow(rowNum).getCell(rowNum).getNumericCellValue();
			 // System.out.println(celldata);
			 }
			 catch(Exception e)
			 {
				System.out.println(e.getMessage());
			 }
		 }
		 public static int getColCount() throws IOException
		 {   
			 int colcount=0;
			 
			 try
			 {
			  
			  colcount = sheet.getRow(0).getPhysicalNumberOfCells();
		     System.out.println("no of cols"+colcount);
			 }
			 catch(Exception e)
			 {
				 System.out.println(e.getMessage());
			 }
			 return colcount;
		 }
		 
	 }
	


