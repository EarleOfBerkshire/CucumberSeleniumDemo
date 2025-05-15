package com.gitlab.richard_earle_uk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CartPage extends BasePage {

  private static final By cartRowItemName = By.className("inventory_item_name");
  private static final By cartRowItemPrice = By.className("inventory_item_price");
  private static final By checkoutButton = By.className("checkout_button");

  public CartPage(WebDriver driver) {
    super(driver);
  }

  public String getCartItemName(int cartRow) {
    return elementUtil.getTextFromElementAt(cartRowItemName, cartRow);

  }

  public String getCartRowItemPrice(int cartRow) {
    return elementUtil.getTextFromElementAt(cartRowItemPrice, cartRow);
  }

  public void clickCheckoutButton() {
    elementUtil.click(checkoutButton);
  }

  @Override
  public boolean isLoaded() {
    return elementUtil.isElementDisplayed(checkoutButton);
  }
}
