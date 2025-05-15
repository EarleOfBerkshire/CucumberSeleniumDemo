package com.earleofberkshire.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ElementUtil {
  private final WebDriver driver;
  private final WebDriverWait wait;

  public ElementUtil(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  public void click(By locator) {
    wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
  }

  public void sendKeys(By locator, String text) {
    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    element.clear();
    element.sendKeys(text);
  }

  public String getText(By locator) {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
  }

  public boolean isElementDisplayed(By locator) {
    try {
      return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    } catch (TimeoutException e) {
      return false;
    }
  }

  public List<WebElement> getElements(By locator) {
    return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
  }

  public String getTextFromElementAt(By locator, int index) {
    List<WebElement> elements = getElements(locator);
    if (index >= 0 && index < elements.size()) {
      return elements.get(index).getText();
    } else {
      throw new NoSuchElementException(
          "Element at index " + index + " not found for locator: " + locator);
    }
  }
}
