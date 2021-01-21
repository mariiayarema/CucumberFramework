package com.hrms.pages;

import com.hrms.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeePage extends CommonMethods {
    @FindBy(id = "firstName")
    public WebElement firstNameTextBox;

    @FindBy(id = "middleName")
    public WebElement middleNameTxtbox;

    @FindBy(id = "lastName")
    public WebElement lastNameTxtbox;

    @FindBy(id = "employeeId")
    public WebElement empIDTxtbox;

    @FindBy(id = "user_name")
    public WebElement usernameTxtbox;

    @FindBy(id = "user_password")
    public WebElement passwordTxtbox;

    @FindBy(id = "re_password")
    public WebElement confirmPasswordTxtbox;

    @FindBy(id = "btnSave")
    public WebElement saveButton;

    @FindBy(id = "chkLogin")
    public WebElement createLoginDetailsCheckbox;

    @FindBy(id = "photofile")
    public WebElement photographInput;

    @FindBy(id = "status")
    public WebElement statusDD;


    public void enterFirstAndLastName(String firstName, String lastName) {

        sendText(addEmployeePage.firstNameTextBox, firstName);
        sendText(addEmployeePage.lastNameTxtbox, lastName);

    }

    public void clickOnCreateLoginDetailsCheckbox() {
        jsClick(createLoginDetailsCheckbox);
    }

    public void enterEmployeeID(String employeeId) {
        sendText(empIDTxtbox, employeeId);
    }


    public void clickOnAddEmployeeBtn() {
        jsClick(saveButton);
    }

    public void enterFirstMiddleAndLastName(String firstName, String middleName, String lastName) {

        sendText(firstNameTextBox, firstName);
        sendText(middleNameTxtbox, middleName);
        sendText(lastNameTxtbox, lastName);

    }

    public AddEmployeePage() {
        PageFactory.initElements(CommonMethods.driver, this);
    }
}
