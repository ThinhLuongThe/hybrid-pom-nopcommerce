package pageFactory.nopcommerce;

import commons.BasePage_Factory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject extends BasePage_Factory {
    public HomePageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(how = How.XPATH, using = "//a[text()='Register']")
    private WebElement registerLink;

    public void clickToRegisterLink() {
        clickToElement(registerLink);
    }


    @CacheLookup
    @FindBy(xpath = "//a[text()='Log in']")
    private WebElement loginLink;

    public void clickToLoginLink() {
        clickToElement(loginLink);
    }


    @CacheLookup
    @FindBy(xpath = "//div[@class='header']//a[text()='My account']")
    private WebElement myAccountLink;

    public void clickToMyAccountLink() {
        clickToElement(myAccountLink);
    }
}
