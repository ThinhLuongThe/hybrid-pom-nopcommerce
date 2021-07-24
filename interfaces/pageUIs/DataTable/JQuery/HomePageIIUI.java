package pageUIs.DataTable.JQuery;

public class HomePageIIUI {
    public static final String COLUMN_INDEX_LOCATOR = "//thead//th[text()='%s']/preceding-sibling::th";
    public static final String ROW_INDEX_LOCATOR = "//tbody/tr[%s]/td[%s]/input";
    public static final String DROPDOWN_ROW_INDEX_LOCATOR = "//tbody/tr[%s]/td[%s]//select";
    public static final String ACTION_LOCATOR = "//tbody/tr[%s]//button[contains(@title,'%s')]";
}
