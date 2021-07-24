package pageObjects.DataTable.JQuery;

import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pageUIs.DataTable.JQuery.HomePageUI;

public class HomePageObject extends BasePage {
    public HomePageObject(WebDriver driver) {
        super(driver);
    }

    public void clickToPageNumber(String pageNumber) {
        clickToElement(HomePageUI.PAGINATION_LOCATOR, pageNumber);
    }

    public void inputToColumnName(String columnName, String value) {
        inputToElement(HomePageUI.FILTER_HEADER_LOCATOR, value, columnName);
        sendKeyboardToElement(HomePageUI.FILTER_HEADER_LOCATOR, Keys.ENTER, columnName);
    }

    public boolean isTheRowDisplay(String femaleValue, String countryValue, String maleValue, String totalValue) {
        return isElementDisplayed(HomePageUI.DATA_OF_A_ROW_LOCATOR, femaleValue, countryValue, maleValue, totalValue);
    }

    public void actionToRowWithColumnName(String action, String countryValue) {
        clickToElement(HomePageUI.ACTION_OF_A_ROW_LOCATOR, countryValue, action);
    }

    public boolean isTheRowHidden(String femaleValue, String countryValue, String maleValue, String totalValue) {
        return isElementInvisible(HomePageUI.DATA_OF_A_ROW_LOCATOR, femaleValue, countryValue, maleValue, totalValue);
    }
}
