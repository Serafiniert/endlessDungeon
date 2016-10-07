package generator;

import java.awt.*;

public class Tile extends Rectangle {

    public static final Point COORDINATES = new Point(0, 0);
    public static final Dimension SIZE = new Dimension(10, 10);
    public static final Color FILL_COLOR = Color.orange;

    public Color fillColor;

    public Tile() {
        this.createTile(Tile.COORDINATES, Tile.SIZE);
    }

    public Tile(final Dimension size) {
        this.createTile(Tile.COORDINATES, size);
    }

    public Tile(final Point coordinates, final Dimension size) {
        this.createTile(coordinates, size);
    }

    public void createTile(final Point coordinates, final Dimension size) {
        this.setBounds(coordinates.x, coordinates.y, size.width, size.height);
        this.setColor(Tile.FILL_COLOR);
    }

    public void setColor(final Color color) {
        this.fillColor = color;
    }

    @Override
    public String toString() {
        return "Tile(fillColor=" + fillColor + ", " + super.toString() + ")";
    }
}