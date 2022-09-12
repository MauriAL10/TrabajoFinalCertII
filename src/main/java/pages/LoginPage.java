package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement userNamePlaceHolder;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement passwordPlaceHolder;

    @FindBy(css = "button.oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button")
    WebElement loginButton;

    @FindBy(className = "orangehrm-login-branding")
    WebElement loginIcon;

    @FindBy(css = "div.oxd-alert-content.oxd-alert-content--error")
    WebElement loginError;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUserNamePlaceHolder(String userName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(userNamePlaceHolder));
        userNamePlaceHolder.sendKeys(userName);
    }
    public void setPasswordPlaceHolder(String password) {passwordPlaceHolder.sendKeys(password);}
    public void clickOnLoginButton() {loginButton.click();}

    public boolean loginIconIsDisplayed(){
        boolean loginIconIsDisplayed = loginIcon.isDisplayed();
        return loginIconIsDisplayed;
    }

    public boolean loginErrorIsDisplayed(){
        boolean loginErrorIsDisplayed = loginError.isDisplayed();
        return loginErrorIsDisplayed;
    }
}
