import java.security.cert.X509CertSelector;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();

        for(int i = 0; i < nums.length; ++i){
            int x = target - nums[i];

            if(mp.containsKey(x)){
                return new int[] {mp.get(x), i};
            }

            mp.put(nums[i], i);
        }
        return null;   
    }
}