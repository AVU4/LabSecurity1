package IO;

import Algorithm.ConverterBigramm;

import java.io.*;

public class FileConverter {

    private File file;
    private ConverterBigramm converterBigramm;
    private StringBuilder stringBuilder;

    public FileConverter() {
        this.stringBuilder = new StringBuilder();
    }

    public void setConverterbigramm(ConverterBigramm converterBigramm) {
        this.converterBigramm = converterBigramm;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void transform() {
        if (converterBigramm != null) {
            try(
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            ) {
                char[] bigramm = new char[2];
                int size;
                while ((size = bufferedReader.read(bigramm)) != -1) {
                    if (size == 1) bigramm[1] = ' ';
                    char[] newBigramm = converterBigramm.transform(bigramm);
                    stringBuilder.append(newBigramm);
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
