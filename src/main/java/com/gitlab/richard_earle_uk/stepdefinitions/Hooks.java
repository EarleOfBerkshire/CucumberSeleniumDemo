package com.gitlab.richard_earle_uk.stepdefinitions;

import com.gitlab.richard_earle_uk.utils.DriverFactory;
import com.gitlab.richard_earle_uk.utils.ScreenshotUtil;
import com.gitlab.richard_earle_uk.context.WebDriverContext;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private final WebDriverContext context;

    public Hooks(WebDriverContext context) {
        this.context = context;
    }


    @Before
    public void setUp() {
        WebDriver driver = DriverFactory.getDriver();
        context.setDriver(driver);    }

    @After
    public void tearDown(Scenario scenario) {
        WebDriver driver = context.getDriver();
        if (driver != null) {
            driver.quit();
            context.setDriver(null);
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