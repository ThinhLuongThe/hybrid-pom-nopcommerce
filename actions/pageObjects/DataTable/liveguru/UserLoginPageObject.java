package pageObjects.DataTable.liveguru;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.DataTable.liveguru.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
    WebDriver driver;

    public UserLoginPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public UserRegisterPageObject clickToCreateAccountBtn() {
        clickToElement(UserLoginPageUI.CREATE_ACCOUNT_BUTTON);
        return Page_Generator.getUserRegisterPage(driver);
    }
}
