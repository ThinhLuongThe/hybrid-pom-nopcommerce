package pageObjects.nopCommerce.level01_newpageTestcase;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.LoginPageUI;

public class LoginPageObject extends BasePage {
    public LoginPageObject(WebDriver driver) {
        super(driver);
    }

    public void inputEmail(String email) {
        inputToElement(LoginPageUI.EMAIL_TXT, email);
    }

    public void inputPassword(String password) {
        inputToElement(LoginPageUI.PASSWORD_TXT, password);
    }

    public void clickToLoginButton() {
        clickToElement(LoginPageUI.LOGIN_BTN);
    }
}
