import game.Game;
import game.GameWindow;

public class Main {

    public static void main(final String[] args) {
        GameWindow gw = new GameWindow();
        gw.window.add(new Game());
    }

}
