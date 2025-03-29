import java.util.Stack;

public class TreeNode {
int val;
TreeNode left;
TreeNode right;
TreeNode() {}
TreeNode(int val) { this.val = val; }
TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
}
}
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while(root != null){
            stack.add(root);
            root = root.left;
        }

        for(int i = 0; i < k - 1; ++i){
            root = stack.pop();
            root = root.right;
            while(root != null){
                stack.push(root);
                root = root.left;
            }
        }
        return stack.peek().val;
    }


    public int kthSmallest1(TreeNode root, int k) {
        int n = 0;
        if(root.left != null) n = countNode(root.left);

        if(n == k - 1) return root.val;
        else if(n >= k) return kthSmallest(root.left, k);
        return kthSmallest(root.right, k - n - 1);
    }
    
    private int countNode(TreeNode root){
        if(root == null) return 0;
        return 1 + countNode(root.left) + countNode(root.right);
    }
}