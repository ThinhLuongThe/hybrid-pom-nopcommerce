package pageObjects.liveguru.dataTable;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.liveguru.Page_Generator;
import pageUIs.liveguru.dataTable.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
    WebDriver driver;

    public UserRegisterPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void inputFistName(String firstName) {
        inputToElement(UserRegisterPageUI.FIRSTNAME_TXT, firstName);
    }

    public void inputLastName(String lastName) {
        inputToElement(UserRegisterPageUI.LASTNAME_TXT, lastName);
    }

    public void inputEmail(String email) {
        inputToElement(UserRegisterPageUI.EMAIL_TXT, email);
    }

    public void inputPassword(String password) {
        inputToElement(UserRegisterPageUI.PASSWORD_TXT, password);
    }

    public void inputConfirmPassword(String password) {
        inputToElement(UserRegisterPageUI.CONFIRM_PASSWORD_TXT, password);
    }

    public UserDashboardPageObject clickToRegisterBtn() {
        clickToElement(UserRegisterPageUI.REGISTER_BTN);
        return Page_Generator.getUserDashboardPage(driver);
    }
}
