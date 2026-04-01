package SmartCheckout;
 // Product.java
public class Product {
    private final String id;
    private final String name;
    private final double price;
    private int stock;

    public Product(String id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    public boolean hasSufficientStock(int qty) {
        return stock >= qty;
    }

    public void reduceStock(int qty) {
        if (qty <= 0) return;
        if (qty > stock) {
            throw new IllegalArgumentException("Not enough stock for product: " + id);
        }
        stock -= qty;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + price + " | stock=" + stock;
    }
}
