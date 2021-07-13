package com.nopcommerce.user;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Lv01_Register_Login {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    @BeforeClass
    public void beforeClass() {
//        System.setProperty("webdriver.gecko.driver", projectPath + File.separator + "browserDrivers" + File.separator + "geckodriver");
//        driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", projectPath + File.separator + "browserDrivers" + File.separator + "chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test
    public void TC01_Register_NopCommerce() {
        Select dobDay, dobMonth, dobYear; // Use for TC03
        String selectedDay, selectedMonth, selectedYear;
        By dayLocator = By.name("DateOfBirthDay");
        By monthLocator = By.name("DateOfBirthMonth");
        By yearLocator = By.name("DateOfBirthYear");

        //////
        selectedDay = "1";
        selectedMonth = "May";
        selectedYear = "1980";

        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.className("ico-register")).click();


        // Step 3a - input Registration data
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Soul1");
        driver.findElement(By.id("LastName")).sendKeys("LT");
        driver.findElement(By.id("Email")).sendKeys(generateRandomEmail());
        driver.findElement(By.id("Password")).sendKeys("123456");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("123456");

        // Step 3b
        dobDay = new Select(driver.findElement(dayLocator));
        dobDay.selectByVisibleText(selectedDay);
        Assert.assertEquals(dobDay.getOptions().size(), 32);

        dobMonth = new Select(driver.findElement(monthLocator));
        dobMonth.selectByVisibleText(selectedMonth);
        Assert.assertEquals(dobMonth.getOptions().size(), 13);

        dobYear = new Select(driver.findElement(yearLocator));
        dobYear.selectByVisibleText(selectedYear);
        Assert.assertEquals(dobYear.getOptions().size(), 112);

        // Step 4
        driver.findElement(By.id("register-button")).click();
        // Step 5
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='result' and text()='Your registration completed']")).isDisplayed());
        // Step 6
        driver.findElement(By.xpath("//a[@class='ico-account']")).click();
        // Verifying
        dobDay = new Select(driver.findElement(dayLocator));
        Assert.assertEquals(dobDay.getFirstSelectedOption().getText(), selectedDay);

        dobMonth = new Select(driver.findElement(monthLocator));
        Assert.assertEquals(dobMonth.getFirstSelectedOption().getText(), selectedMonth);

        dobYear = new Select(driver.findElement(yearLocator));
        Assert.assertEquals(dobYear.getFirstSelectedOption().getText(), selectedYear);
    }

    public String generateRandomEmail() {
        return "Semail" + System.currentTimeMillis() + "@mailinator.com";
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
