package processor;

import java.text.DecimalFormat;

public class Printer {

    public void printMenu() {
        System.out.printf("%s. %s\n", Menu.FIRST.getMenuNumber(), Menu.FIRST.getMenuText());
        System.out.printf("%s. %s\n", Menu.SECOND.getMenuNumber(), Menu.SECOND.getMenuText());
        System.out.printf("%s. %s\n", Menu.THIRD.getMenuNumber(), Menu.THIRD.getMenuText());
        System.out.printf("%s. %s\n", Menu.FOURTH.getMenuNumber(), Menu.FOURTH.getMenuText());
        System.out.printf("%s. %s\n", Menu.FIFTH.getMenuNumber(), Menu.FIFTH.getMenuText());
        System.out.printf("%s. %s\n", Menu.SIXTH.getMenuNumber(), Menu.SIXTH.getMenuText());
        System.out.printf("%s. %s\n", Menu.ZERO.getMenuNumber(), Menu.ZERO.getMenuText());
        printChoicePhrase();
    }

    public void printTransposeMenu() {
        System.out.println("1. Main diagonal");
        System.out.println("2. Side diagonal");
        System.out.println("3. Vertical line");
        System.out.println("4. Horizontal line");
        printChoicePhrase();
    }

    public void printDeterminedResult(Double result) {
        if (new Checker().isDouble(result)) {
            DecimalFormat df = new DecimalFormat("0.0#");
            String digit = df.format(result);
            System.out.printf("The result is:\n%s\n\n", digit);
        } else {
            System.out.printf("The result is:\n%d\n\n", result.intValue());
        }
    }

    public void printChoicePhrase() {
        System.out.print("Your choice: ");
    }

    public void printConstantPhrase() {
        System.out.print("Enter constant: ");
    }


    public void printSizeMatrixPhrase(int numberOfMatrix) {
        if (numberOfMatrix == 1) {
            System.out.printf("\nEnter size of %s matrix: ", "first");
        } else if(numberOfMatrix == 0) {
            System.out.print("\nEnter matrix size: ");
        } else {
            System.out.printf("\nEnter size of %s matrix: ", "second");
        }
    }

    public void printMatrixPhrase(int numberOfMatrix) {
        if (numberOfMatrix == 1) {
            System.out.printf("\nEnter %s matrix:\n", "first");
        } else if(numberOfMatrix == 0) {
            System.out.println("Enter matrix:");
        } else {
            System.out.printf("\nEnter %s matrix:\n", "second");
        }
    }

     public void printErrorIncorrectMatrixSizeValue() {
        System.out.println("\nThe values is incorrect. Try other item.\n");
    }

    public void printErrorOutOfNumberInMenu() {
        System.out.println("\nThis item isn't in menu. Try other item.\n");
    }

    public void printErrorIncorrectData() {
        System.out.println("\nThe operation cannot be performed.\n");
    }

    public void printMatrix(Matrix result) {
        System.out.println("\nThe result is:\n");
        DecimalFormat df = new DecimalFormat("0.0#");
        boolean hasDoubleValue = new Checker().hasDouble(result);
        for (int rows = 0; rows < result.getRows(); rows++) {
            for (int columns = 0; columns < result.getColumns(); columns++) {
                if (columns != result.getColumns() - 1) {
                    if (!hasDoubleValue) {
                        System.out.printf("%d ", result.content[rows][columns].intValue());
                    } else {
                        String digit = df.format(result.content[rows][columns]);
                        System.out.printf("%s ", digit);
                    }
                } else {
                    if (!hasDoubleValue) {
                        System.out.printf("%d\n", result.content[rows][columns].intValue());
                    } else {
                        String digit = df.format(result.content[rows][columns]);
                        System.out.printf("%s\n", digit);
                    }
                }
            }
        }
        System.out.println("");
    }
}
