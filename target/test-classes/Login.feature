Feature: Login Orange HRM
  Background: User Login into Orange HRM page
    Given Im in orange hrm web page

    @loginWithValidCredentials @NeedLogout
    Scenario: Login into Orange HRM page with valid credentials
      Given I set the user name field with "Admin"
      And I set the password field with "admin123"
      When I Click on Login Button
      Then The main page should be displayed

    @loginWithInvalidCredentials
    Scenario Outline: Login into Orange HRM page with invalid credentials
    Given I set the user name field with a "<wrong_user>"
    And I set the password field with a "<wrong_pass>"
    When I Click on Login Button
    Then An error message is displayed
      Examples:
      | wrong_user    | wrong_pass|
      | Mauri         | pass      |
      | admin         | pass123   |
      | standard_user | contrasena|
