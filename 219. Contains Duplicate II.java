
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> seen = new HashMap<>();
        int n = nums.length;
        
        for(int i = 0; i < n; ++i){
            if(seen.containsKey(nums[i]) && i - seen.get(nums[i]) <= k) return true;
            seen.put(nums[i], i);
        }

        return false;
    }
}