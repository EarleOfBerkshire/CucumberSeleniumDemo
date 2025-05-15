package com.earleofberkshire.stepdefinitions;

import com.earleofberkshire.utils.ScreenshotUtil;
import com.earleofberkshire.utils.WebDriverManagerUtil;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {

  private final WebDriverManagerUtil webDriverManager;

  public Hooks(WebDriverManagerUtil webDriverManager) {
    this.webDriverManager = webDriverManager;
  }

  @After
  public void tearDown(Scenario scenario) {
    webDriverManager.quitDriver();
  }

  @AfterStep
  public void takeScreenshot(Scenario scenario) {
    WebDriver driver = WebDriverManagerUtil.getDriver();
    if (scenario.isFailed() && driver != null) {
      byte[] screenshot = ScreenshotUtil.captureScreenshotAsBytes(driver);
      scenario.attach(screenshot, "image/png", "failure-screenshot");
    }
  }
}
