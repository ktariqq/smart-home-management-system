import java.time.LocalDateTime;

public class EnergyConsumption implements Monitorable {
    // Attributes
    private String deviceId;
    private double energyUsed;
    private LocalDateTime timestamp;

    // Constructor
    public EnergyConsumption(String deviceId, double energyUsed, LocalDateTime timestamp) {
        this.deviceId = deviceId;
        this.energyUsed = 0;
        this.timestamp = LocalDateTime.now(); // returns current date and time
    }

    // Methods override, implementing Monitorable interface
    @Override
    public void logEnergyUsage(double energyUsed, LocalDateTime timestamp) {
        this.energyUsed += energyUsed;
        this.timestamp = timestamp;
    }
    @Override
    public String getEnergyReport() {
        return "Device ID: " + deviceId + "\nEnergy Used: " + energyUsed + " kWh\nTimestamp: " + timestamp;
    }
}
