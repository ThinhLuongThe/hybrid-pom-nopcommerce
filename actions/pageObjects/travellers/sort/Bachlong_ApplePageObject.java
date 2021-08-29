package pageObjects.travellers.sort;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageUIs.travellers.sort.Bachlong_ApplePageUI;

public class Bachlong_ApplePageObject extends BasePage {
    public Bachlong_ApplePageObject(WebDriver driver) {
        super(driver);
    }

    public void clickToCloseBanner() {
        if (isElementDisplayed(Bachlong_ApplePageUI.CLOSE_MODAL_BTN)) {
            clickToElement(Bachlong_ApplePageUI.CLOSE_MODAL_BTN);
        }
    }

    public void clickToSpecificDeviceModel(String device, String model) {
        String elementLocator = castRestParameter(Bachlong_ApplePageUI.SPECIFIC_MODEL_LINK, device, model);
        scrollToElement(elementLocator);
        clickToElementByJS(elementLocator);
    }

    public void waitUntilLoadingDisappeared() {
        explicitWait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(Bachlong_ApplePageUI.LOADING_ICON))));
//        isElementUndisplayed(Bachlong_iPhonePageUI.LOADING_ICON);
    }

    public void printAllProductName_ProductPrice(String device) {
        String[][] productList = getItemListOfSpecificProduct(Bachlong_ApplePageUI.ALL_PRODUCT_NAMES, Bachlong_ApplePageUI.PRODUCT_NAME_BY_INDEX, Bachlong_ApplePageUI.PRODUCT_PRICE_BY_INDEX, device);
        sortPriceASCwithCurrency(productList, "₫");
        printItemListOfProduct(productList);
    }
}
