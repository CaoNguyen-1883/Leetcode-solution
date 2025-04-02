class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def isValid(root: TreeNode | None, min: TreeNode | None, max: TreeNode | None) -> bool:
            if not root:
                return True
            if min and root.val <= min:
                return False
            if max and root.val >= max:
                return False
            return isValid(root.left, min, root) and isValid(root.right, root, max)
        
        return isValid(root, None, None)