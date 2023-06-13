Feature: Login Functionality

  Scenario: Successful login
    Given I am on the login page
    When I enter my username as "john@example.com"
    And I enter my password as "password123"
    And I click the login button
    Then I should be redirected to the home page