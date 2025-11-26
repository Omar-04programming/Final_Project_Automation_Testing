package com.swagLabs.pages;

import com.swagLabs.data.WebsiteData;
import com.swagLabs.utils.BrowserActions;
import com.swagLabs.utils.CustomSoftAssertion;
import com.swagLabs.utils.Validations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletePage {
//    Variables
    private final WebDriver driver;

//    Constructors
    public CompletePage(WebDriver driver){
        this.driver = driver;
    }

//    Locators
    private final By completeHeader = By.cssSelector("[data-test='complete-header']");
    private  final By completeText = By.cssSelector("[data-test='complete-text']");
    private final By backToHomeButton = By.id("back-to-products");

//    Actions
    public CompletePage navigateToCheckoutCompletePage(String completePageURL){
        BrowserActions.navigateToURL(driver,completePageURL);
        return this;
    }

    public String extractMessage(By locator){
        String text = driver.findElement(locator).getText();
        return text;
    }

//    Validations
    public CompletePage assertSuccessfulPageTitle(String title){
        Validations.validatePageTitle(driver,title);
        return this;
    }
    public CompletePage assertDisplayCompleteMessageCorrect(String expectedMessageHeader, String expectedMessageText ){
        boolean isValidMessageHeader = extractMessage(completeHeader).equals(expectedMessageHeader);
        boolean isValidMessageText = extractMessage(completeText).equals(expectedMessageText);

        Validations.validateTrue(isValidMessageHeader, "Complete Header Message is incorrect");
        Validations.validateTrue(isValidMessageText,"Complete text Message is incorrect");
        if (isValidMessageHeader && isValidMessageText) {
            driver.findElement(backToHomeButton).click();
        }
        return this;
    }

    public CompletePage assertBackToHome(String homePageURL){
        CustomSoftAssertion.softAssertion.assertEquals(BrowserActions.getCurrentURL(driver),homePageURL, "URL is not as expected");
        return this;
    }

    public CompletePage assertSuccessfulBackToHome(String homePageURL){
        Validations.validatePageUrl(driver,homePageURL);
        return this;
    }
}
