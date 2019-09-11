package workplace;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightBookingTest extends BaseClass {

	@Test
	public void testThatResultsAppearForAOneWayJourney() throws IOException {
		
		ReadPropertiesFile rp=new ReadPropertiesFile();
		driver.findElement(By.id(rp.getWay())).click();
		selectlocation(rp.getflightfromtag(), rp.getflightfromvalue());
		
		getTheValue(rp.getxpathoffromlist(), rp.getflightfromvalue());

		selectlocation(rp.getflighttotag(), rp.getflighttovalue());
		getTheValue(rp.getxpathoftolist(), rp.getflighttovalue());

		while (!driver.findElement(By.xpath(rp.getmonthxpath()))
				.getText().contains(rp.getmonth())) {
			driver.findElement(By.xpath(rp.getclicknextxpath())).click();
		}
		getTheValue(rp.getalldatesxpath(), rp.getdate());
		driver.findElement(By.id(rp.getsearchbuttonid())).click();
		Assert.assertTrue(isElementPresent(By.className("searchSummary")));

	}

	private void selectlocation(String id, String value) {
		driver.findElement(By.id(id)).clear();
		driver.findElement(By.id(id)).sendKeys(value);
	}

	private void getTheValue(String xPath, String value)
	{
		List<WebElement> list = driver.findElements(By.xpath(xPath));
		int count = list.size();
		for (int i = 0; i <= count; i++) {
			String data = list.get(i).getText();
			if (data.contains(value)) {
				list.get(i).click();
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
