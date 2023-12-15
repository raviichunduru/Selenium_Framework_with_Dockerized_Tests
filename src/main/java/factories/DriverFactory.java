package factories;

import enums.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.PropertyUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public final class DriverFactory 
{
    private DriverFactory () {}
    
    public static WebDriver getDriver(String browser, String version) throws MalformedURLException
    {
        String runMode = PropertyUtils.getValue(ConfigProperties.RUNMODE);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        WebDriver driver = null;

        if (browser.equalsIgnoreCase("chrome"))
        {
            if (runMode.equalsIgnoreCase("remote"))
            {
                capabilities.setBrowserName("chrome");
                ChromeOptions options = new ChromeOptions();
                options.setCapability("browserVersion", version);
                options.setCapability("selenoid:options", new HashMap<String, Object>() {{
                    put("enableVNC", "true");
                    put("enableVideo", "true");
                    put("videoName", "chrome_test.mp4");
                }});
                driver =  new RemoteWebDriver(new URL(PropertyUtils.getValue(ConfigProperties.SELENOIDHOST)), capabilities);
            }
            else
            {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
        }

        else if (browser.equalsIgnoreCase("firefox"))
        {
            if (runMode.equalsIgnoreCase("remote"))
            {
                capabilities.setBrowserName("firefox");
                FirefoxOptions options = new FirefoxOptions();
                options.setCapability("browserVersion", version);
                options.setCapability("selenoid:options", new HashMap<String, Object>() {{
                    put("enableVNC", "true");
                    put("enableVideo", "true");
                    put("videoName", "firefox_test.mp4");
                }});
                driver =  new RemoteWebDriver(new URL(PropertyUtils.getValue(ConfigProperties.SELENOIDHOST)), capabilities);
            }
            else
            {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        }
        return driver;
    }
}
