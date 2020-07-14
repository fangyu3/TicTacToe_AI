package tictactoe;

import java.util.ArrayList;
import java.util.List;

public abstract class GameBoard {
    private static char[][] board;
    private static int xCount;
    private static int oCount;
    private static final int ROW=3;
    private static final int COL=3;

    public static int getoCount() {
        return oCount;
    }

    public static int getxCount() {
        return xCount;
    }

    public static int getCOL() {
        return COL;
    }

    public static int getROW() {
        return ROW;
    }

    public static char[][] getBoard() {
        return board;
    }

    public static List<Coordinate> getEmptySpots() {
        List<Coordinate> emptySpots = new ArrayList<>();
        for (int row=0;row<ROW;row++){
            for (int col=0;col<COL;col++){
                if (board[row][col] == ' ') {
                    Coordinate coordinate = new Coordinate(row,col,false);
                    emptySpots.add(coordinate);
                }
            }
        }
        return emptySpots;
    }

    public static void initializeBoard() {
        board = new char[3][3];
        xCount = 0;
        oCount = 0;
        for (int row=0; row<ROW; row++){
            for (int col=0; col<COL; col++){
                board[row][col] = ' ';
            }
        }
    }

    public static void printBoard() {
        System.out.println("---------");
        for (int row=0; row<ROW; row++){
            for (int col=0; col<COL; col++){
                if(col == 0)
                    System.out.print("| ");

                System.out.print(board[row][col]+" ");

                if(col == 2)
                    System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("---------");
    }

    public static boolean addToBoard(char symbol,int row,int col) {
        if(board[row][col] == ' '){
            if(symbol == 'X')
                xCount++;
            else if (symbol == 'O')
                oCount++;

            board[row][col] = symbol;
//            System.out.println("Successfully added!");
            return true;
        }
        else {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }
    }

    public static char checkGameEnd() {
        // Check Row
        for (int row=0; row<ROW; row ++){
            if(board[row][0] == board[row][1] && board[row][1] == board[row][2] && board[row][0]!=' '){
                return board[row][0];
            }
        }

        // Check Column
        for (int col=0; col<COL; col ++){
            if(board[0][col] == board[1][col] && board[1][col] == board[2][col] && board[0][col]!=' '){
                return board[0][col];
            }
        }

        // Check Diagonal
        if (board[1][1] != ' ' && ((board[0][0]==board[1][1] && board[1][1]==board[2][2]) || (board[0][2]==board[1][1] && board[1][1]==board[2][0])))
        {
            return board[1][1];
        }

        // Check Draw
        if(xCount+oCount==ROW*COL){
            return 'T';
        }

        // Game not end. Continue
        return 'C';
    }

    public static void clearCell(int row, int col){
        if (board[row][col] == 'X')
            xCount--;
        else if (board[row][col] == 'O')
            oCount--;

        board[row][col] = ' ';
    }
}
