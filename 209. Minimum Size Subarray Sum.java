class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int n = nums.length;
        int sum = 0;

        for(int l = 0, r = 0; l < n && r < n; ++r){
            sum += nums[r];
            while(sum >= target){
                res = Math.min(res, r - l + 1);
                sum -= nums[l++];
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}