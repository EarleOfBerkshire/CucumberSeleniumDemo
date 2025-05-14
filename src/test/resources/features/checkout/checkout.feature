@checkout
Feature: Checkout

  Background: Successful Login
    Given the user is on the login page
    When the user logs in with valid credentials
    Then the user should be logged in


  Scenario: Complete Checkout Process
    When the user adds the first item to the cart
    And the user navigates to the cart
    And the user proceeds to checkout
    And the user enters valid checkout information
    And the user finishes the checkout
    Then the user should see a confirmation message