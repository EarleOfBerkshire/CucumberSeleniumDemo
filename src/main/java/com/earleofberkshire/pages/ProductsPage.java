package com.earleofberkshire.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

  private final By firstAddToCartButton = By.cssSelector(".inventory_item:first-of-type button");
  private final By shoppingCartLink = By.className("shopping_cart_link");

  public ProductsPage(WebDriver driver) {
    super(driver);
  }

  public void addFirstItemToCart() {
    elementUtil.click(firstAddToCartButton);
  }

  public void navigateToCart() {
    elementUtil.click(shoppingCartLink);
  }
}
