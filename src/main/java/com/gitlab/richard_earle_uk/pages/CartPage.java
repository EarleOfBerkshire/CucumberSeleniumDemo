package com.gitlab.richard_earle_uk.pages;

import com.gitlab.richard_earle_uk.utils.ElementUtil;
import com.gitlab.richard_earle_uk.utils.WebDriverManagerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
  private static final By cartRowItemName = By.className("inventory_item_name");
  private static final By cartRowItemPrice = By.className("inventory_item_price");
  private static final By checkoutButton = By.className("checkout_button");
  private final WebDriver driver;
  private final ElementUtil elementUtil;

  public CartPage(WebDriverManagerUtil driverManagerUtil) {
    this.driver = driverManagerUtil.getDriver();
    this.elementUtil = new ElementUtil(driver);
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
}
