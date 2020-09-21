package stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;

public class CustomerDetails {
	
	public WebDriver driver;
	public CustomerDetails cd;
	
	@Before
	public void user_can_view_Before_the_Dashboard() {
		System.out.println("user_can_view_Before_the_Dashboard");
	}

	@After
	public void user_can_view_After_the_Dashboard() {
		System.out.println("user_can_view_After_the_Dashboard");
	}
	
	@Then("User can view the Dashboard")
	public void user_can_view_the_Dashboard() {
	
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_Menu() {

	}

	@When("click on customers Menu Item")
	public void click_on_customers_Menu_Item() {

	}

	@When("Click on Add New button")
	public void click_on_Add_New_button() {
	 
	}

	@Then("user can view Add new Customer page")
	public void user_can_view_Add_new_Customer_page() {

	}

	@When("User enter Customer info")
	public void user_enter_Customer_info() {
	
	}

	@When("Click on the Save button")
	public void click_on_the_Save_button() {

	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String string) {
	
	}



}
