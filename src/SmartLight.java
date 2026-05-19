public class SmartLight extends Device implements Controllable {

    // Constructor
    public SmartLight(String deviceId, String deviceName) {
        super(deviceId, deviceName);
    }

    //Override Methods
    @Override
    public void turnOn() {
        setStatus(true);
        System.out.println(getDeviceName() + " is now ON.");
    }
    @Override
    public void turnOff() {
        setStatus(false);
        System.out.println(getDeviceName() + " is now OFF.");
    }
    @Override
    public String getStatus() {
        return isStatus() ? "On" : "Off";
    }
}
