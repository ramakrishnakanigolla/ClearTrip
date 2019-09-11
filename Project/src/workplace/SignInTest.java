package workplace;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest extends BaseClass {

	@Test
	public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

		driver.findElement(By.id("userAccountLink")).click();
		driver.findElement(By.id("SignIn")).click();
		driver.switchTo().frame("modal_window");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("ramakanigolla@gmail.com");
		driver.findElement(By.id("password")).sendKeys("1234567890");
		driver.findElement(By.id("signInButton")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id='errors1']/ol/li")).getText());
		Assert.assertTrue(isElementPresent(By.className("primary")));
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
