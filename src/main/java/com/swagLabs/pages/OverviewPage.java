package com.swagLabs.pages;

import com.swagLabs.utils.BrowserActions;
import com.swagLabs.utils.CustomSoftAssertion;
import com.swagLabs.utils.Validations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage {
//    Variables
    private WebDriver driver;

//    Constructor
    public OverviewPage(WebDriver driver){
        this.driver = driver;
    }

//    Locators
    private final By itemTotalLabel = By.cssSelector("[data-test='subtotal-label']");
    private final By taxLabel = By.cssSelector("[data-test='tax-label']");
    private final By totalLabel = By.cssSelector("[data-test='total-label']");
    private final By finishButton = By.id("finish");

//    Actions
    public OverviewPage navigateToOverviewPage(String overviewPageURL){
        BrowserActions.navigateToURL(driver,overviewPageURL);
        return this;
    }

    public double extractAmount(By locator){
        String text = driver.findElement(locator).getText(); // e.g. "Item total: $37.98"
        String amount = text.replaceAll("[^\\d.]", "");      // extract "37.98"
        return Double.parseDouble(amount);
    }
    //    Validations
    public OverviewPage assertSuccessfulPageTitle(String title){
        Validations.validatePageTitle(driver,title);
        return this;
    }

    public OverviewPage assertTotalCalculationIsCorrectAndFinishIfValid(){
        double itemTotal = extractAmount(itemTotalLabel);
        double tax = extractAmount(taxLabel);
        double total = extractAmount(totalLabel);
        double expectedTotal = Math.round((itemTotal + tax) * 100.0) / 100.0;

        boolean isValid = String.valueOf(total).equals(String.valueOf(expectedTotal));

        Validations.validateTrue(isValid, "Total amount is incorrect");
        if (isValid) {
            driver.findElement(finishButton).click();
        }
        return this;
    }

    public OverviewPage assertCheckoutComplete(String completePageURL){
        CustomSoftAssertion.softAssertion.assertEquals(BrowserActions.getCurrentURL(driver),completePageURL, "URL is not as expected");
        return this;
    }

    public OverviewPage assertSuccessfulCheckoutComplete(String completePageURL){
        Validations.validatePageUrl(driver,completePageURL);
        return this;
    }




}
