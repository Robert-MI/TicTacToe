package Game;
import java.util.Random;
public class Bot extends Player{
    public enum DIFFICULTY{
        EASY,
        MEDIUM,
        HARD
    }
    private DIFFICULTY difficulty = DIFFICULTY.EASY;
    public Bot() {
        super('X',"Bot");
    }
    public Bot(char marker) {
        super(marker,"Bot");
    }
    public Bot(String name) {
        super('X',name);
    }
    public Bot(DIFFICULTY dif) {
        super('X',"Bot");
        this.difficulty = dif;
    }
    public Bot(char marker, String name) {
        super(marker,name);
    }
    public Bot(char marker, DIFFICULTY difficulty) {
        super(marker);
        this.difficulty = difficulty;
    }

    public Bot(String name, DIFFICULTY difficulty) {
        super(name);
        this.difficulty = difficulty;
    }

    public Bot(char marker, String name, DIFFICULTY dif) {
        super(marker,name);
        difficulty = dif;
    }
    public String getMove(Board board) {
        switch (difficulty){
            case EASY:
                return easy(board);
            case MEDIUM:
                return medium();
            case HARD:
                return hard(board);
            default:
                throw new RuntimeException("no such difficulty");
        }
    }
    private String easy(Board board){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getGameBoard()[i][j] == 0){
                    board.printBoard();
                    String row = "" + (i + 1);
                    String column = "" + (j + 1);
                    return row + column;
                }
            }
        }
        return String.valueOf(33);
    }
    private String medium(){
        Random random = new Random();
        String row = "" + (random.nextInt(3) + 1);
        String column = "" + (random.nextInt(3) + 1);
        return row + column;
    }
    private String hard(Board board){
        //Check for winning positions
        if (!checkForWinning(this.getMarker(),board).equals("")){
            return checkForWinning(this.getMarker(),board);
        }
        //check winning positions for opponent
        char marker2;
        if (this.getMarker() == 'X'){
            marker2 = 'O';
        }else {
            marker2 = 'X';
        }
        if (!checkForWinning(marker2,board).equals("")){
            return checkForWinning(marker2,board);
        }
        if (board.getGameBoard()[1][1] == 0){
            // Take middle
            return "22";
        }if (board.getGameBoard()[0][0] == 0){
            // Take left corner
            return "11";
        }else {
            //Random
            Random rand = new Random();
            String row = "" + (rand.nextInt(3) + 1);
            String column = "" + (rand.nextInt(3) + 1);
            return row + column;
        }
    }
    private static String checkForWinning(char marker, Board board){
        String move = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getGameBoard()[i][j] == '\0'){
                    board.getGameBoard()[i][j] = marker;
                    if (board.isWinner(marker)){
                        board.getGameBoard()[i][j] = '\0';
                        String row = "" + (i + 1);
                        String column = "" + (j + 1);
                        move += row + column;
                        return move;
                    }else {
                        board.getGameBoard()[i][j] = '\0';
                    }
                }
            }
        }
        return move;
    }
}
