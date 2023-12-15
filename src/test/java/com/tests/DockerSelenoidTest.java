package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DockerSelenoidTest {
    @Test
    public static void runTestsInSelenoid() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        String selenoidUrl = "http://localhost:4444/wd/hub";

        capabilities.setBrowserName("chrome");
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("119.0");

        // Set Chrome options using Map
        Map<String, Object> chromeOptions = new HashMap<>();

        // Use a List for the 'args' key
        List<String> chromeArgs = Arrays.asList("--enableVNC=true", "--enableVideo=true", "--videoName=test.mp4");
        chromeOptions.put("args", chromeArgs);

        options.setCapability("goog:chromeOptions", chromeOptions);

        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        WebDriver driver = new RemoteWebDriver(new URL(selenoidUrl), capabilities);
        driver.get("https://www.google.com");
        Thread.sleep(10000);
        System.out.println("title : " + driver.getTitle());
        driver.quit();
    }
}
