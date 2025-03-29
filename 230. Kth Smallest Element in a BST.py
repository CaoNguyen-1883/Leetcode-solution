class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        def countNode(root: TreeNode | None)->int:
            if not root:
                return 0
            return 1 + countNode(root.left) + countNode(root.right) 

        n = countNode(root.left)

        if(n == k - 1):
            return root.val
        if(n >= k):
            return self.kthSmallest(root.left, k)
        else:
            return self.kthSmallest(root.right, k - n - 1)
        
    def kthSmallest2(self, root: Optional[TreeNode], k: int) -> int:
        cnt = 0 
        stack = []
        cur = root

        while stack or cur:
            while cur:
                stack.append(cur)
                cur = cur.left

            cur = stack.pop()
            cnt += 1
            if cnt == k:
                return cur.val
            cur = cur.right
            