package com.earleofberkshire.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class for capturing screenshots during test execution.
 *
 * <p>Provides a method to capture the current browser window as a byte array, suitable for
 * embedding in test reports or debugging logs.
 */
public class ScreenshotUtil {

  private static final Logger logger = LoggerFactory.getLogger(ScreenshotUtil.class);

  /**
   * Captures a screenshot of the current page and returns it as a byte array.
   *
   * <p>If the provided {@link WebDriver} instance is {@code null}, an empty byte array is returned.
   * This is useful for scenarios where the driver may not be initialized but the test framework
   * still attempts to log a screenshot.
   *
   * @param driver the active {@link WebDriver} instance from which to capture the screenshot
   * @return a byte array containing the screenshot, or an empty array if the driver is {@code null}
   */
  public static byte[] captureScreenshotAsBytes(WebDriver driver) {
    if (driver != null) {
      return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    } else {
      logger.warn("WebDriver is null, cannot capture screenshot.");
      return new byte[0];
    }
  }
}
