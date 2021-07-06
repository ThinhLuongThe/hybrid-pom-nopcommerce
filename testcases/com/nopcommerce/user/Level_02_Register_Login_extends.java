package com.nopcommerce.user;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Level_02_Register_Login_extends extends BasePage {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    @BeforeClass
    public void beforeClass() {
//        System.setProperty("webdriver.gecko.driver", projectPath + File.separator + "browserDrivers" + File.separator + "geckodriver");
//        driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", projectPath + File.separator + "browserDrivers" + File.separator + "chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void TC01_Register_NopCommerce() {
        String selectedDay, selectedMonth, selectedYear;

        String dayLocator = "//select[@name='DateOfBirthDay']";
        String monthLocator = "//select[@name='DateOfBirthMonth']";
        String yearLocator = "//select[@name='DateOfBirthYear']";

        selectedDay = "1";
        selectedMonth = "May";
        selectedYear = "1980";

        // Step 2
        openPageURL(driver, "https://demo.nopcommerce.com/");
        clickToElement(driver, "//a[text()='Register']");

        // Step 3a - input Registration data
        clickToElement(driver, "//input[@id='gender-male']");
        inputToElement(driver, "//input[@id='FirstName']", "Soul_FirstName");
        inputToElement(driver, "//input[@id='LastName']", "Soul_LastName");
        inputToElement(driver, "//input[@id='Email']", generateRandomEmail());
        inputToElement(driver, "//input[@id='Password']", "123456");
        inputToElement(driver, "//input[@id='ConfirmPassword']", "123456");

        // Step 3c (New)
        selectItemInDropDown(driver, dayLocator, selectedDay);
        selectItemInDropDown(driver, monthLocator, selectedMonth);
        selectItemInDropDown(driver, yearLocator, selectedYear);

        // Step 4
        clickToElement(driver, "//button[@id='register-button']");
        // Step 5
        isControlDisplay(driver, "//div[@class='result' and text()='Your registration completed']");
        // Step 6
        clickToElement(driver, "//a[@class='ico-account']");
        // Verifying
        Assert.assertEquals(getSelectedItemInDropDown(driver, dayLocator), selectedDay);
        Assert.assertEquals(getSelectedItemInDropDown(driver, monthLocator), selectedMonth);
        Assert.assertEquals(getSelectedItemInDropDown(driver, yearLocator), selectedYear);
    }

    public String generateRandomEmail() {
        return "Semail" + System.currentTimeMillis() + "@mailinator.com";
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
