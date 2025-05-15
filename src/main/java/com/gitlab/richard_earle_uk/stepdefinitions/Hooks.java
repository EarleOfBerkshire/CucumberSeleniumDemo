package com.gitlab.richard_earle_uk.stepdefinitions;

import com.gitlab.richard_earle_uk.utils.DriverFactory;
import com.gitlab.richard_earle_uk.utils.ScreenshotUtil;
import com.gitlab.richard_earle_uk.context.WebDriverContext;

import com.gitlab.richard_earle_uk.utils.WebDriverManagerUtil;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private final WebDriverManagerUtil webDriverManager;

    public Hooks(WebDriverManagerUtil webDriverManager) {
        this.webDriverManager = webDriverManager;
    }


    @Before
    public void setUp() {
        WebDriver driver = DriverFactory.getDriver();
        webDriverManager.getDriver();    }

    @After
    public void tearDown(Scenario scenario) {
        webDriverManager.quitDriver();
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