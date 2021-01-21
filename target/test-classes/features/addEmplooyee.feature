@addEmployee
Feature: Add Employee Functionality

  Background:
    When enter valid credentials
    And click on login button
    Then verify dashboard is displayed
    When click on PIM
    And click on add employee button


  @addEmployeeWithoutLogin
  Scenario: Add Employee without login details

    When add first and last name
    And click on save btn
    Then verify employee was added

  @addEmployeeWithLogin
  Scenario: Add employee with login details

    When add first and last name and middle name
    And click on login details checkbox
    Then enter login details
    And click on save btn
    Then verify employee was added

  @parameter
  Scenario: Add employee without login details but with middlename
    When enter first name "Mariia", middle name "Mary" and last name "Yarema"
    And click on save btn
    Then verify that "Mariia Mary Yarema" is added successfully

  @examples
  Scenario Outline: Adding multiple employees without login details
    When enter "<FirstName>", "<MiddleName>" and "<LastName>"
    And click on save btn
    Then verify "<FirstName>","<MiddleName>" and "<LastName>" is added successfully

    Examples:
      | FirstName | MiddleName | LastName |
      | Oleh      | Ol         | Borchiv  |
      | Masa      | Ma         | Masuna   |

    @dtWithHeader
    Scenario: Adding multiple employees at one execution
      When add multiple employees and verify they are added successfully

        | FirstName | MiddleName | LastName |EmployeeID|
        | Jac      | Ja         | Toronto   |77781     |
        | Davit    | Da         | Wick      |18877     |

      @excelTask
      Scenario: Adding multiple employees from excel
        When add multiple employees from excel "EmployeeData" sheet and verify they are added
