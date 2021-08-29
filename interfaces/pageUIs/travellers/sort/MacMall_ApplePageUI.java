package pageUIs.travellers.sort;

public class MacMall_ApplePageUI {
    public static final String CLOSE_MODAL_BTN = "//button[@class='close']";
    public static final String MENU = "//header//nav[@id='site-navigation']//a[text()='%s']/parent::li";
    public static final String DEVICE = "//div[@class='slick-track']//span[contains(text(),'%s')]";

    // All product
    public static final String ALL_PRODUCT_NAMES = "//h2";
    public static final String ALL_PRODUCT_PRICES = ALL_PRODUCT_NAMES + "/following-sibling::span/span";
    public static final String PRODUCT_PRICE_BY_INDEX = "(" + ALL_PRODUCT_NAMES + ")[%s]/following-sibling::span/span";
    public static final String PRODUCT_NAME_BY_INDEX = "(" + ALL_PRODUCT_NAMES + ")[%s]";
}