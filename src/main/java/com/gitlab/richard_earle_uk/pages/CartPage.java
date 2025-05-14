package com.gitlab.richard_earle_uk.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
  private static final By cartRowItemName = By.className("inventory_item_name");
  private static final By cartRowItemPrice = By.className("inventory_item_price");
  private static final By checkoutButton = By.className("checkout_button");
  private final WebDriver driver;

  public CartPage(WebDriver driver) {
    this.driver = driver;
  }

  public String getCartItemName(int cartRow) {
    List<WebElement> items = driver.findElements(cartRowItemName);
    if (!items.isEmpty()) {
      return items.get(cartRow).getText();
    } else {
      throw new NoSuchElementException("No cart item found");
    }
  }

  public String getCartRowItemPrice(int cartRow) {
    List<WebElement> items = driver.findElements(cartRowItemPrice);
    if (!items.isEmpty()) {
      return items.get(cartRow).getText();
    } else {
      throw new NoSuchElementException("No cart item found");
    }
  }

  public void clickCheckoutButton() {
    driver.findElement(checkoutButton).click();
  }
}
