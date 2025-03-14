
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;



class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);

        return nums[nums.length - k];
    }
}


class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i : nums) maxHeap.offer(i);

        while(k > 1){
            --k;
            maxHeap.poll();
        }

        return maxHeap.peek();
    }
}