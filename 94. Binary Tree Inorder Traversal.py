class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        self.solve(res, root)
        return res

    def solve(self, res: List[int], root: Optional[TreeNode]) -> None:
        if root:
            self.solve(res, root.left)
            res.append(root.val)
            self.solve(res, root.right)  