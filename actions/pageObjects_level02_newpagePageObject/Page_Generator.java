package pageObjects_level02_newpagePageObject;

import org.openqa.selenium.WebDriver;

public class Page_Generator {
    public static HomePageObject getHomePage(WebDriver driver){
        return new HomePageObject(driver);
    }

    public static RegisterPageObject getRegisterPage(WebDriver driver){
        return new RegisterPageObject(driver);
    }

    public static LoginPageObject getLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }

    public static MyAccountPageObject getMyAccountPage(WebDriver driver){
        return new MyAccountPageObject(driver);
    }
    public static Menu_CustomerInfoPageObject getCustomerInfoPage(WebDriver driver){
        return new Menu_CustomerInfoPageObject(driver);
    }
    public static Menu_AddresssesPageObject getAddressesPage(WebDriver driver){
        return new Menu_AddresssesPageObject(driver);
    }
    public static Menu_OrdersPageObject getOrdersPage(WebDriver driver){
        return new Menu_OrdersPageObject(driver);
    }
    public static Menu_DownloadProductPageObject getDownloadProductPage(WebDriver driver){
        return new Menu_DownloadProductPageObject(driver);
    }
    public static Menu_BackSubscriptionPageObject getBackSubscriptionPage(WebDriver driver){
        return new Menu_BackSubscriptionPageObject(driver);
    }
    public static Menu_RewardPointsPageObject getRewardPointsPage(WebDriver driver){
        return new Menu_RewardPointsPageObject(driver);
    }
    public static Menu_ChangePasswordPageObject getChangePasswordPage(WebDriver driver){
        return new Menu_ChangePasswordPageObject(driver);
    }
    public static Menu_MyProductsPageObject getMyProductsPage(WebDriver driver){
        return new Menu_MyProductsPageObject(driver);
    }

}
