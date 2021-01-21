package com.hrms.stepdefinitions;

import com.hrms.utils.CommonMethods;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SearchEmployeeStepDefinition extends CommonMethods {

    @When("click on Employee List")
    public void click_on_Employee_List() {
        dashboardPage.clickOnEmployeeListBtn();
    }


    @When("enter {string}, {string}")
    public void enter(String firstName, String middleName) {
        waitForVisibilityOfElement(employeeListPage.searchByName);
        employeeListPage.enterFirstAndMiddleNameToSearch(firstName, middleName);

    }

    @When("click on search btn")
    public void click_on_search_btn(){
        employeeListPage.clickOnSearchBtn();

    }

    @Then("verify {string}, {string} exist in a list")
    public void verify_exist_in_a_list(String firstName, String middleName) {
        waitForVisibilityOfElement(employeeListPage.firstMiddleNameCell);

        String actualFirstAndMiddleName = employeeListPage.getFistAndMiddleNameFromCell();
        String expectedFirstAndMiddleNAme = firstName + " " + middleName;

        Assert.assertEquals("Verifying employee exist", expectedFirstAndMiddleNAme, actualFirstAndMiddleName);
    }


    @When("enter {string}")
    public void enter(String employeeID) {
        waitForVisibilityOfElement(employeeListPage.searchById);
        employeeListPage.enterEmployeeIdToSearch(employeeID);

    }

    @Then("verify {string} exist in an employee list")
    public void verify_exist_in_an_employee_list(String employeeID){
        waitForVisibilityOfElement(employeeListPage.employeeIdCell);

        String expectedEmployeeID =employeeID;
        String actualEmployeeID = employeeListPage.getIdFromCell();

        System.out.println(expectedEmployeeID);
        System.out.println(actualEmployeeID);


        Assert.assertEquals("Verifying employee exist", expectedEmployeeID, actualEmployeeID);
    }


}
