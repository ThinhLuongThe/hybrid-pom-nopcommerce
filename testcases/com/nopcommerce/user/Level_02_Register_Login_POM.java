package com.nopcommerce.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyAccountPageObject;
import pageObjects.RegisterPageObject;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Level_02_Register_Login_POM extends BasePage {
    WebDriver driver;
    HomePageObject homePage;
    LoginPageObject loginPage;
    MyAccountPageObject myAccountPage;
    RegisterPageObject registerPage;

    String projectPath = System.getProperty("user.dir");
    String firstName = "Soul_FirstName";
    String lastName = "Soul_LastName";
    String email = generateRandomEmail();
    String selectedDay = "12";
    String selectedMonth = "May";
    String selectedYear = "1989";
    String password = "123456";


    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.gecko.driver", projectPath + File.separator + "browserDrivers" + File.separator + "geckodriver");
        driver = new FirefoxDriver();
//        System.setProperty("webdriver.chrome.driver", projectPath + File.separator + "browserDrivers" + File.separator + "chromedriver");
//        driver = new ChromeDriver();

        driver.get("https://demo.nopcommerce.com/");
        homePage = new HomePageObject(driver);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC01_Register() {
        homePage.clickToRegisterLink();
        registerPage = new RegisterPageObject(driver);

        registerPage.clickToMaleGender();
        registerPage.inputFirstName(firstName);
        registerPage.inputLastName(lastName);
        registerPage.selectDay(selectedDay);
        registerPage.selectMonth(selectedMonth);
        registerPage.selectYear(selectedYear);
        registerPage.inputEmail(email);
        registerPage.inputPassword(password);
        registerPage.inputConfirmPassword(password);
        registerPage.clickToRegisterButton();
        Assert.assertTrue(registerPage.isSuccessfulMessageDisplay());

        registerPage.clickToLogOutLink();
        homePage = new HomePageObject(driver);
    }

    @Test
    public void TC02_Login() {
        homePage.clickToLoginLink();
        loginPage = new LoginPageObject(driver);

        loginPage.inputEmail(email);
        loginPage.inputPassword(password);

        loginPage.clickToLoginButton();
        homePage = new HomePageObject(driver);

    }

    @Test
    public void TC03_MyAccount() {
        homePage.clickToMyAccountLink();
        myAccountPage = new MyAccountPageObject(driver);

        Assert.assertTrue(myAccountPage.isGenderMaleSelected());
        Assert.assertEquals(myAccountPage.getFirstName(), firstName);
        Assert.assertEquals(myAccountPage.getLastName(), lastName);
        Assert.assertEquals(myAccountPage.getSelectedDay(), selectedDay);
        Assert.assertEquals(myAccountPage.getSelectedMonth(), selectedMonth);
        Assert.assertEquals(myAccountPage.getSelectedYear(), selectedYear);
        Assert.assertEquals(myAccountPage.getEmail(), email);

    }

    public String generateRandomEmail() {
        return "Semail" + System.currentTimeMillis() + "@mailinator.com";
    }

    @AfterClass
    public void afterClass() {
//        driver.quit();
    }
}
