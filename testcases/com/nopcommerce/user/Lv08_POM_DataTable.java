package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.DataTable.JQuery.HomePageObject;
import pageObjects.DataTable.JQuery.Page_Generator;


public class Lv08_POM_DataTable extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;


    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        homePage = Page_Generator.getHomePage(driver);
    }

    //    @Test
    public void TC01_Pagination_Switching() {
        homePage.clickToPageNumber("3");
        homePage.clickToPageNumber("5");
        homePage.clickToPageNumber("7");
    }

//    @Test
    public void TC02_Filter_Row() {
        homePage.inputToColumnName("Females", "750");
        Assert.assertTrue(homePage.isTheRowDisplay("750", "Aruba", "756", "1504"));
        homePage.refreshThePage();
        homePage.inputToColumnName("Country", "Antigua and Barbuda");
        Assert.assertTrue(homePage.isTheRowDisplay("777", "Antigua and Barbuda", "803", "1580"));
    }

        @Test
    public void TC03_Action_Row() {
        homePage.actionToRowWithColumnName("remove", "Afghanistan");
        homePage.actionToRowWithColumnName("remove", "Arab Rep of Egypt");
    }

    @AfterClass
    public void afterClass() {
//        driver.quit();
    }
}
