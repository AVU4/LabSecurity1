package IO;

import Algorithm.ConverterBigram;
import Algorithm.DecryptorBigram;

import java.io.*;
import java.math.BigInteger;

public class FileConverter {

    private File file;
    private ConverterBigram converterBigram;
    private StringBuilder stringBuilder;

    public FileConverter(File file, ConverterBigram converterBigram) {
        this.file = file;
        this.stringBuilder = new StringBuilder();
        this.converterBigram = converterBigram;
    }


    public void transform() {
        if (converterBigram != null) {
            try(
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            ) {
                char[] bigram = new char[2];
                int size;
                while ((size = bufferedReader.read(bigram)) != -1) {
                    if (size == 1) bigram[1] = ' ';
                    char[] newBigram = converterBigram.transform(bigram);
                    stringBuilder.append(newBigram);
                }
                writeFile();
            } catch (IOException exception) {
                System.out.println("Didn't manage to read the file");
            }
        }
    }

    private void writeFile() {
        try (
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))
        ) {
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.flush();
        }catch (IOException exception) {
            System.out.println("Didn't manage to write to the file");
        }
    }

}
