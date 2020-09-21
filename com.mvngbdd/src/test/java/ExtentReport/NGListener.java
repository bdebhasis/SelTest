package ExtentReport;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import MVNGBDD.TestBase;

public class NGListener extends TestBase implements ITestListener {
	
	public static ExtentReports extent = ExtentManager.createInstance();
	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	String methoodname;
	
	
		public void onStart(ITestContext context) { 
		 System.out.println("onStart method started");
		 }
		 
		 public void onFinish(ITestContext context) {
		 System.out.println("onFinish method started");
		 if (extent != null)
			{extent.flush();}
		 }
		 
		 public void onTestStart(ITestResult result) {
			 ExtentTest test = extent.createTest(result.getTestClass().getName()+ "::" + 
					 								result.getMethod().getMethodName());
			 extentTest.set(test);
			 System.out.println("New Test Started" +result.getName());
		 }
		 
		 public void onTestSuccess(ITestResult result) {
			 String logText = "<b>Test Methode" + result.getMethod().getMethodName() + "Sucessful -  <b>";
			 Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN); 
			 extentTest.get().log(Status.PASS,m);
			 
			 System.out.println("onTestSuccess Method" +result.getName());
		 }
		 
		 public void onTestFailure(ITestResult result) {
			 
			 System.out.println("onTestFailure Method" +result.getName());
			 
			 String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
			 extentTest.get().fail("<details><summary><b><font colo=red>" + 
			 				"Expected Occured, click to see details:" + "</font></b></summary>" + 
			 				exceptionMessage.replaceAll(",", "br") + "</details> \n");
		
			 methoodname= result.getMethod().getMethodName();
			 String resultFileName= takeScreenshot(methoodname);
			 try {
				 extentTest.get().fail("<b><font color=red>" + "Screenshot of Failure" + "<font><b>",
						 				MediaEntityBuilder.createScreenCaptureFromPath(resultFileName).build());
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			 
			 String logText = "<b> Test Methode" + result.getMethod().getMethodName() + "Failed <b>";
			 Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED); 
			 extentTest.get().log(Status.FAIL,m);		 
		 }
		 
		 public void onTestSkipped(ITestResult result) {
			 String logText = "<b> Test Methode" + result.getMethod().getMethodName() + "Skipped <b>";
			 Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW); 
			 extentTest.get().log(Status.SKIP,m);
			 
			 System.out.println("onTestSkipped Method" +result.getName());
		 }
		 
		 public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		 System.out.println("onTestFailedButWithinSuccessPercentage" +result.getName());
		 }
}
