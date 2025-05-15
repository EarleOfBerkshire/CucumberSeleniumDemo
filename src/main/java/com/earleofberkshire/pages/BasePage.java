package com.earleofberkshire.pages;

import com.earleofberkshire.utils.ElementUtil;
import org.openqa.selenium.WebDriver;

/**
 * Abstract base class for all page objects in the test framework.
 *
 * <p>Provides shared WebDriver and ElementUtil instances for interacting with web elements. All
 * specific page classes should extend this class to gain access to common functionality.
 */
public abstract class BasePage {

  /** The WebDriver instance used to interact with the browser. */
  protected WebDriver driver;

  /** Utility class for interacting with web elements using Selenium. */
  protected ElementUtil elementUtil;

  /**
   * Constructs a new BasePage with the given WebDriver. Initializes the ElementUtil helper for
   * element interactions.
   *
   * @param driver the WebDriver instance to use for browser interaction
   */
  public BasePage(WebDriver driver) {
    this.driver = driver;
    this.elementUtil = new ElementUtil(driver);
  }
}
