
public class RemoveDuplicates {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("aabccabaab");
        removeDuplicates(sb);
        System.out.println(sb.toString()); // Output: "abc" 

    }

    public static void removeDuplicates(StringBuilder sb) {
        boolean[] seen = new boolean[26]; // Assuming only lowercase letters a-z
        int writeIndex = 0;

        for (int readIndex = 0; readIndex < sb.length(); readIndex++) {
            char currentChar = sb.charAt(readIndex);
            int charIndex = currentChar - 'a';

            if (!seen[charIndex]) {
                seen[charIndex] = true;
                sb.setCharAt(writeIndex, currentChar);
                writeIndex++;
            }
        }

        sb.setLength(writeIndex); // Truncate the StringBuilder to the new length
    }

}
