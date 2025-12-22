import java.util.Scanner;

class NumberFormatDemo {
    
    // Method to generate NumberFormatException
    public static void generateException(String text) {
        // Try to parse non-numeric text
        int number = Integer.parseInt(text);
        System.out.println("Number: " + number);
    }
    
    // Method to handle NumberFormatException
    public static void handleException(String text) {
        try {
            // Try to parse non-numeric text
            int number = Integer.parseInt(text);
            System.out.println("Number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught!");
            System.out.println("Error: " + e.getMessage());
            System.out.println("The input '" + text + "' is not a valid number.");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught!");
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string (try non-numeric like 'hello'): ");
        String text = sc.next();
        
        System.out.println("\n Generating NumberFormatException ");
        try {
            generateException(text);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getClass().getSimpleName());
        }
        
        System.out.println("\n Handling NumberFormatException ");
        handleException(text);
        
        sc.close();
    }
}
