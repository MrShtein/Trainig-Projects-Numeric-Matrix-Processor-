package processor;

public class Matrix {

    private final int rows;
    private final int columns;
    Double[][] content;


    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        content = new Double[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
