package main.java.Utility;

import java.io.IOException;

public class ExcelData_Provider {
//	String excelpath ="C:\\Users\\priyasaxena\\eclipse-workspace\\NAGP_Selenium_Assignment\\Datafiles\\Details.xlsx";
//	String sheetname="Details";
	
	public static Object[][] exceldata(String excelpath, String sheetname) throws IOException
	{
		Testdata data1 = new Testdata(excelpath,sheetname);
		int rowcount = data1.getRowCount();
		int colcount= data1.getColCount();
		Object data[][] = new Object[rowcount-1][colcount];
		
		for(int i=1;i<rowcount;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				String celldata= data1.getCellDataString(i, j);
				System.out.println(celldata);
				data[i-1][j]=celldata;
			}
		}
		return data;
	}
	}

//}
