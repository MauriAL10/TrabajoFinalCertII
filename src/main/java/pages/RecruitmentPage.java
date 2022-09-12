package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RecruitmentPage {

    WebDriver driver;

    @FindBy(xpath = "//a[text()='Vacancies']")
    WebElement vacanciesButton;

    @FindBy(css = "i.oxd-icon.bi-plus.oxd-button-icon")
    WebElement addButton;

    @FindBy(xpath = "//label[text()='Vacancy Name']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']/div/input")
    WebElement vacancyNamePlaceHolder;

    @FindBy(xpath = "//label[text()='Job Title']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']/div/div/div/div[@class='oxd-select-text-input']")
    WebElement jobTitle;

    @FindBy(xpath = "//label[text()='Hiring Manager']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']/div//input")
    WebElement hiringManagerHints;

    @FindBy(css = "button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space")
    WebElement saveButton;

    @FindBy(className = "oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message")
    WebElement inputRequired;

    public RecruitmentPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnVacanciesButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(vacanciesButton));
        vacanciesButton.click();
    }

    public void clickOnAddButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(addButton));
        addButton.click();
    }

    public void setVacancyNamePlaceHolder(String vacancyName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(vacancyNamePlaceHolder));
        vacancyNamePlaceHolder.sendKeys(vacancyName);
    }

    public void clickOnJobTitle(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(jobTitle));
        jobTitle.click();
    }

    public void selectJobTitle(String element){
        try{
            WebElement jobTitle = driver.findElement(By.xpath("//*[text()='"+element+"']"));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.visibilityOf(jobTitle));
            jobTitle.click();
        } catch (Exception e){}
    }

    public void setHiringManagerHints(String hiringManager){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(hiringManagerHints));
        hiringManagerHints.sendKeys(hiringManager);
    }

    public void clickOnSaveButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButton.click();
    }

    public boolean inputRequiredIsDisplayed(){
        boolean requiredIsDisplayed = inputRequired.isDisplayed();
        return requiredIsDisplayed;
    }
}
