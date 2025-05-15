package com.earleofberkshire.utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Factory class responsible for creating and managing a singleton instance of {@link WebDriver}.
 *
 * <p>This class currently supports creating a ChromeDriver instance with custom options such as:
 * disabling password manager, using a temporary profile directory, disabling notifications, and
 * maximizing the browser window. It also provides methods to obtain and quit the WebDriver
 * instance.
 */
public class DriverFactory {

  private static final Logger logger = LoggerFactory.getLogger(DriverFactory.class);
  private static WebDriver driver;

  /**
   * Returns the singleton WebDriver instance, creating it if it does not yet exist.
   *
   * @return the WebDriver instance for browser automation
   */
  public static WebDriver getDriver() {
    if (driver == null) {
      logger.info("Creating new WebDriver instance.");
      driver = createChromeDriver();
    }
    return driver;
  }

  /**
   * Creates a new ChromeDriver instance with configured options:
   *
   * <ul>
   *   <li>Disables password manager and credential services.
   *   <li>Uses a temporary Chrome user profile to avoid reuse of saved credentials.
   *   <li>Disables notifications.
   *   <li>Starts the browser maximized.
   * </ul>
   *
   * <p>Headless mode is commented out but can be enabled if needed.
   *
   * @return a configured ChromeDriver instance
   */
  private static WebDriver createChromeDriver() {
    ChromeOptions options = new ChromeOptions();

    // Disable password manager & credential services
    Map<String, Object> prefs = new HashMap<>();
    prefs.put("credentials_enable_service", false);
    prefs.put("profile.password_manager_enabled", false);
    options.setExperimentalOption("prefs", prefs);

    // Create a temporary profile to avoid reused saved credentials
    try {
      Path tempProfileDir = Files.createTempDirectory("chrome-profile");
      options.addArguments("user-data-dir=" + tempProfileDir.toAbsolutePath());
    } catch (Exception e) {
      logger.error("Could not create temporary Chrome profile", e);
    }

    // Optional: enable headless if needed
    // options.addArguments("--headless=new");

    // Optional: other useful settings
    options.addArguments("--disable-notifications");
    options.addArguments("--start-maximized");

    return new ChromeDriver(options);
  }

  /**
   * Quits the current WebDriver instance if it exists, releasing all associated resources. If the
   * WebDriver instance is already null, this method logs the status and does nothing.
   */
  public static void quitDriver() {
    if (driver != null) {
      logger.info("Quitting WebDriver instance.");
      driver.quit();
      driver = null;
    } else {
      logger.warn("WebDriver instance already null.");
    }
  }
}