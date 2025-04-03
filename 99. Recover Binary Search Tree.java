class Solution {
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }

    private TreeNode pred = null;
    private TreeNode x = null; // the first wrong node
    private TreeNode y = null; // the second wrong node

    private void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);

        if(pred != null && root.val < pred.val){
            y = root;
            if(x == null) x = pred;
            else return;
        }
        pred = root;

        inorder(root.right);
        
    }

}