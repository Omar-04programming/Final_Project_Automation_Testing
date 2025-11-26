package com.swagLabs.data;

import java.util.Arrays;
import java.util.List;

public class WebsiteData {

    private WebsiteData() {}

    // Base URLs
    public static final String BASE_URL = "https://www.saucedemo.com/";
    public static final String LOGIN_URL = BASE_URL + "login.html";
    public static final String HOME_URL = BASE_URL + "inventory.html";
    public static final String CART_URL = BASE_URL + "cart.html";
    public static final String CHECKOUT_STEP_ONE_URL = BASE_URL + "checkout-step-one.html";
    public static final String CHECKOUT_STEP_TWO_URL = BASE_URL + "checkout-step-two.html";
    public static final String CHECKOUT_COMPLETE_URL = BASE_URL + "checkout-complete.html";

    // Credentials
    public static final String PASSWORD = "secret_sauce";

    public static final List<String> USERNAMES = Arrays.asList(
            "standard_user",
            "locked_out_user",
            "problem_user",
            "performance_glitch_user",
            "error_user",
            "visual_user"
    );

    public static final List<String> PRODUCT_NAME = Arrays.asList(
            "Sauce Labs Backpack",
            "Sauce Labs Bike Light",
            "Sauce Labs Bolt T-Shirt",
            "Sauce Labs Fleece Jacket",
            "Sauce Labs Onesie",
            "Test.allTheThings() T-Shirt (Red)"
    );

    // Expected Messages
    public static final String COMPLETE_HEADER_MESSAGE = "Thank you for your order!";
    public static final String COMPLETE_TEXT_MESSAGE = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";

    // Expected Titles
    public static final String HOME_PAGE_TITLE = "Products";
    public static final String CART_PAGE_TITLE = "Your Cart";
    public static final String CHECKOUT_PAGE_TITLE = "Checkout: Your Information";
    public static final String OVERVIEW_PAGE_TITLE = "Checkout: Overview";
    public static final String COMPLETE_PAGE_TITLE = "Checkout: Complete!";

    // Expected Errors
    public static final String ERROR_LOGIN_MESSAGE = "Epic sadface: Username and password do not match any user in this service";
    public static final String ERROR_FIRST_NAME_REQUIRED = "Error: First Name is required";
    public static final String ERROR_LAST_NAME_REQUIRED = "Error: Last Name is required";
    public static final String ERROR_POSTAL_CODE_REQUIRED = "Error: Postal Code is required";


}
