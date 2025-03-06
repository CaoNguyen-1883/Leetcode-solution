class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = nums[0];
        int n = nums.length;

        for(int i = 1; i < n; ++i){
            sum += nums[i];

            if(res < sum) res = sum;

            if(sum < 0) sum = 0;
        }
        
        return res;
    }
}