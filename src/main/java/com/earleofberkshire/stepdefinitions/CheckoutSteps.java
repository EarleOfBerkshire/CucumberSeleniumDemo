package com.earleofberkshire.stepdefinitions;

import com.earleofberkshire.context.TestContext;
import com.earleofberkshire.pages.CheckoutOverviewPage;
import com.earleofberkshire.pages.CheckoutPage;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class CheckoutSteps {
  private static final String DEFAULT_FIRST_NAME = "Fred";
  private static final String DEFAULT_LAST_NAME = "Dibner";
  private static final String DEFAULT_POSTAL_CODE = "12345";

  private final CheckoutPage checkoutPage;
  private final CheckoutOverviewPage checkoutOverviewPage;

  public CheckoutSteps(TestContext context) {
    this.checkoutPage = context.getCheckoutPage();
    this.checkoutOverviewPage = context.getCheckoutOverviewPage();
  }

  @When("the user enters valid checkout information")
  public void theUserEntersValidCheckoutInformation() {
    checkoutPage.enterCheckoutDetails(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_POSTAL_CODE);
    Assertions.assertTrue(checkoutOverviewPage.isLoaded(), "Cart page did not load");
  }
}
