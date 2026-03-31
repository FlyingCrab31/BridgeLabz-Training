import java.util.Scanner;

class SubstringDemo {
    
    // Method to create substring using charAt()
    public static String createSubstringByCharAt(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += text.charAt(i);
        }
        return result;
    }
    
    // Method to compare two strings using charAt()
    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
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
        
        System.out.print("Enter start index: ");
        int start = sc.nextInt();
        
        System.out.print("Enter end index: ");
        int end = sc.nextInt();
        
        // Create substring using charAt()
        String substringCharAt = createSubstringByCharAt(text, start, end);
        
        // Create substring using built-in substring()
        String substringBuiltIn = text.substring(start, end);
        
        // Compare both results
        boolean areEqual = compareStrings(substringCharAt, substringBuiltIn);
        
        // Display results
        System.out.println("Substring using charAt(): " + substringCharAt);
        System.out.println("Substring using substring(): " + substringBuiltIn);
        System.out.println("Are both substrings equal? " + areEqual);
        
        sc.close();
    }
}
