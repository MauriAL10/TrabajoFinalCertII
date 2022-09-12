package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.MainPage;
import utilities.DriverManager;

import java.time.Duration;

public class LoginSteps {

    LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);

    @Given("I set the user name field with {string}")
    public void setUserName(String userName) {
        loginPage.setUserNamePlaceHolder(userName);
    }
    @And("I set the password field with {string}")
    public void setPassword(String password){
        loginPage.setPasswordPlaceHolder(password);
    }

    @When("I Click on Login Button")
    public void clickOnLoginButton(){
        loginPage.clickOnLoginButton();
    }

    @Given("I set the user name field with a {string}")
    public void setUserNameIncorrect(String userName) {
        loginPage.setUserNamePlaceHolder(userName);
    }

    @And("I set the password field with a {string}")
    public void setPasswordIncorrect(String password){
        loginPage.setPasswordPlaceHolder(password);
    }

    @Then("An error message is displayed")
    public void loginErrorIsDisplayed(){
        loginPage.loginErrorIsDisplayed();
    }



}
