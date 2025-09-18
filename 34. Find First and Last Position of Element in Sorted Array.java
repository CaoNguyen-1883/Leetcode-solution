    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if(nums.length == 0) return new int[]{-1, -1};
        
            int l = 0;
            int r = nums.length - 1;
            while(l < r){
                int m = (l + r) / 2;
                if(target <= nums[m]) r = m - 1;
                else l = m + 1; 
            }

            if(l == nums.length || nums[l] != target) return new int[]{-1, -1};

            int i = l;

            
            r = nums.length - 1;

            while(l <= r){
                int m = (l + r) / 2;
                if(target >= nums[m]) l = m + 1;
                else r = m - 1;
            }


            return new int[]{i, r};
        }
    }