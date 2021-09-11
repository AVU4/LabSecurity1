import Algorithm.DecryptorBigram;
import Algorithm.ScramblerBigram;
import Algorithm.TableBigram;
import IO.FileConverter;
import IO.FileReaderWrapper;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Type the keyword");
        Scanner scanner = new Scanner(System.in);
        String keyWord = scanner.nextLine();
        while (keyWord == null || keyWord.equals("")) {
            System.out.println("Incorrect key word");
            System.out.println("The correct key word is English word with length above 0");
            keyWord = scanner.nextLine();
        }

        TableBigram tableBigram = TableBigram.createTableBigram(keyWord);
        File file = FileReaderWrapper.getFile(scanner);

        System.out.println("Type \'y\' if you want to scramble the file, type \'n\' if you want to unscramble the file");

        String mode = scanner.nextLine();
        FileConverter fileConverter;

        if (mode.equals("y")) {
            ScramblerBigram converterBigram = new ScramblerBigram(tableBigram);
            fileConverter = new FileConverter(file, converterBigram);
            fileConverter.transform();
        } else if (mode.equals("n")) {
            DecryptorBigram converterBigram = new DecryptorBigram(tableBigram);
            fileConverter = new FileConverter(file, converterBigram);
            fileConverter.transform();
        }

        System.out.println("The file was transformed");
        //todo Сделать проверку на английский
        //todo Подумать о цикле с true
        //todo Подумать над названием методов
    }
}
