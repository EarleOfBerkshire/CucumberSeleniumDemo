package com.gitlab.richard_earle_uk.stepdefinitions;

import com.gitlab.richard_earle_uk.utils.DriverFactory;
import com.gitlab.richard_earle_uk.utils.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private final WebDriver driver;

    // Constructor injection of driver
    public Hooks(WebDriver driver) {
        this.driver = driver;
    }

    @Before
    public void setUp() {
        // driver already injected, can initialize here if needed
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("Tearing down after scenario: " + scenario.getName());
        if (DriverFactory.getDriver() != null) {
            System.out.println("Quitting driver...");
            DriverFactory.quitDriver();
        } else {
            System.out.println("Driver was already null.");
        }
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