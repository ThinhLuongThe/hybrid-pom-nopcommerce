package pageObjects_level02_newpagePageObject;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
    WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToMaleGender() {
        clickToElement(RegisterPageUI.GENDER_MALE_RADIO);
    }

    public void inputFirstName(String firstName) {
        inputToElement(RegisterPageUI.FIRSTNAME_TXT, firstName);
    }

    public void inputLastName(String lastName) {
        inputToElement(RegisterPageUI.LASTNAME_TXT, lastName);
    }

    public void selectDay(String selectedDay) {
        selectItemInDropDown(RegisterPageUI.DAY_DROPDOWN, selectedDay);
    }

    public void selectMonth(String selectedMonth) {
        selectItemInDropDown(RegisterPageUI.MONTH_DROPDOWN, selectedMonth);
    }

    public void selectYear(String selectedYear) {
        selectItemInDropDown(RegisterPageUI.YEAR_DROPDOWN, selectedYear);
    }

    public void inputEmail(String email) {
        inputToElement(RegisterPageUI.EMAIL_TXT, email);
    }

    public void inputPassword(String password) {
        inputToElement(RegisterPageUI.PASSWORD_TXT, password);
    }

    public void inputConfirmPassword(String password) {
        inputToElement(RegisterPageUI.CONFIRM_PASSWORD_TXT, password);
    }

    public void clickToRegisterButton() {
        clickToElement(RegisterPageUI.REGISTER_BTN);
    }

    public boolean isSuccessfulMessageDisplay() {
        return isControlDisplay(RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    public HomePageObject clickToLogOutLink() {
        clickToElement(RegisterPageUI.LOGOUT_BTN);
        return Page_Generator.getHomePage(driver);
    }
}
