package generator;

import java.util.ArrayList;

public class Dungeon {

    private ArrayList<Level> levelList;
    private int currentLevel;

    public Dungeon() {
        this.initializeDungeon();
    }

    private void initializeDungeon() {
        this.levelList = new ArrayList<>();
        this.levelList.add(this.generateLevel());
        this.currentLevel = 0;
    }

    private Level generateLevel() {
        return new Level();
    }

    public Level getCurrentLevel() {
        return this.levelList.get(this.currentLevel);
    }

    public ArrayList<Level> getLevelList() {
        return levelList;
    }

    public void setLevelList(final ArrayList<Level> levelList) {
        this.levelList = levelList;
    }

    public void setCurrentLevel(final int currentLevel) {
        this.currentLevel = currentLevel;
    }
}
