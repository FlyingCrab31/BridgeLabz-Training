
import java.util.*;

abstract class WarehouseItem {

    private String id;
    private String name;
    private double price;

    public WarehouseItem(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public abstract String getDetails();

    @Override
    public String toString() {
        return "ID: " + id
                + ", Name: " + name
                + ", Price: " + price
                + ", Details: " + getDetails();
    }
}

class Electronics extends WarehouseItem {

    private int warrantyInMonths;

    public Electronics(String id, String name, double price, int warrantyInMonths) {
        super(id, name, price);
        this.warrantyInMonths = warrantyInMonths;
    }

    @Override
    public String getDetails() {
        return "Warranty: " + warrantyInMonths + " months";
    }
}

class Groceries extends WarehouseItem {

    private String expiryDate;

    public Groceries(String id, String name, double price, String expiryDate) {
        super(id, name, price);
        this.expiryDate = expiryDate;
    }

    @Override
    public String getDetails() {
        return "Expiry: " + expiryDate;
    }
}

class Furniture extends WarehouseItem {

    private String material;

    public Furniture(String id, String name, double price, String material) {
        super(id, name, price);
        this.material = material;
    }

    @Override
    public String getDetails() {
        return "Material: " + material;
    }
}

class Storage<T extends WarehouseItem> {

    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public T getItem(int index) {
        return items.get(index);
    }

    public List<T> getAllItems() {
        return items;
    }
}

public class WarehouseUtils {

    // Read-only method using upper bounded wildcard
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {

        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("E101", "Laptop", 55000, 24));
        electronicsStorage.addItem(new Electronics("E102", "Smartphone", 25000, 12));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("G201", "Rice", 1200, "2026-03-10"));
        groceriesStorage.addItem(new Groceries("G202", "Milk", 60, "2026-01-25"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("F301", "Chair", 1500, "Wood"));
        furnitureStorage.addItem(new Furniture("F302", "Table", 3500, "Metal"));

        System.out.println("Electronics:");
        WarehouseUtils.displayItems(electronicsStorage.getAllItems());

        System.out.println("\nGroceries:");
        WarehouseUtils.displayItems(groceriesStorage.getAllItems());

        System.out.println("\nFurniture:");
        WarehouseUtils.displayItems(furnitureStorage.getAllItems());
    }
}
