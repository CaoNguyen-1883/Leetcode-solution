
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0, n = nums1.length, m =  nums2.length;   

        while(i < n &&j < m){
            if(nums1[i] < nums2[j]) ++i;
            else if(nums1[i] > nums2[j]) ++j;
            else{
                res.add(nums1[i]);
                ++i; ++j;
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}