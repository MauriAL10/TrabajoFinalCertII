import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import utilities.DriverManager;

public class LogoutTest extends BaseTest {
    @Test
    public void verifyLogoutTest(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNamePlaceHolder("Admin");
        loginPage.setPasswordPlaceHolder("admin123");
        loginPage.clickOnLoginButton();
        MainPage mainPage = new MainPage(DriverManager.getDriver().driver);
        Assert.assertTrue(mainPage.orangeBannerIsDisplayed());
        Assert.assertTrue(mainPage.userDropDownIsDisplayed());
        mainPage.clickOnUserDropdown();
        mainPage.clickOnLogoutButton();
        loginPage.loginIconIsDisplayed();
    }
}
