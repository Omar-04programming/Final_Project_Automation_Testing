
package com.swagLabs.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementActions {
    private ElementActions(){}

    public static void sendData(WebDriver driver, By locator, String data){
        WebElement element = Waits.waitForElementToBeVisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        element.clear();
        element.sendKeys(data);
    }

    public static void clickElement(WebDriver driver, By locator){
        WebElement element = Waits.waitForElementToBeClickable(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        element.click();
    }

    public static String getText(WebDriver driver, By locator) {
        WebElement element = Waits.waitForElementToBeVisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        return element.getText();
    }

    public static WebElement findElement(WebDriver driver, By locator){
        return driver.findElement(locator);
    }
}
