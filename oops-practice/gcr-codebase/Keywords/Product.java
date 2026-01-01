class Product {

    // 1. Static: shared discount for all products
    static double discount = 0.0; // in percentage

    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    // 2. This: instance variables
    private String productName;
    private double price;
    private int quantity;

    // 3. Final: unique, cannot be changed once assigned
    private final int productID;
    private static int idCounter = 1; // used to generate unique IDs

    // Constructor using 'this'
    public Product(String productName, double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;

        this.productID = idCounter++; // assign and then increment
    }

    // Method to calculate total price after static discount
    public double getTotalPrice() {
        double total = price * quantity;
        double discountAmount = total * (discount / 100.0);
        return total - discountAmount;
    }

    // Getters (optional, for printing/usage)
    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getProductID() {
        return productID;
    }


    // 4. instanceof: validate object before processing
    public static void processProduct(Object obj) {
        if (obj instanceof Product) {
            Product p = (Product) obj;   // safe cast
            System.out.println("Processing Product ID: " + p.getProductID());
            System.out.println("Name: " + p.getProductName());
            System.out.println("Quantity: " + p.getQuantity());
            System.out.println("Price per unit: " + p.getPrice());
            System.out.println("Total after discount: " + p.getTotalPrice());
        } else {
            System.out.println("Object is not a Product. Cannot process.");
        }
    }

    public static void main(String[] args) {
        // Update static discount for all products
        Product.updateDiscount(10.0); // 10% discount

        // Create some products
        Product p1 = new Product("Laptop", 50000, 1);
        Product p2 = new Product("Mouse", 500, 2);

        // Process using instanceof validation
        processProduct(p1);
        System.out.println("---------------------");
        processProduct(p2);
        System.out.println("---------------------");
        processProduct("Not a product"); // will go to else part
    }
}
