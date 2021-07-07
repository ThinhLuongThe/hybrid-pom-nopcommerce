package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputEmail(String email) {
        inputToElement(driver, LoginPageUI.EMAIL_TXT, email);
    }

    public void inputPassword(String password) {
        inputToElement(driver, LoginPageUI.PASSWORD_TXT, password);
    }

    public void clickToLoginButton() {
        clickToElement(driver, LoginPageUI.LOGIN_BTN);
    }
}
