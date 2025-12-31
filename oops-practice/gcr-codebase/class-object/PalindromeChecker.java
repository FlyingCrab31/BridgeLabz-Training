class PalindromeChecker {
    // Attribute
    String text;
    
    // Constructor to initialize the PalindromeChecker object
    public PalindromeChecker(String text) {
        this.text = text;
    }
    
    // Method to check if the text is a palindrome
    public boolean isPalindrome() {
        // Remove spaces and convert to lowercase for comparison
        String cleanedText = text.replaceAll("\\s+", "").toLowerCase();
        
        // Check if the string is equal to its reverse
        int left = 0;
        int right = cleanedText.length() - 1;
        
        while (left < right) {
            if (cleanedText.charAt(left) != cleanedText.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    // Method to display the result
    public void displayResult() {
        if (isPalindrome()) {
            System.out.println(text + " is palindrome");
        } else {
            System.out.println(text + " is not Palindrome");
        }
    }
}

class Main {
    public static void main(String[] args) {
        // Create PalindromeChecker objects
        PalindromeChecker checker1 = new PalindromeChecker("A man a plan a canal Panama");
        PalindromeChecker checker2 = new PalindromeChecker("Hello");
        
        // Display results
        checker1.displayResult();
        checker2.displayResult();
    }
}
