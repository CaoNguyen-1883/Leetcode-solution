class Solution1:
    def minDepth(self, root: Optional[TreeNode]) -> int:
        def solve(root: TreeNode | None) -> int:
            if not root:
                return 0
            if not root.left:
                return solve(root.right) + 1
            if not root.right:
                return solve(root.left) + 1
            return min(solve(root.left), solve(root.right)) + 1
        return solve(root)
    
class Solution:
    def minDepth(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0

        queue = deque([root])
        depth = 0
        while queue:
            depth += 1
            for _ in range(len(queue)):
                node = queue.popleft()
                if node.left is None and node.right is None:
                    return depth
                if node.left: queue.append(node.left)
                if node.right: queue.append(node.right)
            