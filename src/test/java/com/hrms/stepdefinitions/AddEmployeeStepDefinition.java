package com.hrms.stepdefinitions;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class AddEmployeeStepDefinition extends CommonMethods {



    @When("click on PIM")
    public void click_on_PIM() {
        waitForVisibilityOfElement(dashboardPage.pimBtn);
        moveToElement(dashboardPage.pimBtn);
    }

    @When("click on add employee button")
    public void click_on_add_employee_button() throws InterruptedException {
        Thread.sleep(1000);
        click(dashboardPage.addEmployeeBtn);
    }

    @When("add first and last name")
    public void add_first_and_last_name() {
     addEmployeePage.enterFirstAndLastName("Har","Pot");
    }


    @When("click on save btn")
    public void click_on_save_btn() throws InterruptedException {
        Thread.sleep(1000);
        addEmployeePage.clickOnAddEmployeeBtn();
        Thread.sleep(1000);
    }


    @Then("verify employee was added")
    public void verify_employee_was_added() {
     String actualProfileName=personalDetailsPage.getUserProfileName();
        Assert.assertEquals("Verifying profile name", actualProfileName, "Har Pot");
    }


    @When("click on login details checkbox")
    public void click_on_login_details_checkbox() {
       addEmployeePage.clickOnCreateLoginDetailsCheckbox();
    }



    @When("enter first name {string}, middle name {string} and last name {string}")
    public void enter_first_name_middle_name_and_last_name(String firstName, String middleName, String lastName) throws InterruptedException {
        Thread.sleep(1000);
     addEmployeePage.enterFirstMiddleAndLastName(firstName,middleName,lastName);
        Thread.sleep(1000);
    }


    @Then("verify that {string} is added successfully")
    public void verify_that_is_added_successfully(String fullName) throws InterruptedException {
        String actualProfileName=personalDetailsPage.getUserProfileName();
        Thread.sleep(1000);
        Assert.assertEquals("Verifying profile name", fullName,actualProfileName );

    }


    @When("enter {string}, {string} and {string}")
    public void enter_and(String firstName, String middleName, String lastName) {
        addEmployeePage.enterFirstMiddleAndLastName(firstName,middleName,lastName);
    }

    @Then("verify {string},{string} and {string} is added successfully")
    public void verify_and_is_added_successfully(String firstName, String middleName, String lastName) throws InterruptedException {
        String fullName=firstName+ " "+middleName+" "+lastName;
        String actualProfileName=personalDetailsPage.getUserProfileName();
        Thread.sleep(1000);
        Assert.assertEquals("Verifying profile name", fullName,actualProfileName );
    }

    @When("add multiple employees and verify they are added successfully")
    public void add_multiple_employees_and_verify_they_are_added_successfully(DataTable employees) {
    List<Map<String,String>> employeeNames =employees.asMaps();
    for(Map<String,String> employeeName:employeeNames){
        String firstName=employeeName.get("FirstName");
        String middleName=employeeName.get("MiddleName");
        String lastName=employeeName.get("LastName");
        String employeeId=employeeName.get("EmployeeID");

        addEmployeePage.enterFirstMiddleAndLastName(firstName,middleName,lastName);
        addEmployeePage.enterEmployeeID(employeeId);
        addEmployeePage.clickOnAddEmployeeBtn();
        String actualFullName=personalDetailsPage.getUserProfileName();
        String expectedFullName=firstName+ " "+middleName+" "+lastName;
        Assert.assertEquals("Verifying profile name",expectedFullName,actualFullName);
        dashboardPage.clickOnAddEmployeeBtn();
     }

    }


    @When("add multiple employees from excel {string} sheet and verify they are added")
    public void add_multiple_employees_from_excel_sheet_and_verify_they_are_added(String sheetName) {
    List<Map<String,String>> excelData=ExcelUtils.exelIntoListOfMaps(Constants.TESTDATA_FILE,sheetName);
    for(Map<String,String> excelEmpName:excelData){
        String firstName=excelEmpName.get("FirstName");
        String middleName=excelEmpName.get("MiddleName");
        String lastName=excelEmpName.get("LastName");
        String employeeID=excelEmpName.get("EmployeeId");

        addEmployeePage.enterFirstMiddleAndLastName(firstName,middleName,lastName);
        addEmployeePage.enterEmployeeID(employeeID);
        addEmployeePage.clickOnAddEmployeeBtn();

        String actualFullName=personalDetailsPage.getUserProfileName();
        String expectedFullName=firstName+ " "+middleName+" "+lastName;
        Assert.assertEquals("Verifying profile name",expectedFullName,actualFullName);
        dashboardPage.clickOnAddEmployeeBtn();
    }



    }



}
