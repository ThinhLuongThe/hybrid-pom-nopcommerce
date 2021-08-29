package pageUIs.travellers.sort;

public class H2Shop_iPhonePageUI {
    public static final String APPLE_FILTER = "//label[text()='Apple']";
    public static final String SORT_DROPDOWN = "//div[@class='ty-sort-dropdown']/a[text()='%s']";
    public static final String SORT_DROPDOWN_ITEMS = "//ul[@id='elm_sort_fields']/li/a";
    public static final String PRODUCT_FRAME = "//div[@id='pagination_contents']";

    // All product
    public static final String ALL_PRODUCT_NAMES = "//div[@class='ty-grid-body']/div[@class='ty-grid-list__item-name']/a";
    public static final String PRODUCT_PRICE_BY_INDEX = "(" + ALL_PRODUCT_NAMES + ")[%s]/parent::div/following-sibling::div//span[contains(@id,'sec_discounted_price')]";
    public static final String PRODUCT_NAME_BY_INDEX = "(" + ALL_PRODUCT_NAMES + ")[%s]";
    // Specific product

    public static final String SPECIFIC_PRODUCT_NAMES = "//div[@class='ty-grid-body']//a[contains(text(),'%s')]";
    public static final String SPECIFIC_PRODUCT_PRICE_BY_INDEX = "(" + SPECIFIC_PRODUCT_NAMES + ")[%s]/parent::div/following-sibling::div//span[contains(@id,'sec_discounted_price')]";
    public static final String SPECIFIC_PRODUCT_NAME_BY_INDEX = "(" + SPECIFIC_PRODUCT_NAMES + ")[%s]";
}