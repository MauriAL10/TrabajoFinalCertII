import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import utilities.DriverManager;

public class LoginTests extends BaseTest {
    @Test
    public void loginSuccessTest(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNamePlaceHolder("Admin");
        loginPage.setPasswordPlaceHolder("admin123");
        loginPage.clickOnLoginButton();
        MainPage mainPage = new MainPage(DriverManager.getDriver().driver);
        Assert.assertTrue(mainPage.orangeBannerIsDisplayed());
        Assert.assertTrue(mainPage.userDropDownIsDisplayed());
    }

    @Test
    public void loginWithInvalidCredentials(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNamePlaceHolder("admin");
        loginPage.setPasswordPlaceHolder("admin");
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.loginErrorIsDisplayed());
    }
}
