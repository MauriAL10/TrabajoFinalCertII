package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    WebDriver driver;

    @FindBy(className = "oxd-brand-banner")
    WebElement orangeBanner;

    @FindBy(className = "oxd-userdropdown")
    WebElement userDropDown;

    @FindBy(xpath = "//a[contains(.,'Logout')]")
    WebElement logoutButton;

    @FindBy(xpath = "//span[contains(.,'Admin')]")
    WebElement adminButton;

    @FindBy(xpath = "//span[contains(.,'Recruitment')]")
    WebElement recruitmentButton;

    public MainPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public boolean orangeBannerIsDisplayed(){
        boolean obIsDisplayed = orangeBanner.isDisplayed();
        return obIsDisplayed;
    }

    public boolean userDropDownIsDisplayed(){
        boolean uddIsDisplayed = userDropDown.isDisplayed();
        return uddIsDisplayed;
    }

    public void clickOnUserDropdown(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(userDropDown));
        userDropDown.click();
    }

    public void clickOnLogoutButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButton.click();
    }

    public void clickOnAdminButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(adminButton));
        adminButton.click();
    }

    public void clickOnRecruitmentButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.elementToBeClickable(recruitmentButton));
        recruitmentButton.click();
    }
}
