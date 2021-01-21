package com.hrms.stepdefinitions;

import com.hrms.utils.CommonMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinition extends CommonMethods {

    //common step
    @Given("navigate to HRMS login page")
    public void navigate_to_hrms_login_page() {
        setUp();

    }

    //login with valid credentials
    @When("enter valid credentials")
    public void enter_valid_credentials() {
        loginPage.login("Admin", "Hum@nhrm123");

    }

    //common step
    @When("click on login button")
    public void click_on_login_button() {
        loginPage.clickOnLoginBth();

    }

    //login with valid credentials
    @Then("verify dashboard is displayed")
    public void verify_dashboard_is_displayed() {
        Assert.assertTrue(dashboardPage.welcomeMessage.isDisplayed());
    }

    //common step
    @Then("quit the browser")
    public void quit_the_browser() {
        tearDown();
    }

    //login with invalid credentials
    @When("enter invalid credentials")
    public void enter_invalid_credentials() {
        loginPage.login("Admin123", "Hum@nhrm123123");
    }

    //login with invalid credentials
    @Then("verify error message")
    public void verify_error_message() {
        Assert.assertEquals("Verifying error message", "Invalid credentials", loginPage.getErrorMessageText());
    }


    //login in with empty username
    @When("leave username empty")
    public void leave_username_empty() {
        loginPage.login("", "Hum@nhrm123");
    }

    //login in with empty username
    @Then("verify error message for empty username")
    public void verify_error_message_for_empty_username() {
        Assert.assertEquals("Verifying error message with empty username", "Username cannot be empty", loginPage.getErrorMessageText());
    }

    //login in with empty password
    @When("leave password empty")
    public void leave_password_empty() {
        loginPage.login("Admin", "");
    }

    //login in with empty password
    @Then("verify error message for empty password")
    public void verify_error_message_for_empty_password() {
        Assert.assertEquals("Verifying error message with empty password", "Password cannot be empty", loginPage.getErrorMessageText());
    }




}
