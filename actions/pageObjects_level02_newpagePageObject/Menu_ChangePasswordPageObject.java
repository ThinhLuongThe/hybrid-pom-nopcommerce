package pageObjects_level02_newpagePageObject;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class Menu_ChangePasswordPageObject extends BasePage {
    WebDriver driver;

    public Menu_ChangePasswordPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
