package com.seleniumsimplified.webdriver.drivers;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.seleniumsimplified.webdriver.manager.Driver;
import com.seleniumsimplified.webdriver.manager.ProxyPort;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HtmlUnitDriverTest {

    @Test
    public void basicHTMLUnitDriverBrowserVersion(){

        // changed to BrowserVersion.FIREFOX_24 from BrowserVersion.FIREFOX_3_6
        // when upgrading to WebDriver 2.42.2, if you are using a version below this
        // then change it back to FIREFOX_3_6
        WebDriver htmlunit = new HtmlUnitDriver(BrowserVersion.FIREFOX_24);

        htmlunit.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

        assertThat(htmlunit.getTitle(), is("HTML Form Elements"));

        htmlunit.quit();
    }

    @Test
    public void basicHTMLUnitDriverJavascriptOn(){

        WebDriver htmlunit = new HtmlUnitDriver(true);

        htmlunit.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

        assertThat(htmlunit.getTitle(), is("HTML Form Elements"));

        htmlunit.quit();
    }

    @Test
         public void basicHTMLUnitDriverCapabilities(){

        DesiredCapabilities capabilities = new DesiredCapabilities();
        // setting this to false does not impact firefox
        capabilities.setJavascriptEnabled(true);

        WebDriver htmlunit = new HtmlUnitDriver(capabilities);

        htmlunit.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

        assertThat(htmlunit.getTitle(), is("HTML Form Elements"));

        htmlunit.quit();
    }

    @Test
    public void basicHTMLUnitDriverProxyCapabilities(){

        //run this only if proxy is running e.g. Fiddler or BrowserMobProxy or BurpSuite etc.
        if(ProxyPort.inUse(Driver.PROXYHOST, Driver.PROXYPORT)) {

            DesiredCapabilities capabilities = new DesiredCapabilities();
            // setting this to false does not impact firefox
            capabilities.setJavascriptEnabled(true);

            org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
            proxy.setHttpProxy(Driver.PROXY)
                    .setFtpProxy(Driver.PROXY)
                    .setSslProxy(Driver.PROXY);
            capabilities.setCapability(CapabilityType.PROXY, proxy);

            WebDriver htmlunit = new HtmlUnitDriver(capabilities);

            htmlunit.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

            assertThat(htmlunit.getTitle(), is("HTML Form Elements"));

            htmlunit.quit();

        }else{
            System.out.println(
                    "No Proxy seemed to be running on " +
                            Driver.PROXY +
                            " so didn't run test basicHTMLUnitDriverProxyCapabilities");
        }
    }
}
