class Solution {
    public void moveZeroes(int[] nums) {
        int countZero = 0, n = nums.length;

        for(int i = 0; i < n; ++i){
            if(nums[i] != 0){
                nums[countZero++] = nums[i];
            }
        }

        while(countZero < n) nums[countZero++] = 0;
    }
}