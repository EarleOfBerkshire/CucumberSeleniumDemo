package com.gitlab.richard_earle_uk.stepdefinitions;

import com.gitlab.richard_earle_uk.pages.CheckoutPage;
import com.gitlab.richard_earle_uk.utils.WebDriverManagerUtil;
import io.cucumber.java.en.When;

public class CheckoutSteps {
  private static final String DEFAULT_FIRST_NAME = "Fred";
  private static final String DEFAULT_LAST_NAME = "Dibner";
  private static final String DEFAULT_POSTAL_CODE = "12345";

  private final CheckoutPage checkoutPage;

  public CheckoutSteps(WebDriverManagerUtil driverManagerUtil) {
    this.checkoutPage = new CheckoutPage(driverManagerUtil);
  }

  @When("the user enters valid checkout information")
  public void theUserEntersValidCheckoutInformation() {
    checkoutPage.enterCheckoutDetails(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_POSTAL_CODE);
  }
}
