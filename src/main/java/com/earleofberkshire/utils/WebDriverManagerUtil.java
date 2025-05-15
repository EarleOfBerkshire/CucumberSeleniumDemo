package com.earleofberkshire.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Utility class for managing the lifecycle of the {@link WebDriver} instance.
 *
 * <p>This class handles the setup and teardown of a singleton ChromeDriver instance using
 * WebDriverManager to automatically manage the browser driver binaries.
 */
public class WebDriverManagerUtil {

  private static WebDriver driver;

  /**
   * Returns a singleton instance of {@link WebDriver}.
   *
   * <p>If the driver is not yet initialized, this method sets up the ChromeDriver using
   * WebDriverManager and returns the new instance.
   *
   * @return the singleton {@link WebDriver} instance
   */
  public static WebDriver getDriver() {
    if (driver == null) {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
    }
    return driver;
  }

  /**
   * Quits the WebDriver session and cleans up the static instance.
   *
   * <p>This method should be called during teardown to ensure the browser is closed and the driver
   * is reset to {@code null} to allow for clean reuse.
   */
  public void quitDriver() {
    if (driver != null) {
      driver.quit();
      driver = null;
    }
  }
}
