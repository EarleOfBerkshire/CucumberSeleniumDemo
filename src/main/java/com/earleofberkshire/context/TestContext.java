package com.earleofberkshire.context;

import com.earleofberkshire.pages.CartPage;
import com.earleofberkshire.pages.CheckoutOverviewPage;
import com.earleofberkshire.pages.CheckoutPage;
import com.earleofberkshire.pages.LoginPage;
import com.earleofberkshire.pages.OrderConfirmationPage;
import com.earleofberkshire.pages.ProductsPage;
import com.earleofberkshire.utils.WebDriverManagerUtil;
import org.openqa.selenium.WebDriver;

/**
 * Provides a centralized context for sharing state and page objects across step definitions.
 *
 * <p>This class is responsible for initializing and exposing all page objects as well as the
 * WebDriver instance used throughout the test lifecycle. It promotes reusability and avoids
 * duplication across step classes.
 */
public class TestContext {

  private final WebDriver driver;
  private final ProductsPage productsPage;
  private final CartPage cartPage;
  private final LoginPage loginPage;
  private final OrderConfirmationPage orderConfirmationPage;
  private final CheckoutOverviewPage checkoutOverviewPage;
  private final CheckoutPage checkoutPage;

  /**
   * Constructs a TestContext by initializing the WebDriver and all related page objects. The
   * WebDriver is managed via {@link WebDriverManagerUtil}.
   */
  public TestContext() {
    this.driver = WebDriverManagerUtil.getDriver();
    this.productsPage = new ProductsPage(driver);
    this.cartPage = new CartPage(driver);
    this.loginPage = new LoginPage(driver);
    this.orderConfirmationPage = new OrderConfirmationPage(driver);
    this.checkoutPage = new CheckoutPage(driver);
    this.checkoutOverviewPage = new CheckoutOverviewPage(driver);
  }

  /**
   * Returns the shared WebDriver instance.
   *
   * @return the WebDriver instance
   */
  public WebDriver getDriver() {
    return driver;
  }

  /**
   * Returns the ProductsPage object for interacting with the product listing screen.
   *
   * @return the ProductsPage instance
   */
  public ProductsPage getProductsPage() {
    return productsPage;
  }

  /**
   * Returns the CartPage object for interacting with the shopping cart.
   *
   * @return the CartPage instance
   */
  public CartPage getCartPage() {
    return cartPage;
  }

  /**
   * Returns the LoginPage object for login-related operations.
   *
   * @return the LoginPage instance
   */
  public LoginPage getLoginPage() {
    return loginPage;
  }

  /**
   * Returns the OrderConfirmationPage object used to validate order success.
   *
   * @return the OrderConfirmationPage instance
   */
  public OrderConfirmationPage getOrderConfirmationPage() {
    return orderConfirmationPage;
  }

  /**
   * Returns the CheckoutPage object for filling in user checkout information.
   *
   * @return the CheckoutPage instance
   */
  public CheckoutPage getCheckoutPage() {
    return checkoutPage;
  }

  /**
   * Returns the CheckoutOverviewPage object for reviewing order details before confirming.
   *
   * @return the CheckoutOverviewPage instance
   */
  public CheckoutOverviewPage getCheckoutOverviewPage() {
    return checkoutOverviewPage;
  }
}
