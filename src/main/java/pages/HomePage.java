package pages;

import enums.WaitStrategy;
import org.openqa.selenium.By;

public class HomePage extends BasePage
{
    private final By linkWelcome = By.xpath("//p[@class='oxd-userdropdown-name']");
    private final By linkLogout  = By.xpath("//a[text()='Logout']");

    public HomePage clickWelcome()
    {
        click(linkWelcome, WaitStrategy.CLICKABLE,"welcome link");
        return this;
    }

    public LoginPage clickLogout()
    {
        click(linkLogout, WaitStrategy.CLICKABLE,"logout link");
        return new LoginPage();
    }
}
