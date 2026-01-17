
public class FirstLastOccurrence {

    public static int firstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;       // candidate for first
                right = mid - 1;    // go left to find earlier occurrence
            } else if (arr[mid] < target) {
                left = mid + 1;     // target is on the right
            } else {
                right = mid - 1;    // target is on the left
            }
        }

        return result;
    }

    public static int lastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;       // candidate for last
                left = mid + 1;     // go right to find later occurrence
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    // Helper that returns both indices as a pair
    public static int[] firstAndLast(int[] arr, int target) {
        int first = firstOccurrence(arr, target);
        int last = lastOccurrence(arr, target);
        return new int[]{first, last};   // if not found => [-1, -1]
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;

        int[] ans = firstAndLast(arr, target);
        System.out.println("First: " + ans[0] + ", Last: " + ans[1]);
    }
}
