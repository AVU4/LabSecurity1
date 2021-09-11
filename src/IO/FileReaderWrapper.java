package IO;

import java.io.File;
import java.util.Scanner;

public class FileReaderWrapper {


    public static File getFile(Scanner scanner) {

        System.out.println("Please type the absolute path to the file");
        String absolutePath = scanner.nextLine();

        File file;
        while (true) {
            if (absolutePath != null && !absolutePath.equals("")) {
                file = new File(absolutePath);
                if (file.isAbsolute()) {
                    return file;
                }
                System.out.println("It isn't absolute path");
            } else {
                System.out.println("Incorrect path");
            }
            absolutePath = scanner.nextLine();
        }
    }
}
