
public class RotateArrayBS {

    public static int findRotation(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] > arr[hi]) {
                lo = mid + 1;
            } else if (arr[mid] < arr[hi]) {
                hi = mid;
            } else {
                hi--;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 1, 3, 3, 4};
        System.out.println(findRotation(arr));
    }
}
