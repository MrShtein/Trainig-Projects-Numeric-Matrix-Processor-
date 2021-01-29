package processor;

public class Checker {

    public boolean isCorrectMenuValue(int value) {
        if (value < 0 || value > 5) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkMenuItem(String menuItem) {
        if (menuItem.matches("\\d")) {
            int tempMenuItem = Integer.parseInt(menuItem);
            return tempMenuItem >= 0 && tempMenuItem <= 5;
        }
        return false;
    }

    public boolean checkMatrixSizeValue(int[] matrixSize) {
        if (matrixSize[0] <= 0 || matrixSize[1] <= 0) {
            return false;
        }
        return true;
    }

    public boolean isDouble(Double digit) {
        double temp = Math.abs(digit);
        return temp - Math.floor(temp) != 0;
    }

    public boolean hasDouble(Matrix matrix) {

        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                double temp = Math.abs(matrix.content[i][j]);
                if (temp - Math.floor(temp) != 0) {
                    return true;
                }
            }
        }
        return false;
    }
}

