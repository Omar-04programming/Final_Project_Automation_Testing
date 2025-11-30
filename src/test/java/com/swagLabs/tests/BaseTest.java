package com.swagLabs.tests;

import com.swagLabs.drivers.DriverManager;
import com.swagLabs.utils.JsonUtils;
import org.testng.annotations.*;

public class BaseTest {

    JsonUtils json = new JsonUtils("test-data");
    @BeforeSuite
    public void setUpSuite(){
        DriverManager.createInstance(json.getJsonData("driverConfig.BROWSER"));
    }

    @AfterSuite
    public void tearDownSuite(){
        DriverManager.getDriver().quit();
    }
}