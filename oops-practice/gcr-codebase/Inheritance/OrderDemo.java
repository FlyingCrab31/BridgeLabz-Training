class Order {
    protected String orderId;
    protected String orderDate;   // e.g., "2026-01-03"

    public Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return "Order placed";
    }
}
class ShippedOrder extends Order {
    protected String trackingNumber;

    public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    public String getOrderStatus() {
        return "Order shipped. Tracking Number: " + trackingNumber;
    }
}
class DeliveredOrder extends ShippedOrder {
    private final String deliveryDate;   // e.g., "2026-01-05"

    public DeliveredOrder(String orderId, String orderDate,
                          String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String getOrderStatus() {
        return "Order delivered on " + deliveryDate +
               ". Tracking Number: " + trackingNumber;
    }
}
public class OrderDemo {
    public static void main(String[] args) {
        Order o1 = new Order("O1001", "2026-01-01");
        ShippedOrder o2 = new ShippedOrder("O1002", "2026-01-02", "TRK12345");
        DeliveredOrder o3 = new DeliveredOrder("O1003", "2026-01-01",
                                               "TRK98765", "2026-01-04");

        System.out.println(o1.getOrderStatus());
        System.out.println(o2.getOrderStatus());
        System.out.println(o3.getOrderStatus());
    }
}

