public class SmartThermostat extends Device implements Controllable {
    // Attributes
    private double temperature;

    // Constructor
    public SmartThermostat(String deviceId, String deviceName) {

        super(deviceId, deviceName);
        this.temperature = 25.0;  // Default temperature
    }

    // Getters and Setters
    public double getTemperature() {
        return temperature;
    }
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    // Methods
    @Override
    public void turnOn() {
        setStatus(true);
        System.out.println(getDeviceName() + " turned on.");
    }

    @Override
    public void turnOff() {
        setStatus(false);
        System.out.println(getDeviceName() + " turned off.");
    }

    @Override
    public String getStatus() {
        return String.valueOf(getTemperature());
    }
}
