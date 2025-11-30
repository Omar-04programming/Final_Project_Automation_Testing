package com.swagLabs.tests;


import com.swagLabs.drivers.DriverManager;
import com.swagLabs.pages.CheckoutPage;
import org.testng.annotations.Test;

public class CheckoutPageTest extends BaseTest {

    @Test
    public void successfulCheckout(){
        new CheckoutPage(DriverManager.getDriver())
                .navigateToCheckoutPage(json.getJsonData("baseUrls.CHECKOUT_STEP_ONE_URL"))
                .assertSuccessfulPageTitle(json.getJsonData("expectedTitles.CHECKOUT_PAGE_TITLE"))
                .enterCheckoutData(json.getJsonData("checkoutData.FIRST_NAME"),
                        json.getJsonData("checkoutData.LAST_NAME"),
                        json.getJsonData("checkoutData.POSTAL_CODE"))
                .assertOverviewPage(json.getJsonData("baseUrls.CHECKOUT_STEP_TWO_URL"))
                .assertSuccessfulCheckout(json.getJsonData("baseUrls.CHECKOUT_STEP_TWO_URL"));
    }
}
