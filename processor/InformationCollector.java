package processor;

import java.util.Scanner;

public class InformationCollector {

    private Checker checker;
    private Scanner scanner;

    public InformationCollector() {
        this.checker = new Checker();
        this.scanner = new Scanner(System.in);
    }

    public int makeChoice(Printer printer) {
        Scanner scanner = new Scanner(System.in);
        String choiceNumber = scanner.nextLine();
        boolean isCorrectMenuItem = checker.checkMenuItem(choiceNumber);
        int menuItem = 0;
        if (isCorrectMenuItem) {
            menuItem = Integer.parseInt(choiceNumber);
        } else {
            printer.printErrorOutOfNumberInMenu();
            return -1;
        }
        boolean isCorrectRangeOfMenuItem = checker.isCorrectMenuValue(menuItem);
        if (isCorrectRangeOfMenuItem) {
            return menuItem;
        } else {
            printer.printErrorOutOfNumberInMenu();
            return -1;
        }
    }

    public int[] getMatrixSize() {
        int[] matrixSize = new int[2];
        matrixSize[0] = scanner.nextInt();
        matrixSize[1] = scanner.nextInt();
        return matrixSize;
    }

    public Double[][] getMatrix(int firstMatrixRows, int firstMatrixColumns) {
        Double[][] matrix = new Double[firstMatrixRows][firstMatrixColumns];
        try {
            for (int rows = 0; rows < firstMatrixRows; rows++) {
                for (int columns = 0; columns < firstMatrixColumns; columns++) {
                    matrix[rows][columns] = scanner.nextDouble();
                }
            }
            return matrix;
        } catch (Exception e) {
            new Printer().printErrorIncorrectData();
            return null;
        }
    }

    public Double getConstantForMultiplying() {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (Exception e) {
                new Printer().printErrorIncorrectData();
            }
        }
    }
}
