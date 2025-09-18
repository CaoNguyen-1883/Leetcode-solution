import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        solve(candidates, target, res, new ArrayList(), 0);

        return res;
    }

    public void solve(int[] candidates, int target, List<List<Integer>> res, List<Integer> path, int j){
        if(target < 0) return;
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = j; i < candidates.length; i++){
            path.add(candidates[i]);
            solve(candidates, target - candidates[i], res, path, i);
            path.removeLast();
        }
    }
}