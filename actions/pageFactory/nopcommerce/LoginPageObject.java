package pageFactory.nopcommerce;

import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends BasePageFactory {
    public LoginPageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
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


    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement loginBtn;

    public void clickToLoginButton() {
        clickToElement(loginBtn);
    }
}
