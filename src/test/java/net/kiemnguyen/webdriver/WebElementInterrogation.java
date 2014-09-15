package net.kiemnguyen.webdriver;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebElementInterrogation {
	@Test
	public void myTest() {
		final WebDriver driver;
		final String testUrl = "http://www.compendiumdev.co.uk" + "/selenium/basic_web_page.html";
		
		driver = new FirefoxDriver();
		
		driver.navigate().to(testUrl);
		
		//Web Element represents on Object in the DOM. If we want to interrogate, we have to locate first
		WebElement para1 = driver.findElement(By.id("para1"));
		
		//Inspect the WebElement using the exposed method
		assertEquals(para1.getText(), "A paragraph of text");
		
		driver.close();
		
	}
}
