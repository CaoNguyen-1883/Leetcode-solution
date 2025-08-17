class Solution {
    public int missingNumber1(int[] nums) {
        int ans = nums.length;

        for(int i = 0; i < nums.length; ++i){
            ans ^= i ^ nums[i];
        }
        
        return ans;
    }

    public int missingNumber(int[] nums){
        int n = nums.length;
        int sum1 = n * (n + 1) / 2;
        int sum2 = 0;
        for(int i : nums){
            sum2 += i;
        }

        return sum1 - sum2;
    }
}
