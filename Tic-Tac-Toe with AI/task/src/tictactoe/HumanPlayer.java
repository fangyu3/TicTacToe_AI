package tictactoe;

import java.util.Scanner;

public class HumanPlayer extends Player {

    public Scanner scanner;

    public HumanPlayer(char symbol, Scanner scanner){
        super(symbol);
        this.scanner = scanner;
    }

    @Override
    public boolean playerMove() {
        try {
            System.out.print("Enter the coordinates: ");
            int xCoord = scanner.nextInt();
            int yCoord = scanner.nextInt();
            scanner.nextLine();

            if (xCoord < 1 || xCoord > 3 || yCoord < 1 || yCoord > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                return false;
            }
            Coordinate coord = new Coordinate(xCoord, yCoord,true);

            return GameBoard.addToBoard(getSymbol(), coord.getRowIdx(), coord.getColIdx());
        }
        catch (java.util.InputMismatchException e){
            System.out.println("You should enter numbers!");
            scanner.nextLine();
            return false;
        }
    }
}
