package commons;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.nopCommerce.level02_newpagePageObject.*;
import pageUIs.nopCommerce.BasePageUI;
import pageUIs.nopCommerce.MyAccountPageUI;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BasePage {
    private WebDriver driver;
    private Alert alert;
    private Select select;
    private Actions actions;
    private JavascriptExecutor jsExecutor;
    private WebDriverWait explicitWait;
    private int shortTimeOut = 5;
    private int longTimeOut = 20;
    protected final Log log;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        log = LogFactory.getLog(getClass());
        explicitWait = new WebDriverWait(driver, longTimeOut);
        actions = new Actions(driver);
    }

    public void openPageURL(String pageURL) {
        driver.get(pageURL);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getPageURL() {
        return driver.getCurrentUrl();
    }

    public String getPageSourceCode() {
        return driver.getPageSource();
    }

    public void backToPage() {
        driver.navigate().back();
    }

    public void forwardToPage() {
        driver.navigate().forward();
    }

    public void refreshThePage() {
        driver.navigate().refresh();
    }

    public Alert waitForAlertPresence() {
        return explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert() {
        alert = waitForAlertPresence();
        alert.accept();
    }

    public void cancelWebAlert() {
        alert = waitForAlertPresence();
        alert.dismiss();
    }

    public String getAlertText() {
        alert = waitForAlertPresence();
        return alert.getText();
    }

    public void sendkeyToAlert(String value) {
        alert = waitForAlertPresence();
        alert.sendKeys(value);
    }

    public void switchToWindowByID(String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }

    public void switchToWindowByTitle(String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            driver.switchTo().window(runWindows);
            String currentWin = driver.getTitle();
            if (currentWin.equals(title)) {
                break;
            }
        }
    }

    public void closeAllWindowsWithoutParent(String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            if (!runWindows.equals(parentID)) {
                driver.switchTo().window(runWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

    public By getByXpath(String locator) {
        return By.xpath(locator);
    }

    public WebElement getElement(String locator) {
        return driver.findElement(getByXpath(locator));
    }

    public List<WebElement> getElementList(String locator) {
        return driver.findElements(getByXpath(locator));
    }

    public void clickToElement(String locator) {
        waitForElementClickable(locator).click();
    }

    public void inputToElement(String locator, String inputValue) {
        waitForElementVisible(locator).clear();
        getElement(locator).sendKeys(inputValue);
    }

    public void selectItemInDropDown(String locator, String text) {
        select = new Select(waitForElementVisible(locator));
        select.selectByVisibleText(text);
    }

    public String getSelectedValueInDropDown(String locator) {
        select = new Select(waitForElementVisible(locator));
        return select.getFirstSelectedOption().getText();
    }

    public boolean isDropdownMultiple(String locator) {
        select = new Select(getElement(locator));
        return select.isMultiple();
    }

    public void sleepInSecond(long second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

    public String getAttributeValue(String locator, String attributeName) {
        return waitForElementVisible(locator).getAttribute(attributeName);
    }

    public String getTextElement(String locator) {
        return waitForElementVisible(locator).getText();
    }

    public String getCssValue(String locator, String cssValue) {
        return waitForElementVisible(locator).getCssValue(cssValue);
    }

    public String convertRGBaToHex(String rgbaValue) {
        return Color.fromString(rgbaValue).asHex();
    }

    public int getSizeOfElementList(String locator) {
        return getElementList(locator).size();
    }

    public void checkTheCheckboxOrRadio(String locator) {
        if (!isElementSelected(locator)) {
            waitForElementClickable(locator).click();
        }
    }

    public void uncheckTheCheckbox(String locator) {
        if (isElementSelected(locator)) {
            waitForElementClickable(locator).click();
        }
    }

    public boolean isElementDisplayed(String locator) {
        return waitForElementVisible(locator).isDisplayed();
    }

    public boolean isElementNotDisplayed(String locator) {
        return !getElement(locator).isDisplayed();
    }

    public boolean isElementSelected(String locator) {
        return waitForElementVisible(locator).isSelected();
    }

    public boolean isElementEnabled(String locator) {
        return waitForElementVisible(locator).isEnabled();
    }

    public void switchToFrame(String locator) {
        driver.switchTo().frame(getElement(locator));
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void doubleClickToElement(String locator) {
        actions.doubleClick(getElement(locator)).perform();
    }

    public void hoverMouseToElement(String locator) {
        actions.moveToElement(getElement(locator)).perform();
    }

    public void righClickToElement(String locator) {
        actions.contextClick(getElement(locator)).perform();
    }

    public void dragAndDrop(String sourceLocator, String targetLocator) {
        actions.dragAndDrop(getElement(sourceLocator), getElement(targetLocator)).perform();
    }

    public void sendKeyboardToElement(String locator, Keys key) {
        actions.sendKeys(getElement(locator), key).perform();
    }

    public Object executeForBrowser(String javaScript) {
        jsExecutor = (JavascriptExecutor) driver;
        return jsExecutor.executeScript(javaScript);
    }

    public String getInnerText() {
        jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
    }

    public boolean areExpectedTextInInnerText(String textExpected) {
        jsExecutor = (JavascriptExecutor) driver;
        String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage() {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void navigateToUrlByJS(String url) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.location = '" + url + "'");
    }

    public void highlightElement(String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getElement(locator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
        sleepInSecond(1);
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
    }

    public void clickToElementByJS(String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getElement(locator));
    }

    public void scrollToElement(String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
    }

    public void sendkeyToElementByJS(String locator, String value) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
    }

    public void removeAttributeInDOM(String locator, String attributeRemove) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(locator));
    }

    public boolean areJQueryAndJSLoadedSuccess() {
        jsExecutor = (JavascriptExecutor) driver;

        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };

        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }

    public String getElementValidationMessage(String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(locator));
    }

    public boolean isImageLoaded(String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && " +
                "typeof arguments[0].naturalWidth != \"undefined\" && " +
                "arguments[0].naturalWidth > 0", getElement(locator));
        return status ? true : false;
    }

    public WebElement waitForElementClickable(String locator) {
        return explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
    }

    public WebElement waitForElementVisible(String locator) {
        return explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
    }

    public boolean waitForElementInvisible(String locator) {
        try {
            return explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
        } catch (Exception e) {
            log.debug("Wait for element Invisible with erroe: " + e.getMessage());
            return false;
        }

    }

    public List<WebElement> waitForAllElementVisible(String locator) {
        return explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
    }

    public boolean isElementUndisplayed(String locator) {
        overrideGlobalTimeOut(shortTimeOut);
        List<WebElement> elements = waitForAllElementVisible(locator);
        overrideGlobalTimeOut(longTimeOut);

        if (elements.size() == 0) {
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

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

    public String castRestParameter(String locator, String... varArguments) {
        return String.format(locator, (Object[]) varArguments);
    }

    public void clickToElement(String locator, String... varArguments) {
        waitForElementClickable(castRestParameter(locator, varArguments)).click();
    }

    public void inputToElement(String locator, String inputValue, String... varArguments) {
        waitForElementVisible(castRestParameter(locator, varArguments)).clear();
        getElement(castRestParameter(locator, varArguments)).sendKeys(inputValue);
    }

    public void selectItemInDropDown(String locator, String text, String... varArguments) {
        select = new Select(waitForElementVisible(castRestParameter(locator, varArguments)));
        select.selectByVisibleText(text);
    }

    public String getSelectedValueInDropDown(String locator, String... varArguments) {
        select = new Select(waitForElementVisible(castRestParameter(locator, varArguments)));
        return select.getFirstSelectedOption().getText();
    }

    public String getAttributeValue(String locator, String attributeName, String... varArguments) {
        return waitForElementVisible(castRestParameter(locator, varArguments)).getAttribute(attributeName);
    }

    public String getTextElement(String locator, String... varArguments) {
        return waitForElementVisible(castRestParameter(locator, varArguments)).getText();
    }

    public String getCssValue(String locator, String cssValue, String... varArguments) {
        return waitForElementVisible(castRestParameter(locator, varArguments)).getCssValue(cssValue);
    }

    public int getSizeOfElementList(String locator, String... varArguments) {
        return getElementList(castRestParameter(locator, varArguments)).size();
    }

    public boolean isElementDisplayed(String locator, String... varArguments) {
        return waitForElementVisible(castRestParameter(locator, varArguments)).isDisplayed();
    }

    /* Use when check Element still exists in DOM */
    public boolean isElementInvisible(String locator, String... varArguments) {
        return waitForElementInvisible(castRestParameter(locator, varArguments));
    }

    /* Use when check Element does not exist in DOM */
    public boolean isElementUndisplayed(String locator, String... varArguments) {
        overrideGlobalTimeOut(shortTimeOut);
        List<WebElement> elements = waitForAllElementVisible(castRestParameter(locator, varArguments));
        overrideGlobalTimeOut(longTimeOut);

        if (elements.size() == 0) {
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public void overrideGlobalTimeOut(int timeInSecond) {
        driver.manage().timeouts().implicitlyWait(timeInSecond, TimeUnit.SECONDS);
    }

    public boolean isElementSelected(String locator, String... varArguments) {
        return waitForElementVisible(castRestParameter(locator, varArguments)).isSelected();
    }

    public boolean isElementEnabled(String locator, String... varArguments) {
        return waitForElementVisible(castRestParameter(locator, varArguments)).isEnabled();
    }

    public void highlightElement(String locator, String... varArguments) {
        jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getElement(castRestParameter(locator, varArguments));
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
        sleepInSecond(1);
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
    }

    public void clickToElementByJS(String locator, String... varArguments) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getElement(castRestParameter(locator, varArguments)));
    }

    public WebElement waitForElementVisible(String locator, String... varArguments) {
        return explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(castRestParameter(locator, varArguments))));
    }

    public WebElement waitForElementClickable(String locator, String... varArguments) {
        return explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(castRestParameter(locator, varArguments))));
    }

    public boolean waitForElementInvisible(String locator, String... varArguments) {
        try {
            return explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(castRestParameter(locator, varArguments))));
        } catch (Exception e) {
            log.debug("Wait for element Invisible with erroe: " + e.getMessage());
            return false;
        }
    }

    public void sendKeyboardToElement(String locator, Keys key, String... varArguments) {
        actions.sendKeys(getElement(castRestParameter(locator, varArguments)), key).perform();
    }

    public void openTargetSubPage_II(String pageName) {
        clickToElement(MyAccountPageUI.DYNAMIC_MENU_PAGE_LINK, pageName);
    }

    public void uploadFiles(String... fileNames) {
        String uploadPath = System.getProperty("user.dir") + File.separator + "uploadFiles" + File.separator;
        String allPath = "";
        for (String fileName : fileNames) {
            allPath += uploadPath + fileName + "\n";
        }
        getElement(pageUIs.BasePageUI.UPLOAD_FILE_LOCATOR).sendKeys(allPath.trim());
    }
}
