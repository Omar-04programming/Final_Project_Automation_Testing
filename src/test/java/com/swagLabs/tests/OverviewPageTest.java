package com.swagLabs.tests;

import com.swagLabs.drivers.DriverManager;
import com.swagLabs.pages.OverviewPage;
import org.testng.annotations.Test;

public class OverviewPageTest extends BaseTest {

    @Test
    public void checkOverviewPageIsDisplayTrueData(){
        new OverviewPage(DriverManager.getDriver())
                .navigateToOverviewPage(json.getJsonData("baseUrls.CHECKOUT_STEP_TWO_URL"))
                .assertSuccessfulPageTitle(json.getJsonData("expectedTitles.OVERVIEW_PAGE_TITLE"))
                .assertTotalCalculationIsCorrectAndFinishIfValid()
                .assertCheckoutComplete(json.getJsonData("baseUrls.CHECKOUT_COMPLETE_URL"))
                .assertSuccessfulCheckoutComplete(json.getJsonData("baseUrls.CHECKOUT_COMPLETE_URL"));
    }
}
