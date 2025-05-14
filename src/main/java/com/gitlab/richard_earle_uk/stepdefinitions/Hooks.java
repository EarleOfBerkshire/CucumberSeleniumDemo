package com.gitlab.richard_earle_uk.stepdefinitions;

import com.gitlab.richard_earle_uk.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp() {
        DriverFactory.getDriver(); // Ensures driver is initialized
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}