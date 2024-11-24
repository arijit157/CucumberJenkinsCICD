Feature: Authentication

  Background: Common steps for all the scenarios
    Given user opens the browser
    And goes to the url "https://amazon.in"

  Scenario: login and logout testing with valid credentials
    When user clicks on the account and list link
    And user gives the email "arijitbhakta611@gmail.com"
    And user clicks the continue button
    And user gives the password "Cas_1010"
    Then clicks the login button
    And user closes the browser

  Scenario: login and logout testing with invalid credentials
    When user clicks on the account and list link
    And user gives the email "arijitbhakta@gmail.com"
    And user clicks the continue button
    And user gives the password "Cas_1010"
    Then clicks the login button
    And user verifies the login error message
    And user closes the browser
