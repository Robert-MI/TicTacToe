package Game;

import java.util.Scanner;

public class Player {
    private char marker;
    public Player() {
        this.marker = 'X';
    }
    public Player(char marker) {
        this.marker = marker;
    }
    public String getMove(Board board) {
        board.printBoard();
        System.out.println("Please make a move, input row and column numbers only(no spaces)");
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }
    char getMarker() {
        return marker;
    }
    public void setMarker(char marker) {
        this.marker = marker;
    }
}
