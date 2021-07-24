package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.level02_newpagePageObject.*;


public class Lv06_POM_InitAtPO_InitAtPageGen extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObject loginPage;
    private MyAccountPageObject myAccountPage;
    private RegisterPageObject registerPage;
    //Switching Page
    private Menu_MyProductsPageObject myProductPage;
    private Menu_RewardPointsPageObject rewardPointPage;
    private Menu_ChangePasswordPageObject changePasswordPage;
    private Menu_OrdersPageObject ordersPage;
    private Menu_AddresssesPageObject addressesPage;

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
        homePage = Page_Generator.getHomePage(driver);
    }

    @Test
    public void TC01_Register() {
        registerPage = homePage.clickToRegisterLink();

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

        homePage = registerPage.clickToLogOutLink();
    }

    @Test
    public void TC02_Login() {
        loginPage = homePage.clickToLoginLink();

        loginPage.inputEmail(email);
        loginPage.inputPassword(password);

        homePage = loginPage.clickToLoginButton();
    }

    @Test
    public void TC03_MyAccount() {
        myAccountPage = homePage.clickToMyAccountLink();

        Assert.assertTrue(myAccountPage.isGenderMaleSelected());
        Assert.assertEquals(myAccountPage.getFirstName(), firstName);
        Assert.assertEquals(myAccountPage.getLastName(), lastName);
        Assert.assertEquals(myAccountPage.getSelectedDay(), selectedDay);
        Assert.assertEquals(myAccountPage.getSelectedMonth(), selectedMonth);
        Assert.assertEquals(myAccountPage.getSelectedYear(), selectedYear);
        Assert.assertEquals(myAccountPage.getEmail(), email);
    }

    @Test
    public void TC04_Switch_Pages_In_MyAccounts() {
        myProductPage = myAccountPage.openMyProductsPage();
        addressesPage = myProductPage.openAddressesPage();
        changePasswordPage = addressesPage.openChangePasswordPage();
        rewardPointPage = changePasswordPage.openRewardPointsPage();
        ordersPage = rewardPointPage.openOrdersPage();
    }

    public String generateRandomEmail() {
        return "Semail" + System.currentTimeMillis() + "@mailinator.com";
    }

    @AfterClass
    public void afterClass() {
//        driver.quit();
    }
}
