package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToRegisterLink() {
        clickToElement(driver, HomePageUI.REGISTER_LINK);
    }

    public void clickToLoginLink() {
        clickToElement(driver, HomePageUI.LOGIN_LINK);
    }

    public void clickToMyAccountLink() {
        clickToElement(driver, HomePageUI.MYACCOUNT_LINK);
    }
}
