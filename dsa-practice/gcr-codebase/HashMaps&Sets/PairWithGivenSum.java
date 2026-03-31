
import java.util.HashSet;

public class PairWithGivenSum {

    public static boolean hasPairWithSum(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;

            if (set.contains(complement)) {
                // pair found: (num, complement)
                return true;
            }

            set.add(num);
        }

        return false; // no pair found
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 1, 6};
        int target = 10;

        if (hasPairWithSum(arr, target)) {
            System.out.println("Pair exists.");
        } else {
            System.out.println("No such pair.");
        }
    }
}
