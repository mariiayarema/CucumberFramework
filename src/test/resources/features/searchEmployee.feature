Feature: SearchEmployee Functionality


  Background:
    When enter valid credentials
    And click on login button
    Then verify dashboard is displayed
    When click on PIM
    And click on Employee List


  @searchByFirstAndMiddleName
  Scenario Outline: Search mult employee by first and middle name
    When enter "<FirstName>", "<MiddleName>"
    And click on search btn
    Then verify "<FirstName>", "<MiddleName>" exist in a list

    Examples:
      | FirstName | MiddleName  |
      | Mariia    | Mary        |
      | Sofiia    | Ihorivna    |
      | Lesia     | Andriivna   |
      | Ihor      | Ievgenovuch |
      | Emily     | Ann         |


  @searchByEmployeeId
  Scenario Outline: Search mutl employee by id
    When enter "<EmployeeId>"
    And click on search btn
    Then verify "<EmployeeId>" exist in an employee list

    Examples:
    |EmployeeId|
    |12058     |
    |11541     |
    |11955     |
    |11983     |
    |11984     |