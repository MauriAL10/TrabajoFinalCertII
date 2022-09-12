package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminPage{
    WebDriver driver;

    @FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']/div/input[@class='oxd-input oxd-input--active']")
    WebElement usernamePlaceHolder;

    @FindBy(xpath = "//span[text()='(1) Record Found']")
    WebElement recordsFound;

    @FindBy(css = "button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space")
    WebElement searchButton;


    public AdminPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUserNamePlaceHolder(String userName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(usernamePlaceHolder));
        usernamePlaceHolder.sendKeys(userName);
    }

    public void clickOnSearchButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
    }

    public String getRecordsFounds(){
        String recordFound = recordsFound.getText();
        return recordFound;
    }

    public boolean recordFoundIsVisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(recordsFound));
        boolean recordFound = recordsFound.isDisplayed();
        return recordFound;
    }

    public boolean verifyUserInTable(String userName){
        boolean userIsDisplayedInTable = false;
        try{
            WebElement userInTable = driver.findElement(By.xpath("//div[text()='"+userName+"']"));
            userIsDisplayedInTable = userInTable.isDisplayed();
            return userIsDisplayedInTable;
        } catch (Exception e){}
        return userIsDisplayedInTable;
    }
}
