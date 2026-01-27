package SmartCheckout;

// SmartCheckoutService.java
import java.util.*;

public class SmartCheckoutService {

    // productId -> Product
    private final Map<String, Product> productCatalog = new HashMap<>();
    // queue of customers at one checkout counter
    private final Queue<Customer> customerQueue = new ArrayDeque<>();

    // --- Product / catalog operations ---

    public void addProduct(Product product) {
        productCatalog.put(product.getId(), product);
    }

    public Product getProduct(String productId) {
        return productCatalog.get(productId); // fetch item price/stock from map
    }

    // --- Queue operations ---

    public void addCustomerToQueue(Customer customer) {
        customerQueue.offer(customer); // enqueue
        System.out.println("Added to queue: " + customer);
    }

    public Customer removeCustomerFromQueue() {
        Customer c = customerQueue.poll(); // dequeue
        if (c != null) {
            System.out.println("Removed from queue: " + c);
        }
        return c;
    }

    public boolean hasWaitingCustomers() {
        return !customerQueue.isEmpty();
    }

    // --- Billing / stock update ---

    public double processNextCustomer() {
        Customer customer = customerQueue.poll();
        if (customer == null) {
            System.out.println("No customers in queue.");
            return 0.0;
        }

        System.out.println("Processing customer: " + customer.getName());
        double totalBill = 0.0;

        for (CartItem item : customer.getCartItems()) {
            Product product = productCatalog.get(item.getProductId());
            if (product == null) {
                System.out.println("Product not found: " + item.getProductId());
                continue;
            }

            int qty = item.getQuantity();
            if (!product.hasSufficientStock(qty)) {
                System.out.println("Insufficient stock for " + product.getName()
                        + ", requested=" + qty + ", available=" + product.getStock());
                continue;
            }

            // price from map and update stock
            double lineTotal = product.getPrice() * qty;
            totalBill += lineTotal;
            product.reduceStock(qty);

            System.out.println("Item: " + product.getName()
                    + ", qty=" + qty
                    + ", price=" + product.getPrice()
                    + ", lineTotal=" + lineTotal);
        }

        System.out.println("Total bill for " + customer.getName() + " = " + totalBill);
        return totalBill;
    }

    public void printCatalog() {
        System.out.println("Current catalog / stock:");
        for (Product p : productCatalog.values()) {
            System.out.println(p);
        }
    }
}

