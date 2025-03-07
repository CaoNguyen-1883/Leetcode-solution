class Solution {
    public int jump(int[] nums) {
        int end = 0;
        int maxDistant = 0;
        int n = nums.length;   
        int res = 0;

        for(int i = 0; i < n - 1; ++i){
            if(maxDistant < i + nums[i]){
                maxDistant = i + nums[i];
            }

            if(maxDistant >= n - 1){
                ++res;
                break;
            }

            if(i == end){
                ++res;
                end = maxDistant;
            }
        }

        return res;
    }
}