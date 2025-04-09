import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        q.add(root);

        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> l = new ArrayList<>();

            for(int i = 0; i < n; ++i){
                TreeNode node = q.poll();
                l.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            res.add(l);
        }
        Collections.reverse(res);
        return res;
    }
}