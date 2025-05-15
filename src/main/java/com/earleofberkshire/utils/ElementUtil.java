package com.earleofberkshire.utils;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class that encapsulates common interactions with web elements using Selenium WebDriver.
 *
 * <p>This helper provides wrapper methods around frequently used operations like clicking, sending
 * keys, waiting for visibility, and retrieving text. All operations include sensible explicit waits
 * for stability and reliability.
 */
public class ElementUtil {
  private static final Logger logger = LoggerFactory.getLogger(ElementUtil.class);

  private final WebDriver driver;
  private final WebDriverWait wait;

  /**
   * Constructs an instance of {@code ElementUtil} with the specified {@link WebDriver}.
   *
   * @param driver the WebDriver instance to use for element interactions
   */
  public ElementUtil(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  /**
   * Waits for an element to be clickable and then clicks it.
   *
   * @param locator the {@link By} locator of the element to click
   */
  public void click(By locator) {
    try {
      wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
      logger.info("Clicked element located by: {}", locator);
    } catch (TimeoutException e) {
      logger.error("Timeout waiting for element to be clickable: {}", locator, e);
      throw e;
    }
  }

  /**
   * Waits for an element to be visible, clears any existing text, and sends the specified keys.
   *
   * @param locator the {@link By} locator of the input element
   * @param text the text to enter into the input field
   */
  public void sendKeys(By locator, String text) {
    try {
      WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
      element.clear();
      element.sendKeys(text);
      logger.info("Sent keys to element located by: {}", locator);
    } catch (TimeoutException e) {
      logger.error("Timeout waiting for element visibility to send keys: {}", locator, e);
      throw e;
    }
  }

  /**
   * Waits for an element to be visible and returns its text content.
   *
   * @param locator the {@link By} locator of the element
   * @return the visible text of the element
   */
  public String getText(By locator) {
    try {
      String text = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
      logger.info("Got text from element located by {}: {}", locator, text);
      return text;
    } catch (TimeoutException e) {
      logger.error("Timeout waiting for element visibility to get text: {}", locator, e);
      throw e;
    }
  }

  /**
   * Checks if an element is visible on the page.
   *
   * @param locator the {@link By} locator of the element
   * @return {@code true} if the element is visible within the wait timeout; {@code false} otherwise
   */
  public boolean isElementDisplayed(By locator) {
    try {
      boolean displayed = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
      logger.info("Element located by {} is displayed: {}", locator, displayed);
      return displayed;
    } catch (TimeoutException e) {
      logger.warn("Element located by {} is not visible within timeout.", locator);
      return false;
    }
  }

  /**
   * Waits for and retrieves a list of elements matching the given locator.
   *
   * @param locator the {@link By} locator of the elements
   * @return a list of matching {@link WebElement} instances
   */
  public List<WebElement> getElements(By locator) {
    try {
      List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
      logger.info("Found {} elements located by {}", elements.size(), locator);
      return elements;
    } catch (TimeoutException e) {
      logger.error("Timeout waiting for presence of elements located by: {}", locator, e);
      throw e;
    }
  }

  /**
   * Retrieves the text content of the element at the specified index in a list of elements.
   *
   * @param locator the {@link By} locator of the element group
   * @param index the zero-based index of the desired element
   * @return the text of the element at the given index
   * @throws NoSuchElementException if the index is out of bounds
   */
  public String getTextFromElementAt(By locator, int index) {
    List<WebElement> elements = getElements(locator);
    if (index >= 0 && index < elements.size()) {
      String text = elements.get(index).getText();
      logger.info("Got text from element at index {} located by {}: {}", index, locator, text);
      return text;
    } else {
      String message = "Element at index " + index + " not found for locator: " + locator;
      logger.error(message);
      throw new NoSuchElementException(message);
    }
  }
}