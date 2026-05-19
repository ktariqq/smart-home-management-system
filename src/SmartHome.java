import java.util.ArrayList;
import java.util.List;

public class SmartHome {
    // Attributes
    private String homeId;
    private String homeName;
    private List<Room> rooms;
    private List<User> users;

    // Constructor
    public SmartHome(String homeId, String homeName) {
        this.homeId = homeId;
        this.homeName = homeName;
        this.rooms = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    // Methods
    public void addRoom(Room room) {
        rooms.add(room);
    }
    public void removeRoom(Room room) {
        rooms.remove(room);
    }
    public void addUser(User user) {
        users.add(user);
    }
    public void removeUser(User user) {
        users.remove(user);
    }
    public void getHomeDetails() {
        System.out.println("Smart Home: " + homeName);
        System.out.println("Rooms:");

        for (Room room : rooms) {
            room.getRoomDetails();
            System.out.println();
        }
    }


    // Getters
    public List<Room> getRooms() {
        return rooms;
    }
}
