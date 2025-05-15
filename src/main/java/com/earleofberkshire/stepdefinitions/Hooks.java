package com.earleofberkshire.stepdefinitions;

import com.earleofberkshire.utils.ScreenshotUtil;
import com.earleofberkshire.utils.WebDriverManagerUtil;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

/**
 * Cucumber hooks class to manage WebDriver lifecycle and capture screenshots after steps.
 *
 * <p>This class defines global setup and teardown logic for scenarios and steps, ensuring browser
 * sessions are closed and screenshots are taken on failure.
 */
public class Hooks {

  private final WebDriverManagerUtil webDriverManager;

  /**
   * Constructs the Hooks instance with the injected WebDriver manager.
   *
   * @param webDriverManager the utility responsible for managing WebDriver instances
   */
  public Hooks(WebDriverManagerUtil webDriverManager) {
    this.webDriverManager = webDriverManager;
  }

  /**
   * Hook that runs after each scenario to clean up the WebDriver instance.
   *
   * @param scenario the scenario that just finished executing
   */
  @After
  public void tearDown(Scenario scenario) {
    webDriverManager.quitDriver();
  }

  /**
   * Hook that runs after each step to capture a screenshot if the scenario has failed. The
   * screenshot is attached to the scenario report.
   *
   * @param scenario the current scenario being executed
   */
  @AfterStep
  public void takeScreenshot(Scenario scenario) {
    WebDriver driver = WebDriverManagerUtil.getDriver();
    if (scenario.isFailed() && driver != null) {
      byte[] screenshot = ScreenshotUtil.captureScreenshotAsBytes(driver);
      scenario.attach(screenshot, "image/png", "failure-screenshot");
    }
  }
}
