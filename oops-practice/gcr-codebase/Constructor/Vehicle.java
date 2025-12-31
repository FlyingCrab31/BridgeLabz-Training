class Vehicle {
    // Instance variables
    String ownerName;
    String vehicleType;

    // Class variable (same for all vehicles)
    static double registrationFee = 5000.0;

    // Constructor to initialize vehicle details
    Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance method to display vehicle details
    void displayVehicleDetails() {
        System.out.println("Owner Name      : " + ownerName);
        System.out.println("Vehicle Type    : " + vehicleType);
        System.out.println("Registration Fee: " + registrationFee);
        System.out.println("-----------------------------");
    }

    // Class method to update registration fee
    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    // Test in main
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Rohan", "Car");
        Vehicle v2 = new Vehicle("Kiran", "Bike");

        v1.displayVehicleDetails();
        v2.displayVehicleDetails();

        // Change registration fee for all vehicles
        Vehicle.updateRegistrationFee(6000.0);

        v1.displayVehicleDetails();
        v2.displayVehicleDetails();
    }
}
