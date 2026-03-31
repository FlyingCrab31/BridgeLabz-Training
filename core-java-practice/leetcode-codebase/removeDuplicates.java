package Array;

import java.util.HashSet;

public class removeDuplicates {
    static void main() {
        int[] arr = {1,1,2};
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < n ; i++){
            set.add(arr[i]);
        }
        System.out.println( set.size());
    }
}
