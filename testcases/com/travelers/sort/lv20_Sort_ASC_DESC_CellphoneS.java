package com.travelers.sort;

import commons.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.travellers.Page_Generator;
import pageObjects.travellers.sort.CellphoneS_iPhonePageObject;


public class lv20_Sort_ASC_DESC_CellphoneS extends BaseTest {
    CellphoneS_iPhonePageObject cellphoneSPage;

    @Parameters({"browser", "url2"})
    @BeforeClass
    public void beforeClass(String browser, String url) {
        cellphoneSPage = Page_Generator.getCellphoneSiPhonePage(getBrowserDriverManager(browser, url));
        cellphoneSPage.clickToCloseBanner();
    }

    @Description("To test sort ASC and DESC")
    @Test
    public void TC_00_Sort_ASC_DESC() {
        cellphoneSPage.clickToLowerPriceBtn();
        log.info("[The Prices displays in ASC on Web]");
        verifyTrue(cellphoneSPage.isPriceSortedASC());

        cellphoneSPage.clickToHigherPriceBtn();
        log.info("[The Prices displays in DESC on Web]");
        verifyTrue(cellphoneSPage.isPriceSortedDESC());
    }

    @Description("To get All Products and Prices")
    @Test
    public void TC_01_Get_All_Product_n_Price() {
        cellphoneSPage.clickToLowerPriceBtn();
        System.out.println("\n[All iPhones sorted ASC in CellphoneS]");
        cellphoneSPage.printAllProductName_ProductPrice();
    }

    @Description("To get Specific Product and Price")
    @Test
    public void TC_02_Get_Specific_Product_n_Price() {
        String device = "iPhone XR";

        cellphoneSPage.clickToLowerPriceBtn();
        System.out.println("\n[" + device + " sorted ASC in CellphoneS]");
        cellphoneSPage.printSpecificProductName_ProductPrice(device);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        removeDriver();
    }
}