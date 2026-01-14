
import java.util.*;

class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deq = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            //step 1 -> make space for nums[i]
            while (!deq.isEmpty() && deq.getFirst() <= i - k) {
                deq.pollFirst();
            }
            // step 2-> if the incoming element i.e(nums[i)) is > the already present element in the deq then we...
            // don't need that element anymore, so we'll pop them out.

            while (!deq.isEmpty() && nums[deq.getLast()] < nums[i]) {
                deq.pollLast();
            }
            //step 3 -> now push i in deq for nums[i]
            deq.addLast(i);
            // step 4 -> now if (i>=k-1) then deq.get_first() is our answer.
            if (i >= k - 1) {
                res.addLast(nums[deq.getFirst()]);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

}

public class SlidingWindowMax {

    static void main() {
        Solution solution = new Solution();
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(solution.maxSlidingWindow(arr, 3)));

    }

}
