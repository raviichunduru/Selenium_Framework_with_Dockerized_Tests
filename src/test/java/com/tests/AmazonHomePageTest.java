package com.tests;

import annotations.FrameworkAnnotations;
import enums.CategoryType;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.AmazonHomePage;

import java.util.Map;

public final class AmazonHomePageTest extends BaseTest
{
    private AmazonHomePageTest() {}

    @FrameworkAnnotations(Author = {"Ravi", "Raja"}, Category = {CategoryType.REGRESSION, CategoryType.SMOKE})
    @Test
    public void AmazonTest(Map<String, String> data)
    {
       String title =
                      new AmazonHomePage()
                              .clickHamburgerMenu()
                              .clickMenuItem()
                              .clickSubMenuItem()
                              .getTitle();

       Assertions.assertThat(title).isEqualTo("Laptop Prices in India: Buy Laptops Online at Low Prices | Windows, Mac, DOS Laptops - Amazon.in");
    }
}