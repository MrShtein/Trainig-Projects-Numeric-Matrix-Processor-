package processor;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private Checker checker;
    private Printer printer;
    private InformationCollector collector;
    private boolean isWorking;

    public Calculator() {
        this.checker = new Checker();
        this.printer = new Printer();
        this.collector = new InformationCollector();
        isWorking = true;
    }

    public void run() {
        while (isWorking) {
            printer.printMenu();
            int menuItem = collector.makeChoice(printer);
            if (menuItem == -1) {
                continue;
            }
            boolean isCorrectMenuChoice = checker.isCorrectMenuValue(menuItem);
            if (isCorrectMenuChoice) {
                selectTheMenuItem(menuItem);
            } else {
                printer.printErrorOutOfNumberInMenu();
            }
        }
    }

    public void selectTheMenuItem(int menuItem) {
        switch (menuItem) {
            case 0:
                isWorking = false;
                break;
            case 1:
                addMatrices();
                break;
            case 2:
                multiplyMatrixByConstant();
                break;
            case 3:
                multiplyMatrices();
                break;
            case 4:
                transposeMatrixMenu();
                break;
            case 5:
                determined();
        }
    }

    public void determined() {
        Matrix matrix = makeMatrix(0);;
        if (matrix == null || matrix.getRows() != matrix.getColumns()) {
            printer.printErrorIncorrectData();
            return;
        }

        double result = determinedMatrix(matrix);
        printer.printDeterminedResult(result);

    }

    public double determinedMatrix(Matrix matrix) {
        if (matrix.getRows() == 1) {
            return matrix.content[0][0];
        } else if (matrix.getRows() == 2) {
            return determinedTwoByTwoMatrix(matrix);
        } else {
            return 0;
        }
    }

    public double determinedMatrixMoreThenTwoByTwo(Matrix matrix) {
        ArrayList<Double> arrayListOfDetermines = new ArrayList<>();
        for (int col = 0; col < matrix.getColumns(); col++) {
            int newRowAndCol = matrix.getColumns() - 1;

            Double digitForMultiply = matrix.content[0][col];
            if  (digitForMultiply == 0) arrayListOfDetermines.add(0.0);


        }
    }

    public Matrix matrixForDetermined(int districtColumnAndRow, Matrix matrix) {
        Matrix newMatrix = new Matrix(matrix.getRows() - 1, matrix.getColumns());

        for (int row = 0, newRow = 0; row < matrix.getRows(); row++) {
            if (row != districtColumnAndRow) {
                for (int col = 0, newCol = 0; col < matrix.getColumns(); col++) {
                    if (col != districtColumnAndRow) {
                        newMatrix.content[newRow][newCol] = matrix.content[row][col];
                        newCol++;
                    }
                }
                newRow++;
            }
        }
        return newMatrix;
    }

    public double determinedTwoByTwoMatrix(Matrix matrix) {
        double a = matrix.content[0][0];
        double b = matrix.content[1][1];
        double c = matrix.content[0][1];
        double d = matrix.content[1][0];
        return a * b - c * d;
    }

    public void selectTransposeMatrix(int menuItem) {
        switch (menuItem) {
            case 1:
                mainDiagonalTranspose();
                break;
            case 2:
                sideDiagonalTranspose();
                break;
            case 3:
                verticalLineTranspose();
                break;
            case 4:
                 horizontalTranspose();
                 break;
        }
    }

    public void horizontalTranspose() {
        ArrayList<Matrix> matrixArrayList = doTwoMatrixForTranspose(true);
        Matrix matrixForTranspose = matrixArrayList.get(0);
        Matrix transposedMatrix = matrixArrayList.get(1);

        for (int row = 0, revRow = matrixForTranspose.getRows() - 1; row < matrixForTranspose.getRows(); row++, revRow--) {
            for (int col = 0; col < matrixForTranspose.getColumns(); col++) {
                transposedMatrix.content[revRow][col] = matrixForTranspose.content[row][col];
            }
        }
        printer.printMatrix(transposedMatrix);
    }

    public void verticalLineTranspose() {
        ArrayList<Matrix> matrixArrayList = doTwoMatrixForTranspose(true);
        Matrix matrixForTranspose = matrixArrayList.get(0);
        Matrix transposedMatrix = matrixArrayList.get(1);

        for (int col = 0, revCol = matrixForTranspose.getColumns() - 1; col < matrixForTranspose.getColumns(); col++, revCol--) {
            for (int row = 0; row < matrixForTranspose.getRows(); row++) {
                transposedMatrix.content[row][revCol] = matrixForTranspose.content[row][col];
            }
        }
        printer.printMatrix(transposedMatrix);
    }

    public void sideDiagonalTranspose() {
        ArrayList<Matrix> matrixArrayList = doTwoMatrixForTranspose(false);
        Matrix matrixForTranspose = matrixArrayList.get(0);
        Matrix transposedMatrix = matrixArrayList.get(1);

        for (int col = matrixForTranspose.getColumns() - 1, revRow = 0; col >= 0; col--, revRow++) {
            for (int row = matrixForTranspose.getRows() - 1, revCol = 0; row >= 0; row--, revCol++) {
                double test = matrixForTranspose.content[row][col];
                transposedMatrix.content[revRow][revCol] = matrixForTranspose.content[row][col];
            }
        }
        printer.printMatrix(transposedMatrix);
    }

    public void mainDiagonalTranspose() {
        ArrayList<Matrix> matrixArrayList = doTwoMatrixForTranspose(false);
        Matrix matrixForTranspose = matrixArrayList.get(0);
        Matrix transposedMatrix = matrixArrayList.get(1);

        for (int col = 0; col < matrixForTranspose.getColumns(); col++) {
            for (int row = 0; row < matrixForTranspose.getRows(); row++) {
                double first = matrixForTranspose.content[row][col];
                transposedMatrix.content[col][row] = matrixForTranspose.content[row][col];
            }
        }
        printer.printMatrix(transposedMatrix);
    }

    public ArrayList<Matrix> doTwoMatrixForTranspose(boolean isVerticalOrHorizontalTranspose) {
        printer.printSizeMatrixPhrase(0);
        int[] matrixSize = collector.getMatrixSize();

        printer.printMatrixPhrase(0);

        Matrix matrixForTranspose = new Matrix(matrixSize[0], matrixSize[1]);
        Matrix transposedMatrix;
        if (isVerticalOrHorizontalTranspose) {
            transposedMatrix = new Matrix(matrixSize[0], matrixSize[1]);
        } else {
            transposedMatrix = new Matrix(matrixSize[1], matrixSize[0]);
        }
        matrixForTranspose.content = collector.getMatrix(matrixSize[0], matrixSize[1]);

        return new ArrayList<>(List.of(matrixForTranspose, transposedMatrix));
    }

    public void transposeMatrixMenu() {
        printer.printTransposeMenu();
        selectTransposeMatrix(collector.makeChoice(printer));
    }

    public void multiplyMatrices() {
        while (true) {
            Matrix firstMatrix = makeMatrix(1);
            Matrix secondMatrix = makeMatrix(2);
            Matrix result = new Matrix(firstMatrix.getRows(), secondMatrix.getColumns());

            if (firstMatrix.getColumns() == secondMatrix.getRows()) {
                for (int rows = 0; rows < firstMatrix.getRows(); rows++) {
                    for (int columns = 0; columns < secondMatrix.getColumns(); columns++) {
                        double multiplyResult = 0;
                        for (int i = 0; i < firstMatrix.getColumns(); i++) {
                            multiplyResult += firstMatrix.content[rows][i] * secondMatrix.content[i][columns];
                        }
                        result.content[rows][columns] = multiplyResult;
                    }
                }
                printer.printMatrix(result);
                break;
            } else {
                printer.printErrorIncorrectData();
            }
        }

    }


    public void multiplyMatrixByConstant() {
        Matrix matrix = makeMatrix(0);
        printer.printConstantPhrase();
        Double constant = collector.getConstantForMultiplying();

        Matrix result = new Matrix(matrix.getRows(), matrix.getColumns());
        for (int rows = 0; rows < result.getRows(); rows++) {
            for (int columns = 0; columns < result.getColumns(); columns++) {
                result.content[rows][columns] = constant * matrix.content[rows][columns];
            }
        }
        printer.printMatrix(result);
    }

    public void addMatrices() {

        Matrix firstMatrix = makeMatrix(1);
        Matrix secondMatrix = makeMatrix(2);
        Matrix result = new Matrix(firstMatrix.getRows(), firstMatrix.getColumns());

        if (firstMatrix.getRows() == secondMatrix.getRows() && firstMatrix.getColumns() == secondMatrix.getColumns()) {
            for (int rows = 0; rows < firstMatrix.getRows(); rows++) {
                for (int columns = 0; columns < firstMatrix.getColumns(); columns++) {
                    result.content[rows][columns] =
                            firstMatrix.content[rows][columns] + secondMatrix.content[rows][columns];
                }
            }
            printer.printMatrix(result);

        } else {
            printer.printErrorIncorrectData();
        }

    }

    public Matrix makeMatrix(int numberOfMatrix) {
        int[] firstMatrixSize;
        printer.printSizeMatrixPhrase(numberOfMatrix);
        firstMatrixSize = collector.getMatrixSize();
        if (!checker.checkMatrixSizeValue(firstMatrixSize)) {
            printer.printErrorIncorrectMatrixSizeValue();
        } else {
            boolean isMatrixValuesTrue = checker.checkMatrixSizeValue(firstMatrixSize);
            if (isMatrixValuesTrue) {
                Matrix matrix = new Matrix(firstMatrixSize[0], firstMatrixSize[1]);
                int firstMatrixRows = matrix.getRows();
                int firstMatrixColumns = matrix.getColumns();
                printer.printMatrixPhrase(numberOfMatrix);
                matrix.content = collector.getMatrix(firstMatrixRows, firstMatrixColumns);
                return matrix;
            } else {
                printer.printErrorIncorrectMatrixSizeValue();
            }
            return null;
        }
        return null;
    }
}
