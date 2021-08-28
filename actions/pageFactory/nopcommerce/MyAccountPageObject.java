package pageFactory.nopcommerce;

import commons.BasePage_Factory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPageObject extends BasePage_Factory {
    public MyAccountPageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='gender-male']")
    private WebElement genderMaleRadio;

    public boolean isGenderMaleSelected() {
        waitForElementVisible(genderMaleRadio);
        return isControlSelected(genderMaleRadio);
    }


    @FindBy(xpath = "//input[@id='FirstName']")
    private WebElement firstNameTxt;

    public String getFirstName() {
        return getAttributeValue(firstNameTxt, "value");
    }


    @FindBy(xpath = "//input[@id='LastName']")
    private WebElement lastNameTxt;

    public String getLastName() {
        return getAttributeValue(lastNameTxt, "value");
    }


    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    private WebElement dayDropdown;

    public String getSelectedDay() {
        return getSelectedValueInDropDown(dayDropdown);
    }


    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    private WebElement monthDropdown;

    public String getSelectedMonth() {
        return getSelectedValueInDropDown(monthDropdown);
    }


    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    private WebElement yearDropdown;

    public String getSelectedYear() {
        return getSelectedValueInDropDown(yearDropdown);
    }


    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailTxt;

    public String getEmail() {
        return getAttributeValue(emailTxt, "value");
    }
}
