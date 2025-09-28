class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;

        while(root != null){
            if(root.left != null){
                TreeNode rightmost = root.left;

                while(rightmost.right != null) rightmost = rightmost.right;

                rightmost.right = root.right;
                root.right = root.left;
                root.left = null;
            }

            root = root.right;
        }
    }
}