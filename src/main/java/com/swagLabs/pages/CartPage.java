package com.swagLabs.pages;

import com.swagLabs.utils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
//    Variables
    private final WebDriver driver;

//    Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

//  Dynamic Locators
    private final By checkout_button = By.id("checkout");

//    Actions
    public CartPage navigateToCartPage(String cartPage){
        BrowserActions.navigateToURL(driver,cartPage);
        return this;
    }
    public CartPage clickCheckoutButton(){
        Waits.waitForElementToBeClickable(driver, checkout_button);
        ElementActions.clickElement(driver, checkout_button);
        return this;
    }

//    Validation
    public CartPage assertSuccessfulPageTitle(String title){
        Validations.validatePageTitle(driver,title);
        return this;
    }

    public CartPage assertCheckoutPage(String checkoutPage){
        CustomSoftAssertion.softAssertion.assertEquals(BrowserActions.getCurrentURL(driver),checkoutPage, "URL is not as expected");
        return this;
    }


    public CartPage assertSuccessfulCheckoutPage(String checkoutPage){
        Validations.validatePageUrl(driver,checkoutPage);
        return this;
    }
}
