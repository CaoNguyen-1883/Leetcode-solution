import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);

        dfs(candidates, target, res, new ArrayList<>(), 0);

        return res;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> path, int index){
        if(target == 0){
            res.add(new ArrayList(path));
            return;
        }
        if(target < 0) return;

        for(int i = index; i < candidates.length; i++){
            if(i > index && candidates[i] == candidates[i - 1]) continue;
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], res, path, i + 1);
            path.removeLast();
        }
    }
}