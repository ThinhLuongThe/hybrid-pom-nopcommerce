package pageObjects.travellers.sort;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.travellers.sort.CellphoneS_iPhonePageUI;

public class CellphoneS_iPhonePageObject extends BasePage {
    public CellphoneS_iPhonePageObject(WebDriver driver) {
        super(driver);
    }

    public void clickToLowerPriceBtn() {
        clickToElement(CellphoneS_iPhonePageUI.LOWER_PRICE_BTN);
    }

    public void clickToHigherPriceBtn() {
        clickToElement(CellphoneS_iPhonePageUI.HIGER_PRICE_BTN);
    }

    public boolean isPriceSortedASC() {
        return isPriceSortedASC(CellphoneS_iPhonePageUI.ALL_PRODUCT_PRICES);
    }

    public boolean isPriceSortedDESC() {
        return isPriceSortedDESC(CellphoneS_iPhonePageUI.ALL_PRODUCT_PRICES);
    }

    public void clickToCloseBanner() {
        clickToElement(CellphoneS_iPhonePageUI.CLOSE_BANNER_BTN);
    }

    public void printAllProductName_ProductPrice() {
        String[][] productList = getItemListOfProduct(CellphoneS_iPhonePageUI.ALL_PRODUCT_NAMES,
                CellphoneS_iPhonePageUI.PRODUCT_NAME_BY_INDEX, CellphoneS_iPhonePageUI.PRODUCT_PRICE_BY_INDEX);
        printItemListOfProduct(productList);
    }

    public void printSpecificProductName_ProductPrice(String specificName) {
        String[][] productList = getItemListOfSpecificProduct(CellphoneS_iPhonePageUI.SPECIFIC_PRODUCT_NAMES,
                CellphoneS_iPhonePageUI.SPECIFIC_PRODUCT_NAME_BY_INDEX, CellphoneS_iPhonePageUI.SPECIFIC_PRODUCT_PRICE_BY_INDEX,
                specificName);
        printItemListOfProduct(productList);
    }

}
