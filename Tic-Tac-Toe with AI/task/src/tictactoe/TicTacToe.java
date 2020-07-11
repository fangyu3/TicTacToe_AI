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
        easy
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

        Player playerX = player1.equals("easy")?new EasyAI('X'):
                                                new HumanPlayer('X',scanner);

        Player playerO = player2.equals("easy")?new EasyAI('O'):
                                                new HumanPlayer('O',scanner);
        playerX.setPlayerTurn(true);

        while (!GameBoard.checkGameEnd()) {
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
        }
    }
}
