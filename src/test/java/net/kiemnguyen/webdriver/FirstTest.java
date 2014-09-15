package net.kiemnguyen.webdriver;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class FirstTest 
{
	@Test
    public void driveIsTheMan()
    {
		WebDriver driver = new HtmlUnitDriver();
		driver.get("http://www.echo.com");
		
        assertTrue( driver.getTitle().startsWith("Home") );
    }
	
	@Test
    public void firefoxIsSupportedByWebDriver()
    {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.echo.com");
		
        assertTrue( driver.getTitle().startsWith("Home") );
        driver.close();
    }
}
