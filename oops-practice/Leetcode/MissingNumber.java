
import java.util.*;
class Solution {
    public static int missingNumber(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
      int max = arr.length; //Arrays.stream(arr).max().getAsInt();
      //int min = Arrays.stream(arr).min().getAsInt();
      for (int ele : arr){
        set.add(ele);
      }
      int res = 0;
      for(int i = 0; i <= max ; i++){
        if(set.contains(i)) continue;
        else res = i;
      }
      return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {1,3,0};
        System.out.println(missingNumber(arr));
    }

}
