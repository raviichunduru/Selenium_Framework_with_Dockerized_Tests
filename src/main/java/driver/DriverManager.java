package driver;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

public final class DriverManager
{
    private DriverManager() {}
    private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    public static WebDriver getDriver()
    {
        return threadLocal.get();
    }

    protected static void setDriver (WebDriver driveRef)
    {
        if(Objects.nonNull(driveRef))
        {
            threadLocal.set(driveRef);
        }
    }

    protected static void unLoad()
    {
        threadLocal.remove();
    }
}
