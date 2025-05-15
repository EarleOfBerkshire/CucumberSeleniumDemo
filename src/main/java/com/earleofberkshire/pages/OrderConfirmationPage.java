package com.earleofberkshire.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object representing the Order Confirmation page displayed after a successful checkout.
 * Provides methods to verify the page is loaded and to retrieve confirmation messages.
 */
public class OrderConfirmationPage extends BasePage {

  private static final By headerMessage = By.className("complete-header");
  private static final By orderConfirmationHeader =
      By.xpath("//div[@class='subheader' and text()='Finish']");

  /**
   * Constructs an OrderConfirmationPage instance with the provided WebDriver.
   *
   * @param driver the WebDriver instance to interact with the browser
   */
  public OrderConfirmationPage(WebDriver driver) {
    super(driver);
  }

  /**
   * Retrieves the main header message displayed on the order confirmation page.
   *
   * @return the header message text
   */
  public String getHeaderMessage() {
    return elementUtil.getText(headerMessage);
  }

  /**
   * Verifies that the order confirmation page is fully loaded by checking for the presence of the
   * specific confirmation header element.
   *
   * @return true if the order confirmation header is displayed, false otherwise
   */
  public boolean isLoaded() {
    return elementUtil.isElementDisplayed(orderConfirmationHeader);
  }
}
