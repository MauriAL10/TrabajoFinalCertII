Feature: Admin page feature
  Background: User login into Orange HRM page
    Given Im in orange hrm web page

  @searchByUsername @NeedLogout
  Scenario Outline: Search in admin by Username
    Given I set the user name field with "Admin"
    And I set the password field with "admin123"
    And I Click on Login Button
    And The orange banner is displayed
    And I click on Admin button
    And I set the employee username "<username>"
    And I click on the search button
    And The record found has only one
    Then The employee username "<username>" is in the table
    Examples:
      |username|
      |Fiona.Grace|
      |Dominic.Chase|
      |Charlie.Carter|
