
import java.util.TreeSet;

class Solution {
    // nlog(n) + n
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        int ans = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] ==  nums[i - 1]) continue;
            else if(nums[i] - nums[i - 1] == 1){
                count++;
            } else{
                ans = Math.max(ans, count);
                count = 1;
            }
        }

        for(int i : nums) System.out.println(i);

        return ans;
    }

    public int longestConsecutive(int[] nums){

    }
}