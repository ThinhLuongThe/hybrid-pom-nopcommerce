package pageObjects.nopCommerce.level02_newpagePageObject;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.LoginPageUI;

public class LoginPageObject extends BasePage {
    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void inputEmail(String email) {
        inputToElement(LoginPageUI.EMAIL_TXT, email);
    }

    public void inputPassword(String password) {
        inputToElement(LoginPageUI.PASSWORD_TXT, password);
    }

    public HomePageObject clickToLoginButton() {
        clickToElement(LoginPageUI.LOGIN_BTN);
        return Page_Generator.getHomePage(driver);
    }
}
