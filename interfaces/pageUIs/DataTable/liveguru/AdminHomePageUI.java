package pageUIs.DataTable.liveguru;

public class AdminHomePageUI {
    public static final String CLOSE_POPUP_BTN = "//div[@class='message-popup-head']/a";
    public static final String RP_COLUMN_INDEX_LOCATOR = "//tr[@class='headings']//span[text()='%s']/ancestor::th/preceding-sibling::th";
    public static final String RP_TARGET_TXT = "//tr[@class='filter']/th[%s]//input";
    public static final String SEARCH_BTN = "//button[@title='Search']";
    public static final String RESET_SEARCH_BTN = "//button[@title='Reset Filter']";
    public static final String LOADING_ICON_LOCATOR = "//p[@id='loading_mask_loader']";
    public static final String RESULT_NUMBER_LOCATOR = "//table[@id='customerGrid_table']//tbody/tr";
    public static final String RP_RESULT_DATA_LOCATOR = "//table[@id='customerGrid_table']//tbody/tr/td[%s][contains(text(),'%s')]";
}
