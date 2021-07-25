package com.travelers;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.travellers.UploadPageObject;
import pageObjects.travellers.Page_Generator;


public class Lv10_Upload_Files extends BaseTest {
    private WebDriver driver;
    UploadPageObject uploadPage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        uploadPage = Page_Generator.getHomePage(driver);
    }

    @Test
    public void TC01_Upload_Single_File() {
        String[] fileNames = {"Bookshelf_Speakers.jpeg"};
        uploadPage.uploadFiles(fileNames);
        Assert.assertTrue(uploadPage.areFilenameLoaded(fileNames));
        uploadPage.clickToUploadBtn(fileNames);
        Assert.assertTrue(uploadPage.areFileUploaded(fileNames));
    }

    @Test
    public void TC02_Upload_Multiple_File() {
        String[] fileNames = {"Bookshelf_Speakers.jpeg","Leaf.jpeg", "X_signal.jpeg"};
        uploadPage.uploadFiles(fileNames);
        Assert.assertTrue(uploadPage.areFilenameLoaded(fileNames));
        uploadPage.clickToUploadBtn(fileNames);
        Assert.assertTrue(uploadPage.areFileUploaded(fileNames));
    }

    @AfterClass
    public void afterClass() {
//        driver.quit();
    }

}
