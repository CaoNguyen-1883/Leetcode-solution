import java.util.LinkedList;
import java.util.Queue;

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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        return Math.max(left, right) + 1;
    }

    public int maxDepth1(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count = 0;
        while(!q.isEmpty()){
            ++count;
            int n = q.size();
            for(int i = 0; i < n; ++i){
                TreeNode node = q.poll();
                if(node.left !=  null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
        }
        return count;
    }

}