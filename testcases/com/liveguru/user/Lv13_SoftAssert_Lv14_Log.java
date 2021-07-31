package com.liveguru.user;

import commons.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;


public class Lv13_SoftAssert_Lv14_Log extends BaseTest {
    SoftAssert soft;
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        soft = new SoftAssert();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://live.demoguru99.com/index.php/customer/account/login/");
    }

    @Test
    public void TC_01_Login_Empty_Email_Password() {
        log.info("Step 01 - Input to email textbox");
        driver.findElement(By.id("email")).sendKeys("");

        log.info("Step 02 - Input to password textbox");
        driver.findElement(By.id("pass")).sendKeys("");

        log.info("Step 03 - Click to Login button");
        driver.findElement(By.id("send2")).click();

        // Pass (5)
        log.info("Step 05 - Verify Equal: error message");
        verifyEquals(driver.findElement(By.id("advice-required-entry-pass")).getText(), "This is a required field.");

        // First Fail (6)
        log.info("Step 06 - Verify Equal: error message");
        verifyEquals(driver.findElement(By.id("advice-required-entry-email")).getText(), "This is a required field");

        // Pass (7)
        log.info("Step 07 - Verify True.");
        verifyTrue(isElementDisplayed("//button[@id='send2']"));

        // Second Fail (8)
        log.info("Step 08 - Verify True.");
        verifyTrue(isElementDisplayed("//button[@id='send_failed_not_found']"));

        // Pass (9)
        log.info("Step 09 - Verify True.");
        verifyTrue(isElementDisplayed("//button[@id='send2']"));

        // Third Fail (10)
        log.info("Step 10 - Verify True.");
        verifyTrue(isElementDisplayed("//button[@id='send_failed_not_found']"));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public boolean isElementDisplayed(String locator) {
        try {
            return driver.findElement(By.xpath(locator)).isDisplayed();
        } catch (Exception e) {
            System.out.println("Exception = " + e.getMessage());
            return false;
        }
    }
}