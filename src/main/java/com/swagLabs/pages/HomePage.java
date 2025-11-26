
package com.swagLabs.pages;

import com.swagLabs.utils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
//    Variables
    private final WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Dynamic Locator for Add to Cart button based on product name
    private By getAddToCartButtonByProductName(String productName) {
        String kebabCase = productName.toLowerCase().replaceAll(" ", "-");
        return By.cssSelector("button[data-test='add-to-cart-" + kebabCase + "']");
    }

    private By getRemoveButtonByProductName(String productName) {
        String kebabCase = productName.toLowerCase().replaceAll(" ", "-");
        return By.cssSelector("button[data-test='remove-" + kebabCase + "']");
    }


    // Action: Add product by name
    public HomePage navigateToHomePage(String productPage){
        BrowserActions.navigateToURL(driver,productPage);
        return this;
    }

    public HomePage addProductToCart(String productName) {
        Waits.waitForElementToBeClickable(driver, getAddToCartButtonByProductName(productName));
        ElementActions.clickElement(driver, getAddToCartButtonByProductName(productName));
        return this;
    }

    public HomePage openCartAndValidateProduct(String expectedProductName, int expectedCount) {
        ElementActions.clickElement(driver, By.className("shopping_cart_link"));
        Waits.waitForElementToBeVisible(driver, By.className("cart_item"));

        List<WebElement> cartItems = driver.findElements(By.className("cart_item"));
        int actualCount = cartItems.size();

        boolean productFound = cartItems.stream()
                .anyMatch(item -> item.findElement(By.className("inventory_item_name"))
                        .getText().equalsIgnoreCase(expectedProductName));

        Validations.validateTrue(productFound, "Product not found in cart: " + expectedProductName);
        Validations.validateEquals(actualCount, expectedCount, "Cart item count mismatch");
        CustomSoftAssertion.softAssertion.assertEquals(BrowserActions.getCurrentURL(driver),"https://www.saucedemo.com/cart.html", "URL is not as expected");
        Validations.validatePageUrl(driver,"https://www.saucedemo.com/cart.html");
        return this;
    }


    // Get button text after click
    public String getProductButtonText(String productName) {
        return ElementActions.getText(driver, getRemoveButtonByProductName(productName));
    }

    // Validation: Check button changed to "Remove"
    public HomePage assertButtonChangedToRemove(String productName) {
        Validations.validateEquals(getProductButtonText(productName), "Remove", "Button did not change to 'Remove' for product: " + productName);
        return this;
    }

}
