class Device {
    protected String deviceId;
    protected String status;   // e.g., "ON", "OFF", "STANDBY"

    public Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    public void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status   : " + status);
    }
}
class Thermostat extends Device {
    private final double temperatureSetting; // in degrees Celsius

    public Thermostat(String deviceId, String status, double temperatureSetting) {
        super(deviceId, status);       // call Device constructor
        this.temperatureSetting = temperatureSetting;
    }

    @Override
    public void displayStatus() {
        System.out.println("Thermostat ID       : " + deviceId);
        System.out.println("Current Status      : " + status);
        System.out.println("Temperature Setting : " + temperatureSetting + " °C");
    }
}
public class SmartHomeDemo {
    public static void main(String[] args) {
        Thermostat t1 = new Thermostat("TH-101", "ON", 24.5);
        t1.displayStatus();
    }
}
