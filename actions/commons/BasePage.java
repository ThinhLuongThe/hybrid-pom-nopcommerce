package commons;

import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.nopCommerce.level02_newpagePageObject.*;
import pageUIs.nopCommerce.BasePageUI;
import pageUIs.nopCommerce.MyAccountPageUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BasePage extends BaseAction {
    private final int arrayName = 0;
    private final int arrayPrice = 1;

    public BasePage(WebDriver driver) {
        super(driver);
        log = LogFactory.getLog(getClass());
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

    public String getTextElement(String locator) {
        return waitForElementVisible(locator).getText();
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

    public String getTextElement(String locator, String... varArguments) {
        return waitForElementVisible(castRestParameter(locator, varArguments)).getText();
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

    public HashMap<String, String> getItemListOfProduct_HashMap(String itemListLocator, String nameLocatorByIndex, String priceLocatorByIndex) {
        HashMap<String, String> productList = new HashMap<>();

        int sizeList = getSizeOfElementList(itemListLocator);
        for (int i = 1; i <= sizeList; i++) {
            String productName = getTextElement(nameLocatorByIndex, String.valueOf(i));
            String productPrice = getTextElement(priceLocatorByIndex, String.valueOf(i));
            System.out.println(productName + " - " + productPrice);
            productList.put(productName, productPrice);
        }
        return productList;
    }

    public HashMap<String, String> getItemListOfSpecificProduct_HashMap(String itemListLocator, String nameLocatorByIndex, String priceLocatorByIndex, String specificName) {
        HashMap<String, String> productList = new HashMap<>();

        int sizeList = getSizeOfElementList(itemListLocator, specificName);
        for (int i = 1; i <= sizeList; i++) {
            String productName = getTextElement(nameLocatorByIndex, specificName, String.valueOf(i));
            String productPrice = getTextElement(priceLocatorByIndex, specificName, String.valueOf(i));
            productList.put(productName, productPrice);
            System.out.println(productName + " - " + productPrice);
        }
        return productList;
    }

    public void printItemListOfProduct_HashMap(HashMap<String, String> products) {
        System.out.println("\nList of expected Products:");
        for (String index : products.keySet()) {
            System.out.println(index + " - " + products.get(index));
        }
    }

    public String[][] getItemListOfProduct(String itemListLocator, String nameLocatorByIndex, String priceLocatorByIndex) {
        waitForAllElementVisible(castRestParameter(itemListLocator));
        int sizeList = getSizeOfElementList(itemListLocator);
        String[][] productList = new String[sizeList][2];

        for (int i = 0; i < sizeList; i++) {
            String productName = getTextElement(nameLocatorByIndex, String.valueOf(i + 1));
            String productPrice = getTextElement(priceLocatorByIndex, String.valueOf(i + 1));
            productList[i][arrayName] = productName;
            productList[i][arrayPrice] = productPrice;
        }
        return productList;
    }

    public String[][] getItemListOfSpecificProduct(String itemListLocator, String nameLocatorByIndex, String priceLocatorByIndex, String specificName) {
        waitForAllElementVisible(castRestParameter(itemListLocator, specificName));
        int sizeList = getSizeOfElementList(itemListLocator, specificName);
        String[][] productList = new String[sizeList][2];

        for (int i = 0; i < sizeList; i++) {
            String productName = getTextElement(nameLocatorByIndex, specificName, String.valueOf(i + 1));
            String productPrice = getTextElement(priceLocatorByIndex, specificName, String.valueOf(i + 1));
            productList[i][arrayName] = productName;
            productList[i][arrayPrice] = productPrice;
        }
        return productList;
    }

    public boolean isPriceSortedASC(String locator) {
        ArrayList actualList = new ArrayList();
        ArrayList sortedList = new ArrayList();
        List<WebElement> elements = waitForAllElementVisible(locator);

        for (WebElement element : elements) {
            Object price = parsePriceToObject(element.getText());
            actualList.add(price);
            sortedList.add(price);
            log.info(price);
        }
        Collections.sort(sortedList);

        return actualList.equals(sortedList);
    }

    public boolean isPriceSortedDESC(String locator) {
        ArrayList actualList = new ArrayList();
        ArrayList sortedList = new ArrayList();
        List<WebElement> elements = waitForAllElementVisible(locator);

        for (WebElement element : elements) {
            Object price = parsePriceToObject(element.getText());
            actualList.add(price);
            sortedList.add(price);
            log.info(price);
        }

        Collections.sort(sortedList);
        Collections.reverse(sortedList);

        return actualList.equals(sortedList);
    }

    public boolean isDateSortedASC(String locator) {
        ArrayList actualList = new ArrayList();
        ArrayList sortedList = new ArrayList();
        List<WebElement> elements = waitForAllElementVisible(locator);

        for (WebElement element : elements) {
            Date price = parseStringToDate(element.getText());
            actualList.add(price);
            sortedList.add(price);
            log.info(price);
        }
        Collections.sort(sortedList);

        return actualList.equals(sortedList);
    }

    public boolean isDateSortedDESC(String locator) {
        ArrayList actualList = new ArrayList();
        ArrayList sortedList = new ArrayList();
        List<WebElement> elements = waitForAllElementVisible(locator);

        for (WebElement element : elements) {
            Date price = parseStringToDate(element.getText());
            actualList.add(price);
            sortedList.add(price);
            log.info(price);
        }
        Collections.sort(sortedList);
        Collections.reverse(sortedList);

        return actualList.equals(sortedList);
    }

    public String[][] sortIntPriceAscending(String[][] originList) {
        String temp;
        int before, after;

        for (int i = 0; i < originList.length - 1; i++) {
            for (int j = i + 1; j < originList.length; j++) {
                before = (int) parsePriceToObject(originList[i][arrayPrice]);
                after = (int) parsePriceToObject(originList[j][arrayPrice]);

                if (before > after) {
                    temp = originList[i][arrayPrice];
                    originList[i][arrayPrice] = originList[j][arrayPrice];
                    originList[j][arrayPrice] = temp;

                    temp = originList[i][arrayName];
                    originList[i][arrayName] = originList[j][arrayName];
                    originList[j][arrayName] = temp;
                }
            }
        }
        return originList;
    }

    public String[][] sortIntPriceDescending(String[][] originList) {
        String temp;
        int before, after;

        for (int i = 0; i < originList.length - 1; i++) {
            for (int j = i + 1; j < originList.length; j++) {
                before = (int) parsePriceToObject(originList[i][arrayPrice]);
                after = (int) parsePriceToObject(originList[j][arrayPrice]);

                if (before < after) {
                    temp = originList[i][arrayPrice];
                    originList[i][arrayPrice] = originList[j][arrayPrice];
                    originList[j][arrayPrice] = temp;

                    temp = originList[i][arrayName];
                    originList[i][arrayName] = originList[j][arrayName];
                    originList[j][arrayName] = temp;
                }
            }
        }
        return originList;
    }

    public Object parsePriceToObject(String targetPrice) {
        if (targetPrice.contains("₫")) {
            return Integer.parseInt(targetPrice.replace("₫", "").replace(".", "").replace(",", "").trim());
        } else if (targetPrice.contains("$")) {
            return Float.parseFloat(targetPrice.replace("$", "").replace(",", "").trim());
        } else if (targetPrice.contains("€")) {
            return Float.parseFloat(targetPrice.replace("€", "").replace(",", "").trim());
        } else {
            return Integer.parseInt(targetPrice.replace("VNĐ", "").replace(".", "").replace(",", "").trim());
        }
    }

    public Date parseStringToDate(String dateInString) {
        SimpleDateFormat formater = null;
        try {
            if (dateInString.contains(",")) {
                dateInString = dateInString.replace(",", "");
            }
            if (dateInString.contains("/")) {
                formater = new SimpleDateFormat("dd/MM/yyyy");
            } else if (dateInString.length() == 11) {
                formater = new SimpleDateFormat("MMM dd yyyy");
            } else {
                formater = new SimpleDateFormat("dd MMMM yyyy");
            }
        } catch (Exception e) {
            System.out.println("Format is not correct" + e.getMessage());
        }

        Date date = null;
        try {
            date = formater.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public void printItemListOfProduct(String[][] products) {
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i][arrayPrice] + " - " + products[i][arrayName]);
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
