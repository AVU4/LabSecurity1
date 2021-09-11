package IO;

import Algorithm.ConverterBigram;
import Algorithm.DecryptorBigram;
import Algorithm.ScramblerBigram;
import Algorithm.TableBigram;

import java.io.File;
import java.util.Scanner;

public class UserInterface {


    public void start() {

        FileConverter fileConverter = new FileConverter();
        boolean encryptMode = true;
        TableBigram tableBigram = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the command");
        while (true){
            String command = scanner.nextLine();
            switch (command) {
                case "help" :
                    System.out.println("Warning! When you start app first time, you need to set such parameters as keyword and file");
                    System.out.println("Warning! Encrypt is default mode");
                    System.out.println("set-keyword - command to start to set/change keyword");
                    System.out.println("set-file - command to start to set/change file");
                    System.out.println("set-mode - command to start to set/change mode");
                    System.out.println("help - command to get support information");
                    System.out.println("start - command to start app");
                    System.out.println("exit - command to finish");
                    break;
                case "set-keyword" :
                    System.out.println("Type the keyword");
                    String keyword = scanner.nextLine();
                    while (keyword == null || keyword.equals("") || !keyword.matches("[a-zA-Z]+")) {
                        System.out.println("Incorrect keyword");
                        keyword = scanner.nextLine();
                    }
                    tableBigram = TableBigram.createTableBigram(keyword);
                    System.out.println("The alphabet was created");
                    break;
                case "set-file" :
                    System.out.println("The type path of the file");
                    String path = scanner.nextLine();
                    while (path == null || path.equals("")) {
                        System.out.println("Incorrect path");
                        path = scanner.nextLine();
                    }
                    File file = new File(path);
                    fileConverter.setFile(file);
                    System.out.println("The file was set");
                    break;
                case "set-mode" :
                    System.out.println("The type 'encrypt' or 'decrypt'");
                    String mode = scanner.nextLine();
                    if (mode.equals("encrypt")) {
                        encryptMode = true;
                        System.out.println("The mode is changed");
                    } else if (mode.equals("decrypt")) {
                        encryptMode = false;
                        System.out.println("The mode is changed");
                    }
                    break;
                case "start" :
                    if (tableBigram != null && fileConverter.getFile() != null) {
                        ConverterBigram converterBigram;
                        if (encryptMode) {
                            converterBigram = new ScramblerBigram(tableBigram);
                        } else {
                            converterBigram = new DecryptorBigram(tableBigram);
                        }
                        fileConverter.setConverterBigram(converterBigram);
                        fileConverter.transform();
                    } else {
                        System.out.println("You forgot to set any parameters");
                    }
                    break;
                case "exit" :
                    System.out.println("Exit!");
                    return;
            }
        }
    }
}
