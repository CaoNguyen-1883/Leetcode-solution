class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int i = 0;
        int maxDistant = nums[0];

        for(; i < n && i <= maxDistant; ++i){
            if(maxDistant < nums[i] + i) maxDistant = nums[i] + i;
        }

        return n == i;
    }
}