package SmartCheckout;

// Customer.java
import java.util.List;

public class Customer {
    private final String id;
    private final String name;
    private final List<CartItem> cartItems;

    public Customer(String id, String name, List<CartItem> cartItems) {
        this.id = id;
        this.name = name;
        this.cartItems = cartItems;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public List<CartItem> getCartItems() { return cartItems; }

    @Override
    public String toString() {
        return id + " | " + name;
    }
}

