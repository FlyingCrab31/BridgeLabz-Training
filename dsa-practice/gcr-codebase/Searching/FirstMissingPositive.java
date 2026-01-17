
import java.util.Arrays;

public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[n + 1];

        // Mark presence of numbers 1..n
        for (int x : nums) {
            if (x >= 1 && x <= n) {
                seen[x] = true;
            }
        }

        // Find first missing positive
        for (int i = 1; i <= n; i++) {
            if (!seen[i]) {
                return i;
            }
        }

        return n + 1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // target not found
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        int missing = firstMissingPositive(nums);
        System.out.println("First missing positive: " + missing);

        Arrays.sort(nums); // required before binary search
        int target = 4;
        int idx = binarySearch(nums, target);
        System.out.println("Index of " + target + " after sorting: " + idx);
    }
}
