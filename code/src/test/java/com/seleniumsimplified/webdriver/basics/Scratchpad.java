package com.seleniumsimplified.webdriver.basics;

import com.seleniumsimplified.webdriver.manager.Driver;
import org.junit.*;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.CombinableMatcher.both;


/**
 * This is not a test in the main course.
 *
 * It is a file that I add for experimenting with code.
 *
 * It should be ignored.
 *
 * The code in here may not actually work.
 */
@Ignore("Because this is a scratchpad and I only want to use it when I need it, it might have random stuff in it")
public class Scratchpad {

    private static WebDriver driver;


    @Before
    public void setup(){

        // frame example to base work on
        driver = Driver.get("http://compendiumdev.co.uk/selenium/basic_html_form.html");
    }

    @Test
    public void myStuff(){

        Assert.assertThat("The Answer", both(containsString("The")).and(containsString("Answer")));

       /* Actions clickOnCB1 = new Actions(driver).
                            click(driver.findElement((By.cssSelector("input[value='cb1']"))));

        clickOnCB1.perform();
        clickOnCB1.perform();
        clickOnCB1.perform();

        System.out.println("BreakPoint");*/
    }

    @After
    public void cleanup(){
        driver.quit();
    }



}
