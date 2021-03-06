package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.level01_newpageTestcase.HomePageObject;
import pageObjects.nopCommerce.level01_newpageTestcase.LoginPageObject;
import pageObjects.nopCommerce.level01_newpageTestcase.MyAccountPageObject;
import pageObjects.nopCommerce.level01_newpageTestcase.RegisterPageObject;

public class Lv03_POM extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObject loginPage;
    private MyAccountPageObject myAccountPage;
    private RegisterPageObject registerPage;

    String firstName = "Soul_FirstName";
    String lastName = "Soul_LastName";
    String email = generateRandomEmail();
    String selectedDay = "12";
    String selectedMonth = "May";
    String selectedYear = "1989";
    String password = "123456";


    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        homePage = new HomePageObject(driver);
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
