package ExtentReport;



import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.*;



public class ExtentManager {
	
	public static ExtentReports extent;
	public static ExtentHtmlReporter htmlReporter;
	
	public static ExtentReports createInstance()
	{
		String fileName = getReportName();
		System.out.println(fileName);
		System.out.println(System.getProperty("user.dir"));
		String directory = System.getProperty("user.dir") + "/report/";
		new File(directory).mkdir();
		String path = directory + fileName;
		System.out.println(path);
		
		htmlReporter = new ExtentHtmlReporter(path);
		
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Automation Test Result");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.setSystemInfo("Organization", "BDEBHASIS LET ROACK");
		extent.setSystemInfo("Browser", "Chrome");
		extent.attachReporter(htmlReporter);
				
		return extent;
		
	}

	private static String getReportName() {
		LocalDateTime currentTime = LocalDateTime.now();
		LocalDate d = currentTime.toLocalDate();
		String filename = "AutomationReport_" + "_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
		return filename;
	}
	

}
