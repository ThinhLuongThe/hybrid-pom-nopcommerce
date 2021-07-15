package pageObjects_level02_newpagePageObject;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class Menu_DownloadProductPageObject extends BasePage {
    WebDriver driver;

    public Menu_DownloadProductPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
