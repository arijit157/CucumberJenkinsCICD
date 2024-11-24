Feature: Authentication

  Background: Common steps for all the scenarios
    Given user opens the browser
    And goes to the url "https://amazon.in"

  Scenario: login and logout testing with valid credentials
    When user clicks on the account and list link
    And user gives the email "9679114095"
    And user clicks the continue button
    And user gives the password "Cas_1010"
    Then clicks the login button
    #Then user verifies the dashboard heading present on the home page
    #When user clicks the logout button
    #Then user verifies the login button present on the page
    And user closes the browser

  Scenario: login and logout testing with invalid credentials
    When user clicks on the account and list link
    And user gives the email "arijitbhakta@gmail.com"
    And user clicks the continue button
    And user gives the password "Cas_1010"
    Then clicks the login button
    And user verifies the login error message
    And user closes the browser