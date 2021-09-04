package pageObjects.liveguru.dataTable;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.liveguru.Page_Generator;
import pageUIs.liveguru.dataTable.UserHomePageUI;

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
