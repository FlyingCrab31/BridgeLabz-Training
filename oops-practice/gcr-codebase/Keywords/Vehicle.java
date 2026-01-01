class Vehicle {

    // 1. Static
    static double registrationFee = 5000.0;   // common for all vehicles
    // Static method to update the fee
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Updated registration fee: " + registrationFee);
    }

    // 3. Final
    private final String registrationNumber;   // unique and cannot be changed

    // Instance fields
    private String ownerName;
    private String vehicleType;

    // 2. This in constructor
    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;  // final initialized here
    }

    // Method to display registration details
    public void displayRegistrationDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Registration Fee: " + registrationFee);
        System.out.println("---------------------------");
    }

    // 4. instanceof usage
    public static void showDetailsIfVehicle(Object obj) {
        if (obj instanceof Vehicle) {              // check before using
            Vehicle v = (Vehicle) obj;             // safe cast after instanceof
            System.out.println("Object is a Vehicle. Showing details:");
            v.displayRegistrationDetails();
        } else {
            System.out.println("Given object is not a Vehicle. Cannot show details.");
        }
    }

    public static void main(String[] args) {
        // Create Vehicle objects
        Vehicle v1 = new Vehicle("Rahul Sharma", "Car", "UP85 AB 1234");
        Vehicle v2 = new Vehicle("Priya Verma", "Bike", "UP85 XY 9876");

        // Display details directly
        v1.displayRegistrationDetails();
        v2.displayRegistrationDetails();

        // Update the static registration fee for all vehicles
        Vehicle.updateRegistrationFee(6000.0);

        // After fee update, check using instanceof and display again
        showDetailsIfVehicle(v1);           // valid Vehicle
        showDetailsIfVehicle("Not a vehicle object");  // not Vehicle
    }
}
