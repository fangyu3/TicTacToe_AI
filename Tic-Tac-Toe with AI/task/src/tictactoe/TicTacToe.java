package tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {

    public static Scanner scanner;

    static{
        scanner = new Scanner(System.in);
    }

    enum Commands{
        start,
        exit,
        user,
        easy,
        medium
    }

    public static void startGame() {
        while(true) {
            System.out.print("Input command: ");
            String option = scanner.nextLine();
            String[] commands = option.split(" ");

            if (checkValidCommands(commands)){
                if(commands[0].equals("exit"))
                    break;
                else if(commands[0].equals("start")){
                    // Play game if commands are valid
                    GameBoard.initializeBoard();
                    GameBoard.printBoard();
                    playGame(commands[1],commands[2]);
                }
            }
            else{
                System.out.println("Bad parameters!");
            }
        }
        scanner.close();
        return;
    }

    public static boolean checkValidCommands(String[] inputCommands) {

        if (inputCommands[0].equals("exit"))
            return true;

        if (inputCommands.length<3)
            return false;

        List<String> validCommands = new ArrayList<>();

        for (Commands command:Commands.values()){
            validCommands.add(command.name());
        }

        for (String command:inputCommands){
            if(!validCommands.contains(command))
                return false;
        }
        return true;
    }

    public static void playGame(String player1, String player2) {

        Player playerX = setPlayerType(player1,'X');
        Player playerO = setPlayerType(player2,'O');

        // 'X' always goes first
        playerX.setPlayerTurn(true);

        while (true) {
            if(playerX.isPlayerTurn()) {
                if(playerX.playerMove()){
                    playerX.setPlayerTurn(false);
                    playerO.setPlayerTurn(true);
                }
            }
            else if (playerO.isPlayerTurn()) {
                if(playerO.playerMove()){
                    playerX.setPlayerTurn(true);
                    playerO.setPlayerTurn(false);
                }
            }

            if (GameBoard.checkGameEnd())
                break;
        }
    }

    public static Player setPlayerType(String playerType,char Symbol) {

        Player player = null;

        switch(playerType){
            case "easy":
                player = new EasyAI(Symbol);
                break;
            case "medium":
                player = new MediumAI(Symbol);
                break;
            case "user":
                player = new HumanPlayer(Symbol,scanner);
                break;
        }

        return player;
    }
}
