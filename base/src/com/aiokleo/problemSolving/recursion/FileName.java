import java.io.File;

public class FileName {
    public static void findDirectories(String directory) {
        File dir = new File(directory);
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }

        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory() && !file.getName().equals(".") && !file.getName().equals("..")) {
                    System.out.println(file.getAbsolutePath());
                    // Recursively call this function on the subdirectory:
                    findDirectories(file.getAbsolutePath());
                }
            }
        }
    }

    public static void main(String[] args) {
        String directory = "/Users/amir/Desktop";
        findDirectories(directory);
    }
}
