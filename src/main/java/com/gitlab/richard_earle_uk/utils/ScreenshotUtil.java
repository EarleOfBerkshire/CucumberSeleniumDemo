package com.gitlab.richard_earle_uk.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
  public static byte[] captureScreenshotAsBytes(WebDriver driver) {
    if (driver != null) {
      return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    } else {
      System.err.println("ScreenshotUtil: WebDriver is null, cannot capture screenshot.");
      return new byte[0]; // return empty byte array to avoid null
    }
  }
}