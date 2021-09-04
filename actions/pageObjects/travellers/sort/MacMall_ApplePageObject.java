package pageObjects.travellers.sort;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.travellers.sort.MacMall_ApplePageUI;

public class MacMall_ApplePageObject extends BasePage {
    public MacMall_ApplePageObject(WebDriver driver) {
        super(driver);
    }

    public void clickToCloseBanner() {
        if (isElementDisplayed(MacMall_ApplePageUI.CLOSE_MODAL_BTN)) {
            clickToElement(MacMall_ApplePageUI.CLOSE_MODAL_BTN);
        }
    }

    public void clickToProductPageByName(String menuName, String deviceName) {
        hoverMouseToElement(castRestParameter(MacMall_ApplePageUI.MENU, menuName));
        clickToElement(MacMall_ApplePageUI.DEVICE, deviceName);
    }

    public void printAllProductName_ProductPrice() {
        String[][] productList = getItemListOfProduct(MacMall_ApplePageUI.ALL_PRODUCT_NAMES, MacMall_ApplePageUI.PRODUCT_NAME_BY_INDEX, MacMall_ApplePageUI.PRODUCT_PRICE_BY_INDEX);
        printItemListOfProduct(sortIntPriceAscending(productList));
    }
}
