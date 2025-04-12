class Solution {
    private boolean res = true;
    public boolean isBalanced(TreeNode root) {
        countHeight(root);
        return res;
    }
    public int countHeight(TreeNode root){
        if(root == null || !res) return 0;
        int left = countHeight(root.left);
        int right = countHeight(root.right);
        if(Math.abs(left - right) > 1) res = false;

        return Math.max(left, right) + 1;
    }
}