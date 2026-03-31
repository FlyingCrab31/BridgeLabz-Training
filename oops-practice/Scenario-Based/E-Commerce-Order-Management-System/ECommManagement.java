
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Product entity
class Product {

    private final int id;
    private final String name;
    private final double price;
    private int stockQuantity;

    public Product(int id, String name, double price, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }

    public void reduceStock(int qty) {
        if (qty <= 0) throw new IllegalArgumentException("Quantity must be positive");
        if (stockQuantity < qty) throw new IllegalArgumentException("Insufficient stock");
        stockQuantity -= qty;
    }

    public void increaseStock(int qty) {
        if (qty <= 0) throw new IllegalArgumentException("Quantity must be positive");
        stockQuantity += qty;
    }

    @Override
    public String toString() {
        return "Product{" + id + ", " + name + ", " + price + ", stock=" + stockQuantity + "}";
    }
}

// Customer entity
class Customer {
    private final int id;
    private final String name;
    private final String email;

    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return "Customer{" + id + ", " + name + "}";
    }
}

// OrderItem for multiple products in an order
class OrderItem {
    private final Product product;
    private final int quantity;

    public OrderItem(Product product, int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be positive");
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }

    public double getItemTotal() {
        return product.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return product.getName() + " x " + quantity + " = " + getItemTotal();
    }
}

enum OrderStatus {
    CREATED,
    PAID,
    CANCELLED,
    SHIPPED,
    DELIVERED
}

// Custom exception for payment failures
class PaymentFailedException extends Exception {
    public PaymentFailedException(String message) {
        super(message);
    }
}

// Order entity
class Order {
    private final int id;
    private final Customer customer;
    private final List<OrderItem> items = new ArrayList<>();
    private OrderStatus status = OrderStatus.CREATED;

    public Order(int id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    public int getId() { return id; }
    public Customer getCustomer() { return customer; }
    public OrderStatus getStatus() { return status; }

    public void addItem(Product product, int qty) {
        if (status != OrderStatus.CREATED)
            throw new IllegalStateException("Can add items only in CREATED state");
        items.add(new OrderItem(product, qty));
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public double getTotalAmount() {
        double total = 0.0;
        for (OrderItem item : items) {
            total += item.getItemTotal();
        }
        return total;
    }

    public void markPaid() {
        if (status != OrderStatus.CREATED)
            throw new IllegalStateException("Order must be in CREATED state to mark as PAID");
        status = OrderStatus.PAID;
    }

    public void cancel() {
        if (status == OrderStatus.CANCELLED || status == OrderStatus.DELIVERED)
            throw new IllegalStateException("Cannot cancel already cancelled/delivered order");
        status = OrderStatus.CANCELLED;
    }

    public void ship() {
        if (status != OrderStatus.PAID)
            throw new IllegalStateException("Only PAID orders can be shipped");
        status = OrderStatus.SHIPPED;
    }

    public void markDelivered() {
        if (status != OrderStatus.SHIPPED)
            throw new IllegalStateException("Only SHIPPED orders can be delivered");
        status = OrderStatus.DELIVERED;
    }

    @Override
    public String toString() {
        return "Order{" + id + ", " + customer + ", status=" + status +
               ", total=" + getTotalAmount() + "}";
    }
}

// Payment interface
interface Payment {
    void pay(double amount) throws PaymentFailedException;
}

// Card payment implementation
class CardPayment implements Payment {
    private final String cardNumber;

    public CardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) throws PaymentFailedException {
        // dummy logic: fail if amount > 100000
        if (amount <= 0) throw new PaymentFailedException("Invalid amount");
        if (amount > 100000) {
            throw new PaymentFailedException("Card limit exceeded");
        }
        System.out.println("Paid " + amount + " via Card ending " +
                           cardNumber.substring(cardNumber.length() - 4));
    }
}

// UPI payment implementation
class UpiPayment implements Payment {
    private final String upiId;

    public UpiPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(double amount) throws PaymentFailedException {
        if (amount <= 0) throw new PaymentFailedException("Invalid amount");
        // simple mock: simulate random failure
        if (Math.random() < 0.1) {
            throw new PaymentFailedException("UPI network issue");
        }
        System.out.println("Paid " + amount + " via UPI: " + upiId);
    }
}

// Wallet payment implementation
class WalletPayment implements Payment {

    private double walletBalance;

    public WalletPayment(double initialBalance) {
        this.walletBalance = initialBalance;
    }

    @Override
    public void pay(double amount) throws PaymentFailedException {
        if (amount <= 0) throw new PaymentFailedException("Invalid amount");
        if (walletBalance < amount) {
            throw new PaymentFailedException("Insufficient wallet balance");
        }
        walletBalance -= amount;
        System.out.println("Paid " + amount + " via Wallet. Remaining balance: " + walletBalance);
    }
}

class ECommerceService {
    
    private final Map<Integer, Product> productCatalog = new HashMap<>();
    private final Map<Integer, Order> orders = new HashMap<>();
    private int nextOrderId = 1;

    // Product catalog
    public void addProduct(Product product) {
        productCatalog.put(product.getId(), product);
    }

    public List<Product> listProducts() {
        return new ArrayList<>(productCatalog.values());
    }

    // Order placement
    public Order createOrder(Customer customer) {
        Order order = new Order(nextOrderId++, customer);
        orders.put(order.getId(), order);
        return order;
    }

    public void addItemToOrder(int orderId, int productId, int qty) {
        Order order = getOrder(orderId);
        Product product = getProduct(productId);
        product.reduceStock(qty);  // stock check
        order.addItem(product, qty);
    }

    public void processPayment(int orderId, Payment payment)
            throws PaymentFailedException {
        Order order = getOrder(orderId);
        double amount = order.getTotalAmount();
        payment.pay(amount);              // polymorphism in action
        order.markPaid();
    }

    // Order cancellation
    public void cancelOrder(int orderId) {
        Order order = getOrder(orderId);
        // restore stock
        for (OrderItem item : order.getItems()) {
            item.getProduct().increaseStock(item.getQuantity());
        }
        order.cancel();
    }

    // Tracking
    public OrderStatus trackOrderStatus(int orderId) {
        return getOrder(orderId).getStatus();
    }

    public void shipOrder(int orderId) {
        getOrder(orderId).ship();
    }

    public void markOrderDelivered(int orderId) {
        getOrder(orderId).markDelivered();
    }

    private Product getProduct(int productId) {
        Product p = productCatalog.get(productId);
        if (p == null) throw new IllegalArgumentException("Product not found: " + productId);
        return p;
    }

    private Order getOrder(int orderId) {
        Order o = orders.get(orderId);
        if (o == null) throw new IllegalArgumentException("Order not found: " + orderId);
        return o;
    }
}

public class ECommManagement {
    public static void main(String[] args) {
        ECommerceService service = new ECommerceService();

        // Product catalog
        Product p1 = new Product(1, "Laptop", 55000.0, 10);
        Product p2 = new Product(2, "Phone", 20000.0, 20);
        Product p3 = new Product(3, "Headphones", 1500.0, 50);
        service.addProduct(p1);
        service.addProduct(p2);
        service.addProduct(p3);

        // Browse products
        System.out.println("Product catalog:");
        for (Product p : service.listProducts()) {
            System.out.println(p);
        }

        // Customer
        Customer c1 = new Customer(1, "Rishabh", "rishabh@example.com");

        // Place order
        Order order = service.createOrder(c1);
        System.out.println("\nCreated " + order);

        service.addItemToOrder(order.getId(), 1, 1); // 1 Laptop
        service.addItemToOrder(order.getId(), 3, 2); // 2 Headphones
        System.out.println("Updated order: " + order);

        // Payment processing with exception handling
        Payment paymentMethod = new CardPayment("1234-5678-9012-3456");
        try {
            service.processPayment(order.getId(), paymentMethod);
            System.out.println("Payment success. Status: " +
                               service.trackOrderStatus(order.getId()));
        } catch (PaymentFailedException e) {
            System.out.println("Payment failed: " + e.getMessage());
            // optionally cancel order or ask for another method
        }

        // Order lifecycle: ship & deliver
        service.shipOrder(order.getId());
        System.out.println("Status after shipping: " +
                           service.trackOrderStatus(order.getId()));

        service.markOrderDelivered(order.getId());
        System.out.println("Final status: " +
                           service.trackOrderStatus(order.getId()));

        // Example cancellation flow (new order)
        Order order2 = service.createOrder(c1);
        service.addItemToOrder(order2.getId(), 2, 1); // Phone
        System.out.println("\nCreated second order: " + order2);
        service.cancelOrder(order2.getId());
        System.out.println("Second order cancelled. Status: " +
                           service.trackOrderStatus(order2.getId()));
    }
}



