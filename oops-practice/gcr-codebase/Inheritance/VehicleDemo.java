// Superclass
class Vehicle {
    protected int maxSpeed;
    protected String fuelType;

    public Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    public void displayInfo() {
        System.out.println("Vehicle -> Max Speed: " + maxSpeed +
                           " km/h, Fuel Type: " + fuelType);
    }
}
class Car extends Vehicle {
    private int seatCapacity;

    public Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    @Override
    public void displayInfo() {
        System.out.println("Car -> Max Speed: " + maxSpeed +
                           " km/h, Fuel Type: " + fuelType +
                           ", Seat Capacity: " + seatCapacity);
    }
}

class Truck extends Vehicle {
    private double loadCapacity; // in tons

    public Truck(int maxSpeed, String fuelType, double loadCapacity) {
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void displayInfo() {
        System.out.println("Truck -> Max Speed: " + maxSpeed +
                           " km/h, Fuel Type: " + fuelType +
                           ", Load Capacity: " + loadCapacity + " tons");
    }
}

class Motorcycle extends Vehicle {
    private boolean hasCarrier;

    public Motorcycle(int maxSpeed, String fuelType, boolean hasCarrier) {
        super(maxSpeed, fuelType);
        this.hasCarrier = hasCarrier;
    }

    @Override
    public void displayInfo() {
        System.out.println("Motorcycle -> Max Speed: " + maxSpeed +
                           " km/h, Fuel Type: " + fuelType +
                           ", Has Carrier: " + hasCarrier);
    }
}
public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle v1 = new Car(180, "Petrol", 5);
        Vehicle v2 = new Truck(120, "Diesel", 10.5);
        Vehicle v3 = new Motorcycle(150, "Petrol", true);

        Vehicle[] vehicles = { v1, v2, v3 }; // polymorphic array

        for (Vehicle v : vehicles) {
            v.displayInfo();  // dynamic dispatch
        }
    }
}
