
import java.util.*;

public class SubarraySumZero {

    // Method to find all subarrays with zero sum: O(n) time, O(n) space
    public static void findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> prefixIndexMap = new HashMap<>();

        int prefixSum = 0;
        // Handle subarray starting from index 0
        prefixIndexMap.put(0, new ArrayList<>(Arrays.asList(-1)));

        System.out.println("\nZero-sum subarrays are:");

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // If this prefix sum was seen before, all ranges (prevIndex+1 .. i) have sum 0
            if (prefixIndexMap.containsKey(prefixSum)) {
                List<Integer> indices = prefixIndexMap.get(prefixSum);
                for (int startIndex : indices) {
                    printSubarray(arr, startIndex + 1, i);
                }
            }

            // Add current index to the list for this prefix sum
            prefixIndexMap
                    .computeIfAbsent(prefixSum, k -> new ArrayList<>())
                    .add(i);
        }
    }

    private static void printSubarray(int[] arr, int start, int end) {
        System.out.print("Subarray (" + start + " to " + end + "): [ ");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter size of array: ");
            int n = sc.nextInt();

            int[] arr = new int[n];
            System.out.println("Enter array elements:");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            findZeroSumSubarrays(arr);
        }
    }
}
