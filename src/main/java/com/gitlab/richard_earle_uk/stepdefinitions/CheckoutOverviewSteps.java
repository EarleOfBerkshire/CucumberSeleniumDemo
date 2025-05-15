package com.gitlab.richard_earle_uk.stepdefinitions;

import com.gitlab.richard_earle_uk.context.TestContext;
import com.gitlab.richard_earle_uk.pages.CheckoutOverviewPage;
import io.cucumber.java.en.When;

public class CheckoutOverviewSteps {

  private final CheckoutOverviewPage checkoutOverviewPage;

  public CheckoutOverviewSteps(TestContext context) {
    this.checkoutOverviewPage = new CheckoutOverviewPage(context.getDriver());
  }

  @When("the user finishes the checkout")
  public void theUserFinishesTheCheckout() {
    checkoutOverviewPage.clickFinishButton();
  }
}
