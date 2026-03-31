import java.util.List;
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}
abstract class Product {
    private int productId;
    private String name;
    private double price; // base price

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Encapsulation: getters/setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {  // if you want it updatable
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {        // validation can be added
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {      // validation can be added
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    // Abstract behavior
    public abstract double calculateDiscount();

    // Helper: default final price calculation
    public double calculateFinalPrice() {
        double tax = (this instanceof Taxable) ? ((Taxable) this).calculateTax() : 0.0;
        return price + tax - calculateDiscount();
    }

    public void printDetails() {
        System.out.println("Product ID: " + productId +
                ", Name: " + name +
                ", Base Price: " + price);
    }
}
class Electronics extends Product implements Taxable {

    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        // Example: 10% discount
        return getPrice() * 0.10;
    }

    @Override
    public double calculateTax() {
        // Example: 18% GST on electronics
        return getPrice() * 0.18;
    }

    @Override
    public String getTaxDetails() {
        return "Electronics Tax: 18% of base price";
    }
}
class Clothing extends Product implements Taxable {

    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        // Example: flat 15% discount
        return getPrice() * 0.15;
    }

    @Override
    public double calculateTax() {
        // Example: 5% tax on clothing
        return getPrice() * 0.05;
    }

    @Override
    public String getTaxDetails() {
        return "Clothing Tax: 5% of base price";
    }
}
class Groceries extends Product { // assume no tax, minimal discount

    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        // Example: 2% discount on groceries
        return getPrice() * 0.02;
    }

    // groceries considered non-taxable here
}
public class EcommPlatform {

    public static void printFinalPrices(List<Product> products) {
        for (Product product : products) {
            double price = product.getPrice();
            double discount = product.calculateDiscount();

            double tax = 0.0;
            String taxDetails = "No tax applicable";

            if (product instanceof Taxable) {
                Taxable taxable = (Taxable) product;
                tax = taxable.calculateTax();
                taxDetails = taxable.getTaxDetails();
            }

            double finalPrice = price + tax - discount;

            System.out.println("----- Product -----");
            product.printDetails();
            System.out.println("Discount: " + discount);
            System.out.println("Tax: " + tax + " (" + taxDetails + ")");
            System.out.println("Final Price: " + finalPrice);
        }
    }

    public static void main(String[] args) {
        Product p1 = new Electronics(1, "Laptop", 60000);
        Product p2 = new Clothing(2, "T-Shirt", 1000);
        Product p3 = new Groceries(3, "Rice 5kg", 500);

        List<Product> productList = List.of(p1, p2, p3);
        printFinalPrices(productList);
    }
}





