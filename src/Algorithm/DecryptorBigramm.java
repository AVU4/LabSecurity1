package Algorithm;


public class DecryptorBigramm implements ConverterBigramm {

    private char[][] algorithmAlphabet;

    public DecryptorBigramm(TableBigramm tableBigramm) {
        this.algorithmAlphabet = tableBigramm.getAlgorithmAlphabet();
    }


    @Override
    public char[] transform(char[] bigramm) {

        char[] newbigramm;

        newbigramm = searchInOneColumn(bigramm);
        if (newbigramm != null) {
            return  newbigramm;
        }

        newbigramm = searchInOneRow(bigramm);
        if (newbigramm != null) {
            return newbigramm;
        }

        newbigramm = makeRectangle(bigramm);
        if (newbigramm != null) {
            return newbigramm;
        }

        return bigramm;
    }


    private char[] searchInOneColumn(char[] bigramm) {

        char[] newbigramm = new char[2];

        for (int i = 0; i < TableBigramm.columnsInRow; i ++) {
            int indexOfFirstSymbol = -1;
            int indexOfSecondSymbol = -1;
            for (int j = 0; j < TableBigramm.rowsInAlphabet; j ++) {
                if (algorithmAlphabet[j][i] == bigramm[0]) {
                    indexOfFirstSymbol = j;
                } else if (algorithmAlphabet[j][i] == bigramm[1]) {
                    indexOfSecondSymbol = j;
                }
            }

            if (indexOfFirstSymbol != -1 && indexOfSecondSymbol != -1) {
                if (indexOfFirstSymbol > 0 ) {
                    newbigramm[0] = algorithmAlphabet[indexOfFirstSymbol - 1][i];
                } else if (indexOfFirstSymbol == 0) {
                    newbigramm[0] = algorithmAlphabet[TableBigramm.rowsInAlphabet - 1][i];
                }

                if (indexOfSecondSymbol > 0) {
                    newbigramm[1] = algorithmAlphabet[indexOfSecondSymbol - 1][i];
                } else if (indexOfSecondSymbol == 0) {
                    newbigramm[1] = algorithmAlphabet[TableBigramm.rowsInAlphabet - 1][i];
                }

                return newbigramm;
            }
        }
        return null;
    }

    private char[] searchInOneRow(char[] bigramm) {

        char[] newbigramm = new char[2];

        for (int i = 0; i < TableBigramm.rowsInAlphabet; i ++ ) {
            int indexOfFirstSymbol = -1;
            int indexOfSecondSymbol = -1;
            for (int j = 0; j < TableBigramm.columnsInRow; j ++ ) {

                if (algorithmAlphabet[i][j] == bigramm[0]) {
                    indexOfFirstSymbol = j;
                } else if (algorithmAlphabet[i][j] == bigramm[1]) {
                    indexOfSecondSymbol = j;
                }
            }

            if (indexOfFirstSymbol != -1 && indexOfSecondSymbol != -1) {
                if (indexOfFirstSymbol > 0) {
                    newbigramm[0] = algorithmAlphabet[i][indexOfFirstSymbol - 1];
                } else if (indexOfFirstSymbol == 0) {
                    newbigramm[0] = algorithmAlphabet[i][TableBigramm.columnsInRow - 1];
                }

                if (indexOfSecondSymbol > 0) {
                    newbigramm[1] = algorithmAlphabet[i][indexOfSecondSymbol - 1];
                } else if (indexOfSecondSymbol == 0) {
                    newbigramm[1] = algorithmAlphabet[i][TableBigramm.columnsInRow - 1];
                }

                return newbigramm;
            }
        }

        return null;
    }

    private char[] makeRectangle(char[] bigramm) {

        char[] newbigramm = new char[2];

        int xCoordinateOfFirstSymbol = -1;
        int yCoordinateOfFirstSymbol = -1;
        int xCoordinateOfSecondSymbol = -1;
        int yCoordinateOfSecondSymbol = -1;

        for (int i = 0; i < TableBigramm.rowsInAlphabet; i ++) {
            for (int j = 0; j < TableBigramm.columnsInRow; j ++) {

                if (algorithmAlphabet[i][j] == bigramm[0]) {
                    xCoordinateOfFirstSymbol = i;
                    yCoordinateOfFirstSymbol = j;
                }

                if (algorithmAlphabet[i][j] == bigramm[1]) {
                    xCoordinateOfSecondSymbol = i;
                    yCoordinateOfSecondSymbol = j;
                }
            }
        }

        if (xCoordinateOfFirstSymbol != -1 && xCoordinateOfSecondSymbol != -1 ) {
            newbigramm[0] = algorithmAlphabet[xCoordinateOfFirstSymbol][yCoordinateOfSecondSymbol];
            newbigramm[1] = algorithmAlphabet[xCoordinateOfSecondSymbol][yCoordinateOfFirstSymbol];

            return newbigramm;
        }

        return null;
    }
}
