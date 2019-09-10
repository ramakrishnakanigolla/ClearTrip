package workplace;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	

	 WebDriver driver;
	    @BeforeClass
	    public void setupApplication()
	    {
	    	Reporter.log("====Browser Session Started====", true);
	    	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	    	
	    	ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			
			driver = new ChromeDriver(options);
			driver.get("https://www.cleartrip.com/");
			Reporter.log("====Application Started====", true);
			    
	    }
	    
	    @AfterClass
	    void closeAppilcation()
	    {
	    	 driver.quit();
	    	 Reporter.log("====Browser closed====", true);
	    }

}
