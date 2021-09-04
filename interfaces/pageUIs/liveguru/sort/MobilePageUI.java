package pageUIs.liveguru.sort;

public class MobilePageUI {
    public static final String SORT_BUTTON = "(//select[@title='Sort By'])[1]";
    public static final String ALL_PRODUCT_PRICES = "//*[@class='special-price' or @class='regular-price']//span[@class='price']";
    public static final String ALL_PRODUCT_NAMES = "//h2/a";
    public static final String PRODUCT_PRICE_BY_INDEX = "(" + ALL_PRODUCT_NAMES + ")[%s]/ancestor::div[@class='product-info']//*[@class='special-price' or @class='regular-price']//span[@class='price']";
    public static final String PRODUCT_NAME_BY_INDEX = "(" + ALL_PRODUCT_NAMES + ")[%s]";
}