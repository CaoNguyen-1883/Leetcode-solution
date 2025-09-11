class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1) return 1;

        int i = 1;

        for(int num : nums){
            if(num > nums[i - 1]){
                nums[i++] = num;
            }
        }
        return i;
    }
}

// 0001

// 0001

// 0010

// 0011