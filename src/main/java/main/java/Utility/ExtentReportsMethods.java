//package main.java.Utility;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.configuration.ChartLocation;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//
//public class ExtentReportsMethods {
//	
//private static ExtentReports extent;
//    
//    public static ExtentReports getInstance() {
//    	if (extent == null)
//    		createInstance(System.getProperty("user.dir")+"extent.html");
//    	
//        return extent;
//    }
//    
//    public static ExtentReports createInstance(String fileName) {
//        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
//        ExtentReportSpark
//        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
//        htmlReporter.config().setChartVisibilityOnOpen(true);
//        htmlReporter.config().setTheme(Theme.STANDARD);
//        htmlReporter.config().setDocumentTitle(fileName);
//        htmlReporter.config().setEncoding("utf-8");
//        htmlReporter.config().setReportName(fileName);
//        
//        extent = new ExtentReports();
//        extent.attachReporter(htmlReporter);
//        
//        return extent;
//    }
//}
//
