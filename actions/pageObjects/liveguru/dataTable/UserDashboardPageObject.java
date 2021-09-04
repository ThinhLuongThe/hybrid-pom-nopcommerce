package pageObjects.liveguru.dataTable;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.liveguru.dataTable.UserDashboardPageUI;

public class UserDashboardPageObject extends BasePage {
    public UserDashboardPageObject(WebDriver driver) {
        super(driver);
    }

    public boolean isSuccessMessageDisplayed() {
        return waitForElementVisible(UserDashboardPageUI.SUCCESS_MSG).isDisplayed();
    }
}
