package Array;

public class sortZerosOnesTwos {
    public static void main(String[] args) {

        // Dutch Flag Algo......

        int[] arr = {1,2,0,1,0,1,2,2,1,0};
        int mid = 0,high = arr.length-1,low=0;
        while(mid<=high){
            if(arr[mid]==0){
                int temp = arr[mid];
                arr[mid]=arr[low];
                arr[low]=temp;
                low++;
                mid++;

            }
           else if(arr[mid]==1){
                mid++;
            }

            else if(arr[mid]==2){
                int temp = arr[high];
                arr[high]=arr[mid];
                arr[mid]=temp;
                high--;
            }

        }
        for(int ele:arr){
            System.out.print(ele+" ");
        }

    }
}
