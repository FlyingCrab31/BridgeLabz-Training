
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {

    public static int[] twoSum(int[] arr, int target) {
        int n = arr.length;
        int[] arr1 = {-1, -1};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int rem = target - arr[i];
            if (map.containsKey(rem)) {
                int val = map.get(rem);
                arr1[0] = i;
                arr1[1] = val;
                break;
            } else {
                map.put(arr[i], i);
            }

        }
        return arr1;

    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int target = sc.nextInt();
            int[] arr = {2, 5, 6, 1, 4, 2, 8};
            System.out.println(Arrays.toString(twoSum(arr, target)));
        }

    }

}
