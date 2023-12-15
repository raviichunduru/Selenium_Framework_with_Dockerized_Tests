package pages;

import enums.WaitStrategy;
import org.openqa.selenium.By;

public final class AmazonSubMenuPage extends BasePage
{
    //private String linkSubMenu = "//a[text()='%s%']";
    private String linkSubMenu = "//a[text()='Laptops']";


    public AmazonLaptopPage clickSubMenuItem( )
    {
        //String newXPath = getXpath(linkSubMenu, subMenuItemName);
        //click(By.xpath(newXPath), WaitStrategy.NONE, subMenuItemName);

        //String newXPath = getXpath(linkSubMenu, subMenuItemName);
        click(By.xpath(linkSubMenu), WaitStrategy.CLICKABLE, "All Mobile Phones");
        return new AmazonLaptopPage();
    }


}
