package pageObjects.nopCommerce.level02_newpagePageObject;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class Menu_OrdersPageObject extends BasePage {
    WebDriver driver;

    public Menu_OrdersPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
