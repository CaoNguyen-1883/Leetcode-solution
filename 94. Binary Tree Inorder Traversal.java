
import java.util.List;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        solve(res, root);
        return res;
    }
    void solve(List<Integer> res, TreeNode root){
        if(root != null){
            solve(res, root.left);
            res.add(root.val);
            solve(res, root.right);
        }
    }
}