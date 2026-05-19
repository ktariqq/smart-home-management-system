import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserCommandProcessor implements Runnable {
    private User user;
    private Device device;
    private boolean turnOn;

    public UserCommandProcessor(User user, Device device, boolean turnOn) {
        this.user = user;
        this.device = device;
        this.turnOn = turnOn;
    }

    @Override
    public void run() {
        user.controlDevice(device, turnOn);
    }

    public static void processCommand(User user, Device device, boolean turnOn) {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        UserCommandProcessor commandProcessor = new UserCommandProcessor(user, device, turnOn);
        executor.submit(commandProcessor);
    }
}

