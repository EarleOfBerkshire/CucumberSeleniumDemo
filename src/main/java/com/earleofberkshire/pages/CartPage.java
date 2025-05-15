package com.earleofberkshire.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object Model class representing the Cart page. Provides methods to retrieve cart item
 * details, proceed to checkout, and verify that the cart page has loaded.
 */
public class CartPage extends BasePage {

  // Locator for item names listed in the cart
  private static final By cartRowItemName = By.className("inventory_item_name");

  // Locator for item prices listed in the cart
  private static final By cartRowItemPrice = By.className("inventory_item_price");

  // Locator for the checkout button
  private static final By checkoutButton = By.className("checkout_button");

  /**
   * Constructs a new CartPage with the provided WebDriver.
   *
   * @param driver the WebDriver used to interact with the cart page
   */
  public CartPage(WebDriver driver) {
    super(driver);
  }

  /**
   * Retrieves the name of the cart item at the specified row index.
   *
   * @param cartRow the zero-based index of the cart row
   * @return the name of the item at the specified index
   */
  public String getCartItemName(int cartRow) {
    return elementUtil.getTextFromElementAt(cartRowItemName, cartRow);
  }

  /**
   * Retrieves the price of the cart item at the specified row index.
   *
   * @param cartRow the zero-based index of the cart row
   * @return the price of the item at the specified index
   */
  public String getCartRowItemPrice(int cartRow) {
    return elementUtil.getTextFromElementAt(cartRowItemPrice, cartRow);
  }

  /** Clicks the checkout button to proceed to the checkout page. */
  public void clickCheckoutButton() {
    elementUtil.click(checkoutButton);
  }

  /**
   * Checks if the cart page has successfully loaded by verifying the presence of the checkout
   * button.
   *
   * @return true if the checkout button is displayed; false otherwise
   */
  public boolean isLoaded() {
    return elementUtil.isElementDisplayed(checkoutButton);
  }
}
