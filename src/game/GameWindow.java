package game;

import javax.swing.*;
import java.awt.*;

public class GameWindow {

    public static final String WINDOW_TITLE = "World";
    public static final Color WINDOW_BACKGROUND = Color.BLACK;
    public static final Dimension WINDOW_SIZE = new Dimension(1024, 768);

    public JFrame window;

    public GameWindow() {
        this.createGameWindow(GameWindow.WINDOW_TITLE, GameWindow.WINDOW_SIZE, GameWindow.WINDOW_BACKGROUND);
    }

    public GameWindow(final String title) {
        this.createGameWindow(title, GameWindow.WINDOW_SIZE, GameWindow.WINDOW_BACKGROUND);
    }

    public GameWindow(final String title, final Dimension size) {
        this.createGameWindow(title, size, GameWindow.WINDOW_BACKGROUND);
    }

    public GameWindow(final String title, final Dimension size, final Color color) {
        this.createGameWindow(title, size, color);
    }

    public void createGameWindow(final String title, final Dimension size, final Color color) {
        this.window = new JFrame(title);
        this.window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.window.setSize(size.width, size.height);
        this.center();
        this.setBackgroundColor(color);
        this.window.setVisible(true);
    }

    private void center() {
        Dimension dim = Toolkit.getDefaultToolkit()
                               .getScreenSize();
        this.window.setLocation(dim.width / 2 - this.window.getSize().width / 2, dim.height / 2 - this.window.getSize().height / 2);
    }

    private void setBackgroundColor(final Color color) {
        this.window.getContentPane()
                   .setBackground(color);

    }

}
