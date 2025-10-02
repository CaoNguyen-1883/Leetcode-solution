class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 1;){
            int count = 0;
            int j = i + 1;
            for(; j < nums.length;){
                if(nums[j] == nums[i]){
                    j++;
                    count++;
                    if(count > nums.length / 2) return nums[i];
                }
            }
            i = j;
        }

        return - 1;
    }
}