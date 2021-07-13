package pageObjects_level01_newpageTestcase;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.MyAccountPageUI;

public class MyAccountPageObject extends BasePage {
    public MyAccountPageObject(WebDriver driver) {
        super(driver);
    }

    public boolean isGenderMaleSelected() {
        waitForElementVisible(MyAccountPageUI.GENDER_MALE_RADIO);
        return isControlSelected(MyAccountPageUI.GENDER_MALE_RADIO);
    }

    public String getFirstName() {
        return getAttributeValue(MyAccountPageUI.FIRSTNAME_TXT, "value");
    }

    public String getLastName() {
        return getAttributeValue(MyAccountPageUI.LASTNAME_TXT, "value");
    }

    public String getSelectedDay() {
        return getSelectedValueInDropDown(MyAccountPageUI.DAY_DROPDOWN);
    }

    public String getSelectedMonth() {
        return getSelectedValueInDropDown(MyAccountPageUI.MONTH_DROPDOWN);
    }

    public String getSelectedYear() {
        return getSelectedValueInDropDown(MyAccountPageUI.YEAR_DROPDOWN);
    }

    public String getEmail() {
        return getAttributeValue(MyAccountPageUI.EMAIL_TXT, "value");
    }
}