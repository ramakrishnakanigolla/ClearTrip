package workplace;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightBookingTest extends BaseClass {
	
	
	@Test
	public void testThatResultsAppearForAOneWayJourney() {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("OneWay")).click();
		selectlocation("FromTag","Bangalore");
		enterCityName("//ul[@id='ui-id-1'] //li[@class='list']", "Bangalore");
		
		selectlocation("ToTag","Delhi");
		enterCityName("//ul[@id='ui-id-2'] //li[@class='list']", "Delhi");
		
		while (!driver.findElement(By.xpath("//span[@class='ui-datepicker-month' or @class='ui-datepicker-year']"))
				.getText().contains("November")) {
			driver.findElement(By.xpath("//a[@ class='nextMonth ']")).click();
		}
		
		List<WebElement> dates = driver.findElements(By.xpath("//td[@ class=' undefined' or @class=' weekEnd undefined'] "));
		int count = dates.size();
		for (int i = 0; i < count; i++) {
			String Adate = dates.get(i).getText();
			if (Adate.equalsIgnoreCase("29")) {
				dates.get(i).click();
				break;
			}
		}
		driver.findElement(By.id("SearchBtn")).click();
		Assert.assertTrue(isElementPresent(By.className("searchSummary")));
	
		
		
	}

	private void selectlocation(String id, String value) {
		driver.findElement(By.id(id)).clear();
		driver.findElement(By.id(id)).sendKeys(value);
	}

	private void enterCityName(String xPath, String value) 
	{
		List<WebElement> list = driver.findElements(By.xpath(xPath));
		int count= list.size();
		for(int i=0;i<=count;i++)
		{
			String data = list.get(i).getText();
			if (data.contains(value)) {
				list.get(i).click();
				break;
			}
		}
			
	}
	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
