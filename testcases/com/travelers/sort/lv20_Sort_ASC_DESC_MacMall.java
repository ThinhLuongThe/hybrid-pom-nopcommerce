package com.travelers.sort;

import commons.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.travellers.Page_Generator;
import pageObjects.travellers.sort.MacMall_ApplePageObject;


public class lv20_Sort_ASC_DESC_MacMall extends BaseTest {
    MacMall_ApplePageObject macMallPage;

    @Parameters({"browser", "url4"})
    @BeforeClass
    public void beforeClass(String browser, String url) {
        macMallPage = Page_Generator.getMacMallApplePage(getBrowserDriverManager(browser, url));
        macMallPage.clickToCloseBanner();
    }

    @Description("To get Macbook and Price")
    @Test
    public void TC_01_Get_Macbook_n_Price() {
        String menuName = "Mac";
        String deviceName = "MacBook Pro 13\"";

        macMallPage.clickToProductPageByName(menuName, deviceName);
        System.out.println("\n[New " + deviceName + " prices at MacMall]");
        macMallPage.printAllProductName_ProductPrice();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        removeDriver();
    }
}