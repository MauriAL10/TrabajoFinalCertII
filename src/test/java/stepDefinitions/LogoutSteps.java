package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import pages.MainPage;
import pages.PIMPage;
import utilities.DriverManager;

public class LogoutSteps {
    MainPage mainPage = new MainPage(DriverManager.getDriver().driver);
    LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);

    @And("I click on logout button")
    public void clickOnLogoutButton(){
        mainPage.clickOnLogoutButton();
    }

    @Then("The login page should be displayed")
    public void loginIconIsDisplayed(){
        loginPage.loginIconIsDisplayed();
    }
}
