package com.earleofberkshire.stepdefinitions;

import com.earleofberkshire.context.TestContext;
import com.earleofberkshire.pages.CartPage;
import com.earleofberkshire.pages.CheckoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class CartSteps {

  private final String FIRST_ITEM_NAME = "Sauce Labs Backpack";
  private final String FIRST_ITEM_PRICE = "29.99";
  private final CartPage cartPage;
  private final CheckoutPage checkoutPage;

  public CartSteps(TestContext testContext) {
    this.cartPage = testContext.getCartPage();
    this.checkoutPage = testContext.getCheckoutPage();
  }

  @Then("the user should see the first item in the cart")
  public void theUserShouldSeeTheFirstItemInTheCart() {
    String actualItemName = cartPage.getCartItemName(0);
    Assertions.assertEquals(FIRST_ITEM_NAME, actualItemName, "Item name does not match expected.");
  }

  @And("the user should see the correct item price")
  public void theUserShouldSeeTheCorrectItemPrice() {
    String actualItemPrice = cartPage.getCartRowItemPrice(0);
    Assertions.assertEquals(
        FIRST_ITEM_PRICE, actualItemPrice, "Item price does not match expected.");
  }

  @And("the user proceeds to checkout")
  public void theUserProceedsToCheckout() {
    cartPage.clickCheckoutButton();
    Assertions.assertTrue(checkoutPage.isLoaded(), "Checkout page did not load");
  }
}
