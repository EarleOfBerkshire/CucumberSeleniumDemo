package com.gitlab.richard_earle_uk.stepdefinitions;

import com.gitlab.richard_earle_uk.pages.CheckoutOverviewPage;
import com.gitlab.richard_earle_uk.utils.WebDriverManagerUtil;
import io.cucumber.java.en.When;

public class CheckoutOverviewSteps {

  private final CheckoutOverviewPage checkoutOverviewPage;

  public CheckoutOverviewSteps(WebDriverManagerUtil driverManagerUtil) {
    this.checkoutOverviewPage = new CheckoutOverviewPage(driverManagerUtil);
  }

  @When("the user finishes the checkout")
  public void theUserFinishesTheCheckout() {
    checkoutOverviewPage.clickFinishButton();
  }
}
