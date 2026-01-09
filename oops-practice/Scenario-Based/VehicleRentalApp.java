import java.util.*;
//Interface 
interface Irentable{
    double calculateRent(int days);
}

//Abtract class Vehicle 
abstract class Vehicle implements Irentable{
    protected int vehicleId;
    protected String brand;
    protected double rentPerDay;

    Vehicle(int vehicleId, String brand, double rentPerDay){
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.rentPerDay = rentPerDay;
    }

    public abstract String getType();
    public void display(){
        System.out.println("ID : " + vehicleId + ", Type: " + getType() + ", Brand: " + brand + ", Rent per day: " + rentPerDay);
    }
}

//Bike class 
class Bike extends Vehicle{
    Bike(int vehicleId, String brand, double rentPerDay){
        super(vehicleId, brand, rentPerDay);
    }

    @Override
    public String getType(){
        return "Bike";
    }

    @Override
    public double calculateRent(int days){
        return rentPerDay * days;
    }
}


//Car Class
class Car extends Vehicle{
    Car(int vehicleId, String brand, double rentPerDay){
        super(vehicleId, brand, rentPerDay);
    }

    @Override
    public String getType(){
        return "Car";
    }

    @Override
    public double calculateRent(int days){
        return rentPerDay * days;
    }
}
class Truck extends Vehicle{
    Truck(int vehicleId, String brand, double rentPerDay){
        super(vehicleId, brand, rentPerDay);
    }

    @Override
    public String getType(){
        return "Truck";
    }

    @Override
    public double calculateRent(int days){
        return rentPerDay * days;
    }
}

//Main class
public class VehicleRentalApp {
    private static Scanner sc = new Scanner(System.in);
    private static List<Vehicle> vehicles = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- Vehicle Rental System ---");
            System.out.println("1. Add Vehicle");
            System.out.println("2. View Vehicles");
            System.out.println("3. Update Rent");
            System.out.println("4. Delete Vehicle");
            System.out.println("5. Calculate Rent");
            System.out.println("6. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addVehicle();
                case 2 -> viewVehicles();
                case 3 -> updateRent();
                case 4 -> deleteVehicle();
                case 5 -> calculateRent();
                case 6 -> {
                    System.out.println("Thank you!");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    //Create 
    static void addVehicle() {
        System.out.print("Enter Vehicle Type (Bike/Car/Truck): ");
        String type = sc.next();
        System.out.print("Enter Vehicle ID: ");
        int id = sc.nextInt();
        System.out.print("Enter Brand: ");
        String brand = sc.next();
        System.out.print("Enter Rent per Day: ");
        double rent = sc.nextDouble();

        Vehicle vehicle;
        switch (type.toLowerCase()) {
            case "bike" -> vehicle = new Bike(id, brand, rent);
            case "car" -> vehicle = new Car(id, brand, rent);
            case "truck" -> vehicle = new Truck(id, brand, rent);
            default -> {
                System.out.println("Invalid Vehicle Type");
                return;
            }
        }
        vehicles.add(vehicle);
        System.out.println("Vehicle Added Successfully");
    }


    //Read
    static void viewVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available");
            return;
        }
        for (Vehicle v : vehicles) {
            v.display();
        }
    }   

    //Update
    static void updateRent() {      
        System.out.print("Enter Vehicle ID to update rent: ");
        int id = sc.nextInt();
        for (Vehicle v : vehicles) {
            if (v.vehicleId == id) {
                System.out.print("Enter new Rent per Day: ");
                double newRent = sc.nextDouble();
                v.rentPerDay = newRent;
                System.out.println("Rent Updated Successfully");
                return;
            }
        }
        System.out.println("Vehicle not found");
    }

    //delete
    static void deleteVehicle() {
        System.out.print("Enter Vehicle ID to delete: ");
        int id = sc.nextInt();
        Iterator<Vehicle> iterator = vehicles.iterator();
        while (iterator.hasNext()) {
            Vehicle v = iterator.next();
            if (v.vehicleId == id) {
                iterator.remove();
                System.out.println("Vehicle Deleted Successfully");
                return;
            }
        }
        System.out.println("Vehicle not found");
    }

    //Calculate Rent
    static void calculateRent() {

        System.out.print("Enter Vehicle ID to calculate rent: ");
        int id = sc.nextInt();
        for (Vehicle v : vehicles) {
            if (v.vehicleId == id) {
                System.out.print("Enter number of days: ");
                int days = sc.nextInt();
                double totalRent = v.calculateRent(days);
                System.out.println("Total Rent for " + days + " days: " + totalRent);
                return;
            }
        }
        System.out.println("Vehicle not found");
    }
}