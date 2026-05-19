public abstract class Device {
    // Attributes
    private String deviceId;
    private String deviceName;
    private boolean status;

    // Constructor
    public Device(String deviceId, String deviceName) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.status = false;
    }

    // Abstract Methods
    public abstract void turnOn();
    public abstract void turnOff();
    public abstract String getStatus();

    public boolean isStatus() {
        return status;
    }

    // Getters and Setters
    public String getDeviceId() {
        return deviceId;
    }
    public String getDeviceName() {
        return deviceName;
    }
    protected void setStatus(boolean status) {

        this.status = status;
    }
}