package Game;

import java.util.Objects;
import java.util.Scanner;

public class Player {
    private char marker;
    private String name;
    public Player() {
        this.marker = 'X';
        this.name = "Player";
    }
    public Player(String name) {
        this.marker = 'X';
        this.name = name;
    }
    public Player(char marker) {
        this.marker = marker;
        this.name = "Player";
    }
    public Player(char marker, String name) {
        this.marker = marker;
        this.name = name;
    }
    public String getMove(Board board) {
        board.printBoard();
        System.out.println("Please make a move, input row and column numbers only(no spaces)");
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return this.getMarker() == player.getMarker() && this.getName().equals(player.getName());
    }
    char getMarker() {
        return marker;
    }

    public String getName() {
        return name;
    }
    public void setMarker(char marker) {
        this.marker = marker;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player " + '\n' + "marker = " + this.getMarker() + '\n' + "name = " + this.getName();
    }
}
