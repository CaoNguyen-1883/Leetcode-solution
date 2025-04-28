import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    private List<Integer> res = new ArrayList();

    public List<Integer> postorderTraversal2(TreeNode root) {
        if(root == null) return new ArrayList<>();
       
        solve(root);
        return res;
    }

    private void solve(TreeNode root){
        if(root != null){
            if(root.left != null) solve(root.left);
  
            if(root.right != null) solve(root.right);

            res.add(root.val);
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();  
        stack.add(root);
        

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.addFirst(node.val);
            if(node.left != null) stack.add(node.left);
            if(node.right != null) stack.add(node.right);
        }


        return res;
    }
}