Feature: User Sign In
  As a user
  I want to have an ability to sign in
  So that I can access my account and use the platform

  Scenario: Successful Sign In
    Given I login with valid email and password
    Then I should be successfully signed in

  Scenario: Failed Sign In with Invalid Credentials
    Given I login with invalid email and password
    Then I should see an error message indicating invalid credentials

  Scenario: Failed Sign In with Missing Credentials
    Given I leave the email and password field blank
    Then  I should see an error message indicating missing credentials
    And I shouldn't be able to sign in