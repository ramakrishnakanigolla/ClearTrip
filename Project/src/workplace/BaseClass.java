package workplace;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass  {

	WebDriver driver;

	
	
	@BeforeClass
	public void setupApplication() throws IOException {
		
		ReadPropertiesFile rp= new ReadPropertiesFile();
		
		Reporter.log("====Browser Session Started====", true);
		if(rp.getBrowser().contains("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");	
		}
		else if(rp.getBrowser().contains("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");	
		}
		else
		{
			System.setProperty("webdriver.IE.driver", "IEDriverServer.exe");
		}
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(rp.getURL());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Reporter.log("====Application Started====", true);

	}

	@AfterClass
	void closeAppilcation() {
		driver.quit();
		Reporter.log("====Browser closed====", true);
	}


	

}
