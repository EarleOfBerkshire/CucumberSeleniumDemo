package com.gitlab.richard_earle_uk.pages;

import com.gitlab.richard_earle_uk.utils.ElementUtil;
import com.gitlab.richard_earle_uk.utils.WebDriverManagerUtil;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

  private final WebDriver driver;
  private final By firstAddToCartButton = By.cssSelector(".inventory_item:first-of-type button");
  private final By shoppingCartLink = By.className("shopping_cart_link");
  private final ElementUtil elementUtil;

  public ProductsPage(WebDriverManagerUtil driverManagerUtil) {
    this.driver = driverManagerUtil.getDriver();
    this.elementUtil = new ElementUtil(driver);
  }

  public void addFirstItemToCart() {
    elementUtil.click(firstAddToCartButton);
  }

  public void navigateToCart() {
    elementUtil.click(shoppingCartLink);
  }
}
