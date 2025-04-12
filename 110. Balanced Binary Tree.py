class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        global res = True

        def countHeight(root: TreeNode | None) -> bool:
            if not root or not res:
                return 0
            left = countHeight(root.left)
            right = countHeight(root.right)
            if abs(left - right) > 1:
                res = False
            return max(left, right) + 1
        countHeight(root)

        return res