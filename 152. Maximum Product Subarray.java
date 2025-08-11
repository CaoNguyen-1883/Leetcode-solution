class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int min = nums[0]; 
        int max = nums[0];

        for(int i = 1; i < nums.length; ++i){
            int num = nums[i];
            int prevMin = min;
            int prevMax = max;

            if(num < 0){
                min = Math.min(prevMax * num, num);
                max = Math.max(prevMin * num, num);
            } else{
                min = Math.min(prevMin * num, num);
                max = Math.max(prevMax * num, num);
            }

            ans = Math.max(ans, max);
        }

        return ans;
    }
}