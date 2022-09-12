import org.junit.Assert;
import org.junit.Test;
import pages.AdminPage;
import pages.LoginPage;
import pages.MainPage;
import pages.RecruitmentPage;
import utilities.DriverManager;

public class RecruitmentTest extends BaseTest {

    @Test
    public void addVacancyTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNamePlaceHolder("Admin");
        loginPage.setPasswordPlaceHolder("admin123");
        loginPage.clickOnLoginButton();
        MainPage mainPage = new MainPage(DriverManager.getDriver().driver);
        Assert.assertTrue(mainPage.orangeBannerIsDisplayed());
        mainPage.clickOnRecruitmentButton();
        RecruitmentPage recruitmentPage = new RecruitmentPage(DriverManager.getDriver().driver);
        recruitmentPage.clickOnVacanciesButton();
        recruitmentPage.clickOnAddButton();
        recruitmentPage.setVacancyNamePlaceHolder("Senior Software Engineer");
        recruitmentPage.clickOnJobTitle();
        //recruitmentPage.selectJobTitle2("Content Specialist");
        recruitmentPage.selectJobTitle("Content Specialist");
        Thread.sleep(2);
        recruitmentPage.setHiringManagerHints("Odis");
        recruitmentPage.clickOnSaveButton();
        Assert.assertTrue(recruitmentPage.inputRequiredIsDisplayed());
        /*
        Feature: Recruitment feature
  Background: User login into Orange HRM page
    Given Im in orange hrm web page

    @verifyInputsAreRequired @ignore
    Scenario: Verify inputs are required in add vacancy
      Given I set the user name field with "Admin"
      And I set the password field with "admin123"
      And I Click on Login Button
      And The orange banner is displayed
      And I click on Recruitment button
      And I click on Vacancies button
      And I click on Add Vacancy button
      And I fill the Vacancy information with
        | Senior Software Engineer | | |
      And I click on Save Button
      Then The alert that the fields are required appears
         */
    }
}
