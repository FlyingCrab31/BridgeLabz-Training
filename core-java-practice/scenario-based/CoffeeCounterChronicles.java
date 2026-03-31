import java.util.Scanner;

public class CoffeeCounterChronicles {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        // Coffee menu with prices,Final keyword is used so the the prices won't change
        final double ESPRESSO_PRICE = 80.0;
        final double LATTE_PRICE = 120.0;
        final double CAPPUCCINO_PRICE = 140.0;
        final double AMERICANO_PRICE = 100.0;
        final double GST_RATE = 0.05; // 5% GST
        
        System.out.println(" Welcome to Rishabh's Coffee Cafe ");
        
        // While loop to continue for next customer until exit is typed
        while (true) {
            System.out.println(" New Customer Order ");
            
            // Display coffee menu
            System.out.println("Coffee Menu:");
            System.out.println("1. Espresso - Rs. 80");
            System.out.println("2. Latte - Rs. 120");
            System.out.println("3. Cappuccino - Rs. 140");
            System.out.println("4. Americano - Rs. 100");
            System.out.print("Enter coffee type (1-4) or 'exit' to close: ");
            
            String input = scanner.nextLine().trim();
            
            // Break condition when user types exit
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            
            // Switch statement to handle different coffee orders
            switch (input) {
                case "1" -> handleOrder(scanner, "Espresso", ESPRESSO_PRICE, GST_RATE);
                case "2" -> handleOrder(scanner, "Latte", LATTE_PRICE, GST_RATE);
                case "3" -> handleOrder(scanner, "Cappuccino", CAPPUCCINO_PRICE, GST_RATE);
                case "4" -> handleOrder(scanner, "Americano", AMERICANO_PRICE, GST_RATE);
                default -> System.out.println("Invalid selection. Please try again.");
            }
        }
        
        System.out.println(" Thank you for visiting! ");
        scanner.close();
    }
    
    // Method to handle individual order...
    private static void handleOrder(Scanner scanner, String coffeeType, double price, double gstRate) {
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        
        // Calculate total bill using arithmetic operators
        double subtotal = price * quantity;
        double gstAmount = subtotal * gstRate;
        double totalBill = subtotal + gstAmount;
        
        // Display bill details
        System.out.println(" Bill Details ");
        System.out.println("Coffee Type: " + coffeeType);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price per unit: Rs. " + price);
        System.out.printf("Subtotal: Rs. %.2f", subtotal); 
        System.out.printf("GST (5%%): Rs. %.2f", gstAmount);
        System.out.printf("Total Bill: Rs. %.2f", totalBill);
    }
}
