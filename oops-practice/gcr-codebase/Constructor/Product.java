class Product {
    // Instance variables
    String productName;
    double price;

    // Class variable (shared by all Product objects)
    static int totalProducts = 0;

    // Constructor to initialize a product
    Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++; // increment count whenever a new product is created
    }

    // Instance method to display product details
    void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price       : " + price);
        System.out.println("------------------------");
    }

    // Class method to display total number of products
    static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }

    // Test in main
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 55000.0);
        Product p2 = new Product("Mouse", 799.0);
        Product p3 = new Product("Keyboard", 1499.0);

        p1.displayProductDetails();
        p2.displayProductDetails();
        p3.displayProductDetails();

        Product.displayTotalProducts(); // call class method using class name
    }
}