package IO;

import Algorithm.ConverterBigram;

import java.io.*;

public class FileConverter {

    private File file;
    private ConverterBigram converterBigram;
    private StringBuilder stringBuilder;

    public FileConverter() {
        this.stringBuilder = new StringBuilder();
    }

    public void setConverterBigram(ConverterBigram converterBigram) {
        this.converterBigram = converterBigram;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
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
            stringBuilder.delete(0, stringBuilder.length());
            System.out.println("The file was transformed");
        }catch (IOException exception) {
            System.out.println("Didn't manage to write to the file");
        }
    }

}
