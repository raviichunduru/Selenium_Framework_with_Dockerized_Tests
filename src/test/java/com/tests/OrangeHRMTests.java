package com.tests;

import annotations.FrameworkAnnotations;
import enums.CategoryType;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.Map;

import static utils.DecodeUtils.getDecodedString;

public final class OrangeHRMTests extends BaseTest
{
    private OrangeHRMTests() {};

    @FrameworkAnnotations(Author = {"Ravi"},Category = {CategoryType.SMOKE}                          )
    @Test
    public void loginLogout(Map<String,String> userData)
    {
        String title = new  LoginPage()
                           .enterUserName(userData.get("username"))
                           .enterPassword(getDecodedString(userData.get("password")))
                           .clickLogin()
                           .clickWelcome().clickLogout()
                           .getTitle();

        Assertions.assertThat(title)
                           .as("Title mismatch").isEqualTo("OrangeHRM");
    }

    @FrameworkAnnotations(Author = {"Raja"},Category = {CategoryType.REGRESSION})
    @Test
    public void dummyTest(Map<String,String> userData)
    {
        String title = new  LoginPage()
                .enterUserName(userData.get("username"))
                .enterPassword(userData.get("password"))
                .clickLogin()
                .clickWelcome().clickLogout()
                .getTitle();

        Assertions.assertThat(title)
                .as("Title mismatch").isEqualTo("OrangeHRM1");
    }
}
