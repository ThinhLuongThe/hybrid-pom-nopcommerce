package pageObjects.DataTable.liveguru;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.DataTable.liveguru.AdminHomePageUI;

public class AdminHomePageObject extends BasePage {
    public AdminHomePageObject(WebDriver driver) {
        super(driver);
    }

    public void clickToClosePopup() {
        clickToElement(AdminHomePageUI.CLOSE_POPUP_BTN);
    }

    public void searchOneColumn(String columnName, String value) {
        clickToElement(AdminHomePageUI.RESET_SEARCH_BTN);
        waitForElementInvisible(AdminHomePageUI.LOADING_ICON_LOCATOR);

        String columnIndex = String.valueOf(getElementSize(AdminHomePageUI.RP_COLUMN_INDEX_LOCATOR, columnName) + 1);
        inputToElement(AdminHomePageUI.RP_TARGET_TXT, value, columnIndex);

        clickToElement(AdminHomePageUI.SEARCH_BTN);
        waitForElementInvisible(AdminHomePageUI.LOADING_ICON_LOCATOR);
    }


    public boolean isDataOfColumnDisplayedCorrectly(String columnName, String value) {
        String columnIndex = String.valueOf(getElementSize(AdminHomePageUI.RP_COLUMN_INDEX_LOCATOR, columnName) + 1);
        return isElementDisplayed(AdminHomePageUI.RP_RESULT_DATA_LOCATOR, columnIndex, value);
    }

    public int getResultNumber() {
        return getElementSize(AdminHomePageUI.RESULT_NUMBER_LOCATOR);
    }
}
