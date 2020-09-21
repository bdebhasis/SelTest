package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.*;

import pageObjects.LoginPage;

public class LoginSteps {
	
	public WebDriver driver;
	public LoginPage lp;
	

	
	@Given("User Launch Chrome Browser")
	public void user_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		lp= new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String uname, String pwd) {
		lp.setUserName(uname);
		lp.setPassword(pwd);
	}

	@When("Click on the Login")
	public void click_on_the_login() {
		lp.clickLogin();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
		if (driver.getPageSource().contains("Login was unsucessful."))
		{
			driver.close();
			Assert.assertTrue(false);
		}else
			{
				Assert.assertEquals(title, driver.getTitle());
			}
		}


	@When("User click on the Log out Link")
	public void user_click_on_the_log_out_link() {
	 lp.clickLogout();   
	}

	@Then("Close the Browser")
	public void close_the_browser() {
	    driver.close();
	}




}
