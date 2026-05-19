import java.util.ArrayList;
import java.util.List;

public class Room {
    // Attributes
    private String roomId;
    private String roomName;
    private List<Device> devices; // Association with the Device class

    // Constructor
    public Room(String roomId, String roomName) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.devices = new ArrayList<>();
    }

    // Methods
    public void addDevice(Device device) {
        devices.add(device);
    }
    public void removeDevice(Device device) {
        devices.remove(device);
    }
    public void getRoomDetails() {
        System.out.println("Room: " + roomName);
        System.out.println("Devices:");

        for (Device device : devices) {
            System.out.println(device.getDeviceName() + " - " + device.getStatus());
        }
    }


    // Getters
    public List<Device> getDevices() {
        return devices;
    }
    public String getRoomName() {
        return roomName;
    }
}
