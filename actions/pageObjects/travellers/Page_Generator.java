package pageObjects.travellers;

import org.openqa.selenium.WebDriver;
import pageObjects.travellers.sort.*;
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

    public static Bachlong_ApplePageObject getBachlongApplePage(WebDriver driver) {
        return new Bachlong_ApplePageObject(driver);
    }

    public static MacMall_ApplePageObject getMacMallApplePage(WebDriver driver) {
        return new MacMall_ApplePageObject(driver);
    }
}