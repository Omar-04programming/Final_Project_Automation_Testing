package com.swagLabs.tests;


import com.swagLabs.drivers.DriverManager;
import com.swagLabs.pages.HomePage;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void addSpecificProductAndVerifyButtonChanged() {
        new HomePage(DriverManager.getDriver())
                .navigateToHomePage(json.getJsonData("baseUrls.HOME_URL"))
                .addProductToCart(json.getJsonData("products[0]"))
                .assertButtonChangedToRemove(json.getJsonData("products[0]"))
                .openCartAndValidateProduct(json.getJsonData("products[0]")
                        , Integer.parseInt(json.getJsonData("cartData.QUANTITY")));
    }
}
