package factories;

import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static constants.FrameworkConstants.getExplicitWaitTimeout;
import static driver.DriverManager.getDriver;

public final class ExplicitWaitFactory
{
    private ExplicitWaitFactory() {};

    public static WebElement performExplicitWait(By by, WaitStrategy waitStrategy)
    {
        WebElement element=null;

        if(waitStrategy==WaitStrategy.PRESENCE)
        {
            element = new WebDriverWait(getDriver(),Duration.ofSeconds(getExplicitWaitTimeout())).until(ExpectedConditions.presenceOfElementLocated(by));
        }
        else if (waitStrategy==WaitStrategy.VISIBILITY)
        {
           element =  new WebDriverWait(getDriver(),Duration.ofSeconds(getExplicitWaitTimeout())).until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        else if (waitStrategy == WaitStrategy.CLICKABLE)
        {
          element =   new WebDriverWait(getDriver(), Duration.ofSeconds(getExplicitWaitTimeout())).until(ExpectedConditions.elementToBeClickable(by));
        }
        else
        {
            element = getDriver().findElement(by);
        }
        return element;
    }
}
