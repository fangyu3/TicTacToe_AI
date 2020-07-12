package tictactoe;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MediumAI extends Player {
    public MediumAI(char symbol) {
        super(symbol);
    }

    @Override
    public boolean playerMove() {

        System.out.println("Making move level \"medium\"");

        /*
            If it can win in one move (if it has two in a row), it places a third to get three in a row and win.
            If the opponent can win in one move, it plays the third itself to block the opponent to win.
            Otherwise make random move
         */
        if(checkRow() || checkColumn() || checkLeftDiagonal() || checkRightDiagonal())
            return true;

        // Make random move
        Random random = new Random();
        int row = random.nextInt(3);
        int col = random.nextInt(3);

        return GameBoard.addToBoard(getSymbol(), row, col);
    }

    public boolean checkRow() {
        for (int row=0; row<GameBoard.getROW(); row++){
            int numEmpty = 0;
            int emptyRowIdx = 0;
            int emptyColIdx = 0;
            Set<Character> symbolTypes = new HashSet<>();

            // Find the location of the empty cell in a row
            // If there is only one and the two other cells are of same symbol, insert at that cell
            for(int col=0; col<GameBoard.getCOL(); col++){
                if(GameBoard.getBoard()[row][col] == ' '){
                    emptyRowIdx = row;
                    emptyColIdx = col;
                    numEmpty++;
                }
                else {
                    symbolTypes.add(GameBoard.getBoard()[row][col]);
                }
            }
            if(numEmpty == 1 && symbolTypes.size()==1){
                GameBoard.addToBoard(getSymbol(), emptyRowIdx, emptyColIdx);
                return true;
            }
        }
        return false;
    }

    public boolean checkColumn() {
        for (int col=0; col<GameBoard.getCOL(); col++){
            int numEmpty = 0;
            int emptyRowIdx = 0;
            int emptyColIdx = 0;
            Set<Character> symbolTypes = new HashSet<>();

            for(int row=0; row<GameBoard.getROW(); row++){
                if(GameBoard.getBoard()[row][col] == ' '){
                    emptyRowIdx = row;
                    emptyColIdx = col;
                    numEmpty++;
                }
                else {
                    symbolTypes.add(GameBoard.getBoard()[row][col]);
                }
            }
            if(numEmpty == 1 && symbolTypes.size()==1){
                GameBoard.addToBoard(getSymbol(), emptyRowIdx, emptyColIdx);
                return true;
            }
        }
        return false;
    }

    public boolean checkLeftDiagonal() {
        // 00 11 22
        int row=0;
        int col=0;
        int numEmpty = 0;
        int emptyRowIdx = 0;
        int emptyColIdx = 0;
        Set<Character> symbolTypes = new HashSet<>();

        while(row<GameBoard.getROW() && col<GameBoard.getCOL()){
            if(GameBoard.getBoard()[row][col] == ' '){
                emptyRowIdx = row;
                emptyColIdx = col;
                numEmpty++;
            }
            else
                symbolTypes.add(GameBoard.getBoard()[row][col]);

            row++;
            col++;
        }

        if(numEmpty == 1 && symbolTypes.size()==1){
            GameBoard.addToBoard(getSymbol(), emptyRowIdx, emptyColIdx);
            return true;
        }

        return false;
    }

    public boolean checkRightDiagonal() {
        // 02 11 20
        int row=0;
        int col=2;
        int numEmpty = 0;
        int emptyRowIdx = 0;
        int emptyColIdx = 0;
        Set<Character> symbolTypes = new HashSet<>();

        while(row<GameBoard.getROW() && col>=0){
            if(GameBoard.getBoard()[row][col] == ' '){
                emptyRowIdx = row;
                emptyColIdx = col;
                numEmpty++;
            }
            else
                symbolTypes.add(GameBoard.getBoard()[row][col]);

            row++;
            col--;
        }

        if(numEmpty == 1 && symbolTypes.size()==1){
            GameBoard.addToBoard(getSymbol(), emptyRowIdx, emptyColIdx);
            return true;
        }
        return false;
    }
}
