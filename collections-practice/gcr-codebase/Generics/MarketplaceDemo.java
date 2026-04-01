
import java.util.ArrayList;
import java.util.List;

enum BookCategory {

    FICTION, NON_FICTION, PROGRAMMING
}

enum ClothingCategory {
    MENS, WOMENS, KIDS
}

enum GadgetCategory {
    MOBILE, LAPTOP, ACCESSORY
}

abstract class Product {

    private String id;
    private String name;
    private double price;   // assume within valid range
    private String categoryName;

    public Product(String id, String name, double price, String categoryName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryName = categoryName;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " (" + categoryName + "), price=" + price;
    }
}

class Book extends Product {

    private BookCategory category;

    public Book(String id, String name, double price, BookCategory category) {
        super(id, name, price, category.name());
        this.category = category;
    }

    public BookCategory getCategory() {
        return category;
    }
}

class Clothing extends Product {

    private ClothingCategory category;

    public Clothing(String id, String name, double price, ClothingCategory category) {
        super(id, name, price, category.name());
        this.category = category;
    }

    public ClothingCategory getCategory() {
        return category;
    }
}

class Gadget extends Product {

    private GadgetCategory category;

    public Gadget(String id, String name, double price, GadgetCategory category) {
        super(id, name, price, category.name());
        this.category = category;
    }

    public GadgetCategory getCategory() {
        return category;
    }
}

class ProductCatalog<T extends Product> {

    private List<T> products = new ArrayList<>();

    public void addProduct(T product) {
        products.add(product);
    }

    public void removeProduct(T product) {
        products.remove(product);
    }

    public List<T> getProducts() {
        return products;
    }

    public void displayAll() {
        for (T p : products) {
            System.out.println(p);
        }
    }
}

public class MarketplaceDemo {

    // generic method with bounded type parameter
    public static <T extends Product> void applyDiscount(T product, double percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Invalid discount: " + percentage);
        }
        double oldPrice = product.getPrice();
        double discountAmount = oldPrice * (percentage / 100.0);
        product.setPrice(oldPrice - discountAmount);
    }

    public static void main(String[] args) {
        ProductCatalog<Book> bookCatalog = new ProductCatalog<>();
        ProductCatalog<Clothing> clothingCatalog = new ProductCatalog<>();
        ProductCatalog<Gadget> gadgetCatalog = new ProductCatalog<>();

        Book b1 = new Book("B1", "Clean Code", 800.0, BookCategory.PROGRAMMING);
        Clothing c1 = new Clothing("C1", "T-Shirt", 500.0, ClothingCategory.MENS);
        Gadget g1 = new Gadget("G1", "Smartphone", 15000.0, GadgetCategory.MOBILE);

        bookCatalog.addProduct(b1);
        clothingCatalog.addProduct(c1);
        gadgetCatalog.addProduct(g1);

        // apply discounts using generic method
        MarketplaceDemo.applyDiscount(b1, 10);    // 10% off on book
        MarketplaceDemo.applyDiscount(c1, 5);     // 5% off on clothing
        MarketplaceDemo.applyDiscount(g1, 20);    // 20% off on gadget

        System.out.println("Books:");
        bookCatalog.displayAll();

        System.out.println("Clothing:");
        clothingCatalog.displayAll();

        System.out.println("Gadgets:");
        gadgetCatalog.displayAll();
    }
}
