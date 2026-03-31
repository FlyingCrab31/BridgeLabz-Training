
import java.util.HashSet;
import java.util.Scanner;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter size of array: ");
            int n = sc.nextInt();

            int[] arr = new int[n];
            System.out.println("Enter array elements: ");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int result = longestConsecutive(arr);
            System.out.println("Length of Longest Consecutive Sequence: " + result);
        }
    }

    public static int longestConsecutive(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int longestStreak = 0;

        for (int num : arr) {
            // Check if this is the start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count the length of the sequence
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
