import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DeviceMonitor implements Runnable {
    private Device device;

    public DeviceMonitor(Device device) {
        this.device = device;
    }

    @Override
    public void run() {
        System.out.println(device.getDeviceName() + " status: " + device.getStatus());
    }

    public static void startMonitoring(Device device) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        DeviceMonitor monitor = new DeviceMonitor(device);
        executor.scheduleAtFixedRate(monitor, 0, 5, TimeUnit.SECONDS);
    }
}

