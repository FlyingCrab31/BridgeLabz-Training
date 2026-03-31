import java.util.Scanner;

public class TextSplitter {
    
    // Find string length without using length()
    public static int getLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Reached the end
        }
        return count;
    }
    
    // Split text into words manually
    public static String[] splitTextIntoWords(String text) {
        int textLength = getLength(text);
        
        // First, count how many words we have
        int wordCount = 0;
        boolean inWord = false;
        
        for (int i = 0; i < textLength; i++) {
            char currentChar = text.charAt(i);
            
            if (currentChar == ' ') {
                inWord = false;
            } else {
                if (!inWord) {
                    wordCount++;
                    inWord = true;
                }
            }
        }
        
        // Create array to store space positions
        int[] spaceIndexes = new int[wordCount + 1];
        int spaceCount = 0;
        spaceIndexes[0] = -1; // Start position before first character
        
        for (int i = 0; i < textLength; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[++spaceCount] = i;
            }
        }
        spaceIndexes[++spaceCount] = textLength; // End position
        
        // Extract words using the space positions
        String[] words = new String[wordCount];
        int wordIndex = 0;
        
        for (int i = 0; i < spaceCount; i++) {
            int startPos = spaceIndexes[i] + 1;
            int endPos = spaceIndexes[i + 1];
            
            if (startPos < endPos) {
                String word = "";
                for (int j = startPos; j < endPos; j++) {
                    word += text.charAt(j);
                }
                words[wordIndex++] = word;
            }
        }
        
        return words;
    }
    
    // Compare two string arrays
    public static boolean compareArrays(String[] array1, String[] array2) {
        if (getArrayLength(array1) != getArrayLength(array2)) {
            return false;
        }
        
        for (int i = 0; i < getArrayLength(array1); i++) {
            if (!array1[i].equals(array2[i])) {
                return false;
            }
        }
        return true;
    }
    
    // Helper to get array length
    private static int getArrayLength(String[] arr) {
        int count = 0;
        try {
            while (true) {
                String temp = arr[count];
                count++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            // Reached the end
        }
        return count;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();
        
        // Split using custom method
        String[] customWords = splitTextIntoWords(sentence);
        
        // Split using built-in method
        String[] builtInWords = sentence.split(" ");
        
        // Compare results
        boolean areEqual = compareArrays(customWords, builtInWords);
        
        System.out.println("\nCustom split result:");
        for (String word : customWords) {
            System.out.println("  " + word);
        }
        
        System.out.println("\nBuilt-in split result:");
        for (String word : builtInWords) {
            System.out.println("  " + word);
        }
        
        System.out.println("\nAre both results equal? " + areEqual);
        
        sc.close();
    }
}
