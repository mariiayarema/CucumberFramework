package com.hrms.pages;

import com.hrms.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeListPage extends CommonMethods {
    @FindBy(id = "empsearch_id")
    public WebElement searchById;

    @FindBy(id = "empsearch_employee_name_empName")
    public WebElement searchByName;

    @FindBy(id = "searchBtn")
    public WebElement searchBtn;

    @FindBy(xpath = "//table[@id='resultTable']/tbody/tr[1]/td[2]")
    public WebElement employeeIdCell;

    @FindBy(xpath = "//table[@id='resultTable']/tbody/tr[1]/td[3]")
    public WebElement firstMiddleNameCell;

    @FindBy(xpath = "//table[@id='resultTable']/tbody/tr[1]/td[4]")
    public WebElement lastNameCell;


   public void clickOnSearchBtn(){
       jsClick(searchBtn);
   }

   public void enterFirstAndMiddleNameToSearch(String firstName,String middleName){
       sendText(searchByName,firstName+" "+middleName);
   }

   public void enterEmployeeIdToSearch(String employeeID){
       sendText(searchById,employeeID);
   }

   public String getFistAndMiddleNameFromCell(){
       return firstMiddleNameCell.getText();
   }

    public String getIdFromCell(){
       return  employeeIdCell.getText();
    }


    public EmployeeListPage() {
        PageFactory.initElements(CommonMethods.driver, this);
    }
}
