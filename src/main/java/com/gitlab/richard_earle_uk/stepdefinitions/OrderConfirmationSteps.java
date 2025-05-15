package com.gitlab.richard_earle_uk.stepdefinitions;

import com.gitlab.richard_earle_uk.context.TestContext;
import com.gitlab.richard_earle_uk.pages.OrderConfirmationPage;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class OrderConfirmationSteps {
  private final String EXPECTED_ORDER_CONFIRMATION_HEADER = "THANK YOU FOR YOUR ORDER";

  private final OrderConfirmationPage orderConfirmationPage;

  public OrderConfirmationSteps(TestContext context) {
    this.orderConfirmationPage = new OrderConfirmationPage(context.getDriver());
  }

  @Then("the user should see a confirmation message")
  public void theUserShouldSeeAConfirmationMessage() {
    String actualOrderConfirmationHeaderMessage = orderConfirmationPage.getHeaderMessage();
    Assertions.assertEquals(
        EXPECTED_ORDER_CONFIRMATION_HEADER,
        actualOrderConfirmationHeaderMessage,
        "Order confirmation header message did not match expected");
  }
}
