package tictactoe;

public class HardAI extends Player{

    public HardAI(char symbol) {
        super(symbol);
    }

    public boolean playerMove() {
        System.out.println("Making move level \"hard\"");

        int maxScore = -10;
        Coordinate nextMove = null;
        // Loop through each available spots to find best score
        for (Coordinate spot:GameBoard.getEmptySpots()){
            GameBoard.addToBoard(getSymbol(),spot.getRowIdx(),spot.getColIdx());
            int score = miniMax(false);
            GameBoard.clearCell(spot.getRowIdx(),spot.getColIdx());
            if(score >= maxScore){
                maxScore = score;
                nextMove = spot;
            }
        }

        GameBoard.addToBoard(getSymbol(),nextMove.getRowIdx(),nextMove.getColIdx());
        return true;
    }

    public int miniMax(boolean AITurn) {
        // Terminal case
        char gameStatus = GameBoard.checkGameEnd();
        if (gameStatus != 'C'){
            if (gameStatus == 'T')
                return 0;
            else if(gameStatus == getSymbol())
                return 10;
            else
                return -10;
        }

        int bestScore = 0;

        for (Coordinate spot:GameBoard.getEmptySpots()){
            if(AITurn){
                GameBoard.addToBoard(getSymbol(),spot.getRowIdx(),spot.getColIdx());
                int score = miniMax(false);
                GameBoard.clearCell(spot.getRowIdx(),spot.getColIdx());
                if(score > bestScore){
                    bestScore = score;
                }
            }
            else {
                GameBoard.addToBoard(getSymbol()=='X'?'O':'X',spot.getRowIdx(),spot.getColIdx());
                int score = miniMax(true);
                GameBoard.clearCell(spot.getRowIdx(),spot.getColIdx());
                if(score < bestScore){
                    bestScore = score;
                }
            }
        }
        return bestScore;
    }
}

