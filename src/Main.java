import game.Game;
import game.GameWindow;

import java.awt.*;

public class Main {

    private static final String NAME = "endlessDungeon";
    private static final Dimension WINDOW_SIZE = new Dimension(960, 960);
    private static final Color BACKGROUND_COLOR = Color.RED;

    public static void main(final String[] args) {
        EventQueue.invokeLater(() -> {
            GameWindow gw = new GameWindow(Main.NAME, Main.WINDOW_SIZE, Main.BACKGROUND_COLOR);
            gw.window.add(new Game());
        });
    }

}