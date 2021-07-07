package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
    WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToMaleGender() {
        clickToElement(driver, RegisterPageUI.GENDER_MALE_RADIO);
    }

    public void inputFirstName(String firstName) {
        inputToElement(driver, RegisterPageUI.FIRSTNAME_TXT, firstName);
    }

    public void inputLastName(String lastName) {
        inputToElement(driver, RegisterPageUI.LASTNAME_TXT, lastName);
    }

    public void selectDay(String selectedDay) {
        selectItemInDropDown(driver, RegisterPageUI.DAY_DROPDOWN, selectedDay);
    }

    public void selectMonth(String selectedMonth) {
        selectItemInDropDown(driver, RegisterPageUI.MONTH_DROPDOWN, selectedMonth);
    }

    public void selectYear(String selectedYear) {
        selectItemInDropDown(driver, RegisterPageUI.YEAR_DROPDOWN, selectedYear);
    }

    public void inputEmail(String email) {
        inputToElement(driver, RegisterPageUI.EMAIL_TXT, email);
    }

    public void inputPassword(String password) {
        inputToElement(driver, RegisterPageUI.PASSWORD_TXT, password);
    }

    public void inputConfirmPassword(String password) {
        inputToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TXT, password);
    }

    public void clickToRegisterButton() {
        clickToElement(driver, RegisterPageUI.REGISTER_BTN);
    }

    public boolean isSuccessfulMessageDisplay() {
        return isControlDisplay(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    public void clickToLogOutLink() {
        clickToElement(driver, RegisterPageUI.LOGOUT_BTN);
    }
}
