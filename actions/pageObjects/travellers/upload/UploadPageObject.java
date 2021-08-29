package pageObjects.travellers.upload;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.travellers.upload.UploadPageUI;

public class UploadPageObject extends BasePage {
    public UploadPageObject(WebDriver driver) {
        super(driver);
    }

    public boolean areFilenameLoaded(String[] fileNames) {
        boolean status = true;
        for (String fileName : fileNames) {
            if (!isElementDisplayed(UploadPageUI.FILENAME_LOCATOR, fileName)) {
                return status = false;
            }
        }
        return status;
    }

    public void clickToUploadBtn(String[] fileNames) {
        for (String fileName : fileNames) {
            clickToElement(UploadPageUI.START_BTN, fileName);
        }
    }

    public boolean areFileUploaded(String[] fileNames) {
        boolean status = true;
        for (String fileName : fileNames) {
            if (!isElementDisplayed(UploadPageUI.FILE_UPLOADED_LOCATOR, fileName)) {
                return status = false;
            }
        }
        return status;
    }
}
