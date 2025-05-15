package com.gitlab.richard_earle_uk.context;

import com.gitlab.richard_earle_uk.pages.*;
import com.gitlab.richard_earle_uk.utils.WebDriverManagerUtil;
import org.openqa.selenium.WebDriver;

public class TestContext {
  private final WebDriver driver;
  private final ProductsPage productsPage;
  private final CartPage cartPage;

  private final LoginPage loginPage;

  private final OrderConfirmationPage orderConfirmationPage;
  private final CheckoutPage checkoutPage;
  private final CheckoutOverviewPage checkoutOverviewPage;

  public TestContext() {
    WebDriverManagerUtil driverManagerUtil = new WebDriverManagerUtil();
    this.driver = driverManagerUtil.getDriver();
    this.productsPage = new ProductsPage(driver);
    this.cartPage = new CartPage(driver);
    this.loginPage = new LoginPage(driver);
    this.orderConfirmationPage = new OrderConfirmationPage(driver);
    this.checkoutOverviewPage = new CheckoutOverviewPage(driver);
    this.checkoutPage = new CheckoutPage(driver);
  }

  public WebDriver getDriver() {
    return driver;
  }

  public ProductsPage getProductsPage() {
    return productsPage;
  }

  public CartPage getCartPage() {
    return cartPage;
  }

  public LoginPage getLoginPage() {
    return loginPage;
  }

  public OrderConfirmationPage getOrderConfirmationPage() {
    return orderConfirmationPage;
  }

  public CheckoutOverviewPage getCheckoutOverviewPage() {
    return checkoutOverviewPage;
  }

  public CheckoutPage getCheckoutPage() {
    return checkoutPage;
  }
}
