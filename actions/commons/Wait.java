package commons;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Wait {
    protected WebDriver driver;
    protected WebDriverWait explicitWait;
    protected final Log log;

    public Wait(WebDriver driver) {
        this.driver = driver;
        explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
        log = LogFactory.getLog(getClass());
    }

    public Alert waitForAlertPresence() {
        try {
            return explicitWait.until(ExpectedConditions.alertIsPresent());
        } catch (Exception e) {
            log.debug("Wait for Alert present with error: " + e.getMessage());
            return null;
        }
    }

    public WebElement waitForElementVisible(String locator) {
        try {
            return explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        } catch (Exception e) {
            log.debug("Wait for element Visible with error: " + e.getMessage());
            return null;
        }
    }

    public WebElement waitForElementClickable(String locator) {
        try {
            return explicitWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(locator))));
        } catch (Exception e) {
            log.debug("Wait for element Clickable with error: " + e.getMessage());
            return null;
        }
    }

    public boolean waitForElementInvisible(String locator) {
        try {
            return explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
        } catch (Exception e) {
            log.debug("Wait for element Invisible with erroe: " + e.getMessage());
            return false;
        }
    }

    public List<WebElement> waitForAllElementVisible(String locator) {
        try {
            return explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator)));
        } catch (Exception e) {
            log.debug("Wait for element list Visible with error: " + e.getMessage());
            return null;
        }
    }

    public WebElement waitForElementVisible(String locator, String... varArguments) {
        return explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(castRestParameter(locator, varArguments))));
    }

    public WebElement waitForElementClickable(String locator, String... varArguments) {
        return explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(castRestParameter(locator, varArguments))));
    }

    public boolean waitForElementInvisible(String locator, String... varArguments) {
        try {
            return explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(castRestParameter(locator, varArguments))));
        } catch (Exception e) {
            log.debug("Wait for element Invisible with erroe: " + e.getMessage());
            return false;
        }
    }

    public void overrideGlobalTimeOut(int timeInSecond) {
        driver.manage().timeouts().implicitlyWait(timeInSecond, TimeUnit.SECONDS);
    }

    public void overrideExplicitTimeOut(int timeInSecond) {
        explicitWait = new WebDriverWait(driver, timeInSecond);
    }

    public String castRestParameter(String locator, String... varArguments) {
        return String.format(locator, (Object[]) varArguments);
    }

}
