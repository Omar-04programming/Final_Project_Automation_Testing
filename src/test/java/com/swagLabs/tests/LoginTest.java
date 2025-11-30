package com.swagLabs.tests;

import com.swagLabs.drivers.DriverManager;
import com.swagLabs.pages.*;
import org.testng.annotations.*;


public class LoginTest extends BaseTest{

    @Test
    public void successfulLogin(){
        new LoginPage(DriverManager.getDriver())
                .navigateToLoginPage(json.getJsonData("baseUrls.BASE_URL"))
                .enterUsername(json.getJsonData("credentials.USERNAMES[0]"))
                .enterPassword(json.getJsonData("credentials.PASSWORD"))
                .clickLoginButton()
                .assertSuccessfulPageTitle(json.getJsonData("expectedTitles.HOME_PAGE_TITLE"))
                .assertSuccessfulLogin(json.getJsonData("baseUrls.HOME_URL"));
    }
}