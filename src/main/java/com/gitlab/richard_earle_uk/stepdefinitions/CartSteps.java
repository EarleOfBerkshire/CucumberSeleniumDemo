package com.gitlab.richard_earle_uk.stepdefinitions;

import com.gitlab.richard_earle_uk.pages.ProductsPage;
import com.gitlab.richard_earle_uk.utils.WebDriverManagerUtil;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class CartSteps {

  private WebDriver driver;
  private ProductsPage productsPage;

  @Before
  public void setup() {
    driver = WebDriverManagerUtil.getDriver();
  }

  @When("the user adds the first item to the cart")
  public void theUserAddsTheFirstItemToTheCart() {
    productsPage.addFirstItemToCart();
  }

  @And("the user navigates to the cart")
  public void theUserNavigatesToTheCart() {
    productsPage.navigateToCart();
  }

  @Then("the user should see the first item in the cart")
  public void theUserShouldSeeTheFirstItemInTheCart() {
    // TODO: Implement verification that the first item is in the cart
  }

  @And("the user should see the correct item name")
  public void theUserShouldSeeTheCorrectItemName() {
    // TODO: Implement verification of the item's name
  }

  @And("the user should see the correct item price")
  public void theUserShouldSeeTheCorrectItemPrice() {
    // TODO: Implement verification of the item's price
  }
}
