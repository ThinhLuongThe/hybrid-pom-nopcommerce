package pageObjects.travellers.sort;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.travellers.sort.H2Shop_iPhonePageUI;

public class H2Shop_iPhonePageObject extends BasePage {
    public H2Shop_iPhonePageObject(WebDriver driver) {
        super(driver);
    }

    public void printAllProductName_ProductPrice() {
        String[][] productList = getItemListOfProduct(H2Shop_iPhonePageUI.ALL_PRODUCT_NAMES,
                H2Shop_iPhonePageUI.PRODUCT_NAME_BY_INDEX, H2Shop_iPhonePageUI.PRODUCT_PRICE_BY_INDEX);
        printItemListOfProduct(productList);
    }

    public void printSpecificProductName_ProductPrice(String specificName) {
        String[][] productList = getItemListOfSpecificProduct(H2Shop_iPhonePageUI.SPECIFIC_PRODUCT_NAMES,
                H2Shop_iPhonePageUI.SPECIFIC_PRODUCT_NAME_BY_INDEX, H2Shop_iPhonePageUI.SPECIFIC_PRODUCT_PRICE_BY_INDEX,
                specificName);
        printItemListOfProduct(productList);
    }

    public void clickToFilterAppleProduct() {
        clickToElement(H2Shop_iPhonePageUI.APPLE_FILTER);
    }

    public void selectSortValue(String parentLocator, String value) {
        selectItemInCustomDropdown(castRestParameter(H2Shop_iPhonePageUI.SORT_DROPDOWN, parentLocator), H2Shop_iPhonePageUI.SORT_DROPDOWN_ITEMS, value);
    }
}
