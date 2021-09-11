package Algorithm;

import java.util.Locale;

public class TableBigram {

    private char[][] algorithmAlphabet;
    public static final int rowsInAlphabet = 13;
    public static final int columnsInRow = 5;

    private TableBigram(char[][] algorithmAlphabet) {
        this.algorithmAlphabet = algorithmAlphabet;
    }


    public static TableBigram createTableBigram(String keyword) {

        char[][] algorithmAlphabet = new char[rowsInAlphabet][columnsInRow];

        keyword = keyword.toLowerCase(Locale.ROOT);

        int i = 0;

        for (int j = 0; j < keyword.length(); j ++) {
            char c = keyword.charAt(j);
            if (keyword.indexOf(c) == j) {
                algorithmAlphabet[i / 5][i % 5] = c;
                i ++;
            }
        }

        char[] alphabet = new char[]
                {
                        'A', 'B', 'C', 'D', 'E',
                        'F', 'G', 'H', 'I', 'J',
                        'K', 'L', 'M', 'N', 'O',
                        'P', 'Q', 'R', 'S', 'T',
                        'U', 'V', 'W', 'X', 'Y',
                        'Z', 'a', 'b', 'c', 'd',
                        'e', 'f', 'g', 'h', 'i',
                        'j', 'k', 'l', 'm', 'n',
                        'o', 'p', 'q', 'r', 's',
                        't', 'u', 'v', 'w', 'x',
                        'y', 'z', '-', ',', '.',
                        ' ', ':', ';', '_', '"',
                        '\n', '\t', '\'', '*', '%'
                };

        for (Character c : alphabet) {
            if (keyword.indexOf(c) == -1) {
                algorithmAlphabet[i / 5][i % 5] = c;
                i ++;
            }
        }

        return new TableBigram(algorithmAlphabet);
    }


    public char[][] getAlgorithmAlphabet() {
        return algorithmAlphabet;
    }

}
