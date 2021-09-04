package com.liveguru.user;

import commons.BaseTest;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.liveguru.Page_Generator;
import pageObjects.liveguru.dataTable.*;


public class Lv09_POM_DataTable_liveguru extends BaseTest {
    private WebDriver driver;
    UserHomePageObject homePage;
    UserLoginPageObject loginPage;
    UserRegisterPageObject registerPage;
    UserDashboardPageObject dashboardPage;
    AdminHomePageObject adminHomePage;
    AdminLoginPageObject adminLoginPage;

    String firstName, lastName, fullName, email, password;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        homePage = Page_Generator.getUserHomePage(driver);

        firstName = "S_fName";
        lastName = "S_lName";
        fullName = firstName + " " + lastName;
        email = emailGenerator();
        password = "123456";
    }

    @Test
    public void TC01_Register_LiveGuru_Account() {
        loginPage = homePage.clickToMyAccountLink();
        registerPage = loginPage.clickToCreateAccountBtn();

        registerPage.inputFistName(firstName);
        registerPage.inputLastName(lastName);
        registerPage.inputEmail(email);
        registerPage.inputPassword(password);
        registerPage.inputConfirmPassword(password);

        dashboardPage = registerPage.clickToRegisterBtn();
        Assert.assertTrue(dashboardPage.isSuccessMessageDisplayed());
    }

    @Parameters({"url2"})
    @Test
    public void TC02_AdminPage_Deal_with_Data(String url2) {
        log.info("Step 01: Login account");
        dashboardPage.openPageURL(url2);
        adminLoginPage = Page_Generator.getAdminLoginPage(driver);

        adminLoginPage.inputToUsername(GlobalConstants.liveguruAdminUserName);
        adminLoginPage.inputToPassword(GlobalConstants.liveguruAdminPassword);
        adminHomePage = adminLoginPage.clickToLogin();
        adminHomePage.clickToClosePopup();

        log.info("Step 02: Searching Data");
        adminHomePage.searchOneColumn("Email", email);
        Assert.assertEquals(adminHomePage.getResultNumber(), 1);
        Assert.assertTrue(adminHomePage.isDataOfColumnDisplayedCorrectly("Email", email));

        adminHomePage.searchOneColumn("Name", fullName);
        Assert.assertNotEquals(adminHomePage.getResultNumber(), 1);
        Assert.assertTrue(adminHomePage.isDataOfColumnDisplayedCorrectly("Name", fullName));
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        removeDriver();
    }

    public String emailGenerator() {
        return "S" + System.currentTimeMillis() + "@smail.com";
    }
}
