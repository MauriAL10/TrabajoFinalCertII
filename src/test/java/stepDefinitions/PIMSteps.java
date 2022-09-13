package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import pages.MainPage;
import pages.PIMPage;
import utilities.DriverManager;

import java.util.List;

public class PIMSteps {
    MainPage mainPage = new MainPage(DriverManager.getDriver().driver);
    PIMPage pimPage = new PIMPage(DriverManager.getDriver().driver);
    @And("I set the employee {string}")
    public void setEmployeeID(String id) {
        pimPage.setEmployeeIdTextBox(id);
    }

    @And("I click on the search button")
    public void clickOnSearchButton(){
        pimPage.clickOnSearchButton();
    }

    @And("The record found has only one")
    public void verifyRecordFound(){
        pimPage.recordFoundIsVisible();
    }

    @And("The employee {string} is in the table")
    public void verifyEmployeeIsInTable(String id){
        pimPage.verifyEmployeeInTable(id);
    }
    @When("I click on employee table")
    public void clickOnEmployeeTable(){
        pimPage.clickOnEmployeeTable();
    }
    @Then("The employee info is displayed")
    public void verifyEmployeeInfoIsDisplayed(){
        Assert.assertTrue(pimPage.employeeInformationIsDisplayed());
    }

    @And("The orange banner is displayed")
    public void verifyOrangeBannerIsDisplayed(){mainPage.orangeBannerIsDisplayed();}

    @And("I click on Add Employee button")
    public void clickOnAddButton(){
        pimPage.clickOnAddButton();
    }

    @And("I fill the Employee information with")
    public void fillEmployeeInformation(DataTable employeeInfo) {
        List<String> data = employeeInfo.transpose().asList(String.class);
        pimPage.setFirstNamePlaceHolder(data.get(0));
        pimPage.setLastNamePlaceHolder(data.get(1));
    }

    @And("I click on Save Button")
    public void clickOnSaveButton(){
        pimPage.clickOnSaveButton();
    }

    @Then("The employee information is displayed")
    public void employeeInfoIsDisplayed(){
        pimPage.employeeInformationIsDisplayed();
    }
}
