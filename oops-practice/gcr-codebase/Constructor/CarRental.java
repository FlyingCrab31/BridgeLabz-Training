class CarRental {
    // Attributes
    String customerName;
    String carModel;
    int rentalDays;
    double totalCost;

    // Assume a simple fixed rate per day
    static final double RATE_PER_DAY = 1500.0;

    // Default constructor
    CarRental() {
        this.customerName = "Unknown";
        this.carModel = "Standard";
        this.rentalDays = 1;
        calculateTotalCost();
    }

    // Parameterized constructor
    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        calculateTotalCost();
    }

    // Method to calculate total cost
    void calculateTotalCost() {
        this.totalCost = rentalDays * RATE_PER_DAY;
    }

    // Optional: display rental details
    void displayDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model    : " + carModel);
        System.out.println("Rental Days  : " + rentalDays);
        System.out.println("Total Cost   : " + totalCost);
        System.out.println("------------------------------");
    }

    // Test in main
    public static void main(String[] args) {
        CarRental defaultRental = new CarRental();
        defaultRental.displayDetails();

        CarRental customRental = new CarRental("Rohan", "SUV", 4);
        customRental.displayDetails();
    }
}
