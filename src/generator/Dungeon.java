package generator;

import java.util.ArrayList;

public class Dungeon {

    ArrayList<Level> levelList;
    int currentLevel;

    public Dungeon() {
        this.levelList = new ArrayList<>();
        Level level = new Level();
        level.addRoom();
        this.levelList.add(level);
        this.currentLevel = 0;
    }

    public Level getCurrentLevel() {
        return this.levelList.get(this.currentLevel);
    }
}
