package pageObjects.DataTable.liveguru;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.DataTable.liveguru.UserHomePageUI;

public class UserHomePageObject extends BasePage {
    WebDriver driver;

    public UserHomePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public UserLoginPageObject clickToMyAccountLink() {
        clickToElement(UserHomePageUI.MYACCOUNT_LINK);
        return Page_Generator.getUserLoginPage(driver);
    }
}
