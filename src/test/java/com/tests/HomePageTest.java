/*
    validate whether title containing google  --     validate whether title is not null and leangth of title is greater than 15 and less than 100
    check for link in page and validate presence of "Testing mini bytes - youtube" --    number of links displayed is exactly 10 or 15
 */
package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static driver.DriverManager.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public final class HomePageTest extends BaseTest
{
    private HomePageTest() {}

    @Test
    public void test3()
    {
        getDriver().findElement(By.name("q")).sendKeys("Testing mini bytes - Youtube",Keys.ENTER);
        String title = getDriver().getTitle();

        assertThat(title)
                .as("title is null").isNotNull()
                .as("Google Search text is not in title").containsIgnoringCase("Google Search")
                .as("title pattern is incorrect").matches("\\w.*"+"Google Search")
                .as("title is size is in between 16 and 99").hasSizeBetween(16,99);

        List<WebElement> elements = getDriver().findElements(By.xpath("//h3"));

        assertThat(elements)
                .as("number of links are not 9").hasSize(9)
                .extracting(WebElement::getText)
                .as("link with text as Testing Mini Bytes not found").contains("Testing Mini Bytes");
    }

}
