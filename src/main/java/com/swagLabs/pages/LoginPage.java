package com.swagLabs.pages;

import com.swagLabs.utils.BrowserActions;
import com.swagLabs.utils.CustomSoftAssertion;
import com.swagLabs.utils.ElementActions;
import com.swagLabs.utils.Validations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
    //    Variables
   private final WebDriver driver;

   //   Locators
    private final By username = By.id("user-name");
    private final  By password = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    //   Constructors
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //  Navigate to the login page
    public LoginPage navigateToLoginPage(String loginPageURL){
        BrowserActions.navigateToURL(driver,loginPageURL);
        return this;
    }


    //    Actions > wait - Scroll - find - sendKey
    public LoginPage enterUsername(String username){
        ElementActions.sendData(driver,this.username,username);
        return this;
    }

    public LoginPage enterPassword(String password){
        ElementActions.sendData(driver,this.password,password);
        return this;
    }

    public LoginPage clickLoginButton(){
        ElementActions.clickElement(driver,loginButton);
        return this;
    }

    public String getErrorMessage(){
        return ElementActions.getText(driver,errorMessage);
    }

    //    Validations
    public LoginPage assertLoginPage(String HomePageURL){
        CustomSoftAssertion.softAssertion.assertEquals(BrowserActions.getCurrentURL(driver), HomePageURL, "URL is not as expected");
        return this;
    }
    public LoginPage assertLoginPageTitle(){
        CustomSoftAssertion.softAssertion.assertEquals(BrowserActions.getPageTitle(driver),"Swag Labs", "Title is not as expected");
        return this;
    }
    public LoginPage assertSuccessfulPageTitle(String homePageTitle){
        Validations.validatePageTitle(driver,homePageTitle);
        return this;
    }
    public LoginPage assertSuccessfulLoginSoft(String HomePageURL){
        assertLoginPage(HomePageURL).assertLoginPageTitle();
        return this;
    }

    public LoginPage assertSuccessfulLogin(String navigateToHomePageURL){
        Validations.validatePageUrl(driver,navigateToHomePageURL);
         return this;
    }

    public LoginPage assertUnsuccessfulLogin(String loginErrorMessage){
        Validations.validateEquals(getErrorMessage(),loginErrorMessage,"Epic sadface: Username and password do not match any user in this service");
        return this;
    }



}
