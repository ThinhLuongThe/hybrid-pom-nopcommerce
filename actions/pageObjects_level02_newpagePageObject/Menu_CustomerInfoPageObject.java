package pageObjects_level02_newpagePageObject;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class Menu_CustomerInfoPageObject extends BasePage {
    WebDriver driver;

    public Menu_CustomerInfoPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
