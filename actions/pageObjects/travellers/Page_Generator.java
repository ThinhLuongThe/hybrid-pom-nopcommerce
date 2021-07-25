package pageObjects.travellers;

import org.openqa.selenium.WebDriver;

public class Page_Generator {
    public static UploadPageObject getHomePage(WebDriver driver) {
        return new UploadPageObject(driver);
    }
}