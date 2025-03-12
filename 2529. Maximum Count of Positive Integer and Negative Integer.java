class Solution {
    public int maximumCount(int[] nums) {
        int l = 0, r = nums.length - 1;

        while(l <= r){
            int m = (l + r) / 2;
            if(nums[m] >= 0) r = m - 1;
            else l = m + 1;
        }

        int neg = l;
        while(l < nums.length && nums[l] == 0) ++l;

        int pos = nums.length - l;

        return neg > pos ? neg : pos;
    }
}