package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class BasePage_Factory {
    private WebDriver driver;
    private Alert alert;
    private Select select;
    private Actions actions;
    private JavascriptExecutor jsExecutor;
    private WebDriverWait explicitWait;
    private int longTimeOut = 30;

    public BasePage_Factory(WebDriver driver) {
        this.driver = driver;
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

    public void refreshToPage() {
        driver.navigate().refresh();
    }

    public Alert waitForAlertPresence() {
        explicitWait = new WebDriverWait(driver, longTimeOut);
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


    public void clickToElement(WebElement element) {
        waitForElementClickable(element).click();
    }

    public void inputToElement(WebElement element, String inputValue) {
        waitForElementVisible(element).clear();
        element.sendKeys(inputValue);
    }

    public void selectItemInDropDown(WebElement element, String text) {
        select = new Select(waitForElementVisible(element));
        select.selectByVisibleText(text);
    }

    public String getSelectedValueInDropDown(WebElement element) {
        select = new Select(waitForElementVisible(element));
        return select.getFirstSelectedOption().getText();
    }

    public boolean isDropdownMultiple(WebElement element) {
        select = new Select(element);
        return select.isMultiple();
    }

    public void sleepInSecond(long second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void selectItemInCustomDropdown(WebElement parentElement, WebElement childItemElement, String expectedItem) {
        waitForElementClickable(parentElement).click();
        explicitWait = new WebDriverWait(driver, longTimeOut);
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.visibilityOfAllElements(childItemElement));

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

    public String getAttributeValue(WebElement element, String attributeName) {
        return waitForElementVisible(element).getAttribute(attributeName);
    }

    public String getTextElement(WebElement element) {
        return waitForElementVisible(element).getText();
    }

    public String getCssValue(WebElement element, String cssValue) {
        return waitForElementVisible(element).getCssValue(cssValue);
    }

    public String convertRGBaToHex(String rgbaValue) {
        return Color.fromString(rgbaValue).asHex();
    }

    public void checkTheCheckboxOrRadio(WebElement element) {
        if (!isControlSelected(element)) {
            waitForElementClickable(element).click();
        }
    }

    public void uncheckTheCheckbox(WebElement element) {
        if (isControlSelected(element)) {
            waitForElementClickable(element).click();
        }
    }

    public boolean isControlDisplay(WebElement element) {
        return waitForElementVisible(element).isDisplayed();
    }

    public boolean isControlSelected(WebElement element) {
        return element.isSelected();
    }

    public boolean isControlEnabled(WebElement element) {
        return waitForElementVisible(element).isEnabled();
    }

    public void switchToFrame(WebElement element) {
        driver.switchTo().frame(element);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void doubleClickToElement(WebElement element) {
        actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    public void hoverMouseToElement(WebElement element) {
        actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void righClickToElement(WebElement element) {
        actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    public void dragAndDrop(WebElement sourceElement, WebElement targetElement) {
        actions = new Actions(driver);
        actions.dragAndDrop(sourceElement, targetElement).perform();
    }

    public void sendKeyboardToElement(WebElement element, Keys key) {
        actions = new Actions(driver);
        actions.sendKeys(element, key).perform();
    }

    public void upload1File(WebElement element, String filePath) {
        element.sendKeys(filePath);
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

    public void highlightElement(WebElement element) {
        jsExecutor = (JavascriptExecutor) driver;
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
        sleepInSecond(1);
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
    }

    public void clickToElementByJS(WebElement element) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    public void scrollToElement(WebElement element) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void sendkeyToElementByJS(WebElement element, String value) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
    }

    public void removeAttributeInDOM(WebElement element, String attributeRemove) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
    }

    public boolean areJQueryAndJSLoadedSuccess() {
        explicitWait = new WebDriverWait(driver, longTimeOut);
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

    public String getElementValidationMessage(WebElement element) {
        jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", element);
    }

    public boolean isImageLoaded(WebElement element) {
        jsExecutor = (JavascriptExecutor) driver;
        boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && " +
                "typeof arguments[0].naturalWidth != \"undefined\" && " +
                "arguments[0].naturalWidth > 0", element);
        if (status) {
            return true;
        } else {
            return false;
        }
    }

    public WebElement waitForElementVisible(WebElement element) {
        explicitWait = new WebDriverWait(driver, longTimeOut);
        return explicitWait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementClickable(WebElement element) {
        explicitWait = new WebDriverWait(driver, longTimeOut);
        return explicitWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean waitForElementInvisible(WebElement element) {
        explicitWait = new WebDriverWait(driver, longTimeOut);
        return explicitWait.until(ExpectedConditions.invisibilityOf(element));
    }
}
