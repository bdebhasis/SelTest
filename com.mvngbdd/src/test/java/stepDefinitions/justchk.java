package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;



public class justchk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String url = "https://www.dsw.com";
	      driver.get(url);
	      driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	      
	      driver.findElement(By.xpath("//app-top-navigation-list//ul[1]//li[3]")).click();
	      
	      List<WebElement> links = driver.findElements(By.xpath("//*[@class=\"shoe-size-grid__size-button\"]"));
	      System.out.println("the number of links is " + links.size());
	      
	      for (WebElement var : links) 
	      { 
	    	  System.out.println(var.getText());
	      }
	      
	      driver.close();
	}

}
