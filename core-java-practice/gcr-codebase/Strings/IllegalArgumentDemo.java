import java.util.Scanner;

class IllegalArgumentDemo {
    
    // Method to generate IllegalArgumentException
    public static void generateException(String text) {
        // Start index greater than end index
        String substr = text.substring(5, 2);
        System.out.println("Substring: " + substr);
    }
    
    // Method to handle IllegalArgumentException
    public static void handleException(String text) {
        try {
            // Start index greater than end index
            String substr = text.substring(5, 2);
            System.out.println("Substring: " + substr);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught!");
            System.out.println("Error: " + e.getMessage());
            System.out.println("Start index cannot be greater than end index in substring.");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught!");
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string (at least 6 characters): ");
        String text = sc.next();
        
        System.out.println("\n--- Generating IllegalArgumentException ---");
        try {
            generateException(text);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getClass().getSimpleName());
        }
        
        System.out.println("\n--- Handling IllegalArgumentException ---");
        handleException(text);
        
        sc.close();
    }
}
