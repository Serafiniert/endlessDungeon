package generator;

import java.awt.*;
import java.util.ArrayList;

public class Level {

    public static final Dimension SIZE_MIN = new Dimension(16, 16);
    public static final Dimension SIZE_MAX = new Dimension(32, 32);

    private ArrayList<Room> roomList;
    private Dimension size;

    public Level() {
        this.initializeRooms(Level.SIZE_MIN, Level.SIZE_MAX);
    }

    public Level(final Dimension min, final Dimension max) {
        this.initializeRooms(min, max);
    }

    private void initializeRooms(final Dimension min, final Dimension max) {
        this.roomList = new ArrayList<>();
        this.size = new RandomDimension(min, max).getSize();
        this.fillLevelWithRooms();
    }

    private void fillLevelWithRooms() {
        int capacity = this.size.width * this.size.height;
        while (capacity > (Room.SIZE_MAX.width * Room.SIZE_MAX.height)) {
            Room room = this.generateRoom();
            this.roomList.add(room);
            capacity -= (room.getSize().width * room.getSize().height);
        }
    }

    public ArrayList<Room> getAllRooms() {
        return this.roomList;
    }

    public Room generateRoom() {
        return new Room();
    }

    public void addRoom() {
        this.roomList.add(this.generateRoom());
    }

    public ArrayList<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(final ArrayList<Room> roomList) {
        this.roomList = roomList;
    }

    public Dimension getSize() {
        return size;
    }

    public void setSize(final Dimension size) {
        this.size = size;
    }
}
