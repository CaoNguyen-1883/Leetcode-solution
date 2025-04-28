class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        
        res = []
        stack = [root]

        while stack:
            node = stack.pop()
            res.append(node.val)
            if node.left:
                stack.append(node.left)
            if node.right:
                stack.append(node.right)

        return list(reversed(res))
