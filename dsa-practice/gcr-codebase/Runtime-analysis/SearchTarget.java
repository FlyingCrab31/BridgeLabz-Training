
public class SearchTarget {

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }

        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return mid; 
            }else if (target < arr[mid]) {
                right = mid - 1; 
            }else {
                left = mid + 1;
            }

        }
        return -1;
    }

    public static void test(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i + 1;
        }

        int target = size;
        long startLinear = System.nanoTime();
        linearSearch(arr, target);
        long endLinear = System.nanoTime();

        long startBinary = System.nanoTime();
        binarySearch(arr, target);
        long endBinary = System.nanoTime();

        double linearTime = (endLinear - startLinear) / 1_000_000.0;
        double binaryTime = (endBinary - startBinary) / 1_000_000.0;

        System.out.printf("%-12d %-20f %-20f\n ", size, linearTime, binaryTime);

    }

    public static void main(String args[]) {
        System.out.println("Dataset size linear search(ms) binary search(ms)");
        System.out.println("------------------------------------------------------");
        test(1_000);
        test(10_000);
        test(1000_000);
    }
}
