package testJava;

public class testSeparator {
    private String osName = System.getProperty("os.name");

    public static void main(String[] args) {
        String projectLocation = System.getProperty("user.dir");
        testSeparator testObject = new testSeparator();

        String danangFileName = "Da Nang.jpg";
        String hanoiFileName = "Ha Noi.jpg";
        String saigonFileName = "Ho Chi Minh.jpg";
        String danangFileNamePath = projectLocation + testObject.getBeforeAndAfterSlashes("uploadFiles") + danangFileName;
        String hanoiFileNamePath = projectLocation + testObject.getBeforeAndAfterSlashes("uploadFiles") + hanoiFileName;
        String saigonFileNamePath = projectLocation + testObject.getBeforeAndAfterSlashes("uploadFiles") + saigonFileName;

        System.out.println(danangFileNamePath);
        System.out.println(hanoiFileNamePath);
        System.out.println(saigonFileNamePath);
    }

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

/*    public static String getDirectorySlash(String folderName) {
        String separator = System.getProperty("file.separator");
        System.out.println(separator);
        separator = FileSystems.getDefault().getSeparator();
        System.out.println(separator);
        separator = File.separator;
        System.out.println(separator);
        return separator + folderName + separator;
    }*/


    /*private String getDirectorySlash(String folderName) {
        if (isMac() || isUnix() || isSolaris()) {
            folderName = "/" + folderName + "/";
        } else if (isWindows()) {
            folderName = "\\" + folderName + "\\";
        } else {
            folderName = null;
        }
        return folderName;
    }

    private boolean isWindows() {
        return (osName.toLowerCase().indexOf("win") >= 0);
    }

    private boolean isMac() {
        return (osName.toLowerCase().indexOf("mac") >= 0);
    }

    private boolean isUnix() {
        return (osName.toLowerCase().indexOf("nix") >= 0 || osName.toLowerCase().indexOf("nux") >= 0);
    }

    private boolean isSolaris() {
        return (osName.toLowerCase().indexOf("sunos") >= 0);
    }*/
}
