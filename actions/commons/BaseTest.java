package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    private String projectPath = System.getProperty("user.dir");

    protected WebDriver getBrowserDriver(String browser, String url) {
        switch (browser.trim().toUpperCase()) {
            case "FIREFOX":
                System.setProperty("webdriver.gecko.driver", projectPath + File.separator + "browserDrivers" + File.separator + "geckodriver");
                driver = new FirefoxDriver();
                break;
            case "CHROME":
                System.setProperty("webdriver.chrome.driver", projectPath + File.separator + "browserDrivers" + File.separator + "chromedriver");
                driver = new ChromeDriver();
                break;
            case "EDGE":
                System.setProperty("webdriver.edge.driver", projectPath + File.separator + "browserDrivers" + File.separator + "msedgedriver");
                driver = new EdgeDriver();
                break;
            case "FIREFOX-HEADLESS":
                System.setProperty("webdriver.gecko.driver", projectPath + File.separator + "browserDrivers" + File.separator + "geckodriver");
                FirefoxOptions firefoxOpt = new FirefoxOptions();
                firefoxOpt.addArguments("headless");
                firefoxOpt.addArguments("window-size=1366x768");
                driver = new FirefoxDriver(firefoxOpt);
                break;
            case "CHROME-HEADLESS":
                System.setProperty("webdriver.chrome.driver", projectPath + File.separator + "browserDrivers" + File.separator + "chromedriver");
                ChromeOptions chromeOpt = new ChromeOptions();
                chromeOpt.addArguments("headless");
                chromeOpt.addArguments("window-size=1366x768");
                driver = new ChromeDriver(chromeOpt);
                break;
            default:
                throw new RuntimeException("Browser Name is not correct!");
        }

        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    protected WebDriver getBrowserDriverManager(String browser, String url) {
        switch (browser.trim().toUpperCase()) {
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "EDGE":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "FIREFOX-HEADLESS":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOpt = new FirefoxOptions();
                firefoxOpt.addArguments("headless");
                firefoxOpt.addArguments("window-size=1366x768");
                driver = new FirefoxDriver(firefoxOpt);
                break;
            case "CHROME-HEADLESS":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOpt = new ChromeOptions();
                chromeOpt.addArguments("headless");
                chromeOpt.addArguments("window-size=1366x768");
                driver = new ChromeDriver(chromeOpt);
                break;
            default:
                throw new RuntimeException("Browser Name is not correct!");
        }

        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    private String osName = System.getProperty("os.name");

    private String getBeforeAndAfterSlashes(String folderName) {
        if (osName.toLowerCase().indexOf("mac") >= 0 ||
                osName.toLowerCase().indexOf("sunos") >= 0 ||
                (osName.toLowerCase().indexOf("nix") >= 0 ||
                        osName.toLowerCase().indexOf("nux") >= 0)) {
            folderName = "/" + folderName + "/";
        } else if (osName.toLowerCase().indexOf("win") >= 0) {
            folderName = "\\" + folderName + "\\";
        } else {
            folderName = null;
        }
        return folderName;
    }
}
