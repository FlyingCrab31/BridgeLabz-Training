class NullPointerDemo {
    
    // Method to generate NullPointerException
    public static void generateException() {
        String text = null;
        // This will throw NullPointerException
        int length = text.length();
        System.out.println("Length: " + length);
    }
    
    // Method to handle NullPointerException
    public static void handleException() {
        String text = null;
        try {
            int length = text.length();
            System.out.println("Length: " + length);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught!");
            System.out.println("Error: " + e.getMessage());
            System.out.println("The string is null. Cannot perform operations on null objects.");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("--- Generating NullPointerException ---");
        try {
            generateException();
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getClass().getSimpleName());
        }
        
        System.out.println("\n--- Handling NullPointerException ---");
        handleException();
    }
}
