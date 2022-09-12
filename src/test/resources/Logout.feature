Feature: Logout feature
  Background: User login into Orange HRM page
    Given Im in orange hrm web page

    @logoutTest
    Scenario: Login into Orange HRM page with valid credentials
      Given I set the user name field with "Admin"
      And I set the password field with "admin123"
      And I Click on Login Button
      And The orange banner is displayed
      And The user dropdown is displayed
      And I click on the user dropdown
      When I click on logout button
      Then The login page should be displayed