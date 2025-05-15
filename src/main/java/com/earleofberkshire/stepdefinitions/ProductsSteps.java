package com.earleofberkshire.stepdefinitions;

import com.earleofberkshire.context.TestContext;
import com.earleofberkshire.pages.CartPage;
import com.earleofberkshire.pages.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ProductsSteps {

  private final ProductsPage productsPage;
  private final CartPage cartPage;
  private final TestContext testContext;

  public ProductsSteps(TestContext context) {
    this.testContext = context;
    this.productsPage = context.getProductsPage();
    this.cartPage = context.getCartPage();
  }

  @When("the user adds the first item to the cart")
  public void theUserAddsTheFirstItemToTheCart() {
    productsPage.addFirstItemToCart();
  }

  @And("the user navigates to the cart")
  public void theUserNavigatesToTheCart() {
    productsPage.navigateToCart();
    Assertions.assertTrue(cartPage.isLoaded(), "Cart page did not load");
  }
}
