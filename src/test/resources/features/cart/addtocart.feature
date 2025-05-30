@cart
Feature: Add to Cart

  Background: Successful Login
    Given the user is on the login page
    When the user logs in with valid credentials
    Then the user should be logged in

  Scenario: Add First Item to Cart and Verify Details
    When the user adds the first item to the cart
    And the user navigates to the cart
    Then the user should see the first item in the cart
    And the user should see the correct item price
