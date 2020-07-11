package tictactoe;

public abstract class Player {
    private char symbol;
    private boolean playerTurn;

    public Player(char symbol){
        this.symbol = symbol;
        this.playerTurn = false;
    }

    public char getSymbol() {
        return symbol;
    }

    public boolean isPlayerTurn() {
        return playerTurn;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setPlayerTurn(boolean playerTurn) {
        this.playerTurn = playerTurn;
    }

    public abstract boolean playerMove();
}
