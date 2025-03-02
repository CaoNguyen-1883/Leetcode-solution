import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        solve(res, nums, new ArrayList<>(), new boolean[nums.length]);

        return res;
    }

    public void solve(List<List<Integer>> res, int[] nums, List<Integer> path, boolean used[]){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; ++i){
            if(used[i]) continue;
            if(i > 0 && nums[i] == nums[i -1] && !used[i - 1]) continue;

            used[i] = true;
            path.add(nums[i]);

            solve(res, nums, path, used);

            used[i] = false;
            path.removeLast();
        }
    }
}