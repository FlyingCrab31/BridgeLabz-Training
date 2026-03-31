import java.util.Scanner;

class CharArrayDemo {
    
    // Method to return characters without using toCharArray()
    public static char[] getCharactersManually(String text) {
        char[] result = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            result[i] = text.charAt(i);
        }
        return result;
    }
    
    // Method to compare two char arrays
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Take user input
        System.out.print("Enter a string: ");
        String text = sc.next();
        
        // Get characters using user-defined method
        char[] manualArray = getCharactersManually(text);
        
        // Get characters using built-in toCharArray()
        char[] builtInArray = text.toCharArray();
        
        // Compare both arrays
        boolean areEqual = compareCharArrays(manualArray, builtInArray);
        
        // Display results
        System.out.print("Characters from user-defined method: ");
        for (char c : manualArray) {
            System.out.print(c + " ");
        }
        System.out.println();
        
        System.out.print("Characters from toCharArray(): ");
        for (char c : builtInArray) {
            System.out.print(c + " ");
        }
        System.out.println();
        
        System.out.println("Are both arrays equal? " + areEqual);
        
        sc.close();
    }
}
