import java.util.Scanner;

class StringIndexOutOfBoundsDemo {
    
    // Method to generate StringIndexOutOfBoundsException
    public static void generateException(String text) {
        // Access index beyond the length
        char ch = text.charAt(text.length() + 5);
        System.out.println("Character: " + ch);
    }
    
    // Method to handle StringIndexOutOfBoundsException
    public static void handleException(String text) {
        try {
            // Access index beyond the length
            char ch = text.charAt(text.length() + 5);
            System.out.println("Character: " + ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException caught!");
            System.out.println("Error: " + e.getMessage());
            System.out.println("The index is out of bounds for the string length: " + text.length());
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = sc.next();
        
        System.out.println("\n Generating StringIndexOutOfBoundsException ");
        try {
            generateException(text);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getClass().getSimpleName());
        }
        
        System.out.println("\n Handling StringIndexOutOfBoundsException ");
        handleException(text);
        
        sc.close();
    }
}
