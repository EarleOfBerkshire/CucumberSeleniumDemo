package com.earleofberkshire.context;

import com.earleofberkshire.pages.CartPage;
import com.earleofberkshire.pages.CheckoutOverviewPage;
import com.earleofberkshire.pages.CheckoutPage;
import com.earleofberkshire.pages.LoginPage;
import com.earleofberkshire.pages.OrderConfirmationPage;
import com.earleofberkshire.pages.ProductsPage;
import com.earleofberkshire.utils.WebDriverManagerUtil;
import org.openqa.selenium.WebDriver;

public class TestContext {

  private final WebDriver driver;
  private final ProductsPage productsPage;
  private final CartPage cartPage;
  private final LoginPage loginPage;
  private final OrderConfirmationPage orderConfirmationPage;
  private final CheckoutOverviewPage checkoutOverviewPage;
  private final CheckoutPage checkoutPage;

  public TestContext() {
    this.driver = WebDriverManagerUtil.getDriver();
    this.productsPage = new ProductsPage(driver);
    this.cartPage = new CartPage(driver);
    this.loginPage = new LoginPage(driver);
    this.orderConfirmationPage = new OrderConfirmationPage(driver);
    this.checkoutPage = new CheckoutPage(driver);
    this.checkoutOverviewPage = new CheckoutOverviewPage(driver);
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

  public CheckoutPage getCheckoutPage() {
    return checkoutPage;
  }

  public CheckoutOverviewPage getCheckoutOverviewPage() {
    return checkoutOverviewPage;
  }
}
