import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Custom exception
class NoDriverAvailableException extends Exception {
    public NoDriverAvailableException(String message) {
        super(message);
    }
}

// User entity
class User {
    private int userId;
    private String name;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public int getUserId() { return userId; }
    public String getName() { return name; }
}

// Driver entity
class Driver {
    private int driverId;
    private String name;
    private boolean available;

    public Driver(int driverId, String name, boolean available) {
        this.driverId = driverId;
        this.name = name;
        this.available = available;
    }

    public int getDriverId() { return driverId; }
    public String getName() { return name; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}

// Ride status enum
enum RideStatus {
    REQUESTED, ONGOING, COMPLETED, CANCELED
}

// Ride entity
class Ride {
    private int rideId;
    private User user;
    private Driver driver;
    private String pickup;
    private String drop;
    private double fare;
    private RideStatus status;

    public Ride(int rideId, User user, String pickup, String drop) {
        this.rideId = rideId;
        this.user = user;
        this.pickup = pickup;
        this.drop = drop;
        this.status = RideStatus.REQUESTED;
    }

    public int getRideId() { return rideId; }
    public User getUser() { return user; }
    public Driver getDriver() { return driver; }
    public void setDriver(Driver driver) { this.driver = driver; }

    public String getPickup() { return pickup; }
    public String getDrop() { return drop; }

    public double getFare() { return fare; }
    public void setFare(double fare) { this.fare = fare; }

    public RideStatus getStatus() { return status; }
    public void setStatus(RideStatus status) { this.status = status; }

    public void printSummary() {
        System.out.println("Ride ID: " + rideId);
        System.out.println("User: " + user.getName());
        System.out.println("Driver: " + (driver != null ? driver.getName() : "Not assigned"));
        System.out.println("From: " + pickup + " To: " + drop);
        System.out.println("Status: " + status);
        System.out.println("Fare: " + fare);
        System.out.println("------------------------------");
    }
}
// Strategy interface
interface FareCalculator {

    double calculateFare(double distanceKm);
}

// Normal pricing
class NormalFareCalculator implements FareCalculator {
    private static final double BASE_FARE = 50;
    private static final double PER_KM = 10;

    @Override
    public double calculateFare(double distanceKm) {
        return BASE_FARE + PER_KM * distanceKm;
    }
}

// Peak pricing
class PeakFareCalculator implements FareCalculator {
    private FareCalculator baseCalculator;
    private double surgeMultiplier;

    public PeakFareCalculator(FareCalculator baseCalculator, double surgeMultiplier) {
        this.baseCalculator = baseCalculator;
        this.surgeMultiplier = surgeMultiplier;
    }

    @Override
    public double calculateFare(double distanceKm) {
        return baseCalculator.calculateFare(distanceKm) * surgeMultiplier;
    }
}

class RideService {
    private List<Driver> drivers = new ArrayList<>();
    private List<Ride> rides = new ArrayList<>();
    private int nextRideId = 1;

    // Create driver
    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    // Read drivers
    public List<Driver> getDrivers() {
        return drivers;
    }

    // Create ride (booking)
    public Ride bookRide(User user, String pickup, String drop,
                         double distanceKm, boolean isPeakHour)
            throws NoDriverAvailableException {

        Driver assignedDriver = findAvailableDriver();
        if (assignedDriver == null) {
            throw new NoDriverAvailableException("No driver available at the moment.");
        }

        assignedDriver.setAvailable(false);

        Ride ride = new Ride(nextRideId++, user, pickup, drop);
        ride.setDriver(assignedDriver);
        ride.setStatus(RideStatus.ONGOING);

        FareCalculator normal = new NormalFareCalculator();
        FareCalculator calculator = isPeakHour
                ? new PeakFareCalculator(normal, 1.5)
                : normal;

        double fare = calculator.calculateFare(distanceKm);
        ride.setFare(fare);

        rides.add(ride);
        return ride;
    }

    // Update ride status to completed and free driver
    public void completeRide(int rideId) {
        for (Ride ride : rides) {
            if (ride.getRideId() == rideId) {
                ride.setStatus(RideStatus.COMPLETED);
                if (ride.getDriver() != null) {
                    ride.getDriver().setAvailable(true);
                }
                break;
            }
        }
    }

    // Read ride history for a user
    public void printRideHistory(User user) {
        System.out.println("Ride history for " + user.getName() + ":");
        for (Ride ride : rides) {
            if (ride.getUser().getUserId() == user.getUserId()) {
                ride.printSummary();
            }
        }
    }

    // Simple assignment: first available driver
    private Driver findAvailableDriver() {
        for (Driver d : drivers) {
            if (d.isAvailable()) {
                return d;
            }
        }
        return null;
    }
}

public class RideManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        User user = new User(1, "Rishabh");

        RideService rideService = new RideService();
        rideService.addDriver(new Driver(101, "Amit", true));
        rideService.addDriver(new Driver(102, "Sonal", true));

        try {
            System.out.print("Enter pickup location: ");
            String pickup = sc.nextLine();

            System.out.print("Enter drop location: ");
            String drop = sc.nextLine();

            System.out.print("Enter distance (km): ");
            double distance = sc.nextDouble();

            System.out.print("Is it peak hour? (true/false): ");
            boolean isPeak = sc.nextBoolean();

            Ride ride = rideService.bookRide(user, pickup, drop, distance, isPeak);

            System.out.println("\nRide booked successfully!");
            ride.printSummary();

            System.out.println("Completing ride...");
            rideService.completeRide(ride.getRideId());

            System.out.println("\nAfter completion:");
            ride.printSummary();

            System.out.println("\nUser ride history:");
            rideService.printRideHistory(user);

        } catch (NoDriverAvailableException e) {
            System.out.println("Booking failed: " + e.getMessage());
        }

        sc.close();
    }
}




