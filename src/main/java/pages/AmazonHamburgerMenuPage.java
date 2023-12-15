package pages;

import enums.WaitStrategy;
import org.openqa.selenium.By;

public final class AmazonHamburgerMenuPage extends BasePage
{
    //private String linkMenu = "//div[text()='%s%']/parent::a']";
    private String linkMenu = "//div[text()='Mobiles, Computers']/parent::a";

    public AmazonSubMenuPage clickMenuItem()
    {
        //String newXPath = getXpath(linkMenu, menuItemName);
        //click(By.xpath(newXPath), WaitStrategy.NONE, menuItemName);

        //String newXPath = getXpath(linkMenu, menuItemName);
        click(By.xpath(linkMenu), WaitStrategy.VISIBILITY, "Mobiles, Computers");

        return new AmazonSubMenuPage();
    }
}
