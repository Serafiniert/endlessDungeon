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

    public Dungeon dungeon;
    public Level level;

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
    public void paint(final Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        this.setRenderingMethod(g2d);
        this.drawCurrentLevel(g2d);
    }

    private void drawCurrentLevel(final Graphics2D g2d) {
        if (this.level != null) {
            this.drawRooms(g2d, this.level.getAllRooms());
        }
    }

    private void drawRooms(final Graphics2D g2d, final ArrayList<Room> rooms) {
        for (final Room room : rooms) {
            this.drawTiles(g2d, room.getAllTiles());
        }
    }

    private void drawTiles(final Graphics2D g2d, final ArrayList<Tile> tiles) {
        for (final Tile tile : tiles) {
            this.drawTile(g2d, tile);
        }
    }

    private void drawTile(final Graphics2D g2d, final Tile tile) {
        g2d.draw(tile);
    }

    private void setRenderingMethod(final Graphics2D g2d) {
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);
    }

}
