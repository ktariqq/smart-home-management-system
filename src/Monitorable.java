// Monitorable interface

public interface Monitorable {
    void logEnergyUsage(double energyUsed, java.time.LocalDateTime timestamp);
    String getEnergyReport();
}
