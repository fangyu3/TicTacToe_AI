package tictactoe;

public abstract class GameBoard {
    private static char[][] board;
    private static int xCount;
    private static int oCount;
    private static final int ROW;
    private static final int COL;


    static {
        board = new char[3][3];
        xCount = 0;
        oCount = 0;
        ROW = 3;
        COL = 3;
    }

    public static int getoCount() {
        return oCount;
    }

    public static int getxCount() {
        return xCount;
    }

    public static void initializeBoard() {
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
            System.out.println("Successfully added!");
            GameBoard.printBoard();
            return true;
        }
        else {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }
    }

    public static boolean checkGameEnd() {
        // Check Draw
        if(xCount+oCount==ROW*COL){
            System.out.println("Draw");
            return true;
        }

        // Check Row
        for (int row=0; row<ROW; row ++){
            if(board[row][0] == board[row][1] && board[row][1] == board[row][2] && board[row][0]!=' '){
                System.out.println(board[row][0] + " wins");
                System.out.println("row win");
                return true;
            }
        }

        // Check Column
        for (int col=0; col<COL; col ++){
            if(board[0][col] == board[1][col] && board[1][col] == board[2][col] && board[0][col]!=' '){
                System.out.println(board[0][col] + " wins");
                System.out.println("col win");
                return true;
            }
        }

        // Check Diagonal

        if (board[1][1] != ' ' && ((board[0][0]==board[1][1] && board[1][1]==board[2][2]) || (board[0][2]==board[1][1] && board[1][1]==board[2][0])))
        {
            System.out.println("diag win");
            System.out.println(board[1][1] + " wins");
            return true;
        }

        // Game not end
        return false;
    }
}
