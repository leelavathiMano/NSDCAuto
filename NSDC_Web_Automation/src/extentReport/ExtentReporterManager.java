package extentReport;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterManager {

	static Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
    private static ExtentReports extent;
    private static String reportFileName = "Test-Automaton-Report"+timestamp+".html";
    private static String fileSeperator = System.getProperty("file.separator");
    private static String reportFilepath = System.getProperty("user.dir") +fileSeperator+ "TestReport";
    private static String reportFileLocation =  reportFilepath +fileSeperator+ reportFileName;
  
 
    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }
 
    //Create an extent report instance
    public static ExtentReports createInstance() {
        String fileName = getReportPath(reportFilepath);
       
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(reportFileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(reportFileName);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
 
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        //Set environment details
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("AUT", "QA");
 
        return extent;
    }
     
    //Create the report path
    private static String getReportPath (String path) {
    	File testDirectory = new File(path);
        if (!testDirectory.exists()) {
        	if (testDirectory.mkdir()) {
                System.out.println("Directory: " + path + " is created!" );
                return reportFileLocation;
            } else {
                System.out.println("Failed to create directory: " + path);
                return System.getProperty("user.dir");
            }
        } else {
            System.out.println("Directory already exists: " + path);
        }
		return reportFileLocation;
    }
 
}






























//
//
//	import java.io.File;
//	import java.util.Calendar;
//	import java.util.Date;
//	import java.util.List;
//	import java.util.Map;
//
//	import org.testng.IReporter;
//	import org.testng.IResultMap;
//	import org.testng.ISuite;
//	import org.testng.ISuiteResult;
//	import org.testng.ITestContext;
//	import org.testng.ITestResult;
//	import org.testng.xml.XmlSuite;
//
//	import com.relevantcodes.extentreports.ExtentReports;
//	import com.relevantcodes.extentreports.ExtentTest;
//	import com.relevantcodes.extentreports.LogStatus;
//
//	public class ExtentReporter implements IReporter {
//		private ExtentReports extent;
//
//		public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
//				String outputDirectory) {
//			extent = new ExtentReports("./test-output/Extent.html", true);
//
//			for (ISuite suite : suites) {
//				Map<String, ISuiteResult> result = suite.getResults();
//
//				for (ISuiteResult r : result.values()) {
//					ITestContext context = r.getTestContext();
//
//					buildTestNodes(context.getPassedTests(), LogStatus.PASS);
//					buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
//					buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
//				}
//			}
//
//			extent.flush();
//			extent.close();
//		}
//
//		private void buildTestNodes(IResultMap tests, LogStatus status) {
//			ExtentTest test;
//
//			if (tests.size() > 0) {
//				for (ITestResult result : tests.getAllResults()) {
//					test = extent.startTest(result.getMethod().getMethodName());
//
//					test.setStartedTime(getTime(result.getStartMillis()));
//					test.setEndedTime(getTime(result.getEndMillis()));
//
//					for (String group : result.getMethod().getGroups())
//						test.assignCategory(group);
//
//					if (result.getThrowable() != null) {
//						test.log(status, result.getThrowable());
//					} else {
//						test.log(status, "Test " + status.toString().toLowerCase()
//								+ "ed");
//					}
//
//					extent.endTest(test);
//				}
//			}
//		}
//
//		private Date getTime(long millis) {
//			Calendar calendar = Calendar.getInstance();
//			calendar.setTimeInMillis(millis);
//			return calendar.getTime();
//		}
//	}
//
