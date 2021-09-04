package testJava;

import java.io.File;

public class testJavaFunction {
    public static void main(String[] args){
        // Test getDynamicMenuPageLink
        String testText = getDynamicMenuPageLink("//div[@class='listbox']//a[text()='%s']", "FFThinh");
        String testText2 = getDynamicMenuPageLink("//div[@role='listbox']//span[text()='" + "%s" + "']", "Tim Barker".toLowerCase());
        System.out.println(testText);
        System.out.println(testText2);


        // Test uploadFiles
        testJavaFunction testObject = new testJavaFunction();
        String[] fileNames = {"building.jpg"};
        testObject.uploadFiles(fileNames);
    }

    public static String getDynamicMenuPageLink(String locator, String... pageName){
        return String.format(locator, (Object[]) pageName);
    }

    public void uploadFiles(String... fileNames) {
        String uploadPath = System.getProperty("user.dir") + File.separator + "uploadFiles" + File.separator;
        String allPath = "";
        for (String fileName : fileNames) {
            allPath += uploadPath + fileName + "\n";
        }
        System.out.println(allPath.trim());
    }
}
