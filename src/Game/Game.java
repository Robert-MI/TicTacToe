package Game;

public class Game {
    private Player player1;
    private Player player2;
    private Board board;

    public Game() {
        this.player1 = new Player();
        this.player2 = new Player('O');
        this.board = new Board();
    }

    public Game(Board board){
        this.player1 = new Player();
        this.player2 = new Player('O');
        this.board = board;
    }

    public Game(Board board, Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
    }

    public String playGame() {
        Player current = player1;
        while (true){
            System.out.println(current.getMarker() + " makes move");
            String move = current.getMove(board);
            while (!board.submitMove(move,current.getMarker())){
                if (!(current instanceof Bot)){
                    System.out.println("Invalid move, please try again");
                    System.out.println(current.getMarker() + " makes move");
                }
                move = current.getMove(board);
            }
            if (board.isWinner(current.getMarker())){
                break;
            }
            if (board.isBoardFull()){
                break;
            }
            if (current.getMarker() == player1.getMarker()){
                current = player2;
            }else {
                current = player1;
            }
        }
        return getResult();
    }

    private String getResult(){
        board.printBoard();
        if (board.isWinner(player1.getMarker())){
            return "Wins " + player1.getMarker();
        } else if (board.isWinner(player2.getMarker())) {
            return "Wins " + player2.getMarker();
        }else {
            return "Tie";
        }
    }
}