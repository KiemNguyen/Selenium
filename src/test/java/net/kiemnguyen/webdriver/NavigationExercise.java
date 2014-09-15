package net.kiemnguyen.webdriver;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationExercise {
	@Test
	public void navigateTo() {
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://compendiumdev.co.uk/selenium");
		assertTrue(driver.getTitle().startsWith("Selenium Simplified"));
		driver.navigate().to("http://compendiumdev.co.uk/selenium/search.php");
		assertTrue(driver.getTitle().startsWith("Selenium Simplified Search Engine"));
		driver.navigate().back();
		assertTrue(driver.getTitle().startsWith("Selenium Simplified"));
		driver.navigate().refresh();
	}
}
