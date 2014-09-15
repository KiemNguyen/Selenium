package net.kiemnguyen.junit;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JUnitExercise {
	public void fireFoxDriver() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://kiemnguyen.net");
		assertTrue(driver.getTitle().startsWith("Kiem"));
	}

}