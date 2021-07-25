package pageUIs.travellers;

public class UploadPageUI {
    public static final String FILENAME_LOCATOR = "//p[@class='name' and text()='%s']";
    public static final String START_BTN = FILENAME_LOCATOR + "/parent::td/following-sibling::td/button[contains(@class,'start')]";
    public static final String FILE_UPLOADED_LOCATOR = "//p[@class='name']/a[text()='%s']";
}
