package Game;
import java.util.Scanner;

public class Player {
    private char marker;
    private static int counter=0;
    private String name;
    public Player() {
        this.marker = 'X';
        this.name = "Player";
        this.counter++;
    }
    public Player(String name) {
        this.marker = 'X';
        this.name = name;
        this.counter++;
    }
    public Player(char marker) {
        this.marker = marker;
        this.name = "Player";
        this.counter++;
    }
    public Player(char marker, String name) {
        this.marker = marker;
        this.name = name;
        this.counter++;
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
    public static int getPlayerCounter(){
        return counter;
    }
    public void setMarker(char marker) {
        this.marker = marker;
    }
    public static void setPlayerCounter(int number){
        counter = number;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player " + '\n' + "marker = " + this.getMarker() + '\n' + "name = " + this.getName();
    }
}
