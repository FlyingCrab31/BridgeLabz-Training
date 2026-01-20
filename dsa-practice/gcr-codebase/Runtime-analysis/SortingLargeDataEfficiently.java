
import java.util.*;

public class SortingLargeDataEfficiently {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }

        for (int i = 0; i < n2; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;

        return i + 1;
    }

    public static void test(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(size);
        }

        int[] bubblearr = Arrays.copyOf(arr, arr.length);
        int[] mergearr = Arrays.copyOf(arr, arr.length);
        int[] quickarr = Arrays.copyOf(arr, arr.length);

        System.out.println("Dataset size : " + size);
        if (size <= 10000) {
            long start = System.currentTimeMillis();
            bubbleSort(bubblearr);
            long end = System.currentTimeMillis();
            System.out.println("Bubble sort time: " + (end - start) + " ms");

        } else {
            System.out.println("Bubble sort time: skipped(too slow)");
        }

        long startMerge = System.currentTimeMillis();
        mergeSort(mergearr, 0, mergearr.length - 1);
        long endMerge = System.currentTimeMillis();
        System.out.println("Merge sort time: " + (endMerge - startMerge) + " ms");

        long startQuick = System.currentTimeMillis();
        quickSort(quickarr, 0, quickarr.length - 1);
        long endQuick = System.currentTimeMillis();
        System.out.println("Quick sort time: " + (endQuick - startQuick) + " ms");
    }

    public static void main(String args[]) {
        test(1_000);
        test(10_000);
        test(100_000);
        test(500_000);
    }

}
