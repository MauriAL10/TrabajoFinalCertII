package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PIMPage {

    WebDriver driver;

    @FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']/div/input[@class='oxd-input oxd-input--active']")
    WebElement employeeIdTextBox;

    @FindBy(xpath = "//label[text()='Employee Name']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']/div/div/div/input")
    WebElement employeeNameTextBox;

    @FindBy(css = "button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space")
    WebElement searchButton;

    @FindBy(css = "div.oxd-table-row.oxd-table-row--with-border.oxd-table-row--clickable")
    WebElement employeeTable;

    @FindBy(xpath = "//a[contains(.,'Add')]")
    WebElement addButton;

    @FindBy(xpath = "//button[contains(.,'Save')]")
    WebElement saveButton;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstNamePlaceHolder;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastNamePlaceHolder;

    @FindBy(className = "orangehrm-edit-employee-imagesection")
    WebElement employeeInformation;

    @FindBy(css = "div.oxd-toast.oxd-toast--success.oxd-toast-container--toast.oxd-toast-list-leave-active.oxd-toast-list-leave-to")
    WebElement successMsg;

    @FindBy(xpath = "//span[text()='(1) Record Found']")
    WebElement recordsFound;


    public PIMPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setEmployeeIdTextBox(String employeeID) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(employeeIdTextBox));
        employeeIdTextBox.sendKeys(employeeID);
    }

    public void setEmployeeNameTextBox(String employeeName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(employeeNameTextBox));
        employeeNameTextBox.sendKeys(employeeName);
    }

    public void clickOnSearchButton(){
        searchButton.click();
    }

    public void clickOnAddButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addButton));
        addButton.click();
    }

    public void clickOnSaveButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButton.click();
    }

    public void clickOnEmployeeTable(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(employeeTable));
        employeeTable.click();
    }

    public void setFirstNamePlaceHolder(String firstName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(firstNamePlaceHolder));
        firstNamePlaceHolder.sendKeys(firstName);
    }

    public void setLastNamePlaceHolder(String lastName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(lastNamePlaceHolder));
        lastNamePlaceHolder.sendKeys(lastName);
    }

    public boolean employeeInformationIsDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(employeeInformation));
        boolean employeeInfoIsDisplayed = employeeInformation.isDisplayed();
        return  employeeInfoIsDisplayed;
    }

    public boolean successMsgIsDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(successMsg));
        boolean successMsgDisplayed = successMsg.isDisplayed();
        return  successMsgDisplayed;
    }

    public boolean verifyEmployeeInTable(String employeeID){
        boolean employeeIsDisplayedInTable = false;
        try{
            WebElement userInTable = driver.findElement(By.xpath("//div[text()='"+employeeID+"']"));
            employeeIsDisplayedInTable = userInTable.isDisplayed();
            return employeeIsDisplayedInTable;
        } catch (Exception e){}
        return employeeIsDisplayedInTable;
    }

    public boolean recordFoundIsVisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(recordsFound));
        boolean recordFound = recordsFound.isDisplayed();
        return recordFound;
    }

}
