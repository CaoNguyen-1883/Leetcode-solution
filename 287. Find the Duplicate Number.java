class Solution {
    public int findDuplicate(int[] nums) {
        while(nums[0] != nums[nums[0]]){
            int i = nums[0];
            int j = nums[nums[0]];
            nums[0] = j;
            nums[i] = i;
       }
       return nums[0];
    }
}