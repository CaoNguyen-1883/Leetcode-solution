import java.util.Collections;

class Solution {
    public int lengthOfLIS1(int[] nums) {
        if(nums.length == 0) return 0;

        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);

        for(int i = 1; i < nums.length; ++i){
            for(int j = 0; j < i; ++j){
                if(nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> arr = new ArrayList<>();
        arr.add(nums[0]);
        int len = 1;

        for(int i = 0; i < n; ++i){
            if(nums[i] > arr.get(arr.size() - 1)){
                arr.add(nums[i]);
                len++;
            } else{
                int ind = Collections.binarySearch(arr, nums[i]);
                if(ind < 0) ind = -ind - 1;
                arr.set(ind, nums[i]);
            }
        }
        return len;
    }
}