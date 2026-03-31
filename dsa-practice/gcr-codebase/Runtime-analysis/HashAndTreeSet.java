
import java.util.*;

public class HashAndTreeSet {

    public static boolean arraySearch(int[] arr, int target) {

        for (int num : arr) {
            if (num == target) {
                return true;
            }
        }
        return false;

    }

    public static void testSearch(int size) {
        System.out.println("Dataset size: " + size);

        int[] arr = new int[size];
        HashSet<Integer> hashset = new HashSet<>();
        TreeSet<Integer> treeset = new TreeSet<>();

        for (int i = 0; i < size; i++) {
            arr[i] = i + 1;
            hashset.add(i + 1);
            treeset.add(i + 1);

        }

        int target = size - 1;

        long startArray = System.currentTimeMillis();
        arraySearch(arr, target);
        long endArray = System.currentTimeMillis();
        System.out.println("Array search time: " + (endArray - startArray) + " ms");

        long startHashSet = System.currentTimeMillis();
        hashset.contains(target);

        long endHashSet = System.currentTimeMillis();
        System.out.println("Hashset search time: " + (endHashSet - startHashSet) + " ms");

        long startTreeSet = System.currentTimeMillis();
        treeset.contains(target);
        long endTreeSet = System.currentTimeMillis();
        System.out.println("Treeset search time: " + (endTreeSet - startTreeSet) + " ms");

    }

    public static void main(String args[]) {

        System.out.println("Comparing different data structures for searching");
        System.out.println("------------------------------------------------------");
        System.out.println("Dataset size array search(ms) hashset search(ms) treeset search(ms)");
        testSearch(1000);
        testSearch(10000);
        testSearch(100000);
        testSearch(500000);
    }

}
