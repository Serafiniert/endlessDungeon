package generator;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Room {

    public static int uniqueID = 0;

    public static final Dimension SIZE_MIN = new Dimension(4, 4);
    public static final Dimension SIZE_MAX = new Dimension(7, 7);

    private int id;
    private Color color;
    private Point position;
    private Dimension size;
    private ArrayList<Tile> tileList;

    public Room() {
        this.initializeRoom(Room.SIZE_MIN, Room.SIZE_MAX);
    }

    public Room(final Dimension min, final Dimension max) {
        this.initializeRoom(min, max);
    }

    public ArrayList<Tile> getAllTiles() {
        return this.tileList;
    }

    private void initializeRoom(final Dimension min, final Dimension max) {
        uniqueID++;
        this.id = uniqueID;
        this.color = generateRandomColor(Color.WHITE);
        this.tileList = new ArrayList<>();
        this.size = new RandomDimension(min, max).getSize();
        this.position = new Point(0, 0);
    }

    public Dimension getSize() {
        return size;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(final Point position) {
        this.position = position;
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

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(final Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + this.id +
                ", position=(" + this.position.x + "," + this.position.y + ")" +
                ", size=(" + this.size.width + "," + this.size.height + ")" +
                '}';
    }

    public void fillRoom() {
        for (int x = 0; x < this.size.width; x++) {
            for (int y = 0; y < this.size.height; y++) {
                Point p = new Point(x * Tile.SIZE.width, y * Tile.SIZE.height);
                p.translate(this.position.x * Tile.SIZE.width, this.position.y * Tile.SIZE.height);
                Tile tile = new Tile(p, Tile.SIZE);
                tile.setColor(color);
                this.tileList.add(tile);
            }
        }
    }

    public Color generateRandomColor(final Color mix) {
        Random random = new Random();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);

        if (mix != null) {
            red = (red + mix.getRed()) / 2;
            green = (green + mix.getGreen()) / 2;
            blue = (blue + mix.getBlue()) / 2;
        }

        return new Color(red, green, blue);
    }

}
