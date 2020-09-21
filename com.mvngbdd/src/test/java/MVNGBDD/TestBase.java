package MVNGBDD;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TestBase {
	
	public static WebDriver driver;
	
	public void driverBase ()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"/Drivers/chromedriver.exe");
		
		driver = new ChromeDriver();
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
	}
	
	public static String takeScreenshot(String methodename)
	{
		String filename = getScreenshotname(methodename);
		String directory = System.getProperty("user.dir") + "/screenshot/";
		new File(directory).mkdirs();
		String path = directory + filename;
		
       TakesScreenshot scrShot =((TakesScreenshot)driver);
        
      //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination
                File DestFile=new File(path);

                //Copy file at destination
                try {
					FileUtils.copyFile(SrcFile, DestFile);
				} catch (IOException e) {
					
					e.printStackTrace();
				}
                
       return path;
	}
	
	public static String getScreenshotname(String methodename)
	{
		LocalDateTime currentTime = LocalDateTime.now();
		LocalDate d = currentTime.toLocalDate();
		
		String filename = methodename + "_" + d.toString().replace(":", "_").replace(" ", "_") + ".png";
		return filename;
		
	}

}
