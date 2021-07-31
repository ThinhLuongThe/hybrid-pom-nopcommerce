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


public class Lv13_Soft_Assert extends BaseTest {
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
        System.out.println("Step 01 - Input to email textbox");
        driver.findElement(By.id("email")).sendKeys("");

        System.out.println("Step 02 - Input to password textbox");
        driver.findElement(By.id("pass")).sendKeys("");

        System.out.println("Step 03 - Click to Login button");
        driver.findElement(By.id("send2")).click();

        // First Pass (5)
        System.out.println("Step 05 - Verify error message displayed");
        verifyEquals(driver.findElement(By.id("advice-required-entry-pass")).getText(), "This is a required field.");

        // Second Fail (10)
        System.out.println("Step 10 - Verify error message displayed");
        verifyEquals(driver.findElement(By.id("advice-required-entry-email")).getText(), "This is a required field");

        // Pass (45)
        System.out.println("Step 45 - Verify .....");
        verifyTrue(isElementDisplayed("//button[@id='send2']"));

        // Third Fail (50)
        System.out.println("Step 50 - Verify .....");
        verifyTrue(isElementDisplayed("//button[@id='send_failed_not_found']"));

        // Pass (65)
        System.out.println("Step 65 - Verify .....");
        verifyTrue(isElementDisplayed("//button[@id='send2']"));

        // Fourth Fail (76)
        System.out.println("Step 76 - Verify .....");
        verifyTrue(isElementDisplayed("//button[@id='send_failed_not_found']"));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public boolean isElementDisplayed(String locator) {
        try {
            WebElement element = driver.findElement(By.xpath(locator));
            return element.isDisplayed();
        } catch (Exception e) {
            System.out.println("Exception = " + e.getMessage());
            return false;
        }
    }
}