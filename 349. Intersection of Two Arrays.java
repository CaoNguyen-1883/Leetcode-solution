
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = HashSet<>();

        for(int i : nums1) set.add(i);

        for(int i : nums2){
            if(set.remove(i)) res.add(i);
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}