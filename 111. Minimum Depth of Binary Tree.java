class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null) return 1 + minDepth(root.right);
        if(root.right == null) return 1 + minDepth(root.left);
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
    public int minDepth2(TreeNode root){
        int res = Integer.MAX_VALUE;



        return res;
    }
    public boolean isLeaf(TreeNode root){
        return root.right == null && root.right == null;
    }
}   