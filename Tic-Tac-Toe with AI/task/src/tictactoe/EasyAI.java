package tictactoe;

import java.util.Random;

public class EasyAI extends Player{
    public EasyAI(char symbol) {
        super(symbol);
    }

    @Override
    public boolean playerMove() {

        // Make random move
        Random random = new Random();
        System.out.println("Making move level \"easy\"");

        int row = random.nextInt(3);
        int col = random.nextInt(3);

        return GameBoard.addToBoard(getSymbol(), row, col);
    }
}
