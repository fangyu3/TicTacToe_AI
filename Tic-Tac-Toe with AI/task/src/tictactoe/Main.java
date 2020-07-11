package tictactoe;

public class Main {

    public static void main(String[] args) {
        GameBoard.initializeBoard();
        GameBoard.printBoard();
        TicTacToe.startGame();
    }
}
