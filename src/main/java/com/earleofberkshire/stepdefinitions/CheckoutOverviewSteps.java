package com.earleofberkshire.stepdefinitions;

import com.earleofberkshire.context.TestContext;
import com.earleofberkshire.pages.CheckoutOverviewPage;
import com.earleofberkshire.pages.OrderConfirmationPage;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class CheckoutOverviewSteps {

  private final CheckoutOverviewPage checkoutOverviewPage;
  private final OrderConfirmationPage orderConfirmationPage;

  public CheckoutOverviewSteps(TestContext context) {
    this.checkoutOverviewPage = context.getCheckoutOverviewPage();
    this.orderConfirmationPage = context.getOrderConfirmationPage();
  }

  @When("the user finishes the checkout")
  public void theUserFinishesTheCheckout() {
    checkoutOverviewPage.clickFinishButton();
    Assertions.assertTrue(orderConfirmationPage.isLoaded(), "Cart page did not load");
  }
}
