package pageUIs.DataTable.JQuery;

public class HomePageUI {
    public static final String PAGINATION_LOCATOR = "//ul[@class='qgrd-pagination-ul']//a[text()='%s']";
    public static final String FILTER_HEADER_LOCATOR = "//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
    public static final String DATA_OF_A_ROW_LOCATOR = "//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='males' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']";
    public static final String ACTION_OF_A_ROW_LOCATOR = "//td[@data-key='country' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[contains(@class,'%s')]";
}
