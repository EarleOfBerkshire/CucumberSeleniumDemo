package com.earleofberkshire.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object representing the Checkout Overview page. Provides methods to complete the checkout
 * process and verify if the page is loaded.
 */
public class CheckoutOverviewPage extends BasePage {

  // Locator for the "Finish" button on the Checkout Overview page
  private static final By finishButton = By.linkText("FINISH");

  // Locator for the header to confirm the user is on the Checkout Overview page
  private static final By checkoutOverviewHeader =
      By.xpath("//div[@class='subheader' and text()='Checkout: Overview']");

  /**
   * Constructs a CheckoutOverviewPage instance with the specified WebDriver.
   *
   * @param driver the WebDriver instance to interact with the browser
   */
  public CheckoutOverviewPage(WebDriver driver) {
    super(driver);
  }

  /** Clicks the "Finish" button to complete the checkout process. */
  public void clickFinishButton() {
    elementUtil.click(finishButton);
  }

  /**
   * Verifies whether the Checkout Overview page is currently displayed.
   *
   * @return true if the page header is visible; false otherwise
   */
  public boolean isLoaded() {
    return elementUtil.isElementDisplayed(checkoutOverviewHeader);
  }
}
