package workplace;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelBooking extends BaseClass {

	@Test
	public void shouldBeAbleToSearchForHotels() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Hotels")).click();
		WebElement localityTextBox = driver.findElement(By.id("Tags"));
		localityTextBox.sendKeys("indiranagar");
		
		selectValue("//ul[@id='ui-id-1'] //li[@class='list']","Bangalore");
		
		driver.findElement(By.id("CheckInDate")).click();
		
		selectMonth("//div[@class='monthBlock first'] //span[@class='ui-datepicker-month']","November");
		
		selectValue("//td[@ data-handler='selectDay'] ","29");
		
		driver.findElement(By.id("CheckOutDate")).click();
		
		selectMonth("//div[@class='monthBlock first'] //span[@class='ui-datepicker-month']","December");
		
		selectValue("//td[@ data-handler='selectDay'] ","2");
		Select s =new Select(driver.findElement(By.id("travellersOnhome")));
		s.selectByVisibleText("1 room, 1 adult");
		driver.findElement(By.id("SearchHotelsButton")).click();
		
		Assert.assertTrue(isElementPresent(By.className("searchSummary")));
	}

	private void selectMonth(String xPath,String value) {
		while(!driver.findElement(By.xpath(xPath)).getText().contains(value))
		{
			driver.findElement(By.xpath("//a[@class='nextMonth ']")).click();
		}
	}

	private void selectValue(String xPath,String Value) {
		List<WebElement> fromlist = driver.findElements(By.xpath(xPath));
		for (int i = 0; i < fromlist.size(); i++)
		{
			String data = fromlist.get(i).getText();
			if (data.contains(Value))
			{
				fromlist.get(i).click();
				break;
			}
		}
	}
	
	private boolean isElementPresent(By hotel) {
		try {
			driver.findElement(hotel);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	

}
