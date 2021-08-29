package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;
import java.util.Set;

public class BaseAction extends BaseJSAction {
    private Alert alert;
    private Select select;
    private Actions actions;

    public BaseAction(WebDriver driver) {
        super(driver);
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

    public void switchToFrame(String locator) {
        driver.switchTo().frame(getElement(locator));
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
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

    public void selectItemInDropDown(String locator, String text) {
        select = new Select(waitForElementVisible(locator));
        select.selectByVisibleText(text);
    }

    public void selectItemInDropDown(String locator, String text, String... varArguments) {
        select = new Select(waitForElementVisible(castRestParameter(locator, varArguments)));
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

    public By getByXpath(String locator) {
        return By.xpath(locator);
    }

    public void sleepInSecond(long second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebElement getElement(String locator) {
        return driver.findElement(getByXpath(locator));
    }

    public List<WebElement> getElementList(String locator) {
        return driver.findElements(getByXpath(locator));
    }

    public String convertRGBaToHex(String rgbaValue) {
        return Color.fromString(rgbaValue).asHex();
    }

    public int getSizeOfElementList(String locator) {
        return waitForAllElementVisible(locator).size();
    }

    public int getSizeOfElementList(String locator, String... varArguments) {
        return getElementList(castRestParameter(locator, varArguments)).size();
    }

    public void doubleClickToElement(String locator) {
        actions.doubleClick(getElement(locator)).perform();
    }

    public void hoverMouseToElement(String locator) {
        actions.moveToElement(waitForElementVisible(locator)).perform();
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

    public void sendKeyboardToElement(String locator, Keys key, String... varArguments) {
        actions.sendKeys(getElement(castRestParameter(locator, varArguments)), key).perform();
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
