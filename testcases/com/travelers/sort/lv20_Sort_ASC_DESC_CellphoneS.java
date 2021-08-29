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

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browser, String url) {
        cellphoneSPage = Page_Generator.getCellphoneSiPhonePage(getBrowserDriverManager(browser, url));
        cellphoneSPage.clickToCloseBanner();
    }

    @Description("To test sort ASC and DESC")
    @Test
    public void TC_00_Sort_ASC_DESC() {
        cellphoneSPage.clickToLowerPriceBtn();
        log.info("The List displays in ASC on Application:");
        verifyTrue(cellphoneSPage.isPriceSortedASC());

        cellphoneSPage.clickToHigherPriceBtn();
        log.info("The List displays in DESC on Application:");
        verifyTrue(cellphoneSPage.isPriceSortedDESC());
    }

    @Description("To get Product and Price")
    @Test
    public void TC_01_Get_All_Product_n_Price() {
        cellphoneSPage.clickToLowerPriceBtn();
        System.out.println("\nAll iPhones sorted ASC in CellphoneS:");
        cellphoneSPage.printAllProductName_ProductPrice();
    }

    @Description("To get Product and Price")
    @Test
    public void TC_02_Get_Specific_Product_n_Price() {
        cellphoneSPage.clickToHigherPriceBtn();
        System.out.println("\niPhone XR sorted DESC in CellphoneS:");
        cellphoneSPage.printSpecificProductName_ProductPrice("iPhone XR");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        removeDriver();
    }
}