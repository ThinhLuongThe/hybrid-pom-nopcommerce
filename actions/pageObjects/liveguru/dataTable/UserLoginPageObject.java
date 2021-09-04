package pageObjects.liveguru.dataTable;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.liveguru.Page_Generator;
import pageUIs.liveguru.dataTable.UserLoginPageUI;

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
