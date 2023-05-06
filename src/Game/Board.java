package Game;

public class Board{

    private char[][] gameBoard;

    public Board() {
        gameBoard = new char[3][3];
    }


    void printBoard() {
        System.out.println(this);
    }

    boolean submitMove(String move, char player){
        int row, column;
        if (move.length() != 2) return false;
        try{
            row = Integer.parseInt(String.valueOf(move.charAt(0)));
            column = Integer.parseInt(String.valueOf(move.charAt(1)));
        }catch (NumberFormatException e){
            System.out.println("1");
            return false;
        }
        if (row < 1 || row > 3 || column < 1 || column > 3){
            System.out.println("2");
            return false;
        }
        if (gameBoard[row-1][column-1] != 0){
            System.out.println(gameBoard[row-1][column-1]);
            System.out.println("3");
            return false;
        }
        gameBoard[row-1][column-1] = player;
        return true;
    }

    boolean isBoardFull() {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[0].length; j++) {
                if (gameBoard[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }

    boolean isWinner(char player) {
        for (int i = 0; i < gameBoard.length; i++) {
            if(gameBoard[i][0] == player && gameBoard[i][1] == player && gameBoard[i][2] == player){
                return true;
            }
            if(gameBoard[0][i] == player && gameBoard[1][i] == player && gameBoard[2][i] == player){
                return true;
            }
        }
        if(gameBoard[0][0] == player && gameBoard[1][1] == player && gameBoard[2][2] == player){
            return true;
        }
        if(gameBoard[0][2] == player && gameBoard[1][1] == player && gameBoard[2][0] == player){
            return true;
        }
        return false;
    }


    public String toString(){
        //coverts the board to string like:
        /*      X | O | X
                -----------
                O | X | O
                -----------
                O | X | X*/
        return " " +
                gameBoard[0][0] + " | " +
                gameBoard[0][1] + " | " +
                gameBoard[0][2] +
                "\n-----------\n" +
                " " +
                gameBoard[1][0] + " | " +
                gameBoard[1][1] + " | " +
                gameBoard[1][2] +
                "\n-----------\n" +
                " " +
                gameBoard[2][0] + " | " +
                gameBoard[2][1] + " | " +
                gameBoard[2][2];
    }

    public char[][] getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(char[][] gameBoard) {
        this.gameBoard = gameBoard;
    }
}
