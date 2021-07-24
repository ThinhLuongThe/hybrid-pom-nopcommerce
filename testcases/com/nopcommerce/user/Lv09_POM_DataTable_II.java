package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.DataTable.JQuery.HomePageIIObject;
import pageObjects.DataTable.JQuery.Page_Generator;


public class Lv09_POM_DataTable_II extends BaseTest {
    private WebDriver driver;
    HomePageIIObject homePage;


    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        homePage = Page_Generator.getHomePageII(driver);
    }

    @Test
    public void TC01_Deal_with_Data() {
        homePage.inputToColumnNameRowNumber("Contact Person", "3", "Soul 3");
        homePage.inputToColumnNameRowNumber("Company", "1", "Company 1");
        homePage.inputToColumnNameRowNumber("Member Since", "2", "02/12/2002");
        homePage.selectItemInColumnNameRowNumber("Country", "2", "Hong Kong");
    }

    @Test
    public void TC02_Deal_with_Actions() {
        homePage.clickToActionOnRow("Insert", "1");
        homePage.clickToActionOnRow("Insert", "2");
        homePage.clickToActionOnRow("Up", "3");
        homePage.clickToActionOnRow("Down", "2");
        homePage.clickToActionOnRow("Remove", "1");
        homePage.clickToActionOnRow("Remove", "1");
    }

    @AfterClass
    public void afterClass() {
//        driver.quit();
    }
}
