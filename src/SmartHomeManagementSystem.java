import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SmartHomeManagementSystem extends Application {
    private SmartHome mySmartHome;

    @Override
    public void start(Stage primaryStage) {
        try {
            initializeSystem();

            VBox root = new VBox();
            root.setSpacing(10);

            Label headerLabel = new Label("Smart Home Management System");
            ListView<String> homeDetails = new ListView<>();
            Button refreshButton = new Button("Refresh");
            refreshButton.setOnAction(e -> updateHomeDetails(homeDetails));
            updateHomeDetails(homeDetails);

            // Turning a device on and off
            TextField deviceIdField = new TextField();
            deviceIdField.setPromptText("Device ID");
            Button turnOnButton = new Button("Turn On");
            turnOnButton.setOnAction(e -> controlDevice(deviceIdField.getText(), true));
            Button turnOffButton = new Button("Turn Off");
            turnOffButton.setOnAction(e -> controlDevice(deviceIdField.getText(), false));


            // Changing the temperature
            TextField temperatureField = new TextField();
            temperatureField.setPromptText("New Temperature");
            Button setTemperatureButton = new Button("Set Temperature");
            setTemperatureButton.setOnAction(e -> {
                String deviceId = deviceIdField.getText();
                String newTemperatureStr = temperatureField.getText();
                try {
                    double newTemperature = Double.parseDouble(newTemperatureStr);
                    controlThermostatTemperature(deviceId, newTemperature);
                    updateHomeDetails(homeDetails);
                } catch (NumberFormatException ex) {
                    showError("Invalid temperature input. Please enter a valid number.");
                }
            });


            // UI elements
            root.getChildren().addAll(headerLabel, homeDetails, refreshButton, deviceIdField, turnOnButton, turnOffButton, temperatureField, setTemperatureButton);

            Scene scene = new Scene(root, 400, 300);
            primaryStage.setTitle("Smart Home Management System");
            primaryStage.setScene(scene);
            primaryStage.show();

            startDeviceMonitoring();
        } catch (Exception e) {
            showError("Error initializing the system: " + e.getMessage());
        }
    }

    // Method to control thermostat
    private void controlThermostatTemperature(String deviceId, double newTemperature) {
        try {
            for (Room room : mySmartHome.getRooms()) {
                for (Device device : room.getDevices()) {
                    if (device.getDeviceId().equals(deviceId) && device instanceof SmartThermostat) {
                        SmartThermostat thermostat = (SmartThermostat) device;
                        thermostat.setTemperature(newTemperature);
                        return;
                    }
                }
            }
            showError("Thermostat not found or invalid device ID: " + deviceId);
        } catch (Exception e) {
            showError("Error controlling thermostat temperature: " + e.getMessage());
        }
    }

    private void initializeSystem() throws Exception {
        mySmartHome = new SmartHome("1", "My Smart Home");

        Room livingRoom = new Room("1", "Living Room");
        Room kitchen = new Room("2", "Kitchen");
        Room bedroom = new Room("3", "Bedroom");


        SmartLight livingRoomLight = new SmartLight("1", "Living Room Light");
        SmartThermostat livingRoomThermostat = new SmartThermostat("2", "Living Room Thermostat");

        livingRoom.addDevice(livingRoomLight);
        livingRoom.addDevice(livingRoomThermostat);

        SmartLight kitchenLight = new SmartLight("3", "Kitchen Light");

        kitchen.addDevice(kitchenLight);

        SmartLight bedroomLight = new SmartLight("4", "Bedroom Light");
        SmartLock bedroomLock = new SmartLock("5", "Bedroom Lock");
        SmartThermostat bedroomThermostat = new SmartThermostat("6", "Bedroom Thermostat");

        bedroom.addDevice(bedroomLight);
        bedroom.addDevice(bedroomLock);
        bedroom.addDevice(bedroomThermostat);


        mySmartHome.addRoom(livingRoom);
        mySmartHome.addRoom(kitchen);
        mySmartHome.addRoom(bedroom);


        User user = new User("1", "Kommal");
        user.addRoom(livingRoom);
        user.addRoom(kitchen);
        user.addRoom(bedroom);
        mySmartHome.addUser(user);
    }

    private void updateHomeDetails(ListView<String> homeDetails) {
        homeDetails.getItems().clear();
        for (Room room : mySmartHome.getRooms()) {
            homeDetails.getItems().add("Room: " + room.getRoomName());
            for (Device device : room.getDevices()) {
                homeDetails.getItems().add("  - " + device.getDeviceName() + " (Status: " + (device.getStatus()) + ")");
            }
        }
    }

    private void controlDevice(String deviceId, boolean turnOn) {
        try {
            for (Room room : mySmartHome.getRooms()) {
                for (Device device : room.getDevices()) {
                    if (device.getDeviceId().equals(deviceId)) {
                        if (turnOn) {
                            device.turnOn();
                        } else {
                            device.turnOff();
                        }
                        return;
                    }
                }
            }
            showError("Device not found: " + deviceId);
        } catch (Exception e) {
            showError("Error controlling device: " + e.getMessage());
        }
    }

    private void startDeviceMonitoring() {
        for (Room room : mySmartHome.getRooms()) {
            for (Device device : room.getDevices()) {
                DeviceMonitor monitor = new DeviceMonitor(device);
                Thread monitorThread = new Thread(monitor);
                monitorThread.start();
            }
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        try {
            launch(args);
        } catch (Exception e) {
            System.err.println("Error launching application: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
