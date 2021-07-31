package pageObjects.DataTable.JQuery;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.DataTable.JQuery.HomePageIIUI;

public class HomePageIIObject extends BasePage {
    public HomePageIIObject(WebDriver driver) {
        super(driver);
    }

    public void inputToColumnNameRowNumber(String columnName, String rowNumber, String value) {
        String columnIndex = String.valueOf(getSizeOfElementList(HomePageIIUI.COLUMN_INDEX_LOCATOR, columnName) + 1);
        inputToElement(HomePageIIUI.ROW_INDEX_LOCATOR, value, rowNumber, columnIndex);
    }

    public void selectItemInColumnNameRowNumber(String columnName, String rowNumber, String value) {
        String columnIndex = String.valueOf(getSizeOfElementList(HomePageIIUI.COLUMN_INDEX_LOCATOR, columnName) + 1);
        selectItemInDropDown(HomePageIIUI.DROPDOWN_ROW_INDEX_LOCATOR, value, rowNumber, columnIndex);
    }

    public void clickToActionOnRow(String actionName, String rowNumber) {
        clickToElement(HomePageIIUI.ACTION_LOCATOR, rowNumber, actionName);
    }
}
