public class SmartLock extends Device implements Controllable {
    // Constructor
    public SmartLock(String deviceId, String deviceName) {
        super(deviceId, deviceName);
    }

    // Methods
    @Override
    public void turnOn() {
        setStatus(true);
        System.out.println(getDeviceName() + " is now locked.");  // Lock the SmartLock
    }

    @Override
    public void turnOff() {
        setStatus(false);
        System.out.println(getDeviceName() + " is now unlocked.");  // Unlock the SmartLock
    }

    @Override
    public String getStatus() {
        return getDeviceName() + " is " + (isStatus() ? "locked" : "unlocked");
    }
}
