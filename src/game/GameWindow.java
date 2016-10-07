package game;

import javax.swing.*;

public class GameWindow {

    public static final String WINDOW_TITLE = "World";
    public static final int WINDOW_WIDTH = 1024;
    public static final int WINDOW_HEIGHT = 768;

    public JFrame window;

    public GameWindow() {
        this.createGameWindow(GameWindow.WINDOW_TITLE, GameWindow.WINDOW_WIDTH, GameWindow.WINDOW_HEIGHT);
    }

    public GameWindow(final String title) {
        this.createGameWindow(title, GameWindow.WINDOW_WIDTH, GameWindow.WINDOW_HEIGHT);
    }

    public GameWindow(final String title, final int width, final int height) {
        this.createGameWindow(title, width, height);
    }

    public void createGameWindow(final String title, final int width, final int height) {
        this.window = new JFrame(title);

        this.window.setVisible(true);
        this.window.setSize(width, height);
        this.window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
