package com.swagLabs.tests;


import com.swagLabs.drivers.DriverManager;
import com.swagLabs.pages.CompletePage;
import org.testng.annotations.Test;

public class CompletePageTest extends BaseTest{
    @Test
    public void checkoutCompletePageDisplayCorrectMessage(){
        new CompletePage(DriverManager.getDriver())
                .navigateToCheckoutCompletePage(json.getJsonData("baseUrls.CHECKOUT_COMPLETE_URL"))
                .assertSuccessfulPageTitle(json.getJsonData("expectedTitles.COMPLETE_PAGE_TITLE"))
                .assertDisplayCompleteMessageCorrect(json.getJsonData("expectedMessages.COMPLETE_HEADER_MESSAGE")
                        , json.getJsonData("expectedMessages.COMPLETE_TEXT_MESSAGE"))
                .assertBackToHome(json.getJsonData("baseUrls.HOME_URL"))
                .assertSuccessfulBackToHome(json.getJsonData("baseUrls.HOME_URL"));
    }

}
