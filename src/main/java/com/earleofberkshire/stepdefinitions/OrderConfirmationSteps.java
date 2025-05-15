package com.earleofberkshire.stepdefinitions;

import com.earleofberkshire.context.TestContext;
import com.earleofberkshire.pages.OrderConfirmationPage;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

/**
 * Step definition class for handling assertions on the Order Confirmation page.
 *
 * <p>This class verifies that the user is shown the correct confirmation message after completing a
 * purchase. It uses the shared {@link TestContext} to retrieve the appropriate page object.
 */
public class OrderConfirmationSteps {

  /** The expected text displayed upon successful order confirmation. */
  private final String expectedOrderConfirmationHeader = "THANK YOU FOR YOUR ORDER";

  private final OrderConfirmationPage orderConfirmationPage;

  /**
   * Constructor that initializes the {@link OrderConfirmationPage} using the shared {@link
   * TestContext}.
   *
   * @param context the test context providing access to the page objects
   */
  public OrderConfirmationSteps(TestContext context) {
    this.orderConfirmationPage = context.getOrderConfirmationPage();
  }

  /**
   * Verifies that the order confirmation message is displayed to the user. This step corresponds to
   * the Cucumber step: <br>
   * {@code Then the user should see a confirmation message}
   */
  @Then("the user should see a confirmation message")
  public void theUserShouldSeeConfirmationMessage() {
    String actualOrderConfirmationHeaderMessage = orderConfirmationPage.getHeaderMessage();
    Assertions.assertEquals(
        expectedOrderConfirmationHeader,
        actualOrderConfirmationHeaderMessage,
        "Order confirmation header message did not match expected");
  }
}
