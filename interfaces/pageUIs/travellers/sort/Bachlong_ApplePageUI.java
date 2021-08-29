package pageUIs.travellers.sort;

public class Bachlong_ApplePageUI {
    public static final String CLOSE_MODAL_BTN = "//a[@class='close-modal1']";
    // More product
    public static final String MORE_NEW_IPHONE_LINK = "//div[@id='apple-iphone']//a[contains(text(),'Xem thêm sản phẩm')]";
    public static final String MORE_OLD_IPHONE_LINK = "//div[@id='apple-iphone-cu']//a[contains(text(),'Xem thêm sản phẩm')]";


    public static final String SPECIFIC_MODEL_LINK = "//div[@id='%s']//a[contains(text(),'%s')]";
    public static final String LOADING_ICON = "//div[@class='waiting']/span";
    // All product
    public static final String ALL_PRODUCT_NAMES = "//div[@id='%s']//div[@class='box-title-1-product-apple']/a";
    public static final String ALL_PRODUCT_PRICES = ALL_PRODUCT_NAMES + "/parent::div/following-sibling::div[@class='box-tg-1-product-apple']/p[contains(@class,'special-price')]//span";
    public static final String PRODUCT_PRICE_BY_INDEX = "(" + ALL_PRODUCT_NAMES + ")[%s]/parent::div/following-sibling::div[@class='box-tg-1-product-apple']/p[contains(@class,'special-price')]//span";
    public static final String PRODUCT_NAME_BY_INDEX = "(" + ALL_PRODUCT_NAMES + ")[%s]";
}