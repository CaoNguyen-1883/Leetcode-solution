from collections import deque

class Solution:
    def hasPathSum11(self, root: Optional[TreeNode], targetSum: int) -> bool:
        if not root: return False

        if root.val == targetSum and not root.left and not root.right:
           return True
        
        return self.hasPathSum(root.left, targetSum - root.val) or self.hasPathSum(root.right, targetSum - root.val)
    
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        if not root:
            return False
        
        stack = [(root, targetSum - root.val)]

        while stack:
            node, sum = stack.pop()

            if not node.left and not node.right and sum == 0:
                return True
            if node.left:
                stack.append((node.left, sum - node.left.val))
            if node.right:
                stack.append((node.right, sum - node.right.val))

        return False    