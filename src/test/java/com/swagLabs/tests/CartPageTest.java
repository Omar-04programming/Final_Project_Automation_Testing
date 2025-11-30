package com.swagLabs.tests;

import com.swagLabs.drivers.DriverManager;
import com.swagLabs.pages.CartPage;
import org.testng.annotations.Test;

public class CartPageTest extends BaseTest {

    @Test
    public void navigateFromCartToCheckoutPage(){
        new CartPage(DriverManager.getDriver())
                .navigateToCartPage(json.getJsonData("baseUrls.CART_URL"))
                .assertSuccessfulPageTitle(json.getJsonData("expectedTitles.CART_PAGE_TITLE"))
                .clickCheckoutButton()
                .assertCheckoutPage(json.getJsonData("baseUrls.CHECKOUT_STEP_ONE_URL"))
                .assertSuccessfulCheckoutPage(json.getJsonData("baseUrls.CHECKOUT_STEP_ONE_URL"));
    }
}
