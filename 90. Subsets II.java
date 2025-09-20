import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        dfs(nums, res, new ArrayList<>(), 0);

        return res;
    }

    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> path, int index){
        res.add(new ArrayList<>(path));
        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i - 1]) continue; 
            path.add(nums[i]);
            dfs(nums, res, path, i + 1);
            path.removeLast();
        }
    }
}