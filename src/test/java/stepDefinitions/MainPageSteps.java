package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.MainPage;
import utilities.DriverManager;

public class MainPageSteps {

    MainPage mainPage = new MainPage(DriverManager.getDriver().driver);
    @And("I click on the user dropdown")
    public void clickOnUserDropDownButton(){
        mainPage.clickOnUserDropdown();
    }

    @Then("")

    @Then("The main page should be displayed")
    public void verifyMainPageIsDisplayed(){
        Assert.assertTrue(mainPage.userDropDownIsDisplayed());
        Assert.assertTrue(mainPage.orangeBannerIsDisplayed());
    }
    @And("The user dropdown is displayed")
    public void verifyUserDropDownIsDisplayed(){mainPage.userDropDownIsDisplayed();}

}
