class Solution {
    private int ans = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    public void dfs(TreeNode root, int path){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            ans += path*10 + root.val;
            return;
        }
        dfs(root.left, path*10 + root.val);
        dfs(root.right, path*10 + root.val);
    }
}