package pages;

import driver.DriverManager;

public class AmazonLaptopPage
{
    public String getTitle()
    {
        return DriverManager.getDriver().getTitle();
    }
}
