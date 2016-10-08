package generator;

import java.awt.*;
import java.util.ArrayList;

public class Room {

    public static final Dimension SIZE_MIN = new Dimension(4, 4);
    public static final Dimension SIZE_MAX = new Dimension(7, 7);

    private Dimension size;
    private ArrayList<Tile> tileList;

    public Room() {
        this.createRoom(Room.SIZE_MIN, Room.SIZE_MAX);
    }

    public Room(final Dimension min, final Dimension max) {
        this.createRoom(min, max);
    }

    public ArrayList<Tile> getAllTiles() {
        return this.tileList;
    }

    private void createRoom(final Dimension min, final Dimension max) {
        this.tileList = new ArrayList<>();
        this.size = new RandomDimension(min, max).getSize();
        this.fillRoom();
    }

    public Dimension getSize() {
        return size;
    }

    public void setSize(final Dimension size) {
        this.size = size;
    }

    public ArrayList<Tile> getTileList() {
        return tileList;
    }

    public void setTileList(final ArrayList<Tile> tileList) {
        this.tileList = tileList;
    }

    private void fillRoom() {
        for (int x = 0; x < this.size.width; x++) {
            for (int y = 0; y < this.size.height; y++) {
                Point position = new Point(x * Tile.SIZE.width, y * Tile.SIZE.height);
                Tile tile = new Tile(position, Tile.SIZE);
                this.tileList.add(tile);
            }
        }
    }

}
