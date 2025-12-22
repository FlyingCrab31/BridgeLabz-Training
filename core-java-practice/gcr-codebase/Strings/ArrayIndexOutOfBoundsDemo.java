import java.util.Scanner;

class ArrayIndexOutOfBoundsDemo {
    
    // Method to generate ArrayIndexOutOfBoundsException
    public static void generateException(String[] names) {
        // Access index larger than the length of array
        String name = names[names.length + 3];
        System.out.println("Name: " + name);
    }
    
    // Method to handle ArrayIndexOutOfBoundsException
    public static void handleException(String[] names) {
        try {
            // Access index larger than the length of array
            String name = names[names.length + 3];
            System.out.println("Name: " + name);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught!");
            System.out.println("Error: " + e.getMessage());
            System.out.println("The index is out of bounds for array length: " + names.length);
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught!");
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of names: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline
        
        String[] names = new String[n];
        
        System.out.println("Enter " + n + " names:");
        for (int i = 0; i < n; i++) {
            System.out.print("Name " + (i + 1) + ": ");
            names[i] = sc.nextLine();
        }
        
        System.out.println("\n--- Generating ArrayIndexOutOfBoundsException ---");
        try {
            generateException(names);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getClass().getSimpleName());
        }
        
        System.out.println("\n--- Handling ArrayIndexOutOfBoundsException ---");
        handleException(names);
        
        sc.close();
    }
}
