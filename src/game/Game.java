package game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Game extends JPanel {

    ArrayList gameBoard;

    public Game() {
        this.gameBoard = new ArrayList();
        this.startPainting();
    }

    public Game(final ArrayList gameboard) {
        this.gameBoard = gameboard;
        this.startPainting();
    }

    public void startPainting() {
        this.setBackground(new Color(255, 255, 255, 0));
        Timer timer = new Timer(10, (arg0) -> {
            Game.this.repaint();
        });
        timer.start();
    }

    @Override
    public void paint(final Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        this.setRenderingMethod(g2d);
        this.drawGameBoard(g);
    }

    private void drawGameBoard(final Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        this.setRenderingMethod(g2d);

    }

    private void setRenderingMethod(final Graphics2D g2d) {
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);
    }

}
