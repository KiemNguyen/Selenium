package com.seleniumsimplified.webdriver.basics.manipulate.alerts;

import com.seleniumsimplified.webdriver.manager.Driver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class AlertHandlingExercisesTest {

    private static WebDriver driver;


    @Before
    public void setup(){
        driver = Driver.get("http://compendiumdev.co.uk/selenium/" +
                        "alerts.html");
    }

    @Test
    public void basicAlertHandlingTest(){

        WebElement alertButton;

        alertButton = driver.findElement(By.id("alertexamples"));

        alertButton.click();

        String alertMessage = "I am an alert box!";

        assertEquals(alertMessage, driver.switchTo().alert().getText());

        driver.switchTo().alert().accept();
    }

    @Test
    public void basicAlertHandlingDismissTest(){

        WebElement alertButton;

        alertButton = driver.findElement(By.id("alertexamples"));

        alertButton.click();

        String alertMessage = "I am an alert box!";

        assertEquals(alertMessage, driver.switchTo().alert().getText());

        driver.switchTo().alert().dismiss();
    }

    @Test
    public void basicConfirmHandlingAcceptTest(){

        WebElement confirmButton;
        WebElement confirmResult;

        confirmButton = driver.findElement(By.id("confirmexample"));
        confirmResult = driver.findElement(By.id("confirmreturn"));

        assertEquals("cret", confirmResult.getText());
        confirmButton.click();

        String alertMessage = "I am a confirm alert";

        Alert confirmAlert = driver.switchTo().alert();

        assertEquals(alertMessage,confirmAlert.getText());

        confirmAlert.accept();

        assertEquals("true", confirmResult.getText());
    }

    @Test
    public void basicConfirmHandlingDismissTest(){

        WebElement confirmButton;
        WebElement confirmResult;

        confirmButton = driver.findElement(By.id("confirmexample"));
        confirmResult = driver.findElement(By.id("confirmreturn"));

        assertEquals("cret", confirmResult.getText());
        confirmButton.click();

        String alertMessage = "I am a confirm alert";

        Alert confirmAlert = driver.switchTo().alert();

        assertEquals(alertMessage,confirmAlert.getText());

        confirmAlert.dismiss();

        assertEquals("false", confirmResult.getText());
    }

    @Test
    public void basicPromptConfirmHandlingAcceptTest(){

        WebElement promptButton;
        WebElement promptResult;

        promptButton = driver.findElement(By.id("promptexample"));
        promptResult = driver.findElement(By.id("promptreturn"));

        assertEquals("pret", promptResult.getText());
        promptButton.click();

        String alertMessage = "I prompt you";

        Alert promptAlert = driver.switchTo().alert();

        // IE prompt now shows the correct message so no need for any caveat
        assertEquals(alertMessage,promptAlert.getText());

        promptAlert.accept();

        assertEquals("change me", promptResult.getText());
    }

    @Test
    public void basicPromptConfirmHandlingDismissTest(){

        WebElement promptButton;
        WebElement promptResult;

        promptButton = driver.findElement(By.id("promptexample"));
        promptResult = driver.findElement(By.id("promptreturn"));

        assertEquals("pret", promptResult.getText());
        promptButton.click();

        String alertMessage = "I prompt you";

        Alert promptAlert = driver.switchTo().alert();

            // In IE the alert always used to return "Script Prompt:" and not the
            // actual prompt text but now it works fine
            assertEquals(alertMessage,promptAlert.getText());


        promptAlert.dismiss();

        assertEquals("pret", promptResult.getText());
    }

    // send text to prompt
    @Test
    public void basicPromptConfirmHandlingChangeAndAcceptTest(){

        WebElement promptButton;
        WebElement promptResult;

        promptButton = driver.findElement(By.id("promptexample"));
        promptResult = driver.findElement(By.id("promptreturn"));

        assertEquals("pret", promptResult.getText());
        promptButton.click();

        String alertMessage = "I prompt you";

        Alert promptAlert = driver.switchTo().alert();

        assertEquals(alertMessage,promptAlert.getText());

        promptAlert.sendKeys("Hello");
        promptAlert.accept();

        assertEquals("Hello", promptResult.getText());
    }

    @Test
    public void basicPromptConfirmHandlingChangeAndDismissTest(){

        WebElement promptButton;
        WebElement promptResult;

        promptButton = driver.findElement(By.id("promptexample"));
        promptResult = driver.findElement(By.id("promptreturn"));

        assertEquals("pret", promptResult.getText());
        promptButton.click();

        String alertMessage = "I prompt you";

        Alert promptAlert = driver.switchTo().alert();

        assertEquals(alertMessage,promptAlert.getText());

        promptAlert.sendKeys("Hello");
        promptAlert.dismiss();

        assertEquals("pret", promptResult.getText());
    }

    // Q: what happens if I send text to alert?
    // A: ElementNotVisibleException  in Firefox
    // A: in Chrome the text is sent
    @Test
    public void basicAlertHandlingKeysTest(){

        WebElement alertButton;
        WebElement alertResult;

        alertButton = driver.findElement(By.id("alertexamples"));

        alertButton.click();

        String alertMessage = "I am an alert box!";

        assertEquals(alertMessage, driver.switchTo().alert().getText());

        if(Driver.currentDriver == Driver.BrowserName.FIREFOX){
            try{
                driver.switchTo().alert().sendKeys("Hello keys Accept");
                fail("expected a ElementNotVisibleException thrown");
            }catch(ElementNotVisibleException e){
                assertTrue("Expected to get an exception", true);
            }
        }

        if(Driver.currentDriver == Driver.BrowserName.GOOGLECHROME){
            // chrome seems happy to send in text to an alert
            driver.switchTo().alert().sendKeys("Hello keys Accept");
        }

        driver.switchTo().alert().accept();
    }

}

