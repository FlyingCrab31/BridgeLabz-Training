class EventManager {

    // Quick Sort entry
    public void quickSort(int[] prices) {
        if (prices == null || prices.length <= 1) return;
        quickSort(prices, 0, prices.length - 1);
    }

    // Recursive Quick Sort
    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);   // left part
            quickSort(arr, pivotIndex + 1, high);  // right part
        }
    }

    // Partition using last element as pivot
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // pivot element
        int i = low - 1;       // index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Top k cheapest tickets (after sorting ascending)
    public int[] getTopCheapest(int[] prices, int k) {
        if (k <= 0) return new int[0];
        quickSort(prices); // sort full array
        int n = prices.length;
        int size = Math.min(k, n);
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = prices[i];
        }
        return result;
    }

    // Top k most expensive tickets (after sorting ascending)
    public int[] getTopMostExpensive(int[] prices, int k) {
        if (k <= 0) return new int[0];
        quickSort(prices); // sort full array
        int n = prices.length;
        int size = Math.min(k, n);
        int[] result = new int[size];
        int idx = 0;
        for (int i = n - 1; i >= n - size; i--) {
            result[idx++] = prices[i];
        }
        return result;
    }

    // Utility to print array
    public void printArray(int[] arr, String msg) {
        System.out.print(msg + ": ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    // Demo main
    public static void main(String[] args) {
        EventManager manager = new EventManager();

        // Example unsorted ticket prices (imagine millions in real system)
        int[] prices = {1200, 500, 750, 2000, 150, 999, 300, 450, 2500, 50};

        int k = 5; // use 50 in real requirement

        int[] cheapest = manager.getTopCheapest(prices.clone(), k);
        int[] mostExpensive = manager.getTopMostExpensive(prices.clone(), k);

        manager.printArray(cheapest, "Top " + k + " cheapest tickets");
        manager.printArray(mostExpensive, "Top " + k + " most expensive tickets");
    }
}