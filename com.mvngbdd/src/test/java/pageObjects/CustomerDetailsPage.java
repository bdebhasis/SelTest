package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CustomerDetailsPage {
	
	public WebDriver cdriver;
	
	public CustomerDetailsPage(WebDriver rdriver)
	{
		cdriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	By lnkCustomer_menu= By.xpath("/html/body/div[3]/div[2]/div/ul/li[4]/a");
	

}
