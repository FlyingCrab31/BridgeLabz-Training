
import java.util.Arrays;

public class CountingSort {

    public static void countingSort(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return;
        }

        // Find the maximum value in the array
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Create count array
        int[] count = new int[max + 1];

        // Store the count of each element
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        // Rebuild the sorted array
        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1}; // Student ages Array
        countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
