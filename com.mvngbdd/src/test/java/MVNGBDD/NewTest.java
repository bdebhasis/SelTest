package MVNGBDD;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import ExtentReport.NGListener;

//@Listeners(NGListener.class)
public class NewTest extends TestBase {
	
	
  @Test(dataProvider = "dp",enabled=true)
  public void Test1(Integer n, String s) {
	  System.out.println("Test1");
	  driver.get("http://Google.com/");
	  System.out.println("Integer ->" + n + "String -." + s);
	  String expectedPageTitle = "Google";
	  Assert.assertTrue(driver.getTitle().contains(expectedPageTitle), "Test Failed");
	  
	  String logText = "<b> Title no Matched <b>";
	  Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN); 
	  NGListener.extentTest.get().log(Status.PASS,m);
	 
  }	
  
  @Test(invocationCount=2, threadPoolSize=1, enabled = true)
  @Parameters({"username","password"})
  public void Test2(String uname, String pass) {
	  System.out.println("Test2");
	  driver.get("http://Google.com/");
	  System.out.println("Integer ->" + uname + "String -." + pass);
	  String expectedPageTitle = "Googles";
	  //String actualtedPageTitle = "Googles";
	  if ((driver.getTitle().equals(expectedPageTitle)));
	  {
		  String logText = "<b> Title no Matched <b>";
		  Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN); 
		  NGListener.extentTest.get().log(Status.PASS,m);
	  };
	  
	
  }	
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("beforeMethod");
	  driverBase();
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("afterMethod");
	  driver.quit();	 
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("beforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("afterClass");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("beforeTest");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("afterTest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("beforeSuite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("afterSuite");
  }

}
