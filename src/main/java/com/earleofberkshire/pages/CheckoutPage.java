package com.earleofberkshire.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object representing the Checkout page. Provides methods to enter user checkout information
 * and verify page load status.
 */
public class CheckoutPage extends BasePage {
  private static final By firstNameInput = By.id("first-name");
  private static final By lastNameInput = By.id("last-name");
  private static final By postalCodeInput = By.id("postal-code");
  private static final By continueButton = By.cssSelector("input[value='CONTINUE']");
  private static final By checkoutInfoHeader =
      By.xpath("//div[@class='subheader' and text()='Checkout: Your Information']");

  /**
   * Constructs a CheckoutPage instance using the provided WebDriver.
   *
   * @param driver the WebDriver instance for browser interaction
   */
  public CheckoutPage(WebDriver driver) {
    super(driver);
  }

  /**
   * Enters checkout details and submits the form.
   *
   * @param firstName the user's first name
   * @param lastName the user's last name
   * @param postalCode the user's postal code
   */
  public void enterCheckoutDetails(String firstName, String lastName, String postalCode) {
    elementUtil.sendKeys(firstNameInput, firstName);
    elementUtil.sendKeys(lastNameInput, lastName);
    elementUtil.sendKeys(postalCodeInput, postalCode);
    elementUtil.click(continueButton);
  }

  /**
   * Verifies if the Checkout page is loaded by checking the visibility of the header.
   *
   * @return true if the page is loaded, false otherwise
   */
  public boolean isLoaded() {
    return elementUtil.isElementDisplayed(checkoutInfoHeader);
  }
}
