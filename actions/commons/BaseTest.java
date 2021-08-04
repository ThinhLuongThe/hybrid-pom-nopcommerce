package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    private String projectPath = System.getProperty("user.dir");
    protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    protected final Log log;

    protected BaseTest() {
        log = LogFactory.getLog(getClass());
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

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
        setDriver(driver);
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
        setDriver(driver);
        return driver;
    }

    protected void removeDriver() {
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            log.info("OS name = " + osName);

            if (getDriver() != null) {
                getDriver().quit();
            }

            String cmd = "";
            if (getDriver().toString().toLowerCase().contains("chrome")) {
                if (osName.toLowerCase().contains("mac")) {
                    cmd = "pkill chromedriver";
                } else if (osName.toLowerCase().contains("windows")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
                }
            } else if (getDriver().toString().toLowerCase().contains("internetexplorer")) {
                if (osName.toLowerCase().contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
                }
            } else if (getDriver().toString().toLowerCase().contains("firefox")) {
                if (osName.toLowerCase().contains("mac")) {
                    cmd = "pkill geckodriver";
                } else if (osName.toLowerCase().contains("windows")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
                }
            } else if (getDriver().toString().toLowerCase().contains("edge")) {
                if (osName.toLowerCase().contains("mac")) {
                    cmd = "pkill msedgedriver";
                } else if (osName.toLowerCase().contains("windows")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
                }
            }

            Process process = Runtime.getRuntime().exec(cmd);
            process.waitFor();

        } catch (Exception e) {
            log.info(e.getMessage());
        }

        threadLocalDriver.remove();
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

    private boolean checkTrue(boolean condition) {
        boolean pass = true;
        try {
            if (condition) {
                log.info(" -------------------------- CONDITION TRUE -------------------------- ");
            } else {
                log.info(" -------------------------- CONDITION FALSE -------------------------- ");
            }
            Assert.assertTrue(condition);
            log.info(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            log.info(" -------------------------- FAILED -------------------------- ");
            pass = false;
            // Add lỗi vào ReportNG
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyTrue(boolean condition) {
        return checkTrue(condition);
    }

    private boolean checkFailed(boolean condition) {
        boolean pass = true;
        try {
            if (condition) {
                log.info(" -------------------------- CONDITION TRUE -------------------------- ");
            } else {
                log.info(" -------------------------- CONDITION FALSE -------------------------- ");
            }
            Assert.assertFalse(condition);
            log.info(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            log.info(" -------------------------- FAILED -------------------------- ");
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyFalse(boolean condition) {
        return checkFailed(condition);
    }

    private boolean checkEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
            log.info(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            log.info(" -------------------------- FAILED -------------------------- ");
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        return checkEquals(actual, expected);
    }

    public void deleteAllFilesInReportNGScreenshot() {
        log.info("---------- START delete file in folder ----------");
        deleteAllFileInFolder();
        log.info("---------- END delete file in folder ----------");
    }

    public void deleteAllFileInFolder() {
        try {
            String workingDir = System.getProperty("user.dir");
            String pathFolderDownload = workingDir + File.separator + "ReportNGScreenshots";
            File file = new File(pathFolderDownload);
            File[] listOfFiles = file.listFiles();
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    log.info(listOfFiles[i].getName());
                    new File(listOfFiles[i].toString()).delete();
                }
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }
}
