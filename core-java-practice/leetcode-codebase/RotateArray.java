package Array;

import java.util.Arrays;

public class RotateArray {
    public int[]  rotate(int[] nums, int k) {
        int n=nums.length;
        // In case value of k is greater than the value of n then
        k=k % n;
        reversePart(nums,0,n-k-1);
        reversePart(nums,n-k,n-1);
        reversePart(nums,0,n-1);
        return nums;

    }
    public void  reversePart(int nums[],int s,int e){
        while (s<e){
            int temp=nums[s];
            nums[s]=nums[e];
            nums[e]=temp;

            s++;
            e--;
        }
    }
    // when k is less than n ;
    public static void main(String[] args) {
        int []arr = {10,20,30,40,50,60,70};
        RotateArray rot=new RotateArray();
        System.out.println( Arrays.toString(rot.rotate(arr, 3)));

    }
}

