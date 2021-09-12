package Algorithm;

public class TableBigramm {

    private char[][] algorithmAlphabet;
    private final static char[] alphabet = new char[]
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

    public static final int rowsInAlphabet = 13;
    public static final int columnsInRow = 5;

    private TableBigramm(char[][] algorithmAlphabet) {
        this.algorithmAlphabet = algorithmAlphabet;
    }


    public static TableBigramm createTableBigramm(String keyword) {

        char[][] algorithmAlphabet = new char[rowsInAlphabet][columnsInRow];

        int i = 0;

        for (int j = 0; j < keyword.length(); j ++) {
            char c = keyword.charAt(j);
            if (keyword.indexOf(c) == j) {
                algorithmAlphabet[i / 5][i % 5] = c;
                i ++;
            }
        }

        for (Character c : alphabet) {
            if (keyword.indexOf(c) == -1) {
                algorithmAlphabet[i / 5][i % 5] = c;
                i ++;
            }
        }

        return new TableBigramm(algorithmAlphabet);
    }


    public char[][] getAlgorithmAlphabet() {
        return algorithmAlphabet;
    }

}
