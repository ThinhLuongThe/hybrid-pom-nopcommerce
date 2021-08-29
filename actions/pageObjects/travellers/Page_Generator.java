package pageObjects.travellers;

import org.openqa.selenium.WebDriver;
import pageObjects.travellers.sort.CellphoneS_iPhonePageObject;
import pageObjects.travellers.sort.H2Shop_iPhonePageObject;
import pageObjects.travellers.upload.UploadPageObject;

public class Page_Generator {
    public static UploadPageObject getHomePage(WebDriver driver) {
        return new UploadPageObject(driver);
    }

    public static CellphoneS_iPhonePageObject getCellphoneSiPhonePage(WebDriver driver) {
        return new CellphoneS_iPhonePageObject(driver);
    }

    public static H2Shop_iPhonePageObject getH2ShopSiPhonePage(WebDriver driver) {
        return new H2Shop_iPhonePageObject(driver);
    }
}