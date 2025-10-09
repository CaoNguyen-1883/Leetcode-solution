
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> st = new HashSet<>();

        for(int num : nums){
            if(st.add(num) == false) return true;
        }

        return false;
    }
    public boolean containsDuplicate_v1(int[] nums) {
        Arrays.sort(nums);
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i - 1] == nums[i]) return true;
        }

        return false;
    }


}