class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closetValue = nums[0] + nums[1] + nums[2];

        int n = nums.length;
        
        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1;
            int r = n - 1;

            while(l < r)
                int sum = nums[i] + nums[l] + nums[r];

                if(sum == target) return sum;

                if(Math.abs(sum - target) < Math.abs(closetValue - target)){
                    closetValue = sum;
                } 
                
                if(sum < target){
                    l++;
                    while(l < r && nums[l] == nums[l - 1]) l++;
                } else{
                    r--;
                    while(l < r && nums[r] == nums[r + 1]) r--;
                }
            }
        }

        return closetValue;
    }
}