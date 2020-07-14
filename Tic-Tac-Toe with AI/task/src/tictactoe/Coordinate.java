package tictactoe;

public class Coordinate {
    private int X;
    private int Y;
    private int rowIdx;
    private int colIdx;

    public Coordinate(int num1, int num2,boolean isCoordinate) {
        if(isCoordinate) {
            X = num1;
            Y = num2;
            tranform2DArrIdx();
        }
        else{
            rowIdx = num1;
            colIdx = num2;
        }
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
