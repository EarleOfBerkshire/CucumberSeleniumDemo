package com.gitlab.richard_earle_uk.stepdefinitions;

import com.gitlab.richard_earle_uk.context.WebDriverContext;
import com.gitlab.richard_earle_uk.pages.CheckoutOverviewPage;
import com.gitlab.richard_earle_uk.pages.OrderConfirmationPage;
import com.gitlab.richard_earle_uk.pages.ProductsPage;
import com.gitlab.richard_earle_uk.utils.WebDriverManagerUtil;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewSteps {

  private WebDriver driver;
  private ProductsPage productsPage;
  private CheckoutOverviewPage checkoutOverviewPage;

  public CheckoutOverviewSteps(WebDriverManagerUtil driverManagerUtil) {
    this.checkoutOverviewPage = new CheckoutOverviewPage(driverManagerUtil);
  }

  @When("the user finishes the checkout")
  public void theUserFinishesTheCheckout() {
    checkoutOverviewPage.clickFinishButton();
  }
}
