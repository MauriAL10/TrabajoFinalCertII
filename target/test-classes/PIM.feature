Feature: PIM page feature
  Background: User login into Orange HRM page
    Given Im in orange hrm web page

    @searchEmployeeByID @NeedLogout
    Scenario Outline: Search an employee by ID
      Given I set the user name field with "Admin"
      And I set the password field with "admin123"
      And I Click on Login Button
      And The orange banner is displayed
      And I set the employee "<id>"
      And I click on the search button
      And The record found has only one
      And The employee "<id>" is in the table
      When I click on employee table
      Then The employee info is displayed
      Examples:
      |id|
      |0212|
      |0066|
      |0020|

    @addEmployeeTest
    Scenario: Add an employee in Pim Page
      Given I set the user name field with "Admin"
      And I set the password field with "admin123"
      And I Click on Login Button
      And The orange banner is displayed
      And I click on Add Employee button
      And I fill the Employee information with
        | Mauricio | Angulo |
      And I click on Save Button
      Then The employee information is displayed
