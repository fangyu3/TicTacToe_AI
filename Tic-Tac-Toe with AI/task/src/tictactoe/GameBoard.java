package tictactoe;

public abstract class GameBoard {
    private static char[][] board;
    private static int xCount;
    private static int oCount;

    static {
        board = new char[3][3];
        initializeBoard();
        xCount = 0;
        oCount = 0;
    }

    public static int getoCount() {
        return oCount;
    }

    public static int getxCount() {
        return xCount;
    }

    private static void initializeBoard() {
        for (int row=0; row<3; row++){
            for (int col=0; col<3; col++){
                board[row][col] = '_';
            }
        }
    }

    public static void printBoard() {
        System.out.println("---------");
        for (int row=0; row<3; row++){
            for (int col=0; col<3; col++){
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
        if(board[row][col] == '_'){
            if(symbol == 'X')
                xCount++;
            else if (symbol == 'O')
                oCount++;

            board[row][col] = symbol;
            System.out.println("Successfully added!");
            return true;
        }
        else {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }
    }

    public static void checkGameStatus() {
        // Check Draw
        if(xCount+oCount==9){
            System.out.println("Draw");
            return;
        }

        // Check Row
        for (int row=0; row<3; row ++){
            if(board[row][0] == board[row][1] && board[row][1] == board[row][2] && board[row][0]!='_'){
                System.out.println(board[row][0] + " wins");
                return;
            }
        }

        // Check Column
        for (int col=0; col<3; col ++){
            if(board[0][col] == board[1][col] && board[1][col] == board[2][col] && board[0][col]!='_'){
                System.out.println(board[0][col] + " wins");
                return;
            }
        }

        // Check Diagonal

        if ((board[0][0]==board[1][1] && board[1][1]==board[2][2])
                || (board[0][2]==board[1][1] && board[1][1]==board[2][0])
                && board[1][1] != '_')
        {
            System.out.println(board[1][1] + " wins");
            return;
        }

        // Game not end
        System.out.println("Game not finished");
    }
}
