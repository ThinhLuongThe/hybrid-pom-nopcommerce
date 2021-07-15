package pageObjects_level02_newpagePageObject;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class Menu_AddresssesPageObject extends BasePage {
    WebDriver driver;

    public Menu_AddresssesPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
