package generator;

import java.awt.*;
import java.util.ArrayList;

public class Dungeon {

    public static final Dimension SIZE_MIN = new Dimension(16, 16);
    public static final Dimension SIZE_MAX = new Dimension(32, 32);

    private ArrayList<Level> levelList;
    private int currentLevel;
    private Dimension size;

    public Dungeon() {
        this.createDungeon(Dungeon.SIZE_MIN, Dungeon.SIZE_MAX);
    }

    public Dungeon(final Dimension min, final Dimension max) {
        this.createDungeon(min, max);
    }

    private void createDungeon(final Dimension min, final Dimension max) {
        this.size = new RandomDimension(min, max).getSize();
        this.levelList = new ArrayList<>();
        Level level = new Level();
        level.addRoom();
        this.levelList.add(level);
        this.currentLevel = 0;
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

    public Dimension getSize() {
        return size;
    }

    public void setSize(final Dimension size) {
        this.size = size;
    }
}
