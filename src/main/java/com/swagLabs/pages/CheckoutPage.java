package com.swagLabs.pages;

import com.swagLabs.utils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
//    Variables
    private final WebDriver driver;

//    Constructor
    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

//    Locators
    private final By first_name = By.id("first-name");
    private final  By last_name = By.id("last-name");
    private final By zip_code = By.id("postal-code");
    private final By continue_button = By.id("continue");
    private  final By errorMessage = By.cssSelector("[data-test='error']");

//    Action
    public CheckoutPage navigateToCheckoutPage(String checkoutPageURL){
        BrowserActions.navigateToURL(driver,checkoutPageURL);
        return this;
    }

    public CheckoutPage enterCheckoutData(String firstName, String lastName, String postalCode){
        ElementActions.sendData(driver,first_name,firstName);
        ElementActions.sendData(driver,last_name,lastName);
        ElementActions.sendData(driver,zip_code,postalCode);
        Waits.waitForElementToBeClickable(driver,continue_button);
        ElementActions.clickElement(driver,continue_button);
        return this;
    }

//    Validations
    public CheckoutPage assertSuccessfulPageTitle(String title){
        Validations.validatePageTitle(driver,title);
        return this;
    }

    public String getErrorMessage(){
        return ElementActions.getText(driver,errorMessage);
    }

    public CheckoutPage assertOverviewPage(String overviewPageURL){
        CustomSoftAssertion.softAssertion.assertEquals(BrowserActions.getCurrentURL(driver),overviewPageURL, "URL is not as expected");
        return this;
    }

    public CheckoutPage assertSuccessfulCheckout(String overviewPageURL){
        Validations.validatePageUrl(driver,overviewPageURL);
        return this;
    }

    public CheckoutPage assertUnSuccessfulCheckout(String expectedMessage){
        Validations.validateEquals(getErrorMessage(),expectedMessage,"Unexpected error message");
        return this;
    }

}
