package com.gitlab.richard_earle_uk.stepdefinitions;

import com.gitlab.richard_earle_uk.pages.ProductsPage;
import com.gitlab.richard_earle_uk.utils.DriverFactory;
import com.gitlab.richard_earle_uk.utils.WebDriverManagerUtil;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class ProductsSteps {

  private WebDriver driver = DriverFactory.getDriver();
  private ProductsPage productsPage;

  @Before
  public void setup() {
    driver = WebDriverManagerUtil.getDriver();
    productsPage = new ProductsPage(driver);
  }

  @When("the user adds the first item to the cart")
  public void theUserAddsTheFirstItemToTheCart() {
    productsPage.addFirstItemToCart();
  }

  @And("the user navigates to the cart")
  public void theUserNavigatesToTheCart() {
    productsPage.navigateToCart();
  }
}
