package pageObjects.liveguru.dataTable;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.liveguru.Page_Generator;
import pageUIs.liveguru.dataTable.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
    WebDriver driver;

    public AdminLoginPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void inputToUsername(String adminUsername) {
        inputToElement(AdminLoginPageUI.USERNAME_TXT, adminUsername);
    }

    public void inputToPassword(String adminPassword) {
        inputToElement(AdminLoginPageUI.PASSWORD_TXT, adminPassword);
    }

    public AdminHomePageObject clickToLogin() {
        clickToElement(AdminLoginPageUI.LOGIN_BTN);
        return Page_Generator.getAdminHomePage(driver);
    }
}
