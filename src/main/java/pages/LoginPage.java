package pages;

import enums.WaitStrategy;
import org.openqa.selenium.By;
import static driver.DriverManager.getDriver;

public final class LoginPage extends BasePage
{
    private final By textboxUsername = By.xpath("//input[@name='username']");
    private final By textboxPassword = By.xpath("//input[@name='password' and @type='password']");
    private final By btnLogin = By.xpath("//button[@type='submit']");

    public LoginPage enterUserName(String username)
    {
        sendKeys(textboxUsername,username, WaitStrategy.PRESENCE,"username");
        return this;
    }

    public LoginPage enterPassword(String password)
    {
        sendKeys(textboxPassword,password, WaitStrategy.NONE,"password ");
        return this;
    }

    public HomePage clickLogin()
    {
        click(btnLogin, WaitStrategy.CLICKABLE,"login button");
        return new HomePage();
    }

    public String getTitle()
    {
        return getDriver().getTitle();
    }
}
