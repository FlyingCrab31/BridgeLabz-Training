package Array;

public class nextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {2,3,45,56,34,6,13,2};
        int[] res = new int[arr.length];
        int n = arr.length;
        res[n-1]=-1;
        int nge = arr[n-1];
        for (int j = n-2; j >=0 ; j--) {
            res[j] = nge;
            nge=Math.max(nge,arr[j]);

        }
        for(int ele : res){
            System.out.print(ele+" ");
        }

    }
}
