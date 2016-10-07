package generator;

import java.awt.*;
import java.util.ArrayList;

public class Room implements iRoom {

    public static final Dimension SIZE_MIN = new Dimension(4, 4);
    public static final Dimension SIZE_MAX = new Dimension(7, 7);
    public Dimension size;
    public ArrayList<Tile> tileList;

    public Room() {
        this.createRoom(Room.SIZE_MIN, Room.SIZE_MAX);
    }

    public Room(final Dimension min, final Dimension max) {
        this.createRoom(min, max);
    }

    public ArrayList<Tile> getAllTiles() {
        return this.tileList;
    }

    public void createRoom(final Dimension min, final Dimension max) {
        this.tileList = new ArrayList<>();
        this.size = this.calculateSize(min, max);
        this.fillRoom();
    }

    public Dimension calculateSize(final Dimension min, final Dimension max) {
        int width = min.width + (int) (Math.random() * max.width);
        int height = min.height + (int) (Math.random() * max.height);
        return new Dimension(width, height);
    }

    public void fillRoom() {
        for (int x = 0; x < size.width; x++) {
            for (int y = 0; y < size.height; y++) {
                Point position = new Point(x, y);
                Tile tile = new Tile(position, Tile.SIZE);
                this.tileList.add(tile);
            }
        }
    }
}
