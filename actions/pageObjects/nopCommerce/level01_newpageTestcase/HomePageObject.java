package pageObjects.nopCommerce.level01_newpageTestcase;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.HomePageUI;

public class HomePageObject extends BasePage {
    public HomePageObject(WebDriver driver) {
        super(driver);
    }

    public void clickToRegisterLink() {
        clickToElement(HomePageUI.REGISTER_LINK);
    }

    public void clickToLoginLink() {
        clickToElement(HomePageUI.LOGIN_LINK);
    }

    public void clickToMyAccountLink() {
        clickToElement(HomePageUI.MYACCOUNT_LINK);
    }
}
