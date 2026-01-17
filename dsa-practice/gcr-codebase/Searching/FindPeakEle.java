
public class FindPeakEle {

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }
        }
        return left;

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        FindPeakEle peak = new FindPeakEle();
        System.out.println(peak.findPeakElement(nums));
    }

}
