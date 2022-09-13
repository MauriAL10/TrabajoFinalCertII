package stepDefinitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.AdminPage;
import pages.MainPage;
import utilities.DriverManager;

public class AdminSteps {
    MainPage mainPage = new MainPage(DriverManager.getDriver().driver);
    AdminPage adminPage = new AdminPage(DriverManager.getDriver().driver);

    @And("I click on Admin button")
    public void clickOnAdminButton(){
        mainPage.clickOnAdminButton();
    }
    @And("I set the employee username {string}")
    public void setEmployeeUsername(String userName){adminPage.setUserNamePlaceHolder(userName);}
    @Then("The employee username {string} is in the table")
    public void verifyUserIsInTable(String userName){
        Assert.assertTrue(adminPage.verifyUserInTable(userName));}

}
