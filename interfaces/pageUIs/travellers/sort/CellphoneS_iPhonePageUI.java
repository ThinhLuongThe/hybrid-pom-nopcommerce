package pageUIs.travellers.sort;

public class CellphoneS_iPhonePageUI {
    public static final String CLOSE_BANNER_BTN = "//div[contains(@class,'box-banner')]//*[@id='btn-close']";
    public static final String LOWER_PRICE_BTN = "//a[@id='sortAsc']";
    public static final String HIGER_PRICE_BTN = "//a[@id='sortDesc']";
    // All product
    public static final String ALL_PRODUCT_PRICES = "//div[@class='item-product__box-price']//p[@class='special-price']";
    public static final String ALL_PRODUCT_NAMES = "//div[@class='item-product__box-name']//h3";
    public static final String PRODUCT_PRICE_BY_INDEX = "(" + ALL_PRODUCT_NAMES + "/ancestor::div[@class='item-product']//p[@class='special-price'])[%s]";
    public static final String PRODUCT_NAME_BY_INDEX = "(" + ALL_PRODUCT_NAMES + ")[%s]";
    // Specific product

    public static final String SPECIFIC_PRODUCT_NAMES = "//h3[contains(text(),'%s')]";
    public static final String SPECIFIC_PRODUCT_PRICE_BY_INDEX = "(" + SPECIFIC_PRODUCT_NAMES + "/ancestor::div[@class='item-product']//p[@class='special-price'])[%s]";
    public static final String SPECIFIC_PRODUCT_NAME_BY_INDEX = "(" + SPECIFIC_PRODUCT_NAMES + ")[%s]";
}