package com.travelers.sort;

import commons.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.travellers.Page_Generator;
import pageObjects.travellers.sort.H2Shop_iPhonePageObject;


public class lv20_Sort_ASC_DESC_H2Shop extends BaseTest {
    H2Shop_iPhonePageObject h2shopPage;

    @Parameters({"browser", "url3"})
    @BeforeClass
    public void beforeClass(String browser, String url) {
        h2shopPage = Page_Generator.getH2ShopSiPhonePage(getBrowserDriverManager(browser, url));
        h2shopPage.clickToFilterAppleProduct();
    }

    @Description("To get All Products and Prices")
    @Test
    public void TC_01_Get_All_Product_n_Price() {
        h2shopPage.selectSortValue("Low position", "Giá Rẻ Nhất");
        System.out.println("\n[All iPhone prices sorted ASC in H2Shop]");
        h2shopPage.printAllProductName_ProductPrice();
    }

    @Description("To get Specific Product and Price")
    @Test
    public void TC_02_Get_Specific_Product_n_Price() {
        String device = "iPhone XR";

        h2shopPage.selectSortValue("Giá Rẻ Nhất", "Giá Cao Nhất");
        System.out.println("\n[" + device + " prices sorted DESC in H2SHOP]");
        h2shopPage.printSpecificProductName_ProductPrice(device);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        removeDriver();
    }
}