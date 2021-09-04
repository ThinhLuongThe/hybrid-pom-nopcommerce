package pageObjects.liveguru.sort;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.liveguru.sort.MobilePageUI;

public class MobilePageObject extends BasePage {
    public MobilePageObject(WebDriver driver) {
        super(driver);
    }

    public void clickToSortDropdownByText(String sortOption) {
        selectItemInDropDown(MobilePageUI.SORT_BUTTON, sortOption.trim());
    }

    public boolean isProductPriceASC() {
        return isPriceSortedASC(MobilePageUI.ALL_PRODUCT_PRICES);
    }

    public void printProductList(String[][] productList) {
        printItemListOfProduct(productList);
    }

    public String[][] getProductNamesnPrices() {
        return getItemListOfProduct(MobilePageUI.ALL_PRODUCT_NAMES, MobilePageUI.PRODUCT_NAME_BY_INDEX, MobilePageUI.PRODUCT_PRICE_BY_INDEX);
    }
}
