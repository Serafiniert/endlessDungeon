package game;

import generator.Dungeon;
import generator.Level;
import generator.Room;
import generator.Tile;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Game extends JPanel {

    public static final Color TRANSPARENT = new Color(255, 255, 255, 0);
    public static final int UPDATE_INTERVAL = 10;
    public static final double SCALE = 1.0;

    public Dungeon dungeon;
    public Level level;

    private boolean redrawIsNeeded = true;

    public Game() {
        this.initializeGame(new Dungeon());
    }

    public Game(final Dungeon dungeon) {
        this.initializeGame(dungeon);
    }

    public void initializeGame(final Dungeon dungeon) {
        this.dungeon = dungeon;
        this.level = this.dungeon.getCurrentLevel();
        this.startPainting();
    }

    public void startPainting() {
        this.setBackground(Game.TRANSPARENT);
        Timer timer = new Timer(Game.UPDATE_INTERVAL, (arg0) -> {
            Game.this.repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        if (this.redrawIsNeeded) {
            Graphics2D g2d = (Graphics2D) g;
            this.setRenderingMethod(g2d);
            g2d.scale(SCALE, SCALE);
            this.drawCurrentLevel(g2d);
            this.redrawIsNeeded = false;
        }
    }

    // TODO: Implement correctly
    @Override
    public void repaint() {
        //super.repaint();
    }

    private void drawCurrentLevel(final Graphics2D g2d) {
        if (this.level != null) {
            this.drawRooms(g2d, this.level.getAllRooms());
            g2d.setStroke(new BasicStroke(1));
            g2d.setPaint(Color.WHITE);
            g2d.drawRect(0, 0, this.level.getSize().width * Tile.SIZE.width, this.level.getSize().height * Tile.SIZE.height);
        }
    }

    private void drawRooms(final Graphics2D g2d, final ArrayList<Room> rooms) {
        for (final Room room : rooms) {
            this.drawTiles(g2d, room.getAllTiles());
            //g2d.drawString("" + room.getId(), room.getPosition().x * Tile.SIZE.width, room.getPosition().y * Tile.SIZE.height);
        }
    }

    private void drawTiles(final Graphics2D g2d, final ArrayList<Tile> tiles) {
        for (final Tile tile : tiles) {
            this.drawTile(g2d, tile);
        }
    }

    private void drawTile(final Graphics2D g2d, final Tile tile) {
        g2d.setPaint(tile.fillColor);
        g2d.fill(tile);
        g2d.setStroke(new BasicStroke(1));
        g2d.setPaint(Color.GRAY);
        g2d.drawRect(tile.x, tile.y, tile.width, tile.height);

    }

    private void setRenderingMethod(final Graphics2D g2d) {
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);
    }

}
