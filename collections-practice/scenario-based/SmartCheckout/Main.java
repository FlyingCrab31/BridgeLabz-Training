package SmartCheckout;
import java.util.Arrays;

public class Main
{

        public static void main(String[] args) {
            SmartCheckoutService checkout = new SmartCheckoutService();

            // Initialize catalog (HashMap: productId -> Product)
            checkout.addProduct(new Product("P001", "Milk", 50.0, 10));
            checkout.addProduct(new Product("P002", "Bread", 30.0, 20));
            checkout.addProduct(new Product("P003", "Eggs", 6.0, 50));

            // Create customers with carts
            Customer c1 = new Customer(
                    "C101",
                    "Ravi",
                    Arrays.asList(
                            new CartItem("P001", 2),
                            new CartItem("P002", 1)
                    )
            );

            Customer c2 = new Customer(
                    "C102",
                    "Sneha",
                    Arrays.asList(
                            new CartItem("P002", 3),
                            new CartItem("P003", 12)
                    )
            );

            // Add customers to Queue
            checkout.addCustomerToQueue(c1);
            checkout.addCustomerToQueue(c2);

            checkout.printCatalog();

            // Process customers in FIFO order
            checkout.processNextCustomer(); // processes c1, updates stock
            checkout.processNextCustomer(); // processes c2, updates stock
            checkout.processNextCustomer(); // queue empty

            checkout.printCatalog(); // stock after purchases
        }
    }


