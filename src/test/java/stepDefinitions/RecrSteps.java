package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.MainPage;
import pages.RecruitmentPage;
import utilities.DriverManager;

import java.util.List;

public class RecrSteps {
    MainPage mainPage = new MainPage(DriverManager.getDriver().driver);
    RecruitmentPage recruitmentPage = new RecruitmentPage(DriverManager.getDriver().driver);

    @And("I click on Recruitment button")
    public void clickOnRecruitmentButton(){
        mainPage.clickOnRecruitmentButton();
    }

    @And("I click on Vacancies button")
    public void clickOnVacanciesButton(){ recruitmentPage.clickOnVacanciesButton();}

    @And("I click on Add Vacancy button")
    public void clickOnAddVacancyButton(){recruitmentPage.clickOnAddButton();}

    @And("I fill the Vacancy information with")
    public void fillVacancyInformation(DataTable vacancyInfo) {
        List<String> data = vacancyInfo.transpose().asList(String.class);
        recruitmentPage.setVacancyNamePlaceHolder(data.get(0));
        recruitmentPage.selectJobTitle(data.get(1));
        recruitmentPage.setHiringManagerHints(data.get(2));
    }

    @Then("The alert that the fields are required appears")
    public void alertIsDisplayed(){recruitmentPage.inputRequiredIsDisplayed();}
}
