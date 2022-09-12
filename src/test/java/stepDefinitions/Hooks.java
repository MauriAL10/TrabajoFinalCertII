package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import org.junit.Assert;
import pages.LoginPage;
import pages.MainPage;
import utilities.DriverManager;

public class Hooks {

    @After("@NeedLogout")
    public void afterScenario(){
        MainPage mainPage = new MainPage(DriverManager.getDriver().driver);
        mainPage.clickOnUserDropdown();
        mainPage.clickOnLogoutButton();
    }

    @AfterAll
    public static void afterAll(){
        DriverManager.getDriver().driver.close();
    }

}
