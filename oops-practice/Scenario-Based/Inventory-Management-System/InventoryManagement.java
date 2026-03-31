import java.util.HashMap;
import java.util.Map;
interface AlertService {

    void sendLowStockAlert(Product product);
}


// OutOfStockException.java
class OutOfStockException extends Exception {

    public OutOfStockException(String message) {
        super(message);
    }
}


// Product.java
class Product {
    private final String id;
    private String name;
    private int quantity;
    private int reorderLevel;   // low-stock threshold

    public Product(String id, String name, int quantity, int reorderLevel) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.reorderLevel = reorderLevel;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    // Increase stock when new items arrive
    public void addStock(int amount) {
        if (amount > 0) {
            this.quantity += amount;
        }
    }

    // Decrease stock when items are sold or dispatched
    public void reduceStock(int amount) throws OutOfStockException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }
        if (amount > this.quantity) {
            throw new OutOfStockException(
                "Requested " + amount + " of " + name +
                " but only " + quantity + " in stock."
            );
        }
        this.quantity -= amount;
    }

    public boolean isLowStock() {
        return quantity <= reorderLevel;
    }

    @Override
    public String toString() {
        return "Product{id='" + id + "', name='" + name + "', qty=" + quantity +
               ", reorderLevel=" + reorderLevel + "}";
    }
}
// ConsoleAlertService.java
class ConsoleAlertService implements AlertService {

    @Override
    public void sendLowStockAlert(Product product) {
        System.out.println("[ALERT] Low stock for product: " + product.getName() +
                " (ID: " + product.getId() + "), qty=" + product.getQuantity() +
                ", reorderLevel=" + product.getReorderLevel());
    }
}
// InventoryManagement.java
// Inventory.java


class Inventory {

    private final Map<String, Product> products = new HashMap<>();
    private final AlertService alertService;

    public Inventory(AlertService alertService) {
        this.alertService = alertService;
    }

    // Add a new product or replace existing one with same id
    public void addOrUpdateProduct(Product product) {
        products.put(product.getId(), product);
    }

    // Add incoming stock
    public void addStock(String productId, int amount) {
        Product p = products.get(productId);
        if (p != null) {
            p.addStock(amount);
            checkAndAlertLowStock(p);
        } else {
            System.out.println("Product not found: " + productId);
        }
    }

    // Process outgoing order
    public void processOrder(String productId, int quantity) throws OutOfStockException {
        Product p = products.get(productId);
        if (p == null) {
            throw new OutOfStockException("Product with ID " + productId + " not found.");
        }
        p.reduceStock(quantity);
        checkAndAlertLowStock(p);
    }

    // Check all products for low stock
    public void checkLowStockForAll() {
        for (Product p : products.values()) {
            checkAndAlertLowStock(p);
        }
    }

    private void checkAndAlertLowStock(Product p) {
        if (p.isLowStock()) {
            alertService.sendLowStockAlert(p);
        }
    }

    public void printAllProducts() {
        for (Product p : products.values()) {
            System.out.println(p);
        }
    }
}
// Main.java (demo / warehouse staff usage)
public class InventoryManagement {
    public static void main(String[] args) {
        AlertService alertService = new ConsoleAlertService();
        Inventory inventory = new Inventory(alertService);

        // Warehouse staff adding products
        Product p1 = new Product("P101", "Laptop", 20, 5);
        Product p2 = new Product("P102", "Mouse", 50, 10);
        inventory.addOrUpdateProduct(p1);
        inventory.addOrUpdateProduct(p2);

        inventory.printAllProducts();

        // Receiving new stock
        inventory.addStock("P101", 5);

        // Processing orders
        try {
            inventory.processOrder("P101", 18); // may trigger low-stock alert
            inventory.processOrder("P102", 45); // may trigger low-stock alert
            // This will throw OutOfStockException if quantity > available
            inventory.processOrder("P101", 10);
        } catch (OutOfStockException e) {
            System.out.println("Order failed: " + e.getMessage());
        }

        System.out.println("\nFinal Inventory:");
        inventory.printAllProducts();

        // Manual low stock check
        System.out.println("\nManual low stock scan:");
        inventory.checkLowStockForAll();
    }
}



