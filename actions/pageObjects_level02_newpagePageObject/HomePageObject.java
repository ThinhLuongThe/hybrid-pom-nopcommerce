package pageObjects_level02_newpagePageObject;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public RegisterPageObject clickToRegisterLink() {
        clickToElement(HomePageUI.REGISTER_LINK);
        return PageGenerator.getRegisterPage(driver);
    }

    public LoginPageObject clickToLoginLink() {
        clickToElement(HomePageUI.LOGIN_LINK);
        return PageGenerator.getLoginPage(driver);
    }

    public MyAccountPageObject clickToMyAccountLink() {
        clickToElement(HomePageUI.MYACCOUNT_LINK);
        return PageGenerator.getMyAccountPage(driver);
    }
}
