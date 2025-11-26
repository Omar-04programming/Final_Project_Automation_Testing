package com.swagLabs.tests;

import com.swagLabs.data.WebsiteData;
import com.swagLabs.drivers.DriverManager;
import com.swagLabs.pages.*;
import org.testng.annotations.*;


public class LoginTest {

    @BeforeClass
    public void setUp(){
        DriverManager.createInstance("edge");
        new LoginPage(DriverManager.getDriver()).navigateToLoginPage(WebsiteData.BASE_URL);
    }

    @Test
    public void successfulLogin(){
            new LoginPage(DriverManager.getDriver())
                    .enterUsername(WebsiteData.USERNAMES.get(0))
                    .enterPassword(WebsiteData.PASSWORD)
                    .clickLoginButton()
                    .assertSuccessfulPageTitle(WebsiteData.HOME_PAGE_TITLE)
                    .assertSuccessfulLogin(WebsiteData.HOME_URL);
    }

    @Test(dependsOnMethods = "successfulLogin")
    public void addSpecificProductAndVerifyButtonChanged() {
        new HomePage(DriverManager.getDriver())
                .navigateToHomePage(WebsiteData.HOME_URL)
                .addProductToCart(WebsiteData.PRODUCT_NAME.get(0))
                .assertButtonChangedToRemove(WebsiteData.PRODUCT_NAME.get(0))
                .openCartAndValidateProduct(WebsiteData.PRODUCT_NAME.get(0), 1);
    }

    @Test(dependsOnMethods = "addSpecificProductAndVerifyButtonChanged")
    public void navigateFromCartToCheckoutPage(){
        new CartPage(DriverManager.getDriver())
                .navigateToCartPage(WebsiteData.CART_URL)
                .assertSuccessfulPageTitle(WebsiteData.CART_PAGE_TITLE)
                .clickCheckoutButton()
                .assertCheckoutPage(WebsiteData.CHECKOUT_STEP_ONE_URL)
                .assertSuccessfulCheckoutPage(WebsiteData.CHECKOUT_STEP_ONE_URL);
    }

    @Test(dependsOnMethods = "navigateFromCartToCheckoutPage")
    public void successfulCheckout(){
        new CheckoutPage(DriverManager.getDriver())
                .navigateToCheckoutPage(WebsiteData.CHECKOUT_STEP_ONE_URL)
                .assertSuccessfulPageTitle(WebsiteData.CHECKOUT_PAGE_TITLE)
                .enterCheckoutData("Kylian","Mbappé","12345")
                .assertOverviewPage(WebsiteData.CHECKOUT_STEP_TWO_URL)
                .assertSuccessfulCheckout(WebsiteData.CHECKOUT_STEP_TWO_URL);
    }

    @Test(dependsOnMethods = "successfulCheckout")
    public void checkOverviewPageIsDisplayTrueData(){
        new OverviewPage(DriverManager.getDriver())
                .navigateToOverviewPage(WebsiteData.CHECKOUT_STEP_TWO_URL)
                .assertSuccessfulPageTitle(WebsiteData.OVERVIEW_PAGE_TITLE)
                .assertTotalCalculationIsCorrectAndFinishIfValid()
                .assertCheckoutComplete(WebsiteData.CHECKOUT_COMPLETE_URL)
                .assertSuccessfulCheckoutComplete(WebsiteData.CHECKOUT_COMPLETE_URL);
    }

    @Test(dependsOnMethods = "checkOverviewPageIsDisplayTrueData")
    public void checkoutCompletePageDisplayCorrectMessage(){
        new CompletePage(DriverManager.getDriver())
                .navigateToCheckoutCompletePage(WebsiteData.CHECKOUT_COMPLETE_URL)
                .assertSuccessfulPageTitle(WebsiteData.COMPLETE_PAGE_TITLE)
                .assertDisplayCompleteMessageCorrect(WebsiteData.COMPLETE_HEADER_MESSAGE, WebsiteData.COMPLETE_TEXT_MESSAGE)
                .assertBackToHome(WebsiteData.HOME_URL)
                .assertSuccessfulBackToHome(WebsiteData.HOME_URL);
    }

    @AfterClass
    public void tearDown(){
        DriverManager.getDriver().quit();
    }
}
