Feature: Login Functionality

  Scenario: Successful Login
    Given the user is on the login page
    When the user logs in with username "standard_user" and password "secret_sauce"
    Then the user should be logged in

  Scenario: Unsuccessful Login with Invalid Username
    Given the user is on the login page
    When the user logs in with username "invalid_user" and password "secret_sauce"
    Then the user should see an error message "Epic sadface: Username and password do not match any user in this service"