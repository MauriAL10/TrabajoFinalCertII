import org.junit.Assert;
import org.junit.Test;
import pages.AdminPage;
import pages.LoginPage;
import pages.MainPage;
import utilities.DriverManager;

public class AdminTests extends BaseTest{
    @Test
    public void searchByUsernameTest(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNamePlaceHolder("Admin");
        loginPage.setPasswordPlaceHolder("admin123");
        loginPage.clickOnLoginButton();
        MainPage mainPage = new MainPage(DriverManager.getDriver().driver);
        Assert.assertTrue(mainPage.orangeBannerIsDisplayed());
        mainPage.clickOnAdminButton();
        AdminPage adminPage = new AdminPage(DriverManager.getDriver().driver);
        adminPage.setUserNamePlaceHolder("Alice.Duval");
        adminPage.clickOnSearchButton();
        Assert.assertTrue(adminPage.recordFoundIsVisible());
        Assert.assertTrue(adminPage.verifyUserInTable("Alice.Duval"));
    }
}
