package com.liveguru.user;

import commons.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.liveguru.Page_Generator;
import pageObjects.liveguru.sort.MobilePageObject;


public class lv20_Sort_ASC_DESC_Liveguru extends BaseTest {
    MobilePageObject mobilePage;

    @Parameters({"browser", "url3"})
    @BeforeClass
    public void beforeClass(String browser, String url) {
        mobilePage = Page_Generator.getMobilePage(getBrowserDriverManager(browser, url));
    }

    @Description("To Sort Price ASC")
    @Test
    public void TC_01_Sort_Price_ASC() {
        String sortOption = "Price";

        mobilePage.clickToSortDropdownByText(sortOption);
        System.out.println("\n[Products are sorted By " + sortOption + "]");
        verifyTrue(mobilePage.isProductPriceASC());
        mobilePage.printProductList(mobilePage.getProductNamesnPrices());
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        removeDriver();
    }
}