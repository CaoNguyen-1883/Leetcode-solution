
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    private List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal1(TreeNode root) {
        solve(root);
        return res;
    }
    
    private void solve(TreeNode root){
        if(root != null){
            res.add(root.val);
            if(root.left != null) solve(root.left);
            if(root.right != null) solve(root.right);
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            ans.add(node.val);
            if(node.right != null) stack.add(node.right);
            if(node.left != null) stack.add(node.left);
        }

        return ans;
    }

}