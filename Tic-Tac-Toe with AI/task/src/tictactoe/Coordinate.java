package tictactoe;

public class Coordinate {
    private int X;
    private int Y;
    private int rowIdx;
    private int colIdx;

    public Coordinate(int xCoord, int yCoord) {
        X = xCoord;
        Y = yCoord;
        tranform2DArrIdx();
    }

    private void tranform2DArrIdx() {
        rowIdx = 3-Y;
        colIdx = X-1;
    }

    public int getRowIdx() {
        return rowIdx;
    }

    public int getColIdx() {
        return colIdx;
    }
}
