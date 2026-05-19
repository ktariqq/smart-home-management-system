import java.util.ArrayList;
import java.util.List;

public class User {
    // Attributes
    private String userId;
    private String userName;
    private List<Room> managedRooms; // Association with the Room class

    // Constructor
    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.managedRooms = new ArrayList<>();
    }

    // Methods
    public void addRoom(Room room) {
        managedRooms.add(room);
    }
    public void removeRoom(Room room) {
        managedRooms.remove(room);
    }
    public void controlDevice(Device device, boolean turnOn) {
        if (turnOn) {
            device.turnOn();
        } else {
            device.turnOff();
        }
    }
}
