package maze;

public class Room {
    public int minX;
    public int minY;
    public int maxX;
    public int maxY;

    public Room(int minX, int minY, int maxX, int maxY) {
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }
}
