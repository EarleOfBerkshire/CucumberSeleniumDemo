@login
Feature: Login Functionality
Background:
  Given the user is on the login page

  Scenario: Successful Login
    When the user logs in with username "standard_user" and password "secret_sauce"
    Then the user should be logged in


  Scenario: Unsuccessful Login with Invalid Username
    When the user logs in with username "invalid_user" and password "secret_sauce"
    Then the user should see an error message "Epic sadface: Username and password do not match any user in this service"


  Scenario: Unsuccessful Login with Invalid Password
    When the user logs in with username "standard_user" and password "wrong_password"
    Then the user should see an error message "Epic sadface: Username and password do not match any user in this service"


  Scenario: Unsuccessful Login with Locked Out User
    When the user logs in with username "locked_out_user" and password "secret_sauce"
    Then the user should see an error message "Epic sadface: Sorry, this user has been locked out."