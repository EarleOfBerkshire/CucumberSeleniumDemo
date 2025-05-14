package com.gitlab.richard_earle_uk.stepdefinitions;

import com.gitlab.richard_earle_uk.utils.DriverFactory;
import com.gitlab.richard_earle_uk.utils.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {

    @Before
    public void setUp() {
        DriverFactory.getDriver(); // Ensures driver is initialized
    }

    @After
    public void tearDown() {
        System.out.println("Running tearDown...");
        DriverFactory.quitDriver();
    }

    @AfterStep
    public void takeScreenshot(Scenario scenario) {
        WebDriver driver = DriverFactory.getDriver();
        if (scenario.isFailed()) {
            byte[] screenshot = ScreenshotUtil.captureScreenshotAsBytes(driver);
            scenario.attach(screenshot, "image/png", "Failed Step Screenshot");
        }
    }

    
}