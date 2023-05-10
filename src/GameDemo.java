import Game.Board;
import Game.Bot;
import Game.Game;
import Game.Player;
import java.util.Scanner;

public class GameDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Tic Tac Toe");
        while (true){
            System.out.println("For multiplayer press M");
            System.out.println("For single player press S");
            System.out.println("For quitting press Q");
            String choice = sc.next();
            if (choice.equals("S") || choice.equals("s")){
                Game game;
                while (true){
                    System.out.println("Please choose difficulty");
                    System.out.println("For easy press E");
                    System.out.println("For medium press M");
                    System.out.println("For hard press H");
                    System.out.println("For quitting press Q");
                    String dif = sc.next();
                    Bot.DIFFICULTY difficulty;
                    if (dif.equals("h") || dif.equals("H")){
                        difficulty = Bot.DIFFICULTY.HARD;
                    } else if (dif.equals("m") || dif.equals("M")) {
                        difficulty = Bot.DIFFICULTY.MEDIUM;
                    } else if (dif.equals("e") || dif.equals("E")) {
                        difficulty = Bot.DIFFICULTY.EASY;
                    }else if (dif.equals("q") || dif.equals("Q")){
                        break;
                    }else {
                        continue;
                    }
                    while (true){
                        System.out.println("For X press X for O press O");
                        System.out.println("For quitting press Q");
                        String marker = sc.next();
                        if (marker.equals("X") || marker.equals("x")){
                            game = new Game(new Board(),new Player(), new Bot('O',difficulty));
                            String result = game.playGame();
                            System.out.println();
                            System.out.println("-----------------------");
                            System.out.println("Result: " + result);
                            System.out.println();
                            break;
                        }else if (marker.equals("O") || marker.equals("o") || marker.equals("0")){
                            game = new Game(new Board(), new Bot(difficulty),new Player('O'));
                            String result = game.playGame();
                            System.out.println();
                            System.out.println("-----------------------");
                            System.out.println("Result: " + result);
                            System.out.println();
                            break;
                        }else if (marker.equals("Q") || marker.equals("q")){
                            break;
                        }
                    }
                }
            }else if (choice.equals("M") || choice.equals("m")){
                Game game = new Game();
                String result = game.playGame();
                System.out.println();
                System.out.println("-----------------------");
                System.out.println("Result: " + result);
                System.out.println();
            }else if (choice.equals("Q") || choice.equals("q")){
                break;
            }
        }
        System.out.println("Number of Players: " + Player.getPlayerCounter());
        System.out.println("Number of Bots: " + Bot.getBotCounter());
    }
}