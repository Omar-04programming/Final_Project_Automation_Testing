package com.swagLabs.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;

public class Validations {
    private final By pageTitle = By.cssSelector("[data-test='title']");

    private Validations(){}

    public static void validateTrue(boolean condition, String message){
        Assert.assertTrue(condition,message);
    }

    public static void validateFalse(boolean condition, String message){
        Assert.assertFalse(condition,message);
    }

    public static void validateEquals(String actual, String expected, String message){
        Assert.assertEquals(actual, expected, message);
    }

    public static void validateNoteEquals(String actual, String expected, String message){
        Assert.assertNotEquals(actual, expected, message);
    }

    public static void validatePageUrl(WebDriver driver, String expected){
        Assert.assertEquals(BrowserActions.getCurrentURL(driver) , expected);
    }

    public static void validateEquals(int actual, int expected, String message){
        Assert.assertEquals(actual, expected, message);
    }

    public static void validateListContains(List<String> list, String expectedItem, String message){
        Assert.assertTrue(list.contains(expectedItem), message);
    }

    public static void validatePageTitle(WebDriver driver, String expectedTitle){
        String actualTitle = driver.findElement(By.cssSelector("[data-test='title']")).getText();
        Assert.assertEquals(actualTitle, expectedTitle, "Page title text is not as expected");
    }




}
