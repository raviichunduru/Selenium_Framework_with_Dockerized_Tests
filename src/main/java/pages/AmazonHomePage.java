package pages;

import enums.WaitStrategy;
import org.openqa.selenium.By;

public final class AmazonHomePage extends BasePage
{
    private final By amazonHamburgerLink = By.xpath("//a[@id='nav-hamburger-menu']");

    public AmazonHamburgerMenuPage clickHamburgerMenu ()
    {
        click(amazonHamburgerLink, WaitStrategy.VISIBILITY, "HambugerMenu");
        return new AmazonHamburgerMenuPage();
    }

}
