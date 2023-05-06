package Game;

import java.util.Random;

public class Bot extends Player{
    public Bot() {
        super('X');
    }

    public Bot(char marker) {
        super(marker);
    }
    public String getMove(Board board) {
        String move = "";
        char[][] copyBoard = board.getGameBoard().clone();
        //Check for winning positions
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (copyBoard[i][j] == '\0'){
                    copyBoard[i][j] = this.getMarker();
                    if (board.isWinner(this.getMarker())){
                        copyBoard[i][j] = '\0';
                        String row = "" + (i + 1);
                        String column = "" + (j + 1);
                        move += row + column;
                        return move;
                    }else {
                        copyBoard[i][j] = '\0';
                    }
                }
            }
        }
        if (board.isBoardFull()){
            System.exit(0);
        }
        //check winning positions for opponent
        char marker;
        if (this.getMarker() == 'X'){
            marker = 'O';
        }else {
            marker = 'X';
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (copyBoard[i][j] == '\0'){
                    copyBoard[i][j] = marker;
                    if (board.isWinner(marker)){
                        copyBoard[i][j] = '\0';
                        String row = "" + (i + 1);
                        String column = "" + (j + 1);
                        move += row + column;
                        return move;
                    }else {
                        copyBoard[i][j] = '\0';
                    }
                }
            }
        }

        // Take middle
        if (board.getGameBoard()[1][1] == 0){
            move = "22";
        }else {
            //Random
            Random random = new Random();
            String row = "" + (random.nextInt(3) + 1);
            String column = "" + (random.nextInt(3) + 1);
            move = row + column;
        }
        return move;
    }
}
