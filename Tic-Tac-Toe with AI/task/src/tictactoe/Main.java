package tictactoe;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static boolean playerTurn = true;

    public static void main(String[] args) {
        GameBoard.initializeBoard();
        GameBoard.printBoard();
        playGame();
    }

    public static void playGame() {
        while (!GameBoard.checkGameEnd()) {
            if(playerTurn)
                playerMove();
            else
                computerMove();
        }
    }

    public static void playerMove() {
        try {
            System.out.println("Enter the coordinates: ");
            int xCoord = scanner.nextInt();
            int yCoord = scanner.nextInt();
            scanner.nextLine();

            if (xCoord < 1 || xCoord > 3 || yCoord < 1 || yCoord > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                return;
            }
            Coordinate coord = new Coordinate(xCoord, yCoord);

            if(!GameBoard.addToBoard('X', coord.getRowIdx(), coord.getColIdx()))
                return;
        }
        catch (java.util.InputMismatchException e){
            System.out.println("You should enter numbers!");
            scanner.nextLine();
            return;
        }

        playerTurn = false;
    }

    public static void computerMove() {
        Random random = new Random();
        System.out.println("Making move level \"easy\"");

        int xCoord = random.nextInt(3)+1;
        int yCoord = random.nextInt(3)+1;

        Coordinate coord = new Coordinate(xCoord, yCoord);

        if(!GameBoard.addToBoard('O', coord.getRowIdx(), coord.getColIdx()))
            return;

        playerTurn = true;
    }
}
