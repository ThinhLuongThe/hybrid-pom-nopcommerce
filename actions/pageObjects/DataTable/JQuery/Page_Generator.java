package pageObjects.DataTable.JQuery;

import org.openqa.selenium.WebDriver;

public class Page_Generator {
    public static pageObjects.DataTable.JQuery.HomePageObject getHomePage(WebDriver driver) {
        return new pageObjects.DataTable.JQuery.HomePageObject(driver);
    }
}