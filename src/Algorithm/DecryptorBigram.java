package Algorithm;


public class DecryptorBigram implements ConverterBigram {

    private char[][] algorithmAlphabet;

    public DecryptorBigram(TableBigram tableBigram) {
        this.algorithmAlphabet = tableBigram.getAlgorithmAlphabet();
    }


    @Override
    public char[] transform(char[] bigram) {

        char[] newBigram;

        newBigram = searchInOneColumn(bigram);
        if (newBigram != null) {
            return  newBigram;
        }

        newBigram = searchInOneRow(bigram);
        if (newBigram != null) {
            return newBigram;
        }

        newBigram = makeRectangle(bigram);
        if (newBigram != null) {
            return newBigram;
        }

        return bigram;
    }


    private char[] searchInOneColumn(char[] bigram) {

        char[] newBigram = new char[2];

        for (int i = 0; i < TableBigram.columnsInRow; i ++) {
            int indexOfFirstSymbol = -1;
            int indexOfSecondSymbol = -1;
            for (int j = 0; j < TableBigram.rowsInAlphabet; j ++) {
                if (algorithmAlphabet[j][i] == bigram[0]) {
                    indexOfFirstSymbol = j;
                } else if (algorithmAlphabet[j][i] == bigram[1]) {
                    indexOfSecondSymbol = j;
                }
            }

            if (indexOfFirstSymbol != -1 && indexOfSecondSymbol != -1) {
                if (indexOfFirstSymbol > 0 ) {
                    newBigram[0] = algorithmAlphabet[indexOfFirstSymbol - 1][i];
                } else if (indexOfFirstSymbol == 0) {
                    newBigram[0] = algorithmAlphabet[TableBigram.rowsInAlphabet - 1][i];
                }

                if (indexOfSecondSymbol > 0) {
                    newBigram[1] = algorithmAlphabet[indexOfSecondSymbol - 1][i];
                } else if (indexOfSecondSymbol == 0) {
                    newBigram[1] = algorithmAlphabet[TableBigram.rowsInAlphabet - 1][i];
                }

                return newBigram;
            }
        }
        return null;
    }

    private char[] searchInOneRow(char[] bigram) {

        char[] newBigram = new char[2];

        for (int i = 0; i < TableBigram.rowsInAlphabet; i ++ ) {
            int indexOfFirstSymbol = -1;
            int indexOfSecondSymbol = -1;
            for (int j = 0; j < TableBigram.columnsInRow; j ++ ) {

                if (algorithmAlphabet[i][j] == bigram[0]) {
                    indexOfFirstSymbol = j;
                } else if (algorithmAlphabet[i][j] == bigram[1]) {
                    indexOfSecondSymbol = j;
                }
            }

            if (indexOfFirstSymbol != -1 && indexOfSecondSymbol != -1) {
                if (indexOfFirstSymbol > 0) {
                    newBigram[0] = algorithmAlphabet[i][indexOfFirstSymbol - 1];
                } else if (indexOfFirstSymbol == 0) {
                    newBigram[0] = algorithmAlphabet[i][TableBigram.columnsInRow - 1];
                }

                if (indexOfSecondSymbol > 0) {
                    newBigram[1] = algorithmAlphabet[i][indexOfSecondSymbol - 1];
                } else if (indexOfSecondSymbol == 0) {
                    newBigram[1] = algorithmAlphabet[i][TableBigram.columnsInRow - 1];
                }

                return newBigram;
            }
        }

        return null;
    }

    private char[] makeRectangle(char[] bigram) {

        char[] newBigram = new char[2];

        int xCoordinateOfFirstSymbol = -1;
        int yCoordinateOfFirstSymbol = -1;
        int xCoordinateOfSecondSymbol = -1;
        int yCoordinateOfSecondSymbol = -1;

        for (int i = 0; i < TableBigram.rowsInAlphabet; i ++) {
            for (int j = 0; j < TableBigram.columnsInRow; j ++) {

                if (algorithmAlphabet[i][j] == bigram[0]) {
                    xCoordinateOfFirstSymbol = i;
                    yCoordinateOfFirstSymbol = j;
                }

                if (algorithmAlphabet[i][j] == bigram[1]) {
                    xCoordinateOfSecondSymbol = i;
                    yCoordinateOfSecondSymbol = j;
                }
            }
        }

        if (xCoordinateOfFirstSymbol != -1 && xCoordinateOfSecondSymbol != -1 ) {
            newBigram[0] = algorithmAlphabet[xCoordinateOfFirstSymbol][yCoordinateOfSecondSymbol];
            newBigram[1] = algorithmAlphabet[xCoordinateOfSecondSymbol][yCoordinateOfFirstSymbol];

            return newBigram;
        }

        return null;
    }
}
