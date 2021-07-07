package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.MyAccountPageUI;

public class MyAccountPageObject extends BasePage {
    WebDriver driver;

    public MyAccountPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isGenderMaleSelected() {
        waitForElementVisible(driver, MyAccountPageUI.GENDER_MALE_RADIO);
        return isControlSelected(driver, MyAccountPageUI.GENDER_MALE_RADIO);
    }

    public String getFirstName() {
        return getAttributeValue(driver, MyAccountPageUI.FIRSTNAME_TXT, "value");
    }

    public String getLastName() {
        return getAttributeValue(driver, MyAccountPageUI.LASTNAME_TXT, "value");
    }

    public String getSelectedDay() {
        return getSelectedValueInDropDown(driver, MyAccountPageUI.DAY_DROPDOWN);
    }

    public String getSelectedMonth() {
        return getSelectedValueInDropDown(driver, MyAccountPageUI.MONTH_DROPDOWN);
    }

    public String getSelectedYear() {
        return getSelectedValueInDropDown(driver, MyAccountPageUI.YEAR_DROPDOWN);
    }

    public String getEmail() {
        return getAttributeValue(driver, MyAccountPageUI.EMAIL_TXT, "value");
    }
}
