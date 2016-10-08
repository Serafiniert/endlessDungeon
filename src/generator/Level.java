package generator;

import java.util.ArrayList;

public class Level {

    private ArrayList<Room> roomList;

    public Level() {
        this.roomList = new ArrayList<>();
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
}
