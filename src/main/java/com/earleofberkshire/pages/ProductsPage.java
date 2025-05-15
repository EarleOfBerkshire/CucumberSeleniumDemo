package com.earleofberkshire.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object representing the Products page of the application. Provides methods to interact with
 * product items such as adding items to the cart and navigating to the shopping cart.
 */
public class ProductsPage extends BasePage {

  private final By firstAddToCartButton = By.cssSelector(".inventory_item:first-of-type button");
  private final By shoppingCartLink = By.className("shopping_cart_link");

  /**
   * Constructs a ProductsPage instance using the provided WebDriver.
   *
   * @param driver the WebDriver instance to interact with the browser
   */
  public ProductsPage(WebDriver driver) {
    super(driver);
  }

  /** Clicks the 'Add to Cart' button for the first product item displayed on the page. */
  public void addFirstItemToCart() {
    elementUtil.click(firstAddToCartButton);
  }

  /** Navigates to the shopping cart page by clicking the shopping cart link/icon. */
  public void navigateToCart() {
    elementUtil.click(shoppingCartLink);
  }
}
