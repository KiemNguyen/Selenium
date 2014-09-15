package net.kiemnguyen.webdriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InterrogationExercise {

	public static WebDriver driver;

	@BeforeClass
	public static void startDriver() {
		driver = new FirefoxDriver();
	}

	@Test
	public void interrogation() {
		final String pageURL = "http://compendiumdev.co.uk/selenium/basic_web_page.html";

		driver.navigate().to(pageURL);

		// Check if title equals "Basic Web Page Titlte"
		assertEquals(driver.getTitle(), "Basic Web Page Title");
		
		// Check if current URL is what I would expect
		assertEquals(driver.getCurrentUrl(), pageURL);

		// Check if page source contain "A paragraph of text"
		String pageSource = driver.getPageSource();
		assertTrue(pageSource.contains("A paragraph of text"));

	}

	@AfterClass
	public static void stopDriver() {
		driver.quit();
	}
}
