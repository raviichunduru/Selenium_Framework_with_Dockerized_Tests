package driver;

import factories.DriverFactory;
import enums.ConfigProperties;
import exceptions.BrowserInvocationException;

import java.net.MalformedURLException;
import java.util.Objects;

import static utils.PropertyUtils.getValue;

public class Driver
{
    private Driver() {}

    public static void initDriver(String browser, String version)
    {
        if (Objects.isNull(DriverManager.getDriver()))
        {
            try
            {
                DriverManager.setDriver(DriverFactory.getDriver(browser,version));
            }
            catch (MalformedURLException e)
            {
                throw new BrowserInvocationException("Browser Invocation Failed");
            }
        }
        DriverManager.getDriver().get(getValue((ConfigProperties.URL)));
        DriverManager.getDriver().manage().window().maximize();
    }

    public static void quitDriver()
    {
        if(Objects.nonNull(DriverManager.getDriver()))
        {
            DriverManager.getDriver().quit();
            DriverManager.unLoad();
        }
    }
}