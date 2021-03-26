package g55836.LuckyNumbers.model;

/**
 * @author Kerdoudi Zakaria
 * Position take the row and column as parameter and return the row and column
 */


public class Position {
    private final int row, column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
