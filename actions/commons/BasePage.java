package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.nopCommerce.level02_newpagePageObject.*;
import pageUIs.nopCommerce.BasePageUI;
import pageUIs.nopCommerce.MyAccountPageUI;

import java.util.List;

public class BasePage extends BaseAction {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public void clickToElement(String locator) {
        try {
            waitForElementClickable(locator).click();
        } catch (Exception e) {
            log.debug("Wait for element is Clicked with error: " + e.getMessage());
        }
    }

    public void inputToElement(String locator, String inputValue) {
        try {
            waitForElementVisible(locator).clear();
            getElement(locator).sendKeys(inputValue);
        } catch (Exception e) {
            log.debug("Wait for text is input with error: " + e.getMessage());
        }
    }

    public boolean isElementDisplayed(String locator) {
        try {
            return waitForElementVisible(locator).isDisplayed();
        } catch (Exception e) {
            log.debug("Wait for element Display with error: " + e.getMessage());
            return false;
        }
    }

    public boolean isElementSelected(String locator) {
        try {
            return waitForElementVisible(locator).isSelected();
        } catch (Exception e) {
            log.debug("Wait for element Selected with error: " + e.getMessage());
            return false;
        }
    }

    public boolean isElementEnabled(String locator) {
        try {
            return waitForElementVisible(locator).isEnabled();
        } catch (Exception e) {
            log.debug("Wait for element Enabled with error: " + e.getMessage());
            return false;
        }
    }

    public boolean isElementInvisible(String locator) {
        return waitForElementInvisible(locator);
    }

    public boolean isElementUndisplayed(String locator) {
        overrideGlobalTimeOut(GlobalConstants.SHORT_TIMEOUT);
        List<WebElement> elements = waitForAllElementVisible(locator);
        overrideGlobalTimeOut(GlobalConstants.LONG_TIMEOUT);

        if (elements.size() == 0) {
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public String getAttributeValue(String locator, String attributeName) {
        return waitForElementVisible(locator).getAttribute(attributeName);
    }

    public String getTextElement(String locator) {
        return waitForElementVisible(locator).getText();
    }

    public String getCssValue(String locator, String cssValue) {
        return waitForElementVisible(locator).getCssValue(cssValue);
    }

    public void selectItemInCustomDropdown(String parentLocator, String childItemLocator, String expectedItem) {
        waitForElementClickable(parentLocator).click();
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

        for (WebElement item : allItems) {
            if (item.getText().equalsIgnoreCase(expectedItem)) {
                if (item.isDisplayed()) {
                    item.click();
                } else {
                    jsExecutor.executeScript("arguments[0].scollIntoView(true);", item);
                    sleepInSecond(1);
                    jsExecutor.executeScript("arguments[0].click();");
                }
                sleepInSecond(1);
                break;
            }
        }
    }

    public void checkTheCheckboxOrRadio(String locator) {
        if (!isElementSelected(locator)) {
            clickToElement(locator);
        }
    }

    public void uncheckTheCheckbox(String locator) {
        if (isElementSelected(locator)) {
            clickToElement(locator);
        }
    }

    public void clickToElement(String locator, String... varArguments) {
        try {
            waitForElementClickable(castRestParameter(locator, varArguments)).click();
        } catch (Exception e) {
            log.debug("Wait for element is Clicked with error: " + e.getMessage());
        }
    }

    public void inputToElement(String locator, String inputValue, String... varArguments) {
        waitForElementVisible(castRestParameter(locator, varArguments)).clear();
        getElement(castRestParameter(locator, varArguments)).sendKeys(inputValue);
    }

    public boolean isElementDisplayed(String locator, String... varArguments) {
        try {
            return waitForElementVisible(castRestParameter(locator, varArguments)).isDisplayed();
        } catch (Exception e) {
            log.debug("Wait for element Display with error: " + e.getMessage());
            return false;
        }
    }

    public boolean isElementSelected(String locator, String... varArguments) {
        return waitForElementVisible(castRestParameter(locator, varArguments)).isSelected();
    }

    public boolean isElementEnabled(String locator, String... varArguments) {
        return waitForElementVisible(castRestParameter(locator, varArguments)).isEnabled();
    }

    /* Use when check Element still exists in DOM */
    public boolean isElementInvisible(String locator, String... varArguments) {
        return waitForElementInvisible(castRestParameter(locator, varArguments));
    }

    /* Use when check Element does not exist in DOM */
    public boolean isElementUndisplayed(String locator, String... varArguments) {
        overrideGlobalTimeOut(GlobalConstants.SHORT_TIMEOUT);
        List<WebElement> elements = waitForAllElementVisible(castRestParameter(locator, varArguments));
        overrideGlobalTimeOut(GlobalConstants.LONG_TIMEOUT);

        if (elements.size() == 0) {
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }


    // For specific Pages
    public Menu_CustomerInfoPageObject openCustomerInfoPage() {
        clickToElement(BasePageUI.CUSTOMERINFO_LINK);
        return Page_Generator.getCustomerInfoPage(driver);
    }

    public Menu_AddresssesPageObject openAddressesPage() {
        clickToElement(BasePageUI.ADDRESSES_LINK);
        return Page_Generator.getAddressesPage(driver);
    }

    public Menu_OrdersPageObject openOrdersPage() {
        clickToElement(BasePageUI.ORDERS_LINK);
        return Page_Generator.getOrdersPage(driver);
    }

    public Menu_DownloadProductPageObject openDownloadProductPage() {
        clickToElement(BasePageUI.DOWNLOAD_PRODUCT_LINK);
        return Page_Generator.getDownloadProductPage(driver);
    }

    public Menu_BackSubscriptionPageObject openBackSubscriptionPage() {
        clickToElement(BasePageUI.BACK_SUBSCRIPTION_LINK);
        return Page_Generator.getBackSubscriptionPage(driver);
    }

    public Menu_RewardPointsPageObject openRewardPointsPage() {
        clickToElement(BasePageUI.REWARD_POINTS_LINK);
        return Page_Generator.getRewardPointsPage(driver);
    }

    public Menu_ChangePasswordPageObject openChangePasswordPage() {
        clickToElement(BasePageUI.CHANGE_PASSWORD_LINK);
        return Page_Generator.getChangePasswordPage(driver);
    }

    public Menu_MyProductsPageObject openMyProductsPage() {
        clickToElement(BasePageUI.MY_PRODUCTS_LINK);
        return Page_Generator.getMyProductsPage(driver);
    }

    // For specific Pages_II
    public void openTargetSubPage_II(String pageName) {
        clickToElement(MyAccountPageUI.DYNAMIC_MENU_PAGE_LINK, pageName);
    }
}
