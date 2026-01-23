
import java.util.*;

public class ShoppingCart {

    // Product -> Price
    private Map<String, Double> productPrices = new HashMap<>();

    // Product -> Quantity (in order of addition)
    private Map<String, Integer> cart = new LinkedHashMap<>();

    // Add/define a product in the catalog
    public void addProduct(String name, double price) {
        productPrices.put(name, price);
    }

    // Add item to cart (by product name)
    public void addToCart(String productName, int quantity) {
        if (!productPrices.containsKey(productName)) {
            throw new IllegalArgumentException("Unknown product: " + productName);
        }
        cart.put(productName, cart.getOrDefault(productName, 0) + quantity);
    }

    // Display cart in insertion order (LinkedHashMap)
    public void displayCartInInsertionOrder() {
        System.out.println("Cart (insertion order):");
        double total = 0.0;
        for (Map.Entry<String, Integer> e : cart.entrySet()) {
            String product = e.getKey();
            int qty = e.getValue();
            double price = productPrices.get(product);
            double lineTotal = price * qty;
            total += lineTotal;
            System.out.println(product + " x " + qty
                    + " @ " + price + " = " + lineTotal);
        }
        System.out.println("Total: " + total);
        System.out.println();
    }

    // Display items sorted by price using TreeMap
    public void displayItemsSortedByPrice() {
        // price -> list of product names
        TreeMap<Double, List<String>> priceMap = new TreeMap<>();

        for (String product : cart.keySet()) {
            double price = productPrices.get(product);
            priceMap.computeIfAbsent(price, k -> new ArrayList<>()).add(product);
        }

        System.out.println("Cart items sorted by unit price:");
        for (Map.Entry<Double, List<String>> e : priceMap.entrySet()) {
            double price = e.getKey();
            for (String product : e.getValue()) {
                int qty = cart.get(product);
                double lineTotal = price * qty;
                System.out.println(product + " x " + qty
                        + " @ " + price + " = " + lineTotal);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ShoppingCart sc = new ShoppingCart();

        // Define product catalog (HashMap)
        sc.addProduct("Apple", 10.0);
        sc.addProduct("Milk", 30.0);
        sc.addProduct("Bread", 25.0);
        sc.addProduct("Chocolate", 50.0);

        // Add to cart (LinkedHashMap preserves order)
        sc.addToCart("Apple", 3);      // first
        sc.addToCart("Milk", 1);       // second
        sc.addToCart("Chocolate", 2);  // third
        sc.addToCart("Bread", 1);      // fourth

        // Show in insertion order
        sc.displayCartInInsertionOrder();

        // Show items sorted by price (TreeMap)
        sc.displayItemsSortedByPrice();
    }
}
