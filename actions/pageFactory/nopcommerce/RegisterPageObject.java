package pageFactory.nopcommerce;

import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject extends BasePageFactory {
    public RegisterPageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//input[@id='gender-male']")
    private WebElement genderMaleRadio;

    public void clickToMaleGender() {
        clickToElement(genderMaleRadio);
    }


    @FindBy(xpath = "//input[@id='FirstName']")
    private WebElement firstNameTxt;

    public void inputFirstName(String firstName) {
        inputToElement(firstNameTxt, firstName);
    }


    @FindBy(xpath = "//input[@id='LastName']")
    private WebElement lastNameTxt;

    public void inputLastName(String lastName) {
        inputToElement(lastNameTxt, lastName);
    }


    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    private WebElement dayDropdown;

    public void selectDay(String selectedDay) {
        selectItemInDropDown(dayDropdown, selectedDay);
    }


    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    private WebElement monthDropdown;

    public void selectMonth(String selectedMonth) {
        selectItemInDropDown(monthDropdown, selectedMonth);
    }


    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    private WebElement yearDropdown;

    public void selectYear(String selectedYear) {
        selectItemInDropDown(yearDropdown, selectedYear);
    }


    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailTxt;

    public void inputEmail(String email) {
        inputToElement(emailTxt, email);
    }


    @FindBy(xpath = "//input[@id='Password']")
    private WebElement passwordTxt;

    public void inputPassword(String password) {
        inputToElement(passwordTxt, password);
    }


    @FindBy(xpath = "//input[@id='ConfirmPassword']")
    private WebElement confirmPasswordTxt;

    public void inputConfirmPassword(String password) {
        inputToElement(confirmPasswordTxt, password);
    }


    @FindBy(xpath = "//button[@id='register-button']")
    private WebElement registerBtn;

    public void clickToRegisterButton() {
        clickToElement(registerBtn);
    }


    @FindBy(xpath = "//div[@class='result' and text()='Your registration completed']")
    private WebElement registerSuccessMessage;

    public boolean isSuccessfulMessageDisplay() {
        return isControlDisplay(registerSuccessMessage);
    }


    @FindBy(xpath = "//a[text()='Log out']")
    private WebElement logoutBtn;

    public void clickToLogOutLink() {
        clickToElement(logoutBtn);
    }
}
