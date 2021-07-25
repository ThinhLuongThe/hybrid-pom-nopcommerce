package pageObjects.DataTable.liveguru;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.DataTable.liveguru.UserDashboardPageUI;

public class UserDashboardPageObject extends BasePage {
    public UserDashboardPageObject(WebDriver driver) {
        super(driver);
    }

    public boolean isSuccessMessageDisplayed() {
        return waitForElementVisible(UserDashboardPageUI.SUCCESS_MSG).isDisplayed();
    }
}
