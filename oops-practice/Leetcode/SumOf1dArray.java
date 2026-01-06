
import java.util.Arrays;
import java.util.Scanner;

class Solution {

    public static int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        int pointer = 0;
        res[0] = nums[0];
        for(int i= 1 ; i<nums.length ; i++){
            res[i] = nums[i] + res[pointer]; 
            pointer++;
        }
        return res;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(runningSum(nums)));
    }
}