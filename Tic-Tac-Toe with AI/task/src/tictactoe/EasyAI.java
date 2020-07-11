package tictactoe;

import java.util.Random;

public class EasyAI extends Player{
    public EasyAI(char symbol) {
        super(symbol);
    }

    @Override
    public boolean playerMove() {
        Random random = new Random();
        System.out.println("Making move level \"easy\"");

        int xCoord = random.nextInt(3)+1;
        int yCoord = random.nextInt(3)+1;

        Coordinate coord = new Coordinate(xCoord, yCoord);

        return GameBoard.addToBoard(getSymbol(), coord.getRowIdx(), coord.getColIdx());
    }
}
