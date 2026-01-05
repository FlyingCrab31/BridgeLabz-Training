// GPS interface
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Abstract class Vehicle
abstract class Vehicle implements GPS {

    // Encapsulated fields
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    // Constructor
    public Vehicle(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = currentLocation;
    }

    // Abstract method for fare calculation
    public abstract double calculateFare(double distance);

    // Concrete method
    public String getVehicleDetails() {
        return "Vehicle ID: " + vehicleId +
               ", Driver: " + driverName +
               ", Rate/km: " + ratePerKm +
               ", Location: " + currentLocation;
    }

    // Encapsulated getters and setters with validation
    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        if (vehicleId != null && !vehicleId.isEmpty()) {
            this.vehicleId = vehicleId;
        }
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        if (driverName != null && !driverName.isEmpty()) {
            this.driverName = driverName;
        }
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public void setRatePerKm(double ratePerKm) {
        if (ratePerKm > 0) {
            this.ratePerKm = ratePerKm;
        }
    }

    // GPS implementation
    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        if (newLocation != null && !newLocation.isEmpty()) {
            this.currentLocation = newLocation;
        }
    }
}

class Car extends Vehicle {
    public Car(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
}

class Bike extends Vehicle {

    public Bike(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        // Example: bikes give a small discount
        double baseFare = getRatePerKm() * distance;
        return baseFare * 0.9;
    }
}

class Auto extends Vehicle {
    public Auto(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        // Example: autos may have a minimum fare
        double fare = getRatePerKm() * distance;
        double minFare = 30.0;
        return fare < minFare ? minFare : fare;
    }
}
public class RideHailingApp {

    // Polymorphic method: works for any Vehicle subtype
    public static double calculateRideFare(Vehicle vehicle, double distance) {
        return vehicle.calculateFare(distance);
    }

    public static void main(String[] args) {
        Vehicle car = new Car("CAR101", "Rahul", 15.0, "Sector 18, Noida");
        Vehicle bike = new Bike("BIK202", "Aman", 8.0, "Alpha 1, Greater Noida");
        Vehicle auto = new Auto("AUT303", "Suresh", 10.0, "Pari Chowk, Greater Noida");

        double distance = 12.5; // in km

        System.out.println(car.getVehicleDetails());
        System.out.println("Car fare: " + calculateRideFare(car, distance));

        System.out.println(bike.getVehicleDetails());
        System.out.println("Bike fare: " + calculateRideFare(bike, distance));

        System.out.println(auto.getVehicleDetails());
        System.out.println("Auto fare: " + calculateRideFare(auto, distance));

        // Demonstrate GPS usage
        car.updateLocation("Wave City Center, Noida");
        System.out.println("Car new location: " + car.getCurrentLocation());
    }
}


