import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.PIMPage;
import utilities.DriverManager;

public class PIMTests extends BaseTest {

    @Test @Ignore
    public void searchByEmployeeIdTest(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNamePlaceHolder("Admin");
        loginPage.setPasswordPlaceHolder("admin123");
        loginPage.clickOnLoginButton();
        MainPage mainPage = new MainPage(DriverManager.getDriver().driver);
        Assert.assertTrue(mainPage.orangeBannerIsDisplayed());
        PIMPage pimPage = new PIMPage(DriverManager.getDriver().driver);
        pimPage.setEmployeeIdTextBox("0221");
        pimPage.setEmployeeNameTextBox("Alice Duval");
        pimPage.clickOnSearchButton();
        Assert.assertTrue(pimPage.recordFoundIsVisible());
        Assert.assertTrue(pimPage.verifyEmployeeInTable("0221"));
        pimPage.clickOnEmployeeTable();
        Assert.assertTrue(pimPage.employeeInformationIsDisplayed());
    }

    @Test
    public void addEmployeeTest(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNamePlaceHolder("Admin");
        loginPage.setPasswordPlaceHolder("admin123");
        loginPage.clickOnLoginButton();
        MainPage mainPage = new MainPage(DriverManager.getDriver().driver);
        Assert.assertTrue(mainPage.orangeBannerIsDisplayed());
        PIMPage pimPage = new PIMPage(DriverManager.getDriver().driver);
        pimPage.clickOnAddButton();
        pimPage.setFirstNamePlaceHolder("Mauri");
        pimPage.setLastNamePlaceHolder("Angulo");
        pimPage.clickOnSaveButton();
        //Assert.assertTrue(pimPage.successMsgIsDisplayed());
        Assert.assertTrue(pimPage.employeeInformationIsDisplayed());
    }
}
