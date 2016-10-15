package generator;

import java.awt.*;
import java.util.ArrayList;

public class Level {

    public static final Dimension SIZE_MIN = new Dimension(32, 32);
    public static final Dimension SIZE_MAX = new Dimension(64, 64);

    private ArrayList<Room> roomList;
    private Dimension size;
    private final int maxTries = 200;

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

    private Point findRandomPosition(final Dimension roomSize) {
        int x = (int) (Math.random() * (this.size.width - roomSize.width));
        int y = (int) (Math.random() * (this.size.height - roomSize.height));
        return new Point(x, y);
    }

    private boolean positionAvailable(final Room room) {
        Rectangle roomRectangle = new Rectangle(room.getPosition(), room.getSize());
        for (final Room currentRoom : this.roomList) {
            Rectangle currentRoomRectangle = new Rectangle(currentRoom.getPosition(), currentRoom.getSize());
            if (roomRectangle.intersects(currentRoomRectangle)) {
                return false;
            }
        }
        return true;
    }

    private void fillLevelWithRooms() {
        int capacity = this.size.width * this.size.height;
        int currentTry = 0;
        while (capacity > (Room.SIZE_MAX.width * Room.SIZE_MAX.height) && currentTry <= maxTries) {
            Room room = this.generateRoom();
            Point position = findRandomPosition(room.getSize());
            room.setPosition(position);
            boolean roomPositionAvailable = positionAvailable(room);
            if (roomPositionAvailable) {
                room.fillRoom();
                System.out.println(room);
                this.roomList.add(room);
                capacity -= (room.getSize().width * room.getSize().height);
            } else {
                currentTry++;
                Room.uniqueID--;
            }
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
