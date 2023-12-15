package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class DockerGridTest
{
    @Test(dataProvider = "getData")
    public void runTestsInSeleniumGrid (String browser, String version) throws MalformedURLException
    {
        String gridHubUrl = "http://localhost:4444/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser);
        capabilities.setVersion(version);

        WebDriver driver = new RemoteWebDriver(new URL(gridHubUrl), capabilities);
        driver.get("https://www.google.com");
        System.out.println("title : " +driver.getTitle());
        driver.quit();
    }

    @DataProvider(parallel = true)
    public Object[][] getData()
    {
        return new Object[][]
        { {"chrome", "119.0"}, {"firefox", "120.0"} };
    }
}
