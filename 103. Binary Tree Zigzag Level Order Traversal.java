import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


class TreeNode {
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) return res;

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        boolean isLeft = true;
        while(!q.isEmpty()){
            List<Integer> l = new ArrayList<>();
            for(int i = q.size(); i > 0; --i){
                TreeNode node = q.poll();
                if(isLeft){
                    l.add(node.val);
                } else{
                    l.add(0, node.val);
                }

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            res.add(l);
            isLeft = !isLeft;
        }

        return res;
    }
}