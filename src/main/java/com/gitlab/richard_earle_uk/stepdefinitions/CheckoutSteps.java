package com.gitlab.richard_earle_uk.stepdefinitions;

import com.gitlab.richard_earle_uk.pages.CheckoutOverviewPage;
import com.gitlab.richard_earle_uk.pages.CheckoutPage;
import com.gitlab.richard_earle_uk.pages.OrderConfirmationPage;
import com.gitlab.richard_earle_uk.pages.ProductsPage;
import com.gitlab.richard_earle_uk.utils.WebDriverManagerUtil;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class CheckoutSteps {
  private static final String DEFAULT_FIRST_NAME = "Fred";
  private static final String DEFAULT_LAST_NAME = "Dibner";
  private static final String DEFAULT_POSTAL_CODE = "12345";
  private final String EXPECTED_ORDER_CONFIRMATION_HEADER = "THANK YOU FOR YOUR ORDER";

  private WebDriver driver;
  private ProductsPage productsPage;
  private CheckoutPage checkoutPage;
  private CheckoutOverviewPage checkoutOverviewPage;
  private OrderConfirmationPage orderConfirmationPage;

  @Before
  public void setup() {
    driver = WebDriverManagerUtil.getDriver();
    checkoutPage = new CheckoutPage(driver);
    checkoutOverviewPage = new CheckoutOverviewPage(driver);
    orderConfirmationPage = new OrderConfirmationPage(driver);
  }

  @When("the user enters valid checkout information")
  public void theUserEntersValidCheckoutInformation() {
    checkoutPage.enterCheckoutDetails(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_POSTAL_CODE);
  }

  @When("the user finishes the checkout")
  public void theUserFinishesTheCheckout() {
    checkoutOverviewPage.clickFinishButton();
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
