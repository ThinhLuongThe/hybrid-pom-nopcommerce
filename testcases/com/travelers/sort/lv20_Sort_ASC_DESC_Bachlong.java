package com.travelers.sort;

import commons.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.travellers.Page_Generator;
import pageObjects.travellers.sort.Bachlong_ApplePageObject;


public class lv20_Sort_ASC_DESC_Bachlong extends BaseTest {
    Bachlong_ApplePageObject bachlongPage;

    @Parameters({"browser", "url1"})
    @BeforeClass
    public void beforeClass(String browser, String url) {
        bachlongPage = Page_Generator.getBachlongApplePage(getBrowserDriverManager(browser, url));
        bachlongPage.clickToCloseBanner();
    }

    @Description("To get iPhone and Price")
    @Test
    public void TC_01_Get_iPhone_n_Price() {
        String newiPhone = "apple-iphone";
        String newiPhoneXR = "Xr, Xs Max";
        String newiPhoneSE2020 = "iPhone SE 2020";
        String oldiPhone = "apple-iphone-cu";
        String oldiPhoneXR = "iPhone Xr";
        String oldiPhoneX_XS = "iPhone X, Xs Max, Xs";
        String oldiPhone8 = "iPhone 8|8+";

        bachlongPage.clickToSpecificDeviceModel(newiPhone, newiPhoneXR);
//        bachlongPage.waitUntilLoadingDisappeared();
        System.out.println("\n[New " + newiPhoneXR + " prices at BachLong]");
        bachlongPage.printAllProductName_ProductPrice(newiPhone);

        bachlongPage.clickToSpecificDeviceModel(newiPhone, newiPhoneSE2020);
        System.out.println("\n[New " + newiPhoneSE2020 + " prices at BachLong]");
        bachlongPage.printAllProductName_ProductPrice(newiPhone);

        bachlongPage.clickToSpecificDeviceModel(oldiPhone, oldiPhoneXR);
        System.out.println("\n[Old " + oldiPhoneXR + " prices at BachLong]");
        bachlongPage.printAllProductName_ProductPrice(oldiPhone);

        bachlongPage.clickToSpecificDeviceModel(oldiPhone, oldiPhoneX_XS);
        System.out.println("\n[Old " + oldiPhoneX_XS + " prices at BachLong]");
        bachlongPage.printAllProductName_ProductPrice(oldiPhone);

        bachlongPage.clickToSpecificDeviceModel(oldiPhone, oldiPhone8);
        System.out.println("\n[Old " + oldiPhone8 + " prices at BachLong]");
        bachlongPage.printAllProductName_ProductPrice(oldiPhone);
    }

    @Test
    public void TC_02_Get_iPad_n_Price() {
        String newiPad = "apple-ipad";
        String newiPadGen8 = "iPad Gen 8";
        String newiPadMini2019 = "iPad Mini 2019";
        String newiPadAir2019 = "iPad Air 2019";

        bachlongPage.clickToSpecificDeviceModel(newiPad, newiPadGen8);
        System.out.println("\n[New " + newiPadGen8 + " prices at BachLong]");
        bachlongPage.printAllProductName_ProductPrice(newiPad);

        bachlongPage.clickToSpecificDeviceModel(newiPad, newiPadMini2019);
        System.out.println("\n[New " + newiPadMini2019 + " prices at BachLong]");
        bachlongPage.printAllProductName_ProductPrice(newiPad);

        bachlongPage.clickToSpecificDeviceModel(newiPad, newiPadAir2019);
        System.out.println("\n[New " + newiPadAir2019 + " prices at BachLong]");
        bachlongPage.printAllProductName_ProductPrice(newiPad);
    }

    @Test
    public void TC_03_Get_Macbook_n_Price() {
        String newMacbook = "apple-macbook";
        String newMacbookProM1 = "Macbook Pro 2020 M1";
        String newMacbookPro2020 = "Macbook Pro 2020";

        bachlongPage.clickToSpecificDeviceModel(newMacbook, newMacbookProM1);
        System.out.println("\n[New " + newMacbookProM1 + " prices at BachLong]");
        bachlongPage.printAllProductName_ProductPrice(newMacbook);

        bachlongPage.clickToSpecificDeviceModel(newMacbook, newMacbookPro2020);
        System.out.println("\n[New " + newMacbookPro2020 + " prices at BachLong]");
        bachlongPage.printAllProductName_ProductPrice(newMacbook);
    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
        removeDriver();
    }
}