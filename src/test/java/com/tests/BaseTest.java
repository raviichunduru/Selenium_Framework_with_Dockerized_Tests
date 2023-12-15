package com.tests;

import driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Map;

public class BaseTest
{
    protected BaseTest() {};

    @BeforeMethod()
    protected void setUp(Object[] data)
    {
        Map<String, String> map = (Map<String, String>) data[0];
        Driver.initDriver(map.get("browser"), map.get("version"));
    }

    @AfterMethod
    protected void tearDown()
    {
        Driver.quitDriver();
    }
}
