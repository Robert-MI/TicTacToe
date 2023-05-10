package Game;
public interface Movable {
    String getMove(Board board);
    char getMarker();
    String getName();
    void setMarker(char marker);
    void setName(String marker);
}
