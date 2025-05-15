package com.earleofberkshire.utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

  private static WebDriver driver;

  public static WebDriver getDriver() {
    if (driver == null) {
      System.out.println("Creating new WebDriver instance.");
      // create driver instance here
    }
    return driver;
  }

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
      System.err.println("Could not create temporary Chrome profile: " + e.getMessage());
    }

    // Optional: enable headless if needed
    // options.addArguments("--headless=new");

    // Optional: other useful settings
    options.addArguments("--disable-notifications");
    options.addArguments("--start-maximized");

    return new ChromeDriver(options);
  }

  public static void quitDriver() {
    if (driver != null) {
      System.out.println("Quitting WebDriver instance.");
      driver.quit();
      driver = null;
    } else {
      System.out.println("WebDriver instance already null.");
    }
  }
}
