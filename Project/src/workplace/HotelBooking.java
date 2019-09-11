package workplace;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelBooking extends BaseClass {

	@Test
	public void shouldBeAbleToSearchForHotels() {

		driver.findElement(By.linkText("Hotels")).click();
		WebElement localityTextBox = driver.findElement(By.id("Tags"));
		localityTextBox.sendKeys("indiranagar");
		List<WebElement> fromlist = driver.findElements(By.xpath("//ul[@id='ui-id-1'] //li[@class='list']"));
		for (int i = 0; i < fromlist.size(); i++) {
			String data = fromlist.get(i).getText();
			if (data.contains("Bangalore")) {
				fromlist.get(i).click();
				break;
			}
		}

		driver.findElement(By.id("CheckInDate")).click();

		selectDate("//div[@class='monthBlock first'] //span[@class='ui-datepicker-month']", "November",
				"//td[@ data-handler='selectDay'] ", "29");

		driver.findElement(By.id("CheckOutDate")).click();

		selectDate("//div[@class='monthBlock first'] //span[@class='ui-datepicker-month']", "December",
				"//td[@ data-handler='selectDay'] ", "22");

		Select s = new Select(driver.findElement(By.id("travellersOnhome")));
		s.selectByVisibleText("1 room, 1 adult");
		driver.findElement(By.id("SearchHotelsButton")).click();

		Assert.assertTrue(isElementPresent(By.className("searchSummary")));
	}

	private void selectDate(String MxPath, String MValue, String DxPath, String DValue) {

		while (!driver.findElement(By.xpath(MxPath)).getText().contains(MValue)) {
			driver.findElement(By.xpath("//a[@class='nextMonth ']")).click();
		}
		List<WebElement> fromlist = driver.findElements(By.xpath(DxPath));
		for (int i = 0; i < fromlist.size(); i++) {
			String data = fromlist.get(i).getText();
			if (data.contains(DValue)) {
				fromlist.get(i).click();
				break;
			}
		}
	}
	protected boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}


}
